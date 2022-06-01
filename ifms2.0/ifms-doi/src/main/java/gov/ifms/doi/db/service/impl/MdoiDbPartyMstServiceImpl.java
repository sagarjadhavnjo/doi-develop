package gov.ifms.doi.db.service.impl;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.doi.db.constant.DoiDBConstants;
import gov.ifms.doi.db.entity.MdoiDbPartyMstEntity;
import gov.ifms.doi.db.utility.DbUtility;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.MdoiDbPartyMstConverter;
import gov.ifms.doi.db.dto.MdoiDbPartyMstDTO;
import gov.ifms.doi.db.repository.MdoiDbPartyMstRepository;
import gov.ifms.doi.db.service.MdoiDbPartyMstService;

@Service
public class MdoiDbPartyMstServiceImpl implements MdoiDbPartyMstService {

	@Autowired
	MdoiDbPartyMstRepository repository;

	@Autowired
	MdoiDbPartyMstConverter converter;

	@Autowired
	DbUtility dbUtility;

	@Override
	public MdoiDbPartyMstDTO saveOrUpdate(MdoiDbPartyMstDTO dto) {
		if (StringUtils.isEmpty(dto.getReferenceNo())) {
			dto.setReferenceNo(dbUtility.getReferenceNumber(DoiDBConstants.DOI_DB_PM_REFERENCE_NUMBER,DoiDBConstants.DOI_DB_PM_REFERENCE_NUMBER_URI));
		}
		return converter.toDtoFromEntity(repository.save(converter.toEntity(dto)));
	}

	@Override
	public PagebleDTO<MdoiDbPartyMstDTO> findAll(PageDetails pageDetails) {
		PageRequest pagable = null;
		SearchCriteria searchCriteria = new SearchCriteria();
		SpecificationImpl<MdoiDbPartyMstEntity> specImpl = new SpecificationImpl<>();
		pagable = pageDetails.getPageDetails(pageDetails);
		Specification<MdoiDbPartyMstEntity> dataSpec = searchCriteria.getSpecificationDetails(specImpl,pageDetails.getJsonArr());
		Page<MdoiDbPartyMstEntity> page = repository.findAll(dataSpec, pagable);

		return new PagebleDTO<>(page.getSize(), page.getTotalPages(),
				page.getTotalElements(), converter.toDtoListFromEntityList(page.getContent()));
	}

	@Override
	public List<MdoiDbPartyMstDTO> findAllByCriteria(MdoiDbPartyMstDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<MdoiDbPartyMstDTO> findAllByStatus(MdoiDbPartyMstDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public void softDeleteById(Long id) {
		repository.softDeleteById(id);
	}

	@Override
	public MdoiDbPartyMstDTO add(MdoiDbPartyMstDTO dto) {
		MdoiDbPartyMstEntity mdoiDbPartyMstEntity = converter.toEntity(dto);
		repository.save(mdoiDbPartyMstEntity);
		return dto;
	}

	@Override
	public List<MdoiDbPartyMstDTO> fetch() {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


}

