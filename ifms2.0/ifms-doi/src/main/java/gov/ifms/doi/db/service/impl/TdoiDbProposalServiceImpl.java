package gov.ifms.doi.db.service.impl;

import java.util.List;

import gov.ifms.doi.db.entity.TdoiDbProposalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbProposalConverter;
import gov.ifms.doi.db.dto.TdoiDbProposalDTO;
import gov.ifms.doi.db.repository.TdoiDbProposalRepository;
import gov.ifms.doi.db.service.TdoiDbProposalService;

@Service
public class TdoiDbProposalServiceImpl implements TdoiDbProposalService {

	@Autowired
	TdoiDbProposalRepository repository;

	@Autowired
	TdoiDbProposalConverter converter;

	@Override
	public TdoiDbProposalDTO saveOrUpdate(TdoiDbProposalDTO dto) {
		TdoiDbProposalEntity entity = repository.save(converter.toEntity(dto));
		return converter.toDtoFromEntity(entity);
	}


	@Override
	public List<TdoiDbProposalDTO> findAllByCriteria(TdoiDbProposalDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbProposalDTO> findAllByStatus(TdoiDbProposalDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbProposalDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}

