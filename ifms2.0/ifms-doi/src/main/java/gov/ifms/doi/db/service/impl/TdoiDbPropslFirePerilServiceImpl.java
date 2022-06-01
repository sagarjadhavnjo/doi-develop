package gov.ifms.doi.db.service.impl;

import java.util.List;

import gov.ifms.doi.db.entity.TdoiDbProposalEntity;
import gov.ifms.doi.db.entity.TdoiDbPropslFirePerilEntity;
import gov.ifms.doi.db.repository.TdoiDbFireBuildingValRepository;
import gov.ifms.doi.db.repository.TdoiDbProposalRepository;
import gov.ifms.doi.db.service.TdoiDbProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbPropslFirePerilConverter;
import gov.ifms.doi.db.dto.TdoiDbPropslFirePerilDTO;
import gov.ifms.doi.db.repository.TdoiDbPropslFirePerilRepository;
import gov.ifms.doi.db.service.TdoiDbPropslFirePerilService;

@Service
public class TdoiDbPropslFirePerilServiceImpl implements TdoiDbPropslFirePerilService {

	@Autowired
	TdoiDbPropslFirePerilRepository repository;

	@Autowired
	TdoiDbPropslFirePerilConverter converter;

	@Autowired
	TdoiDbProposalRepository dbProposalRepository;

	@Autowired
	TdoiDbFireBuildingValRepository buildingValRepository;

	@Override
	public TdoiDbPropslFirePerilDTO saveOrUpdate(TdoiDbPropslFirePerilDTO dto) {
		TdoiDbPropslFirePerilEntity firePerilEntity = converter.toEntity(dto);
		if(firePerilEntity.getTdoiDbProposal()!=null
				&& firePerilEntity.getTdoiDbProposal().getDbProposalId()==null){
			firePerilEntity.setTdoiDbProposal(dbProposalRepository.save(firePerilEntity.getTdoiDbProposal()));
		}
		//BuildingVal
		if(firePerilEntity.getTdoiDbFireBuildingVals()!=null
				&& !firePerilEntity.getTdoiDbFireBuildingVals().isEmpty()){
			firePerilEntity.getTdoiDbFireBuildingVals().forEach(o -> {
				o.setTdoiDbProposal(firePerilEntity.getTdoiDbProposal());
				o.setTdoiDbPropslFirePeril(firePerilEntity);
			});
		}

		if(firePerilEntity.getTdoiDbFirePastPolicies()!=null && !firePerilEntity.getTdoiDbFirePastPolicies().isEmpty()){
			//PastPolicies
			firePerilEntity.getTdoiDbFirePastPolicies().forEach(o -> {
				o.setTdoiDbProposal(firePerilEntity.getTdoiDbProposal());
				o.setTdoiDbPropslFirePeril(firePerilEntity);
			});
		}

		if(firePerilEntity.getTdoiDbFireRiskLocs()!=null && !firePerilEntity.getTdoiDbFireRiskLocs().isEmpty()){
			//FireRisk
			firePerilEntity.getTdoiDbFireRiskLocs().forEach(o -> {
				o.setTdoiDbProposal(firePerilEntity.getTdoiDbProposal());
				o.setTdoiDbPropslFirePeril(firePerilEntity);
			});
		}

		if(firePerilEntity.getTdoiDbFireSumInsureds()!=null && !firePerilEntity.getTdoiDbFireSumInsureds().isEmpty()){
			//FireSumInsured
			firePerilEntity.getTdoiDbFireSumInsureds().forEach(o -> {
				o.setTdoiDbProposal(firePerilEntity.getTdoiDbProposal());
				o.setTdoiDbPropslFirePeril(firePerilEntity);
			});
		}

		//FireRiDtls
		if(firePerilEntity.getTdoiDbPropFireRiDtls()!=null && !firePerilEntity.getTdoiDbPropFireRiDtls().isEmpty()){
			firePerilEntity.getTdoiDbPropFireRiDtls().forEach(o -> {
				o.setTdoiDbPropslFirePeril(firePerilEntity);
			});
		}

		return converter.toDtoFromEntity(repository.save(firePerilEntity));
	}


	@Override
	public List<TdoiDbPropslFirePerilDTO> findAllByCriteria(TdoiDbPropslFirePerilDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbPropslFirePerilDTO> findAllByStatus(TdoiDbPropslFirePerilDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbPropslFirePerilDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


}

