package gov.ifms.dmo.service.impl;

import java.util.List;

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
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.dmo.converter.DMONSSFLoanRePaymentConverter;
import gov.ifms.dmo.dto.DMONSSFLoanDto;
import gov.ifms.dmo.dto.DMONSSFLoanPostDto;
import gov.ifms.dmo.dto.DMONSSFLoanRePaymentDto;
import gov.ifms.dmo.entity.DMONSSFLoanRePaymentEntity;
import gov.ifms.dmo.repository.DMODPSheetEntryRepository;
import gov.ifms.dmo.repository.DMONSSFLoanRePaymentRepository;
import gov.ifms.dmo.repository.DMONSSFLoanRepository;
import gov.ifms.dmo.service.DMONSSFLoanRePaymentService;
import gov.ifms.dmo.utils.DMOUtility;

/**
 * The Class DMONSSFLoanRePaymentServiceImpl.
 * 
 * @version v 2.0.
 * @created 2021/07/20 15:19:32
 *
 */
@Service
public class DMONSSFLoanRePaymentServiceImpl implements DMONSSFLoanRePaymentService {
	
	/** The logger. */
	private Logger  logger =LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	DMONSSFLoanRePaymentRepository repository;
	
	@Autowired
	DMONSSFLoanRepository nssfLoanRepository;
	
	@Autowired
	DMODPSheetEntryRepository dpSheetEntryRepository;
	
	@Autowired
	DMONSSFLoanRePaymentConverter converter;
	
	/**
	 * Fetch all the NSSF loan RePayments schedule list items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<DMONSSFLoanDto>
	 */
	@Override
	public PagebleDTO<DMONSSFLoanDto> findAll(PageDetails pageDetail) throws CustomException{

		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<DMONSSFLoanRePaymentEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
	        Specification<DMONSSFLoanRePaymentEntity> dataSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
	        Page<DMONSSFLoanRePaymentEntity> page = repository.findAll(dataSpec, pageable);
	        
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), converter.toDTO(page.getContent()));
		}
		catch (Exception ex) {
			    logger.error(ex.toString());
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Convert NSSFLoanRePaymentEntity to DMONSSFLoanMatchPayableDto
	 * Retrieves an NSSFLoanRePaymentEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the NSSFLoanRePaymentEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public DMONSSFLoanDto findById(Long id) {
		DMONSSFLoanRePaymentEntity entity = repository.getOne(id);
		return converter.toDTO(entity);
	}

	@Override
	public List<DMONSSFLoanDto> save(DMONSSFLoanPostDto dto) {
		List<DMONSSFLoanRePaymentDto> dtos  = DMOUtility.rePaymentUtility(dto);
		return converter.toDTO(repository.saveAll(converter.toRePaymentEntity(dtos)));
	}

}
