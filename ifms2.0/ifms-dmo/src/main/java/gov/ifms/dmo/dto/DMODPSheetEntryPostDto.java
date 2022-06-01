package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * The Class DMODPSheetEntryPostDto.
 * 
 * @version 2.0
 * @created 2021/07/21 08:19:32
 *
 */
public class DMODPSheetEntryPostDto implements Serializable{

	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;
	
	/** The DPSheetEntryId. */
	private Long id;
	
	private Long parentDpSheetId;
	/** The Advice No.**/
	private String adviceNo;
	/** The Advice Date.**/
	private LocalDate adviceDate;

	
	/** The Advice By.**/
	private String adviceBy;
	
	/** The Payment Type Id.**/
	private Long paymentTypeId;

	/** The Payment Type Description.**/
	private String paymentTypeDesc;

	/** The Transaction TypeId.**/
	private Long transactTypeId;

	/** The Transaction Description.**/
	private String transactionDesc;

	/** The creditAmt.**/
	private Long creditAmt;

	/** ThedebitAmt.**/
	private Long debitAmt;

	/** The Memo No.**/
	private String memoNo;
	
	private LocalDate dpSheetReciveDate; 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdviceNo() {
		return adviceNo;
	}

	public void setAdviceNo(String adviceNo) {
		this.adviceNo = adviceNo;
	}

	public LocalDate getAdviceDate() {
		return adviceDate;
	}

	public void setAdviceDate(LocalDate adviceDate) {
		this.adviceDate = adviceDate;
	}

	public String getAdviceBy() {
		return adviceBy;
	}

	public void setAdviceBy(String adviceBy) {
		this.adviceBy = adviceBy;
	}

	public Long getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(Long paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public String getPaymentTypeDesc() {
		return paymentTypeDesc;
	}

	public void setPaymentTypeDesc(String paymentTypeDesc) {
		this.paymentTypeDesc = paymentTypeDesc;
	}

	public Long getTransactTypeId() {
		return transactTypeId;
	}

	public void setTransactTypeId(Long transactTypeId) {
		this.transactTypeId = transactTypeId;
	}

	public String getTransactionDesc() {
		return transactionDesc;
	}

	public void setTransactionDesc(String transactionDesc) {
		this.transactionDesc = transactionDesc;
	}

	public Long getCreditAmt() {
		return creditAmt;
	}

	public void setCreditAmt(Long creditAmt) {
		this.creditAmt = creditAmt;
	}

	public Long getDebitAmt() {
		return debitAmt;
	}

	public void setDebitAmt(Long debitAmt) {
		this.debitAmt = debitAmt;
	}

	public String getMemoNo() {
		return memoNo;
	}

	public void setMemoNo(String memoNo) {
		this.memoNo = memoNo;
	}

	/**
	 * @return the dpSheetReciveDate
	 */
	public LocalDate getDpSheetReciveDate() {
		return dpSheetReciveDate;
	}

	/**
	 * @param dpSheetReciveDate the dpSheetReciveDate to set
	 */
	public void setDpSheetReciveDate(LocalDate dpSheetReciveDate) {
		this.dpSheetReciveDate = dpSheetReciveDate;
	}

	/**
	 * @return the parentDpSheetId
	 */
	public Long getParentDpSheetId() {
		return parentDpSheetId;
	}

	/**
	 * @param parentDpSheetId the parentDpSheetId to set
	 */
	public void setParentDpSheetId(Long parentDpSheetId) {
		this.parentDpSheetId = parentDpSheetId;
	}
		

}
