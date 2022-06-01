package gov.ifms.edp.service;

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
import gov.ifms.edp.converter.EDPMsBankIfscConverter;
import gov.ifms.edp.dto.EDPMsBankIfscDto;
import gov.ifms.edp.entity.EDPMsBankIfscEntity;
import gov.ifms.edp.repository.EDPMsBankIfscRepository;

/**
 * The Class EDPMsBankIfscController.
 * 
 * @version v 1.0
 * @created 2020/05/28 17:17:24
 */
@Service
public class EDPMsBankIfscServiceImpl implements EDPMsBankIfscService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The EDPMsBankIfscAsMethodName repository. */
	@Autowired
	private EDPMsBankIfscRepository repository;

	/** The EDPMsBankIfscAsMethodName helper. */
	@Autowired
	private EDPMsBankIfscConverter converter;

	/**
	 * Retrieves an EDPMsBankIfscEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsBankIfscEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPMsBankIfscEntity getMsBankIfsc(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPMsBankIfscEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPMsBankIfscEntity
	 */
	@Override
	public EDPMsBankIfscEntity saveOrUpdateMsBankIfsc(EDPMsBankIfscEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Fetch all the EDPMsBankIfsc items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsBankIfscDto>
	 */
	@Override
	public PagebleDTO<EDPMsBankIfscDto> getMsBankIfscs(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<EDPMsBankIfscEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<EDPMsBankIfscEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<EDPMsBankIfscEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

}
