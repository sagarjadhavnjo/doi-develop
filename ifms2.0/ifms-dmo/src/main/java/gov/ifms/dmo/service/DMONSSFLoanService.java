package gov.ifms.dmo.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.dmo.dto.DMONSSFLoanDto;
import gov.ifms.dmo.dto.DMONSSFLoanPostDto;

/**
 * The Class DMONSSFLoanService.
 * 
 * @version v 1.0.
 * @created 2021/07/13 11:40:45.
 *
 */
public interface DMONSSFLoanService {

	/**
	 * Convert given DMONSSFLoanDto to DMONSSFLoanEntity
	 * Saves a given DMONSSFLoanEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param dto the dto
	 * @return the saved DMONSSFLoanEntity
	 */
	DMONSSFLoanPostDto saveOrUpdateNSSFLoanReceived(DMONSSFLoanPostDto dto);

	
	/**
	 * Retrieves an DMONSSFLoanEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the DMONSSFLoanEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	DMONSSFLoanPostDto getNSSFLoanReceived(Long id);
	
	/**
	 * Fetch all the NSSFLoanApprovedList items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<DMONSSFLoanDto>
	 */

	public PagebleDTO<DMONSSFLoanPostDto> getNSSFLoanApprovedList(PageDetails pageDetail) throws CustomException;


	/**
	 * Retrieves all repayments
	 * 
	 * @param id must not be {@literal null}.
	 * @return the DMONSSFLoanEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	DMONSSFLoanDto getAllRepayments(Long id);

}
