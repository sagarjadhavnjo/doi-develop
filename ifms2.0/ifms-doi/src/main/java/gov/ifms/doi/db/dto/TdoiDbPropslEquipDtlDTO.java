package gov.ifms.doi.db.dto;

import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_PROPSL_EQUIP_DTLS database table.
 * 
 */

public class TdoiDbPropslEquipDtlDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long equipDtlsId;

	private String equipDesc;

	private long equipHirePur;

	private short equipQuantity;

	private String equipmentDtls;

	private double excessClAmt;

	private short manufactureYr;

	private double sumInsured;

	private TdoiDbPropslElecEquipDTO tdoiDbPropslElecEquip;

	public long getEquipDtlsId() {
		return this.equipDtlsId;
	}

	public void setEquipDtlsId(long equipDtlsId) {
		this.equipDtlsId = equipDtlsId;
	}

	public String getEquipDesc() {
		return this.equipDesc;
	}

	public void setEquipDesc(String equipDesc) {
		this.equipDesc = equipDesc;
	}

	public long getEquipHirePur() {
		return this.equipHirePur;
	}

	public void setEquipHirePur(long equipHirePur) {
		this.equipHirePur = equipHirePur;
	}

	public short getEquipQuantity() {
		return this.equipQuantity;
	}

	public void setEquipQuantity(short equipQuantity) {
		this.equipQuantity = equipQuantity;
	}

	public String getEquipmentDtls() {
		return this.equipmentDtls;
	}

	public void setEquipmentDtls(String equipmentDtls) {
		this.equipmentDtls = equipmentDtls;
	}

	public double getExcessClAmt() {
		return this.excessClAmt;
	}

	public void setExcessClAmt(double excessClAmt) {
		this.excessClAmt = excessClAmt;
	}

	public short getManufactureYr() {
		return this.manufactureYr;
	}

	public void setManufactureYr(short manufactureYr) {
		this.manufactureYr = manufactureYr;
	}

	public double getSumInsured() {
		return this.sumInsured;
	}

	public void setSumInsured(double sumInsured) {
		this.sumInsured = sumInsured;
	}

	public TdoiDbPropslElecEquipDTO getTdoiDbPropslElecEquip() {
		return this.tdoiDbPropslElecEquip;
	}

	public void setTdoiDbPropslElecEquip(TdoiDbPropslElecEquipDTO tdoiDbPropslElecEquip) {
		this.tdoiDbPropslElecEquip = tdoiDbPropslElecEquip;
	}

}
