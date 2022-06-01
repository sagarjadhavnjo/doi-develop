package gov.ifms.doi.db.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;
/**
 * The persistent class for the TDOI_DB_PROPSL_FIRE_PERIL database table.
 * 
 */
@Entity
@Table(name = "TDOI_DB_PROPSL_FIRE_PERIL", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiDbPropslFirePerilEntity.findAll", query = "SELECT t FROM TdoiDbPropslFirePerilEntity t")
public class TdoiDbPropslFirePerilEntity extends BaseEntity {
	private static final Long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FIRE_PERIL_ID", unique = true, nullable = false)
	private Long firePerilId;

	@Column(name = "PROPSL_POLICIES_ID", nullable = false)
	private Long propslPoliciesId;

	@Column(name = "PROPOSER_BUSINESS", length = 100)
	private String proposerBusiness;

	@Column(name = "FIRM_CAPITAL_PAID")
	private Double firmCapitalPaid;

	@Column(name = "ISSUED_IN_FAVOR", length = 200)
	private String issuedInFavor;

	@Temporal(TemporalType.DATE)
	@Column(name = "INSUR_START_DT")
	private Date insurStartDt;

	@Temporal(TemporalType.DATE)
	@Column(name = "INSUR_END_DT")
	private Date insurEndDt;

	@Column(name = "COVERS_INCLUDED", length = 200)
	private String coversIncluded;

	@Column(name = "IS_COVER_PINTH", length = 1)
	private String isCoverPinth;

	@Column(name = "IS_ARCHITECT_FEES_ADD", length = 1)
	private String isArchitectFeesAdd;

	@Column(name = "ARCHITECT_FEES")
	private Double architectFees;

	@Column(name = "IS_DEBRIS_REMV_ADD", length = 1)
	private String isDebrisRemvAdd;

	@Column(name = "DEBRIS_REMVL_AMT")
	private Double debrisRemvlAmt;

	@Column(name = "COLD_STRG_DETOR")
	private Double coldStrgDetor;

	@Column(name = "FOREST_FIRE")
	private Double forestFire;

	@Column(name = "VEHICLE_DAMAGE")
	private Double vehicleDamage;

	@Column(name = "SPONT_COMBUSTION")
	private Double spontCombustion;

	@Column(name = "OMMISSION_ADDTN")
	private Double ommissionAddtn;

	@Column(name = "IS_EARTHQUAKE_COV", length = 1)
	private String isEarthquakeCov;

	@Column(name = "IS_OTHR_COMP_INS", length = 1)
	private String isOthrCompIns;

	@Column(name = "OTHR_COMPNY_NAME", length = 100)
	private String othrCompnyName;

	@Column(name = "INSRNCE_DETAILS", length = 200)
	private String insrnceDetails;

	@Column(name = "IS_INSR_DECLINED", length = 1)
	private String isInsrDeclined;

	@Column(name = "DECLINE_DETAILS", length = 200)
	private String declineDetails;

	@Column(name = "TERRORISM_DTLS", length = 100)
	private String terrorismDtls;

	@Column(name = "IS_RESI_OFFC_SHOP", length = 1)
	private String isResiOffcShop;


	@Column(name = "ANY_INDUSTRY_RISK", length = 1)
	private String anyIndustryRisk;

	@Column(name = "OUT_STORG_RISK", length = 1)
	private String outStorgRisk;

	@Column(name = "OUT_GAS_TANKS_RISK", length = 1)
	private String outGasTanksRisk;

	@Column(name = "UTILITIES_OUT_RISK", length = 1)
	private String utilitiesOutRisk;

	@Column(name = "IS_USED_AS_SHOP", length = 1)
	private String isUsedAsShop;

	@Column(name = "GOODS_AS_PER_LIST", length = 1)
	private String goodsAsPerList;

	@Column(name = "STOCK_VAL_EXCEED", length = 1)
	private String stockValExceed;

	@Column(name = "USED_WAREHOUSE_GODWN", length = 1)
	private String usedWarehouseGodwn;

	@Column(name = "GOODS_STORED_LIST", length = 400)
	private String goodsStoredList;

	@Column(name = "USED_AS_INDUSTRY", length = 1)
	private String usedAsIndustry;

	@Column(name = "MANUF_PRODUCT_LIST", length = 400)
	private String manufProductList;

	@Column(name = "FACTORY_STATUS")
	private Long factoryStatus;

	@Column(name = "FIRE_PROTECT_DEVICE", length = 200)
	private String fireProtectDevice;

	@Column(name = "BASIS_PROP_INSUR", length = 20)
	private String basisPropInsur;

	@Column(name = "MARKET_VAL_BASIS", length = 10)
	private String marketValBasis;

	@Column(name = "REINSTAT_VAL_BASIS", length = 10)
	private String reinstatValBasis;

	@Column(name = "WALL_MATERIAL_USED", length = 200)
	private String wallMaterialUsed;

	@Column(name = "FLOOR_MATERIAL_USED", length = 200)
	private String floorMaterialUsed;

	@Column(name = "ROOF_MATERIAL_USED", length = 200)
	private String roofMaterialUsed;

	@Column(name = "BUILDING_HEIGHT", length = 20)
	private String buildingHeight;

	@Column(name = "BUILDING_AGE_ID")
	private Long buildingAgeId;

	@Column(name = "IS_FLOATER_BASIS", length = 1)
	private String isFloaterBasis;

	@Column(name = "FLOATER_BASIS_AMT")
	private Double floaterBasisAmt;

	@Column(name = "IS_DECLARAE_BASIS", length = 1)
	private String isDeclaraeBasis;

	@Column(name = "DECLARE_BASIS_AMT")
	private Double declareBasisAmt;

	@Column(name = "IS_FLOAT_DEC_BASIS", length = 1)
	private String isFloatDecBasis;

	@Column(name = "FLOAT_DEC_BASIS_AMT")
	private Double floatDecBasisAmt;

	@Column(name = "IS_STOCK_STOR_OPEN", length = 1)
	private String isStockStorOpen;

	@Column(name = "OPEN_STOR_LOC", length = 50)
	private String openStorLoc;

	@Column(name = "OPEN_STOCKS_AMT")
	private Double openStocksAmt;

	@Column(name = "SUM_INSURED")
	private Double sumInsured;

	@Column(name = "RATE_OF_INTRST")
	private Double rateOfIntrst;

	@Column(name = "INSRNC_PREMIUM")
	private Double insrncPremium;

	@Column(name = "PREM_DISC_PC")
	private Double premDiscPc;

	@Column(name = "PREM_DISC_AMT")
	private Double premDiscAmt;

	@Column(name = "TOT_ADDON_PREM")
	private Double totAddonPrem;

	@Column(name = "TOTAL_PREMIUM")
	private Double totalPremium;

	@Column(name = "PREM_GST_PC")
	private Double premGstPc;

	@Column(name = "PREM_GST_AMT")
	private Double premGstAmt;

	@Column(name = "PAYABLE_PREM_AMT")
	private Double payablePremAmt;

	@Column(name = "IS_RI_REQD", length = 1)
	private String isRiReqd;

	@Column(name = "TOT_RI_AMT")
	private Double totRiAmt;

	@Column(name = "PAYMENT_MODE_ID")
	private Long paymentModeId;

	@Temporal(TemporalType.DATE)
	@Column(name = "CHEQUE_DD_DT")
	private Date chequeDdDt;

	@Column(name = "BANK_ID")
	private Long bankId;

	@Column(name = "BRANCH_ID")
	private Long branchId;

	@Column(name = "CHEQUE_DD_NO", length = 20)
	private String chequeDdNo;

	@Column(name = "BANK_NAME", length = 40)
	private String bankName;

	@Column(name = "BRANCH_NAME", length = 40)
	private String branchName;

	@Column(name = "CHALLAN_NO", length = 20)
	private String challanNo;

	@Temporal(TemporalType.DATE)
	@Column(name = "CHALLAN_DT")
	private Date challanDt;

	@Column(name = "CHALLAN_AMOUNT")
	private Double challanAmount;

	@Temporal(TemporalType.DATE)
	@Column(name = "PAYMENT_DATE")
	private Date paymentDate;

	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	@Column(name = "REFERENCE_NO", length = 30)
	private String referenceNo;

	// bi-directional many-to-one association to TdoiDbProposal
	@ManyToOne
	@JoinColumn(name = "DB_PROPOSAL_ID", nullable = false)
	@JsonBackReference
	private TdoiDbProposalEntity tdoiDbProposal;

	// bi-directional many-to-one association to TdoiDbFireRiskLoc
	@OneToMany(mappedBy = "tdoiDbPropslFirePeril",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<TdoiDbFireRiskLocEntity> tdoiDbFireRiskLocs;

	// bi-directional many-to-one association to TdoiDbFirePastPolicy
	@OneToMany(mappedBy = "tdoiDbPropslFirePeril",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<TdoiDbFirePastPolicyEntity> tdoiDbFirePastPolicies;

	// bi-directional many-to-one association to TdoiDbFireBuildingVal
	@OneToMany(mappedBy = "tdoiDbPropslFirePeril",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<TdoiDbFireBuildingValEntity> tdoiDbFireBuildingVals;

	// bi-directional many-to-one association to TdoiDbFireSumInsured
	@OneToMany(mappedBy = "tdoiDbPropslFirePeril",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<TdoiDbFireSumInsuredEntity> tdoiDbFireSumInsureds;

	// bi-directional many-to-one association to TdoiDbPropFireRiDtl
	@OneToMany(mappedBy = "tdoiDbPropslFirePeril",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<TdoiDbPropFireRiDtlEntity> tdoiDbPropFireRiDtls;

	// bi-directional many-to-one association to TdoiDbPropslFireWf
	@OneToMany(mappedBy = "tdoiDbPropslFirePeril",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<TdoiDbPropslFireWfEntity> tdoiDbPropslFireWfs;

	public TdoiDbPropslFirePerilEntity() {
	}

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

	public List<TdoiDbFireBuildingValEntity> getTdoiDbFireBuildingVals() {
		return this.tdoiDbFireBuildingVals;
	}

	public void setTdoiDbFireBuildingVals(List<TdoiDbFireBuildingValEntity> tdoiDbFireBuildingVals) {
		this.tdoiDbFireBuildingVals = tdoiDbFireBuildingVals;
	}

	public TdoiDbFireBuildingValEntity addTdoiDbFireBuildingVal(TdoiDbFireBuildingValEntity tdoiDbFireBuildingVal) {
		getTdoiDbFireBuildingVals().add(tdoiDbFireBuildingVal);
		tdoiDbFireBuildingVal.setTdoiDbPropslFirePeril(this);

		return tdoiDbFireBuildingVal;
	}

	public TdoiDbFireBuildingValEntity removeTdoiDbFireBuildingVal(TdoiDbFireBuildingValEntity tdoiDbFireBuildingVal) {
		getTdoiDbFireBuildingVals().remove(tdoiDbFireBuildingVal);
		tdoiDbFireBuildingVal.setTdoiDbPropslFirePeril(null);

		return tdoiDbFireBuildingVal;
	}

	public List<TdoiDbFirePastPolicyEntity> getTdoiDbFirePastPolicies() {
		return this.tdoiDbFirePastPolicies;
	}

	public void setTdoiDbFirePastPolicies(List<TdoiDbFirePastPolicyEntity> tdoiDbFirePastPolicies) {
		this.tdoiDbFirePastPolicies = tdoiDbFirePastPolicies;
	}

	public TdoiDbFirePastPolicyEntity addTdoiDbFirePastPolicy(TdoiDbFirePastPolicyEntity tdoiDbFirePastPolicy) {
		getTdoiDbFirePastPolicies().add(tdoiDbFirePastPolicy);
		tdoiDbFirePastPolicy.setTdoiDbPropslFirePeril(this);

		return tdoiDbFirePastPolicy;
	}

	public TdoiDbFirePastPolicyEntity removeTdoiDbFirePastPolicy(TdoiDbFirePastPolicyEntity tdoiDbFirePastPolicy) {
		getTdoiDbFirePastPolicies().remove(tdoiDbFirePastPolicy);
		tdoiDbFirePastPolicy.setTdoiDbPropslFirePeril(null);

		return tdoiDbFirePastPolicy;
	}

	public List<TdoiDbFireRiskLocEntity> getTdoiDbFireRiskLocs() {
		return this.tdoiDbFireRiskLocs;
	}

	public void setTdoiDbFireRiskLocs(List<TdoiDbFireRiskLocEntity> tdoiDbFireRiskLocs) {
		this.tdoiDbFireRiskLocs = tdoiDbFireRiskLocs;
	}

	public TdoiDbFireRiskLocEntity addTdoiDbFireRiskLoc(TdoiDbFireRiskLocEntity tdoiDbFireRiskLoc) {
		getTdoiDbFireRiskLocs().add(tdoiDbFireRiskLoc);
		tdoiDbFireRiskLoc.setTdoiDbPropslFirePeril(this);

		return tdoiDbFireRiskLoc;
	}

	public TdoiDbFireRiskLocEntity removeTdoiDbFireRiskLoc(TdoiDbFireRiskLocEntity tdoiDbFireRiskLoc) {
		getTdoiDbFireRiskLocs().remove(tdoiDbFireRiskLoc);
		tdoiDbFireRiskLoc.setTdoiDbPropslFirePeril(null);

		return tdoiDbFireRiskLoc;
	}

	public List<TdoiDbFireSumInsuredEntity> getTdoiDbFireSumInsureds() {
		return this.tdoiDbFireSumInsureds;
	}

	public void setTdoiDbFireSumInsureds(List<TdoiDbFireSumInsuredEntity> tdoiDbFireSumInsureds) {
		this.tdoiDbFireSumInsureds = tdoiDbFireSumInsureds;
	}

	public TdoiDbFireSumInsuredEntity addTdoiDbFireSumInsured(TdoiDbFireSumInsuredEntity tdoiDbFireSumInsured) {
		getTdoiDbFireSumInsureds().add(tdoiDbFireSumInsured);
		tdoiDbFireSumInsured.setTdoiDbPropslFirePeril(this);

		return tdoiDbFireSumInsured;
	}

	public TdoiDbFireSumInsuredEntity removeTdoiDbFireSumInsured(TdoiDbFireSumInsuredEntity tdoiDbFireSumInsured) {
		getTdoiDbFireSumInsureds().remove(tdoiDbFireSumInsured);
		tdoiDbFireSumInsured.setTdoiDbPropslFirePeril(null);

		return tdoiDbFireSumInsured;
	}

	public TdoiDbProposalEntity getTdoiDbProposal() {
		return this.tdoiDbProposal;
	}

	public void setTdoiDbProposal(TdoiDbProposalEntity tdoiDbProposal) {
		this.tdoiDbProposal = tdoiDbProposal;
	}

	public List<TdoiDbPropslFireWfEntity> getTdoiDbPropslFireWfs() {
		return this.tdoiDbPropslFireWfs;
	}

	public void setTdoiDbPropslFireWfs(List<TdoiDbPropslFireWfEntity> tdoiDbPropslFireWfs) {
		this.tdoiDbPropslFireWfs = tdoiDbPropslFireWfs;
	}

	public TdoiDbPropslFireWfEntity addTdoiDbPropslFireWf(TdoiDbPropslFireWfEntity tdoiDbPropslFireWf) {
		getTdoiDbPropslFireWfs().add(tdoiDbPropslFireWf);
		tdoiDbPropslFireWf.setTdoiDbPropslFirePeril(this);

		return tdoiDbPropslFireWf;
	}

	public TdoiDbPropslFireWfEntity removeTdoiDbPropslFireWf(TdoiDbPropslFireWfEntity tdoiDbPropslFireWf) {
		getTdoiDbPropslFireWfs().remove(tdoiDbPropslFireWf);
		tdoiDbPropslFireWf.setTdoiDbPropslFirePeril(null);

		return tdoiDbPropslFireWf;
	}

	public List<TdoiDbPropFireRiDtlEntity> getTdoiDbPropFireRiDtls() {
		return this.tdoiDbPropFireRiDtls;
	}

	public void setTdoiDbPropFireRiDtls(List<TdoiDbPropFireRiDtlEntity> tdoiDbPropFireRiDtls) {
		this.tdoiDbPropFireRiDtls = tdoiDbPropFireRiDtls;
	}

	public TdoiDbPropFireRiDtlEntity addTdoiDbPropFireRiDtl(TdoiDbPropFireRiDtlEntity tdoiDbPropFireRiDtl) {
		getTdoiDbPropFireRiDtls().add(tdoiDbPropFireRiDtl);
		tdoiDbPropFireRiDtl.setTdoiDbPropslFirePeril(this);

		return tdoiDbPropFireRiDtl;
	}

	public TdoiDbPropFireRiDtlEntity removeTdoiDbPropFireRiDtl(TdoiDbPropFireRiDtlEntity tdoiDbPropFireRiDtl) {
		getTdoiDbPropFireRiDtls().remove(tdoiDbPropFireRiDtl);
		tdoiDbPropFireRiDtl.setTdoiDbPropslFirePeril(null);

		return tdoiDbPropFireRiDtl;
	}

}