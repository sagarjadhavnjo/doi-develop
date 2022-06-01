package gov.ifms.dmo.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.dmo.dto.DMONSSFLoanPostDto;
import gov.ifms.dmo.entity.DMODPSheetEntryEntity;
import gov.ifms.dmo.entity.DMONSSFLoanEntity;

@Component
public class DMONSSFLoanConverter implements BaseConverter<DMONSSFLoanEntity, DMONSSFLoanPostDto>{

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the DMONSSFLoanEntity entity
	 */
	@Override
	public DMONSSFLoanEntity toEntity(DMONSSFLoanPostDto dto) {
		DMONSSFLoanEntity entity = new DMONSSFLoanEntity();
		BeanUtils.copyProperties(dto, entity);
		if(null != dto.getDpSheetId()) {
			entity.setDpSheetId(new DMODPSheetEntryEntity(dto.getDpSheetId()));
		}
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the DMONSSFLoanPostDto dto
	 */
	@Override
	public DMONSSFLoanPostDto toDTO(DMONSSFLoanEntity entity) {
		DMONSSFLoanPostDto dto = new DMONSSFLoanPostDto();
		if(!ObjectUtils.isEmpty(entity.getDpSheetId())){
			dto.setDpSheetId(entity.getDpSheetId().getId());
		}		
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
