package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Class DMODPSheetEntryDto.
 * 
 * @version 2.0
 * @created 2021/07/10 15:19:32
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DMODPSheetHDREntryPostDto implements Serializable{

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The DPSheetEntryId. */
	private Long id;
	
	/**  The Date of Previous DP Sheet Submitted */
	private LocalDate dpSheetReciveDate;
	
	/** The DP Sheet Entry Sheet Date **/
	private LocalDate dpSheetDate; 
	
	/** The Gujarat Advice Code.**/
	private int gogCode;
	
	/** The Opening Balance Debit.**/
	private Double openBalDr;
	
	/** The Opening Balance Credit.**/
	private Double openBalCr;
	
	/** The PAD Transactions Debit.**/
	private Double padTransDr;
	
	/** The PAD Transactions Credit.**/
	private Double padTransCr;
	
	/** The PAD Mumbai GST Transaction Debit.**/
	private Double padMumbGstDr;
	
	/** The PAD Mumbai GST Transaction Credit.**/
	private Double padMumbGstCr;
	
	/** The Agency Bank Transactions Debit.**/
	private Double agencyBankDr;
	
	/** The Agency Bank Transactions Credit.**/
	private Double agencyBankCr;
	
	/** The Memo No.**/
	private String memoNo;
	
	/** List of DP EntrySheet **/
	private List<DMODPSheetEntryPostDto> dpSheetDtos = new ArrayList<>();
	
	/** The Debit Amount.**/
	private Double debitAmount;
	
	/** The Credit Amount.**/
	private Double creditAmount;
	
	/** The Total Debit Amount.**/
	private Double totalDebitAmount;
	
	/** The Total Credit Amount.**/
	private Double totalCreditAmount;
	
	/** The Closing Minimum Balance.**/
	private Double closMinBal;
	
	/** The 14 Day Tbill Balance.**/
	private Double tBill14DBal;
	
	/** The Required Action.**/
	private int action;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDpSheetReciveDate() {
		return dpSheetReciveDate;
	}

	public void setDpSheetReciveDate(LocalDate dpSheetReciveDate) {
		this.dpSheetReciveDate = dpSheetReciveDate;
	}

	public LocalDate getDpSheetDate() {
		return dpSheetDate;
	}

	public void setDpSheetDate(LocalDate dpSheetDate) {
		this.dpSheetDate = dpSheetDate;
	}

	public int getGogCode() {
		return gogCode;
	}

	public void setGogCode(int gogCode) {
		this.gogCode = gogCode;
	}

	public Double getOpenBalDr() {
		return openBalDr;
	}

	public void setOpenBalDr(Double openBalDr) {
		this.openBalDr = openBalDr;
	}

	public Double getOpenBalCr() {
		return openBalCr;
	}

	public void setOpenBalCr(Double openBalCr) {
		this.openBalCr = openBalCr;
	}


	public Double getPadTransDr() {
		return padTransDr;
	}

	public void setPadTransDr(Double padTransDr) {
		this.padTransDr = padTransDr;
	}

	public Double getPadTransCr() {
		return padTransCr;
	}

	public void setPadTransCr(Double padTransCr) {
		this.padTransCr = padTransCr;
	}

	public Double getPadMumbGstDr() {
		return padMumbGstDr;
	}

	public void setPadMumbGstDr(Double padMumbGstDr) {
		this.padMumbGstDr = padMumbGstDr;
	}

	public Double getPadMumbGstCr() {
		return padMumbGstCr;
	}

	public void setPadMumbGstCr(Double padMumbGstCr) {
		this.padMumbGstCr = padMumbGstCr;
	}

	public Double getAgencyBankDr() {
		return agencyBankDr;
	}

	public void setAgencyBankDr(Double agencyBankDr) {
		this.agencyBankDr = agencyBankDr;
	}

	public Double getAgencyBankCr() {
		return agencyBankCr;
	}

	public void setAgencyBankCr(Double agencyBankCr) {
		this.agencyBankCr = agencyBankCr;
	}

	public String getMemoNo() {
		return memoNo;
	}

	public void setMemoNo(String memoNo) {
		this.memoNo = memoNo;
	}

	public Double getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(Double debitAmount) {
		this.debitAmount = debitAmount;
	}

	public Double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public Double getTotalDebitAmount() {
		return totalDebitAmount;
	}

	public void setTotalDebitAmount(Double totalDebitAmount) {
		this.totalDebitAmount = totalDebitAmount;
	}

	public Double getTotalCreditAmount() {
		return totalCreditAmount;
	}

	public void setTotalCreditAmount(Double totalCreditAmount) {
		this.totalCreditAmount = totalCreditAmount;
	}

	public Double getClosMinBal() {
		return closMinBal;
	}

	public void setClosMinBal(Double closMinBal) {
		this.closMinBal = closMinBal;
	}

	

	public Double gettBill14DBal() {
		return tBill14DBal;
	}

	public void settBill14DBal(Double tBill14DBal) {
		this.tBill14DBal = tBill14DBal;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public List<DMODPSheetEntryPostDto> getDpSheetDtos() {
		return dpSheetDtos;
	}

	public void setDpSheetDtos(List<DMODPSheetEntryPostDto> dpSheetDtos) {
		this.dpSheetDtos = dpSheetDtos;
	}

	
	
}