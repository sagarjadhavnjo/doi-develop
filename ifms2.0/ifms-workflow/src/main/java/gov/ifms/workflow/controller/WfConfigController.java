package gov.ifms.workflow.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.exception.MultipleRecordsFoundException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.dto.EDPSDTDto;
import gov.ifms.workflow.converter.WfConfigConverter;
import gov.ifms.workflow.dto.WfConfigDto;
import gov.ifms.workflow.dto.WfRequestDto;
import gov.ifms.workflow.service.WfConfigService;

/**
 * The Class MsWorkflowController.
 * 
 * @version 1.0.
 * @created 2019/08/29 17:22:45.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_WF_CONFIG)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WfConfigController {

	/** The service. */
	@Autowired
	private WfConfigService service;

	/** The converter. */
	@Trace
	@Autowired
	private WfConfigConverter converter;

	/**
	 * @param id
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getWfConfig(@RequestBody IdDto id) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH,
				this.converter.toDTO(service.getMsWorkflow(id.getId())));
	}

	/**
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createWfConfig(@RequestBody WfConfigDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateMsWorkflow(converter.toEntity(dto))));
	}

	/**
	 * 
	 * @param dto
	 * @return the updated entity in dto type
	 */
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateWfConfig(@RequestBody WfConfigDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateMsWorkflow(converter.toEntity(dto))));
	}

	/**
	 * Fetch all the MsWorkflow items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<WfConfigDto>
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getMsWorkflowRole(@RequestBody PageDetails pageDetail) {
		PagebleDTO<WfConfigDto> data = service.msWorkflowAsMethodNameSearch(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH, data);
	}

	/**
	 * Creates the ms workflows.
	 *
	 * @param dtos the dtos
	 * @return the response entity
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST_ALL)
	public ResponseEntity<ApiResponse> createWfConfigs(@RequestBody List<WfConfigDto> dtos) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH,
				converter.toDTO(service.saveMsWorkflows(converter.toEntity(dtos))));
	}

	
	/**
	 * Gets the wf config actions.
	 *
	 * @param dto the dto
	 * @return the wf config actions
	 * @throws MultipleRecordsFoundException the multiple records found exception
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_WORKFLOW_NEXT_ACTIONS)
	public ResponseEntity<ApiResponse> getWfConfigActions(@Valid @RequestBody WfRequestDto dto) throws MultipleRecordsFoundException, CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH_LIST,
				converter.toWfActionDTO(service.getNextWfActions(dto)));
	}
 
	/**
	 * Gets the users by wf role and office id.
	 *
	 * @param dto the dto
	 * @return the users by wf role and office id
	 * @throws MultipleRecordsFoundException the multiple records found exception
	 * @throws CustomException 
	 */
	@Trace
	@PostMapping(URLConstant.URL_WORKFLOW_USERS_BY_WF_ACTION)
	public ResponseEntity<ApiResponse> getWfConfigUserByAction(@Valid @RequestBody WfRequestDto dto) throws MultipleRecordsFoundException, CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH_LIST, service.getUsersByWfActionId(dto));
	}

	/**
	 * Fetch Workflow Submit Enable
	 *
	 * @param dto
	 * @return the Map
	 */
	@Trace
	@PostMapping(URLConstant.URL_WORKFLOW_SUBMIT_ENABLE)
	public ResponseEntity<ApiResponse> getWorkflowSubmitEnable(@RequestBody WfConfigDto dto){
		Map<String, Boolean> result = new HashMap<>();
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH, result);
	}

	/**
	 * Fetch WfRoleId By PostId And MenuId
	 *
	 * @param dto
	 * @return the Map
	 */
	@Trace
	@PostMapping(URLConstant.URL_WF_ROLE_ID_BY_USER_POST)
	public ResponseEntity<ApiResponse> getWfRoleIdByPostIdAndMenuId(@RequestBody WfConfigDto dto){
		Map<String, Long> result = new HashMap<>();
		result.put("wfRoleId", service.getWfRoleIdByPostIdAndMenuId(1, dto.getMenuId()));
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH, result);
	}

	/**
	 * Fetch WfEnableForSc
	 *
	 * @param dto
	 * @return the Map
	 */
	@Trace
	@PostMapping(URLConstant.URL_WF_BUDGET_SC_BY_HEADER_ID)
	public ResponseEntity<ApiResponse> getWfEnableForSc(@RequestBody IdDto dto) {
		Map<String, Boolean> result = new HashMap<>();
		result.put("isWfEnable", service.isEditableScHeader(dto.getId()));
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH, result);
	}

	/**
	 * Gets the wf status.
	 *
	 * @param idDto the id dto
	 * @return the wf status
	 */
	@Trace
	@PostMapping(URLConstant.URL_WF_STATUS)
	public ResponseEntity<ApiResponse> getWfStatus(@RequestBody IdDto idDto) {
		List<EDPSDTDto> workflowStatus = service.getMsWorkflowStatus(idDto.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH, workflowStatus);
	}


	/**
	 * @param idDto
	 * @return
	 */
	@Trace
	@PostMapping(URLConstant.URL_TRN_STATUS)
	public ResponseEntity<ApiResponse> getTrnStatus(@RequestBody IdDto idDto) {
		List<EDPSDTDto> trnStatus = service.getMsWorkflowTrnStatus(idDto.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH, trnStatus);
	}
		
}
