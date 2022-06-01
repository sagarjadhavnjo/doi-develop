package gov.ifms.dmo.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.dmo.dto.DMOMarketLoanDto;

/**
 * The Class DMOMarketLoanService.
 * 
 * @version v 1.0.
 * @created 2021/08/01 11:40:45.
 *
 */
public interface DMOMarketLoanService {

	/**
	 * Convert given DMOMarketLoanDto to DMOMarketLoanEntity
	 * Saves a given DMOMarketLoanEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param dto the dto
	 * @return the saved DMOMarketLoanEntity
	 */
	DMOMarketLoanDto saveOrUpdate(DMOMarketLoanDto dto);

	/**
	 * Retrieves an DMOMarketLoanEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the DMOMarketLoanEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	DMOMarketLoanDto getMarketLoanReceived(Long id);

	/**
	 * Fetch all the findAll List items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<DMONSSFLoanDto>
	 */
	PagebleDTO<DMOMarketLoanDto> findAll(PageDetails pageDetail) throws CustomException;

}
