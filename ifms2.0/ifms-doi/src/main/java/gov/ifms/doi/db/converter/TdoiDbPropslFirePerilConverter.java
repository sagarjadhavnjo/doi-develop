package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import gov.ifms.doi.db.dto.TdoiDbProposalDTO;
import gov.ifms.doi.db.entity.*;
import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPropslFirePerilDTO;

@Component
public class TdoiDbPropslFirePerilConverter{

	public TdoiDbPropslFirePerilEntity toEntity(TdoiDbPropslFirePerilDTO dto) {
		TdoiDbPropslFirePerilEntity entity = new TdoiDbPropslFirePerilEntity();
		BeanUtils.copyProperties(dto, entity);
		if(entity.getFirePerilId() == null){
			if(entity.getTdoiDbProposal()==null){
				TdoiDbProposalEntity tdoiDbProposal = new TdoiDbProposalEntity();
				BeanUtils.copyProperties(dto.getTdoiDbProposal(),tdoiDbProposal);
				entity.setTdoiDbProposal(tdoiDbProposal);
			}

			//BuildingVals
			entity.setTdoiDbFireBuildingVals(new ArrayList<>());
			dto.getTdoiDbFireBuildingVals().forEach(b->{
				TdoiDbFireBuildingValEntity buildingValEntity = new TdoiDbFireBuildingValEntity();
				BeanUtils.copyProperties(b,buildingValEntity);
				entity.addTdoiDbFireBuildingVal(buildingValEntity);
			});

			//Past3Policy
			entity.setTdoiDbFirePastPolicies(new ArrayList<>());
			dto.getTdoiDbFirePastPolicies().forEach(p->{
				TdoiDbFirePastPolicyEntity pastPolicyEntity = new TdoiDbFirePastPolicyEntity();
				BeanUtils.copyProperties(p,pastPolicyEntity);
				entity.addTdoiDbFirePastPolicy(pastPolicyEntity);
			});

			//FireRisk
			entity.setTdoiDbFireRiskLocs(new ArrayList<>());
			dto.getTdoiDbFireRiskLocs().forEach(r->{
				TdoiDbFireRiskLocEntity fireRiskLocEntity = new TdoiDbFireRiskLocEntity();
				BeanUtils.copyProperties(r,fireRiskLocEntity);
				entity.addTdoiDbFireRiskLoc(fireRiskLocEntity);
			});

			//FireSumInsured
			entity.setTdoiDbFireSumInsureds(new ArrayList<>());
			dto.getTdoiDbFireSumInsureds().forEach(sum->{
				TdoiDbFireSumInsuredEntity fireSumInsuredEntity = new TdoiDbFireSumInsuredEntity();
				BeanUtils.copyProperties(sum,fireSumInsuredEntity);
				entity.addTdoiDbFireSumInsured(fireSumInsuredEntity);
			});

			//FireRiDtls
			entity.setTdoiDbPropFireRiDtls(new ArrayList<>());
			dto.getTdoiDbPropFireRiDtls().forEach(ri->{
				TdoiDbPropFireRiDtlEntity fireRiDtlEntity = new TdoiDbPropFireRiDtlEntity();
				BeanUtils.copyProperties(ri,fireRiDtlEntity);
				entity.addTdoiDbPropFireRiDtl(fireRiDtlEntity);
			});
		}
		return entity;
	}


	public List<TdoiDbPropslFirePerilDTO> toDtoListFromEntityList(List<TdoiDbPropslFirePerilEntity> entityList) {
		List<TdoiDbPropslFirePerilDTO> dtoList = new ArrayList<>();
		for (TdoiDbPropslFirePerilEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
		return dtoList;
	}


	public TdoiDbPropslFirePerilDTO toDtoFromEntity(TdoiDbPropslFirePerilEntity entity) {
		TdoiDbPropslFirePerilDTO dto=new TdoiDbPropslFirePerilDTO();
		BeanUtils.copyProperties(entity, dto);
		if(dto.getTdoiDbProposal()==null){
			TdoiDbProposalDTO proposalDTO = new TdoiDbProposalDTO();
			BeanUtils.copyProperties(entity.getTdoiDbProposal(),proposalDTO);
			dto.setTdoiDbProposal(proposalDTO);
		}
		return dto;
	}


}

