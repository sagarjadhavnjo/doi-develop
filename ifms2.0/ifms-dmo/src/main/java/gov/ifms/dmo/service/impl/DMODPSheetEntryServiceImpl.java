package gov.ifms.dmo.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.dmo.converter.DMODPSheetEntryConverter;
import gov.ifms.dmo.converter.DMODPSheetEntryHDRConverter;
import gov.ifms.dmo.dto.DMODPDateSearchDto;
import gov.ifms.dmo.dto.DMODPSheetEntryDto;
import gov.ifms.dmo.dto.DMODPSheetEntryPostDto;
import gov.ifms.dmo.dto.DMODPSheetHDREntryPostDto;
import gov.ifms.dmo.entity.DMODPSheetEntryEntity;
import gov.ifms.dmo.entity.DMODPSheetHDREntity;
import gov.ifms.dmo.repository.DMODPSheetEntryHRDRepository;
import gov.ifms.dmo.repository.DMODPSheetEntryRepository;
import gov.ifms.dmo.service.DMODPSheetEntryService;
import gov.ifms.dmo.utils.DMOConstant;
import gov.ifms.dmo.utils.DMOUtility;

@Service
public class DMODPSheetEntryServiceImpl implements DMODPSheetEntryService {

	@Autowired
	DMODPSheetEntryRepository repository;

	@Autowired
	DMODPSheetEntryConverter converter;

	@Autowired
	DMODPSheetEntryHRDRepository hrdRepository;

	@Autowired
	DMODPSheetEntryHDRConverter hrdConverter;

	/**
	 * Fetch all the DMODPSheetHDR items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<DMODPSheetHDREntity>
	 */
	@Override
	public PagebleDTO<DMODPSheetEntryPostDto> dpSheetListing(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<DMODPSheetEntryEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<DMODPSheetEntryEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<DMODPSheetEntryEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	@Override
	public DMODPSheetEntryPostDto findById(Long id) {
		return converter.toDTO(repository.getOne(id));
	}

	/**
	 * Convert given DMODPSheetHDREntryPostDto to DMODPSheetHDREntity Saves a given
	 * DMODPSheetHDREntity. Use the returned instance for further operations as the
	 * save operation might have changed the entity instance completely.
	 *
	 * @param dto the dto
	 * @return the saved DMODPSheetHDREntity
	 */
	@Override
	public DMODPSheetEntryDto saveOrUpdateDPSheet(DMODPSheetHDREntryPostDto dto) {
		DMODPSheetHDREntity hrdEntity = hrdConverter.toEntity(dto);
		hrdEntity.setRefDate(LocalDateTime.now());
		hrdEntity.setRefNo(generateTrnNo(DMOConstant.DPS_MENU_ID));
		hrdEntity.setFinancialYear("2021-2022");
		List<DMODPSheetEntryEntity> entryEntities = converter.toEntity(dto.getDpSheetDtos());
		hrdEntity.setEntities(entryEntities);
		hrdEntity = hrdRepository.save(hrdEntity);
		return null;
	}

	/**
	 * Generate trn no.
	 *
	 * @param menuCode the menu code
	 * @return the string
	 */
	private String generateTrnNo(String menuCode) {
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(DMOConstant.TRN_SCREEN, menuCode);
		String procName = DMOConstant.DMO_SCHEMA.concat(Constant.DOT.concat(DMOConstant.TRANSACTION_NO_GENERATION));
		List<Object[]> responseList = hrdRepository.callStoredProcedure(procName, argMap);
		return DMOUtility.convertObjectToString(responseList.get(0)[0]);
	}

	/**
	 * Fetch all the DMODPSheetHDR items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<DMODPSheetHDREntity>
	 */
	@Override
	public DMODPSheetHDREntryPostDto searchByDate(DMODPDateSearchDto dateSearchDto) throws CustomException {

		DMODPSheetHDREntryPostDto dto = new DMODPSheetHDREntryPostDto();
		DMODPSheetHDREntity entity = hrdRepository.findByDpSheetReciveDateAndIsProcessed(
				Utils.convertStringToLocalDate(dateSearchDto.getDate()), DMOConstant.IS_PROCESSED);
		if (ObjectUtils.isEmpty(entity)) {
			dto.setDpSheetDtos(new ArrayList<>());
		}else {
			dto = hrdConverter.toDTO(entity);
			dto.setDpSheetDtos(converter.toDTO(entity.getEntities()));
		}
		return dto;

	}
}
