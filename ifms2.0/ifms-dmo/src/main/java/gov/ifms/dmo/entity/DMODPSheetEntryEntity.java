package gov.ifms.dmo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

@Entity
@Table(name = "TDMO_DP_SHEET_DTL", schema = Constant.DMO_SCHEMA)
public class DMODPSheetEntryEntity extends BaseEntity implements Serializable {

	
	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DP_SHEET_ID")
	private Long id;

	@Column(name = "ADVICE_NO")
	private String adviceNo;

	@Column(name = "ADVICE_DT")
	private LocalDate adviceDate;

	@Column(name = "ADVICE_BY")
	private String adviceBy;

	@Column(name = "PAYMENT_TYPE_ID")
	private Long paymentTypeId;

	@Column(name = "PAYMENT_TYPE_DESC")
	private String paymentTypeDesc;

	@Column(name = "TRANSACT_TYPE_ID")
	private Long transactTypeId;

	@Column(name = "TRANSACTION_DESC")
	private String transactionDesc;

	@Column(name = "CREDIT_AMT")
	private Long creditAmt;

	@Column(name = "DEBIT_AMT")
	private Long debitAmt;

	@Column(name = "MEMO_NO")
	private String memoNo;

	/** The is DP_HDR_SHEET_ID. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DP_SHEET_HDR_ID", referencedColumnName = "DP_SHEET_HDR_ID")
	private DMODPSheetHDREntity entity;
	
	
	
	public DMODPSheetEntryEntity() {
		super();
	}

	public DMODPSheetEntryEntity(Long id, String adviceNo, LocalDate adviceDate, String adviceBy, Long paymentTypeId,
			String paymentTypeDesc, Long transactTypeId, String transactionDesc, Long creditAmt, Long debitAmt,
			String memoNo) {
		super();
		this.id = id;
		this.adviceNo = adviceNo;
		this.adviceDate = adviceDate;
		this.adviceBy = adviceBy;
		this.paymentTypeId = paymentTypeId;
		this.paymentTypeDesc = paymentTypeDesc;
		this.transactTypeId = transactTypeId;
		this.transactionDesc = transactionDesc;
		this.creditAmt = creditAmt;
		this.debitAmt = debitAmt;
		this.memoNo = memoNo;
	}

	public DMODPSheetEntryEntity(Long dpSheetId) {
		super();
		this.id = dpSheetId;
	}

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

	public DMODPSheetHDREntity getEntity() {
		return entity;
	}

	public void setEntity(DMODPSheetHDREntity entity) {
		this.entity = entity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adviceBy, adviceDate, adviceNo, creditAmt, debitAmt, entity, id, memoNo, paymentTypeDesc,
				paymentTypeId, transactTypeId, transactionDesc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DMODPSheetEntryEntity other = (DMODPSheetEntryEntity) obj;
		return Objects.equals(adviceBy, other.adviceBy) && Objects.equals(adviceDate, other.adviceDate)
				&& Objects.equals(adviceNo, other.adviceNo) && Objects.equals(creditAmt, other.creditAmt)
				&& Objects.equals(debitAmt, other.debitAmt) && Objects.equals(entity, other.entity)
				&& Objects.equals(id, other.id) && Objects.equals(memoNo, other.memoNo)
				&& Objects.equals(paymentTypeDesc, other.paymentTypeDesc)
				&& Objects.equals(paymentTypeId, other.paymentTypeId)
				&& Objects.equals(transactTypeId, other.transactTypeId)
				&& Objects.equals(transactionDesc, other.transactionDesc);
	}

	
}
