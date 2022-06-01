package gov.ifms.dmo.service.impl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.dmo.converter.DMONSSFLoanConverter;
import gov.ifms.dmo.converter.DMONSSFLoanRePaymentConverter;
import gov.ifms.dmo.dto.DMONSSFLoanDto;
import gov.ifms.dmo.dto.DMONSSFLoanPostDto;
import gov.ifms.dmo.entity.DMONSSFLoanEntity;
import gov.ifms.dmo.repository.DMODPSheetEntryRepository;
import gov.ifms.dmo.repository.DMONSSFLoanRepository;
import gov.ifms.dmo.service.DMONSSFLoanService;
import gov.ifms.dmo.utils.DMOConstant;
import gov.ifms.dmo.utils.DMOUtility;


/**
 * The Class DMONSSFLoanServiceImpl.
 * 
 * @version v 1.0.
 * @created 2021/07/13 11:40:45.
 *
 */
@Service
public class DMONSSFLoanServiceImpl implements DMONSSFLoanService {

	/** The logger. */
	private Logger  logger =LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	DMONSSFLoanRepository repository;
	
	@Autowired
	DMONSSFLoanConverter converter;
	
	@Autowired
	DMODPSheetEntryRepository dpSheetRepository;
	
	@Autowired
	DMONSSFLoanRePaymentConverter repaymentConverter;
	
	/**
	 * Saves a given DMONSSFLoanEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param dto the dto
	 * @return the saved entity
	 */
	@Override
	public DMONSSFLoanPostDto saveOrUpdateNSSFLoanReceived(DMONSSFLoanPostDto dto) {
		DMONSSFLoanEntity entity = converter.toEntity(dto);
		entity.setRefrenceDate(LocalDateTime.now());
		entity.setRefrenceNo(generateTrnNo(DMOConstant.NLR_TRN_SCREEN));
		return converter.toDTO(repository.save(entity));
	}

	/**
	 * Retrieves an DMONSSFLoanEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the DMONSSFLoanEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public DMONSSFLoanPostDto getNSSFLoanReceived(Long id) {
		return converter.toDTO(repository.getOne(id));
	}

	/**
	 * Fetch all the NSSFLoanApprovedList items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<DMONSSFLoanDto>
	 */
	@Override
	public PagebleDTO<DMONSSFLoanPostDto> getNSSFLoanApprovedList(PageDetails pageDetail) throws CustomException{
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<DMONSSFLoanEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
	        Specification<DMONSSFLoanEntity> dataSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
	        Page<DMONSSFLoanEntity> page = repository.findAll(dataSpec, pageable);
	        
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), converter.toDTO(page.getContent()));
		}
		catch (Exception ex) {
			    logger.error(ex.toString());
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Retrieves all repayments
	 * 
	 * @param id must not be {@literal null}.
	 * @return the DMONSSFLoanEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public DMONSSFLoanDto getAllRepayments(Long id) {
		DMONSSFLoanEntity entity = repository.getOne(id);
		DMONSSFLoanDto dto = repaymentConverter.toRePaymentDTO(entity);
		dto.setDtos(repaymentConverter.toRePaymentDTO(entity.getRepayments()));
		return dto;
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
			List<Object[]> responseList = repository.callStoredProcedure(procName, argMap);
			return DMOUtility.convertObjectToString(responseList.get(0)[0]);
	}
}
