package gov.ifms.doi.db.controller;

import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.CONTENT_TYPE_APP_JSON;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.DOI_JPA_DB_BASE_URL;

import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.DOI_JPA_DB_PROPSLFIREPERIL_ENTRY;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.DOI_JPA_DB_PROPSLFIREPERIL_LISTING;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.DOI_JPA_DB_PROPSLFIREPERIL_LISTING_BY_STATUS;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.DOI_JPA_DB_PROPSLFIREPERIL_DELETE;

import gov.ifms.doi.db.constant.DoiDBUriConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.doi.db.dto.TdoiDbPropslFirePerilDTO;
import gov.ifms.doi.db.service.TdoiDbPropslFirePerilService;


@RestController
@RequestMapping(DOI_JPA_DB_BASE_URL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TdoiDbPropslFirePerilController{

	@Autowired
	TdoiDbPropslFirePerilService service;


	@Trace
	@PostMapping(value = DoiDBUriConstants.DOI_DB_PROP_STAND_FIRE_PERILS_ENTRY , produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> saveOrUpdate(@RequestBody TdoiDbPropslFirePerilDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.saveOrUpdate(dto));
	}


	@Trace
	@PostMapping(value = DOI_JPA_DB_PROPSLFIREPERIL_LISTING, produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getAll(@RequestBody TdoiDbPropslFirePerilDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, service.findAllByCriteria(dto));
	}


	@Trace
	@DeleteMapping(value = DOI_JPA_DB_PROPSLFIREPERIL_DELETE, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> softDeleteById(@RequestParam(name = "id") Long id) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_DELETE, service.softDeleteById(id));
	}


	@Trace
	@PostMapping(value = DOI_JPA_DB_PROPSLFIREPERIL_LISTING_BY_STATUS, produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getAllByStatus(@RequestBody TdoiDbPropslFirePerilDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, service.findAllByStatus(dto));
	}

}

