package gov.ifms.doi.db.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_PROPSL_FIRE_PERIL database table.
 * 
 */
public class TdoiDbPropslFirePerilDTO extends BaseDto {
	private static final Long serialVersionUID = 1L;

	private Long firePerilId;

	private String anyIndustryRisk;

	private Double architectFees;

	private Long bankId;

	private String bankName;

	private String basisPropInsur;

	private Long branchId;

	private String branchName;

	private Long buildingAgeId;

	private String buildingHeight;

	private Double challanAmount;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_FORMAT)
	private Date challanDt;

	private String challanNo;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_FORMAT)
	private Date chequeDdDt;

	private String chequeDdNo;

	private Double coldStrgDetor;

	private String coversIncluded;

	private Double debrisRemvlAmt;

	private Double declareBasisAmt;

	private String declineDetails;

	private Long factoryStatus;

	private String fireProtectDevice;

	private Double firmCapitalPaid;

	private Double floatDecBasisAmt;

	private Double floaterBasisAmt;

	private String floorMaterialUsed;

	private Double forestFire;

	private String goodsAsPerList;

	private String goodsStoredList;

	private Double insrncPremium;

	private String insrnceDetails;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_FORMAT)
	private Date insurEndDt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_FORMAT)
	private Date insurStartDt;

	private String isArchitectFeesAdd;

	private String isCoverPinth;

	private String isDebrisRemvAdd;

	private String isDeclaraeBasis;

	private String isEarthquakeCov;

	private String isFloatDecBasis;

	private String isFloaterBasis;

	private String isInsrDeclined;

	private String isOthrCompIns;

	private String isResiOffcShop;

	private String isRiReqd;

	private String isStockStorOpen;

	private String isUsedAsShop;

	private String issuedInFavor;

	private String manufProductList;

	private String marketValBasis;

	private Double ommissionAddtn;

	private Double openStocksAmt;

	private String openStorLoc;

	private String othrCompnyName;

	private String outGasTanksRisk;

	private String outStorgRisk;

	private Double payablePremAmt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_FORMAT)
	private Date paymentDate;

	private Long paymentModeId;

	private Double premDiscAmt;

	private Double premDiscPc;

	private Double premGstAmt;

	private Double premGstPc;

	private String proposerBusiness;

	private Long propslPoliciesId;

	private Double rateOfIntrst;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date referenceDt;

	private String referenceNo;

	private String reinstatValBasis;

	private String roofMaterialUsed;

	private Double spontCombustion;

	private String stockValExceed;

	private Double sumInsured;

	private String terrorismDtls;

	private Double totAddonPrem;

	private Double totRiAmt;

	private Double totalPremium;

	private String usedAsIndustry;

	private String usedWarehouseGodwn;

	private String utilitiesOutRisk;

	private Double vehicleDamage;

	private String wallMaterialUsed;

	private List<TdoiDbFireBuildingValDTO> tdoiDbFireBuildingVals;

	private List<TdoiDbFirePastPolicyDTO> tdoiDbFirePastPolicies;

	private List<TdoiDbFireRiskLocDTO> tdoiDbFireRiskLocs;

	private List<TdoiDbFireSumInsuredDTO> tdoiDbFireSumInsureds;

	private TdoiDbProposalDTO tdoiDbProposal;

	private List<TdoiDbPropslFireWfDTO> tdoiDbPropslFireWfs;

	private List<TdoiDbPropFireRiDtlDTO> tdoiDbPropFireRiDtls;

	public Long getFirePerilId() {
		return this.firePerilId;
	}

	public void setFirePerilId(Long firePerilId) {
		this.firePerilId = firePerilId;
	}

	public String getAnyIndustryRisk() {
		return this.anyIndustryRisk;
	}

	public void setAnyIndustryRisk(String anyIndustryRisk) {
		this.anyIndustryRisk = anyIndustryRisk;
	}

	public Double getArchitectFees() {
		return this.architectFees;
	}

	public void setArchitectFees(Double architectFees) {
		this.architectFees = architectFees;
	}

	public Long getBankId() {
		return this.bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBasisPropInsur() {
		return this.basisPropInsur;
	}

	public void setBasisPropInsur(String basisPropInsur) {
		this.basisPropInsur = basisPropInsur;
	}

	public Long getBranchId() {
		return this.branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Long getBuildingAgeId() {
		return this.buildingAgeId;
	}

	public void setBuildingAgeId(Long buildingAgeId) {
		this.buildingAgeId = buildingAgeId;
	}

	public String getBuildingHeight() {
		return this.buildingHeight;
	}

	public void setBuildingHeight(String buildingHeight) {
		this.buildingHeight = buildingHeight;
	}

	public Double getChallanAmount() {
		return this.challanAmount;
	}

	public void setChallanAmount(Double challanAmount) {
		this.challanAmount = challanAmount;
	}

	public Date getChallanDt() {
		return this.challanDt;
	}

	public void setChallanDt(Date challanDt) {
		this.challanDt = challanDt;
	}

	public String getChallanNo() {
		return this.challanNo;
	}

	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	public Date getChequeDdDt() {
		return this.chequeDdDt;
	}

	public void setChequeDdDt(Date chequeDdDt) {
		this.chequeDdDt = chequeDdDt;
	}

	public String getChequeDdNo() {
		return this.chequeDdNo;
	}

	public void setChequeDdNo(String chequeDdNo) {
		this.chequeDdNo = chequeDdNo;
	}

	public Double getColdStrgDetor() {
		return this.coldStrgDetor;
	}

	public void setColdStrgDetor(Double coldStrgDetor) {
		this.coldStrgDetor = coldStrgDetor;
	}

	public String getCoversIncluded() {
		return this.coversIncluded;
	}

	public void setCoversIncluded(String coversIncluded) {
		this.coversIncluded = coversIncluded;
	}

	public Double getDebrisRemvlAmt() {
		return this.debrisRemvlAmt;
	}

	public void setDebrisRemvlAmt(Double debrisRemvlAmt) {
		this.debrisRemvlAmt = debrisRemvlAmt;
	}

	public Double getDeclareBasisAmt() {
		return this.declareBasisAmt;
	}

	public void setDeclareBasisAmt(Double declareBasisAmt) {
		this.declareBasisAmt = declareBasisAmt;
	}

	public String getDeclineDetails() {
		return this.declineDetails;
	}

	public void setDeclineDetails(String declineDetails) {
		this.declineDetails = declineDetails;
	}

	public Long getFactoryStatus() {
		return this.factoryStatus;
	}

	public void setFactoryStatus(Long factoryStatus) {
		this.factoryStatus = factoryStatus;
	}

	public String getFireProtectDevice() {
		return this.fireProtectDevice;
	}

	public void setFireProtectDevice(String fireProtectDevice) {
		this.fireProtectDevice = fireProtectDevice;
	}

	public Double getFirmCapitalPaid() {
		return this.firmCapitalPaid;
	}

	public void setFirmCapitalPaid(Double firmCapitalPaid) {
		this.firmCapitalPaid = firmCapitalPaid;
	}

	public Double getFloatDecBasisAmt() {
		return this.floatDecBasisAmt;
	}

	public void setFloatDecBasisAmt(Double floatDecBasisAmt) {
		this.floatDecBasisAmt = floatDecBasisAmt;
	}

	public Double getFloaterBasisAmt() {
		return this.floaterBasisAmt;
	}

	public void setFloaterBasisAmt(Double floaterBasisAmt) {
		this.floaterBasisAmt = floaterBasisAmt;
	}

	public String getFloorMaterialUsed() {
		return this.floorMaterialUsed;
	}

	public void setFloorMaterialUsed(String floorMaterialUsed) {
		this.floorMaterialUsed = floorMaterialUsed;
	}

	public Double getForestFire() {
		return this.forestFire;
	}

	public void setForestFire(Double forestFire) {
		this.forestFire = forestFire;
	}

	public String getGoodsAsPerList() {
		return this.goodsAsPerList;
	}

	public void setGoodsAsPerList(String goodsAsPerList) {
		this.goodsAsPerList = goodsAsPerList;
	}

	public String getGoodsStoredList() {
		return this.goodsStoredList;
	}

	public void setGoodsStoredList(String goodsStoredList) {
		this.goodsStoredList = goodsStoredList;
	}

	public Double getInsrncPremium() {
		return this.insrncPremium;
	}

	public void setInsrncPremium(Double insrncPremium) {
		this.insrncPremium = insrncPremium;
	}

	public String getInsrnceDetails() {
		return this.insrnceDetails;
	}

	public void setInsrnceDetails(String insrnceDetails) {
		this.insrnceDetails = insrnceDetails;
	}

	public Date getInsurEndDt() {
		return this.insurEndDt;
	}

	public void setInsurEndDt(Date insurEndDt) {
		this.insurEndDt = insurEndDt;
	}

	public Date getInsurStartDt() {
		return this.insurStartDt;
	}

	public void setInsurStartDt(Date insurStartDt) {
		this.insurStartDt = insurStartDt;
	}

	public String getIsArchitectFeesAdd() {
		return this.isArchitectFeesAdd;
	}

	public void setIsArchitectFeesAdd(String isArchitectFeesAdd) {
		this.isArchitectFeesAdd = isArchitectFeesAdd;
	}

	public String getIsCoverPinth() {
		return this.isCoverPinth;
	}

	public void setIsCoverPinth(String isCoverPinth) {
		this.isCoverPinth = isCoverPinth;
	}

	public String getIsDebrisRemvAdd() {
		return this.isDebrisRemvAdd;
	}

	public void setIsDebrisRemvAdd(String isDebrisRemvAdd) {
		this.isDebrisRemvAdd = isDebrisRemvAdd;
	}

	public String getIsDeclaraeBasis() {
		return this.isDeclaraeBasis;
	}

	public void setIsDeclaraeBasis(String isDeclaraeBasis) {
		this.isDeclaraeBasis = isDeclaraeBasis;
	}

	public String getIsEarthquakeCov() {
		return this.isEarthquakeCov;
	}

	public void setIsEarthquakeCov(String isEarthquakeCov) {
		this.isEarthquakeCov = isEarthquakeCov;
	}

	public String getIsFloatDecBasis() {
		return this.isFloatDecBasis;
	}

	public void setIsFloatDecBasis(String isFloatDecBasis) {
		this.isFloatDecBasis = isFloatDecBasis;
	}

	public String getIsFloaterBasis() {
		return this.isFloaterBasis;
	}

	public void setIsFloaterBasis(String isFloaterBasis) {
		this.isFloaterBasis = isFloaterBasis;
	}

	public String getIsInsrDeclined() {
		return this.isInsrDeclined;
	}

	public void setIsInsrDeclined(String isInsrDeclined) {
		this.isInsrDeclined = isInsrDeclined;
	}

	public String getIsOthrCompIns() {
		return this.isOthrCompIns;
	}

	public void setIsOthrCompIns(String isOthrCompIns) {
		this.isOthrCompIns = isOthrCompIns;
	}

	public String getIsResiOffcShop() {
		return this.isResiOffcShop;
	}

	public void setIsResiOffcShop(String isResiOffcShop) {
		this.isResiOffcShop = isResiOffcShop;
	}

	public String getIsRiReqd() {
		return this.isRiReqd;
	}

	public void setIsRiReqd(String isRiReqd) {
		this.isRiReqd = isRiReqd;
	}

	public String getIsStockStorOpen() {
		return this.isStockStorOpen;
	}

	public void setIsStockStorOpen(String isStockStorOpen) {
		this.isStockStorOpen = isStockStorOpen;
	}

	public String getIsUsedAsShop() {
		return this.isUsedAsShop;
	}

	public void setIsUsedAsShop(String isUsedAsShop) {
		this.isUsedAsShop = isUsedAsShop;
	}

	public String getIssuedInFavor() {
		return this.issuedInFavor;
	}

	public void setIssuedInFavor(String issuedInFavor) {
		this.issuedInFavor = issuedInFavor;
	}

	public String getManufProductList() {
		return this.manufProductList;
	}

	public void setManufProductList(String manufProductList) {
		this.manufProductList = manufProductList;
	}

	public String getMarketValBasis() {
		return this.marketValBasis;
	}

	public void setMarketValBasis(String marketValBasis) {
		this.marketValBasis = marketValBasis;
	}

	public Double getOmmissionAddtn() {
		return this.ommissionAddtn;
	}

	public void setOmmissionAddtn(Double ommissionAddtn) {
		this.ommissionAddtn = ommissionAddtn;
	}

	public Double getOpenStocksAmt() {
		return this.openStocksAmt;
	}

	public void setOpenStocksAmt(Double openStocksAmt) {
		this.openStocksAmt = openStocksAmt;
	}

	public String getOpenStorLoc() {
		return this.openStorLoc;
	}

	public void setOpenStorLoc(String openStorLoc) {
		this.openStorLoc = openStorLoc;
	}

	public String getOthrCompnyName() {
		return this.othrCompnyName;
	}

	public void setOthrCompnyName(String othrCompnyName) {
		this.othrCompnyName = othrCompnyName;
	}

	public String getOutGasTanksRisk() {
		return this.outGasTanksRisk;
	}

	public void setOutGasTanksRisk(String outGasTanksRisk) {
		this.outGasTanksRisk = outGasTanksRisk;
	}

	public String getOutStorgRisk() {
		return this.outStorgRisk;
	}

	public void setOutStorgRisk(String outStorgRisk) {
		this.outStorgRisk = outStorgRisk;
	}

	public Double getPayablePremAmt() {
		return this.payablePremAmt;
	}

	public void setPayablePremAmt(Double payablePremAmt) {
		this.payablePremAmt = payablePremAmt;
	}

	public Date getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Long getPaymentModeId() {
		return this.paymentModeId;
	}

	public void setPaymentModeId(Long paymentModeId) {
		this.paymentModeId = paymentModeId;
	}

	public Double getPremDiscAmt() {
		return this.premDiscAmt;
	}

	public void setPremDiscAmt(Double premDiscAmt) {
		this.premDiscAmt = premDiscAmt;
	}

	public Double getPremDiscPc() {
		return this.premDiscPc;
	}

	public void setPremDiscPc(Double premDiscPc) {
		this.premDiscPc = premDiscPc;
	}

	public Double getPremGstAmt() {
		return this.premGstAmt;
	}

	public void setPremGstAmt(Double premGstAmt) {
		this.premGstAmt = premGstAmt;
	}

	public Double getPremGstPc() {
		return this.premGstPc;
	}

	public void setPremGstPc(Double premGstPc) {
		this.premGstPc = premGstPc;
	}

	public String getProposerBusiness() {
		return this.proposerBusiness;
	}

	public void setProposerBusiness(String proposerBusiness) {
		this.proposerBusiness = proposerBusiness;
	}

	public Long getPropslPoliciesId() {
		return this.propslPoliciesId;
	}

	public void setPropslPoliciesId(Long propslPoliciesId) {
		this.propslPoliciesId = propslPoliciesId;
	}

	public Double getRateOfIntrst() {
		return this.rateOfIntrst;
	}

	public void setRateOfIntrst(Double rateOfIntrst) {
		this.rateOfIntrst = rateOfIntrst;
	}

	public Date getReferenceDt() {
		return this.referenceDt;
	}

	public void setReferenceDt(Date referenceDt) {
		this.referenceDt = referenceDt;
	}

	public String getReferenceNo() {
		return this.referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getReinstatValBasis() {
		return this.reinstatValBasis;
	}

	public void setReinstatValBasis(String reinstatValBasis) {
		this.reinstatValBasis = reinstatValBasis;
	}

	public String getRoofMaterialUsed() {
		return this.roofMaterialUsed;
	}

	public void setRoofMaterialUsed(String roofMaterialUsed) {
		this.roofMaterialUsed = roofMaterialUsed;
	}

	public Double getSpontCombustion() {
		return this.spontCombustion;
	}

	public void setSpontCombustion(Double spontCombustion) {
		this.spontCombustion = spontCombustion;
	}

	public String getStockValExceed() {
		return this.stockValExceed;
	}

	public void setStockValExceed(String stockValExceed) {
		this.stockValExceed = stockValExceed;
	}

	public Double getSumInsured() {
		return this.sumInsured;
	}

	public void setSumInsured(Double sumInsured) {
		this.sumInsured = sumInsured;
	}

	public String getTerrorismDtls() {
		return this.terrorismDtls;
	}

	public void setTerrorismDtls(String terrorismDtls) {
		this.terrorismDtls = terrorismDtls;
	}

	public Double getTotAddonPrem() {
		return this.totAddonPrem;
	}

	public void setTotAddonPrem(Double totAddonPrem) {
		this.totAddonPrem = totAddonPrem;
	}

	public Double getTotRiAmt() {
		return this.totRiAmt;
	}

	public void setTotRiAmt(Double totRiAmt) {
		this.totRiAmt = totRiAmt;
	}

	public Double getTotalPremium() {
		return this.totalPremium;
	}

	public void setTotalPremium(Double totalPremium) {
		this.totalPremium = totalPremium;
	}

	public String getUsedAsIndustry() {
		return this.usedAsIndustry;
	}

	public void setUsedAsIndustry(String usedAsIndustry) {
		this.usedAsIndustry = usedAsIndustry;
	}

	public String getUsedWarehouseGodwn() {
		return this.usedWarehouseGodwn;
	}

	public void setUsedWarehouseGodwn(String usedWarehouseGodwn) {
		this.usedWarehouseGodwn = usedWarehouseGodwn;
	}

	public String getUtilitiesOutRisk() {
		return this.utilitiesOutRisk;
	}

	public void setUtilitiesOutRisk(String utilitiesOutRisk) {
		this.utilitiesOutRisk = utilitiesOutRisk;
	}

	public Double getVehicleDamage() {
		return this.vehicleDamage;
	}

	public void setVehicleDamage(Double vehicleDamage) {
		this.vehicleDamage = vehicleDamage;
	}

	public String getWallMaterialUsed() {
		return this.wallMaterialUsed;
	}

	public void setWallMaterialUsed(String wallMaterialUsed) {
		this.wallMaterialUsed = wallMaterialUsed;
	}

	public List<TdoiDbFireBuildingValDTO> getTdoiDbFireBuildingVals() {
		return this.tdoiDbFireBuildingVals;
	}

	public void setTdoiDbFireBuildingVals(List<TdoiDbFireBuildingValDTO> tdoiDbFireBuildingVals) {
		this.tdoiDbFireBuildingVals = tdoiDbFireBuildingVals;
	}

	public TdoiDbFireBuildingValDTO addTdoiDbFireBuildingVal(TdoiDbFireBuildingValDTO tdoiDbFireBuildingVal) {
		getTdoiDbFireBuildingVals().add(tdoiDbFireBuildingVal);
		tdoiDbFireBuildingVal.setTdoiDbPropslFirePeril(this);

		return tdoiDbFireBuildingVal;
	}

	public TdoiDbFireBuildingValDTO removeTdoiDbFireBuildingVal(TdoiDbFireBuildingValDTO tdoiDbFireBuildingVal) {
		getTdoiDbFireBuildingVals().remove(tdoiDbFireBuildingVal);
		tdoiDbFireBuildingVal.setTdoiDbPropslFirePeril(null);

		return tdoiDbFireBuildingVal;
	}

	public List<TdoiDbFirePastPolicyDTO> getTdoiDbFirePastPolicies() {
		return this.tdoiDbFirePastPolicies;
	}

	public void setTdoiDbFirePastPolicies(List<TdoiDbFirePastPolicyDTO> tdoiDbFirePastPolicies) {
		this.tdoiDbFirePastPolicies = tdoiDbFirePastPolicies;
	}

	public TdoiDbFirePastPolicyDTO addTdoiDbFirePastPolicy(TdoiDbFirePastPolicyDTO tdoiDbFirePastPolicy) {
		getTdoiDbFirePastPolicies().add(tdoiDbFirePastPolicy);
		tdoiDbFirePastPolicy.setTdoiDbPropslFirePeril(this);

		return tdoiDbFirePastPolicy;
	}

	public TdoiDbFirePastPolicyDTO removeTdoiDbFirePastPolicy(TdoiDbFirePastPolicyDTO tdoiDbFirePastPolicy) {
		getTdoiDbFirePastPolicies().remove(tdoiDbFirePastPolicy);
		tdoiDbFirePastPolicy.setTdoiDbPropslFirePeril(null);

		return tdoiDbFirePastPolicy;
	}

	public List<TdoiDbFireRiskLocDTO> getTdoiDbFireRiskLocs() {
		return this.tdoiDbFireRiskLocs;
	}

	public void setTdoiDbFireRiskLocs(List<TdoiDbFireRiskLocDTO> tdoiDbFireRiskLocs) {
		this.tdoiDbFireRiskLocs = tdoiDbFireRiskLocs;
	}

	public TdoiDbFireRiskLocDTO addTdoiDbFireRiskLoc(TdoiDbFireRiskLocDTO tdoiDbFireRiskLoc) {
		getTdoiDbFireRiskLocs().add(tdoiDbFireRiskLoc);
		tdoiDbFireRiskLoc.setTdoiDbPropslFirePeril(this);

		return tdoiDbFireRiskLoc;
	}

	public TdoiDbFireRiskLocDTO removeTdoiDbFireRiskLoc(TdoiDbFireRiskLocDTO tdoiDbFireRiskLoc) {
		getTdoiDbFireRiskLocs().remove(tdoiDbFireRiskLoc);
		tdoiDbFireRiskLoc.setTdoiDbPropslFirePeril(null);

		return tdoiDbFireRiskLoc;
	}

	public List<TdoiDbFireSumInsuredDTO> getTdoiDbFireSumInsureds() {
		return this.tdoiDbFireSumInsureds;
	}

	public void setTdoiDbFireSumInsureds(List<TdoiDbFireSumInsuredDTO> tdoiDbFireSumInsureds) {
		this.tdoiDbFireSumInsureds = tdoiDbFireSumInsureds;
	}

	public TdoiDbFireSumInsuredDTO addTdoiDbFireSumInsured(TdoiDbFireSumInsuredDTO tdoiDbFireSumInsured) {
		getTdoiDbFireSumInsureds().add(tdoiDbFireSumInsured);
		tdoiDbFireSumInsured.setTdoiDbPropslFirePeril(this);

		return tdoiDbFireSumInsured;
	}

	public TdoiDbFireSumInsuredDTO removeTdoiDbFireSumInsured(TdoiDbFireSumInsuredDTO tdoiDbFireSumInsured) {
		getTdoiDbFireSumInsureds().remove(tdoiDbFireSumInsured);
		tdoiDbFireSumInsured.setTdoiDbPropslFirePeril(null);

		return tdoiDbFireSumInsured;
	}

	public TdoiDbProposalDTO getTdoiDbProposal() {
		return this.tdoiDbProposal;
	}

	public void setTdoiDbProposal(TdoiDbProposalDTO tdoiDbProposal) {
		this.tdoiDbProposal = tdoiDbProposal;
	}

	public List<TdoiDbPropslFireWfDTO> getTdoiDbPropslFireWfs() {
		return this.tdoiDbPropslFireWfs;
	}

	public void setTdoiDbPropslFireWfs(List<TdoiDbPropslFireWfDTO> tdoiDbPropslFireWfs) {
		this.tdoiDbPropslFireWfs = tdoiDbPropslFireWfs;
	}

	public TdoiDbPropslFireWfDTO addTdoiDbPropslFireWf(TdoiDbPropslFireWfDTO tdoiDbPropslFireWf) {
		getTdoiDbPropslFireWfs().add(tdoiDbPropslFireWf);
		tdoiDbPropslFireWf.setTdoiDbPropslFirePeril(this);

		return tdoiDbPropslFireWf;
	}

	public TdoiDbPropslFireWfDTO removeTdoiDbPropslFireWf(TdoiDbPropslFireWfDTO tdoiDbPropslFireWf) {
		getTdoiDbPropslFireWfs().remove(tdoiDbPropslFireWf);
		tdoiDbPropslFireWf.setTdoiDbPropslFirePeril(null);

		return tdoiDbPropslFireWf;
	}

	public List<TdoiDbPropFireRiDtlDTO> getTdoiDbPropFireRiDtls() {
		return this.tdoiDbPropFireRiDtls;
	}

	public void setTdoiDbPropFireRiDtls(List<TdoiDbPropFireRiDtlDTO> tdoiDbPropFireRiDtls) {
		this.tdoiDbPropFireRiDtls = tdoiDbPropFireRiDtls;
	}

	public TdoiDbPropFireRiDtlDTO addTdoiDbPropFireRiDtl(TdoiDbPropFireRiDtlDTO tdoiDbPropFireRiDtl) {
		getTdoiDbPropFireRiDtls().add(tdoiDbPropFireRiDtl);
		tdoiDbPropFireRiDtl.setTdoiDbPropslFirePeril(this);

		return tdoiDbPropFireRiDtl;
	}

	public TdoiDbPropFireRiDtlDTO removeTdoiDbPropFireRiDtl(TdoiDbPropFireRiDtlDTO tdoiDbPropFireRiDtl) {
		getTdoiDbPropFireRiDtls().remove(tdoiDbPropFireRiDtl);
		tdoiDbPropFireRiDtl.setTdoiDbPropslFirePeril(null);

		return tdoiDbPropFireRiDtl;
	}

}
