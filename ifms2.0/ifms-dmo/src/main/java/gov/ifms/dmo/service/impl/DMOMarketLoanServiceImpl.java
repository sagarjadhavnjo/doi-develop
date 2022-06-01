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
import gov.ifms.dmo.converter.DMOMarketLoanConverter;
import gov.ifms.dmo.dto.DMOMarketLoanDto;
import gov.ifms.dmo.entity.DMOMarketLoanEntity;
import gov.ifms.dmo.repository.DMOMarketLoanRepository;
import gov.ifms.dmo.service.DMOMarketLoanService;
import gov.ifms.dmo.utils.DMOConstant;
import gov.ifms.dmo.utils.DMOUtility;

/**
 * The Class DMOMarketLoanServiceImpl.
 * 
 * @version v 1.0.
 * @created 2021/08/01 11:40:45.
 *
 */
@Service
public class DMOMarketLoanServiceImpl implements DMOMarketLoanService{

	
	@Autowired
	DMOMarketLoanRepository repository;
	
	@Autowired
	DMOMarketLoanConverter converter;
	
	/** The logger. */
	private Logger  logger =LoggerFactory.getLogger(this.getClass().getName());
	
	
	/**
	 * Convert given DMOMarketLoanDto to DMOMarketLoanEntity
	 * Saves a given DMOMarketLoanEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param dto the dto
	 * @return the saved DMOMarketLoanEntity
	 */
	@Override
	public DMOMarketLoanDto saveOrUpdate(DMOMarketLoanDto dto) {
		DMOMarketLoanEntity entity  = converter.toEntity(dto);
		entity.setReferenceDt(LocalDateTime.now());
		entity.setReferenceNo(generateTrnNo(DMOConstant.MML_SCREEN));
		return converter.toDTO(repository.save(entity));
	}

	/**
	 * Retrieves an DMOMarketLoanEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the DMOMarketLoanEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public DMOMarketLoanDto getMarketLoanReceived(Long id) {
		DMOMarketLoanEntity entity =  repository.getOne(id);
		return converter.toDTO(entity);
	}

	/**
	 * Fetch all the findAll List items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<DMONSSFLoanDto>
	 */
	@Override
	public PagebleDTO<DMOMarketLoanDto> findAll(PageDetails pageDetail) throws CustomException{
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<DMOMarketLoanEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
	        Specification<DMOMarketLoanEntity> dataSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
	        Page<DMOMarketLoanEntity> page = repository.findAll(dataSpec, pageable);
	        
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), converter.toDTO(page.getContent()));
		}
		catch (Exception ex) {
			    logger.error(ex.toString());
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
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
