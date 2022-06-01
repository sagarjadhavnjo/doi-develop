package gov.ifms.dmo.converter;

/*import java.time.LocalDateTime;*/

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.dmo.dto.DMODPSheetHDREntryPostDto;
import gov.ifms.dmo.entity.DMODPSheetHDREntity;

/**
 * The Class DMODPSheetEntryHDRConverter.
 * 
 * @version 2.0
 * @created 2021/07/21 15:19:32
 *
 */
@Component
public class DMODPSheetEntryHDRConverter implements BaseConverter<DMODPSheetHDREntity, DMODPSheetHDREntryPostDto>{

	@Override
	public DMODPSheetHDREntity toEntity(DMODPSheetHDREntryPostDto dto) {
		DMODPSheetHDREntity entity = new DMODPSheetHDREntity();
		BeanUtils.copyProperties(dto, entity);
		entity.setIsProcessed(dto.getAction());
		return entity;
	}

	@Override
	public DMODPSheetHDREntryPostDto toDTO(DMODPSheetHDREntity entity) {
		DMODPSheetHDREntryPostDto dto = new DMODPSheetHDREntryPostDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
