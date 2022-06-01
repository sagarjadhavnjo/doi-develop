package gov.ifms.doi.jpa.controller;

import gov.ifms.doi.db.constant.DoiDBConstants;
import gov.ifms.doi.db.constant.DoiDBUriConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.StateDTO;
import gov.ifms.doi.jpa.service.BankBranchService;
import gov.ifms.doi.jpa.service.BankService;
import gov.ifms.doi.jpa.service.DistrictService;
import gov.ifms.doi.jpa.service.DoiCommonLookupInfoService;
import gov.ifms.doi.jpa.service.StateService;
import gov.ifms.doi.jpa.service.TalukaService;
import gov.ifms.doi.jpa.service.VillageService;

import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.*;

/**
 * 
 * @author Sagar Jadhav
 *
 */
@RestController
public class CommonController {

	@Autowired
	DoiCommonLookupInfoService doiCommonLookupInfoService;

	@Autowired
	StateService stateService;

	@Autowired
	DistrictService districtService;

	@Autowired
	TalukaService talukaService;

	@Autowired
	VillageService villageService;

	@Autowired
	BankService bankService;

	@Autowired
	BankBranchService bankBranchService;

	@Trace
	@GetMapping(value = JPA_COMMON_LOOKUP_CAUSE_OF_LOST, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getStatusList() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiJPAConstants.CAUSE_OF_LOSS_LIST));
	}

	@Trace
	@GetMapping(value = JPA_COMMON_REQUIREMENT_LIST, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getRequirementList() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiJPAConstants.YES_NO_REQUIREMENT_LIST));
	}

	@Trace
	@GetMapping(value = JPA_ACTIVE_INACTIVE_LIST, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getActiveInActiveList() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiJPAConstants.ACTIVE_INACTIVE_LIST));
	}

	@Trace
	@GetMapping(value = JPA_POLICY_TYPES_LIST, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getPolicyTypeList() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiJPAConstants.ACTIVE_POLICY_TYPES_LIST));
	}

	@Trace
	@GetMapping(value = JPA_POLICY_STATUS_LIST, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getPolicyStatusList() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiJPAConstants.ACTIVE_POLICY_STATUS_LIST));
	}

	@Trace
	@GetMapping(value = JPA_YEAR_LIST, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getYearList() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiJPAConstants.ACTIVE_YEAR_LIST));
	}

	@Trace
	@GetMapping(value = JPA_MONTH_LIST, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getMonthList() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiJPAConstants.ACTIVE_MONTH_LIST));
	}

	@Trace
	@GetMapping(value = JPA_LOOKUP_INFO_BASED_ON_CATEGORY, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getLookupInfo(@RequestParam(name = "pathVariable") String pathVariable) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(pathVariable));
	}

	@Trace
	@GetMapping(value = JPA_DOI_GET_DISTRICT_LIST_GUJRAT, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getDistrictListGujrat() {
		StateDTO stateDTO = stateService.getStateByName(DoiJPAConstants.GUJRAT_STATE);
		if (stateDTO != null) {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
					districtService.getDistrictByStateId(stateDTO.getStateId()));
		}
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				districtService.getDistrictByStateId(DoiJPAConstants.GUJRAT_STATE_ID));
	}

	@Trace
	@GetMapping(value = JPA_DOI_GET_DISTRICT_LIST_BY_STATE_ID, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getDistrictListByStateId(
			@RequestParam(name = "pathVariable") Long pathVariable) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				districtService.getDistrictByStateId(pathVariable));
	}

	@Trace
	@GetMapping(value = JPA_DOI_GET_DISTRICT_LIST, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getDistrictList() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				districtService.getDistrictList());
	}

	@Trace
	@GetMapping(value = JPA_DOI_GET_TALUKA_LIST_BY_DISTRICT_ID, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getTalukaListByDistrictId(
			@RequestParam(name = "pathVariable") Long pathVariable) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				talukaService.getTalukaListByDistrictId(pathVariable));
	}

	@Trace
	@GetMapping(value = JPA_DOI_GET_VILLAGE_LIST_BY_TALUKA_ID, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getVillageListByTalukaId(
			@RequestParam(name = "pathVariable") Long pathVariable) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				villageService.getVillageListByTalukaId(pathVariable));
	}

	@Trace
	@GetMapping(value = JPA_DOI_GET_TALUKA_BY_TALUKA_ID, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getTalukaByTalukaId(@RequestParam(name = "pathVariable") Long pathVariable) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				talukaService.getTalukaById(pathVariable));
	}

	@Trace
	@GetMapping(value = JPA_DOI_GET_VILLAGE_BY_VILLAGE_ID, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getVillageByVillageId(@RequestParam(name = "pathVariable") Long pathVariable) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				villageService.getVillageById(pathVariable));
	}

	@Trace
	@GetMapping(value = JPA_DOI_GET_STATE_LIST, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getStateList() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, stateService.getStateList());
	}

	@Trace
	@GetMapping(value = DOI_BANK_LIST, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getActiveBankList() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, bankService.getActiveBankList());
	}

	@Trace
	@GetMapping(value = DOI_BANK_BRANCH_LIST, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getActiveBankBranchListByBankId(
			@RequestParam(name = "pathVariable") Long pathVariable) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				bankBranchService.getActiveBankBranchListByBankId(pathVariable));
	}

	@Trace
	@GetMapping(value = DOI_DB_PARTY_TYPES, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getDirectBusinessPartyType() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DIRECT_BUSINESS_PARTY_TYPE));
	}

	@Trace
	@GetMapping(value = DOI_DB_OFFICE_TYPES, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getDirectBusinessOfficeTypes() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DIRECT_BUSINESS_OFFICE_TYPE));
	}

	@Trace
	@GetMapping(value = DOI_DB_LOCATION_TYPES, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getLocationTypes() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DIRECT_BUSINESS_Location_TYPE));
	}

	@Trace
	@GetMapping(value = DOI_BANK_BRANCH_TYPES, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getDoiBankBranchTypes() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DOI_BANK_BRANCH_TYPE));
	}

	@Trace
	@GetMapping(value = DOI_PAYMENT_MODES, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getDoiPaymentModes() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DOI_PAYMENT_MODE));
	}

	@Trace
	@GetMapping(value = DOI_DB_COVER_INC_BAS_COVER, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getCoversIncludedInBasicCoverChecks() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DIR_BUSS_STAND_COVER_INC_BAS_COVER));
	}

	@Trace
	@GetMapping(value = DOI_DB_COVER_PLINTH_AND_FOUND, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getCoverPlinthFoundationChecks() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DIR_BUSS_STAND_COVER_PLINTH_AND_FOUND));
	}

	@Trace
	@GetMapping(value = DOI_DB_ARCHI_CONS_AND_ENGG_FEE, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getArchEnggFeesChecks() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DIR_BUSS_STAND_ARCHI_CONS_AND_ENGG_FEE));
	}

	@Trace
	@GetMapping(value = DOI_DB_DEBRI_REMOVAL, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getDebrisRemovalChecks() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DIR_BUSS_STAND_DEBRI_REMOVAL));
	}

	@Trace
	@GetMapping(value = DOI_DB_EARTHQUICK, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getEarthquakeChecks() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DIR_BUSS_STAND_EARTHQUICK));
	}

	@Trace
	@GetMapping(value = DOI_DB_INSU_SAME_WITH_OTH_INS, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getInsuredWithOtherCompanyChecks() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DIR_BUSS_STAND_INSU_SAME_WITH_OTH_INS));
	}

	@Trace
	@GetMapping(value = DOI_DB_INSU_WAS_DECL_BY_OTH_COMP, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getInsuredWasDeclinedByOtherCompChecks() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DIR_BUSS_STAND_INSU_WAS_DECL_BY_OTH_COMP));
	}

	@Trace
	@GetMapping(value = DOI_DB_RESID_OFFI_SHOP_HOTEL, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getResidenceOfficeShopChecks() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DIR_BUSS_STAND_RESID_OFFI_SHOP_HOTEL));
	}

	@Trace
	@GetMapping(value = DOI_DB_INDUS_MANUFA_RISKS, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getIndusManufacturingRisksChecks() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DIR_BUSS_STAND_INDUS_MANUFA_RISKS));
	}

	@Trace
	@GetMapping(value = DOI_DB_STORAGE_OUT_INDU_RISK, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getStorageOutsideIndusRiskChecks() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DIR_BUSS_STAND_STORAGE_OUT_INDU_RISK));
	}

	@Trace
	@GetMapping(value = DOI_DB_TANK_GAS_HOLD_OUT_INDUS, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getTankGasHoldersOutsideIndusRisksChecks() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DIR_BUSS_STAND_TANK_GAS_HOLD_OUT_INDUS));
	}

	@Trace
	@GetMapping(value = DOI_DB_UTILI_LOCA_OUT_INDUS_MANU, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getUtilitiesOutsideIndusChecks() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DIR_BUSS_STAND_UTILI_LOCA_OUT_INDUS_MANU));
	}

	@Trace
	@GetMapping(value = DOI_DB_USE_AS_SHOP, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getUsedAsShop() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DIR_BUSS_STAND_USE_AS_SHOP));
	}

	@Trace
	@GetMapping(value = DOI_DB_USE_AS_WAREHOUSE_OR_GODA, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getUsedAsWareHouseChecks() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DIR_BUSS_STAND_USE_AS_WAREHOUSE_OR_GODA));
	}

	@Trace
	@GetMapping(value = DOI_DB_USE_AS_AN_INDUST_MANUF_UNIT, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getUsedAsInIndusManufUnitChecks() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DIR_BUSS_STAND_USE_AS_AN_INDUST_MANUF_UNIT));
	}

	@Trace
	@GetMapping(value = DOI_DB_FIRE_PROTC_DEVI_INSTA, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getFireProtectionDevicesLists() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DIR_BUSS_STAND_FIRE_PROTC_DEVI_INSTA));
	}

	@Trace
	@GetMapping(value = DIR_BUSS_STAND_THE_BASIS_PROPO_FO_INSU, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getBasisProposedList() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DIR_BUSS_STAND_THE_BASIS_PROPO_FO_INSU));
	}

	@Trace
	@GetMapping(value = DOI_DB_MARK_VALU_BASIS, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getMarketValueBasisChecks() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DIR_BUSS_STAND_MARK_VALU_BASIS));
	}

	@Trace
	@GetMapping(value = DOI_DB_REINSTA_VALU_BASIS, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getReinstamentValueBasisChecks() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DIR_BUSS_STAND_REINSTA_VALU_BASIS));
	}

	@Trace
	@GetMapping(value = DOI_DB_AGE_OF_BUILDING, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getAgeOfBuildingLists() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DIR_BUSS_STAND_AGE_OF_BUILDING));
	}

	@Trace
	@GetMapping(value = DOI_DB_FLOTER_BASIS, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getFloterBasisChecks() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DIR_BUSS_STAND_FLOTER_BASIS));
	}

	@Trace
	@GetMapping(value = DOI_DB_STOCK_STORED_IN_OPEN, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getStocksStoredInOpen() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DIR_BUSS_STAND_STOCK_STORED_IN_OPEN));
	}

	@Trace
	@GetMapping(value = DOI_DB_RI_REQUIEST, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getIsRiRequiredChecks() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DIR_BUSS_STAND_RI_REQUIEST));
	}

	@Trace
	@GetMapping(value = DoiDBUriConstants.DOI_DB_PROPOSAL_TYPES, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getProposalTypes() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DOI_DB_PROPOSAL_TYPE));
	}

	//NPS_GroupHead
	@Trace
	@GetMapping(value = DoiDBUriConstants.DOI_DB_TREASURY_NAMES, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getTreasuryNames() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiCommonLookupInfoService.getByParentLookUpName(DoiDBConstants.DOI_DB_TREASURY_NAME));
	}





}
