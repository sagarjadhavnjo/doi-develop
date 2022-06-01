package gov.ifms.dmo.utils;

/**
 * The Class DMOURLConstant.
 * 
 * @version v 1.0.
 * @created 2021/07/13 11:40:45.
 *
 */
public class DMOURLConstant {

	/**
	 * Instantiates a new URL constant.
	 */
	private DMOURLConstant() {
		super();
	}

	/**
	 * The Constant URL_POST. (Save As Draft)
	 */
	public static final String URL_POST = "/101";

	/**
	 * The Constant URL_POST_LIST.
	 */
	public static final String URL_POST_LIST = "/1001";

	/**
	 * The Constant URL_POST (Submit).
	 */
	public static final String URL_POST_SUBMIT = "/901";

	/**
	 * The Constant URL_GET_ALL.
	 */
	public static final String URL_GET_ALL = "/201";

	/**
	 * The Constant URL_GET_BY_ID.
	 */
	public static final String URL_GET_BY_ID = "/301";

	/**
	 * The Constant URL_PUT_BY_ID.
	 */
	public static final String URL_PUT_BY_ID = "/401";
	
	/**
	 * The Constant URL_GET_ALL.
	 */
	public static final String URL_SEARCH_DATE = "/202";
	
	
	/*** DMO MODULE ***/
	   
	/** The Constant URL_DMO_DPSheeetEntry. */
	public static final String DPSHEETENTRY_BASE_URL = "dmo/DPSheetEntry";

	/**
	 * The Constant URL_POST. (Save As Draft)
	 */
	public static final String DPSHEET_POST_URL = "/101";

	/**
	 * The Constant URL_POST_LIST.
	 */
	public static final String DPSHEET_POST_LIST = "/1001";

	/**
	 * The Constant URL_POST (Submit).
	 */
	public static final String DPSHEET_POST_SUBMIT = "/901";

	/**
	 * The Constant URL_GET_ALL.
	 */
	public static final String DPSHEET_GET_ALL = "/201";

	/**
	 * The Constant URL_GET_BY_ID.
	 */
	public static final String DPSHEET_GET_BY_ID = "/301";
	
	/**
	 * The Constant URL_DELETE_BY_ID.
	 */
	public static final String DPSHEET_DELETE_BY_ID = "/101";
	
	/**
	 * The Constant URL_MAIN_TRANSACTION.
	 */
	public static final String MAIN_TRANSACTION_BASE_URL = "dmo/transactions";

	/**
	 * The Constant URL_GET_BY_ID.
	 */
	public static final String URL_ALL_ACTIVE_TRANSACTION = "/302";
	
	/**
	 * The Constant NSSF Loan Module.
	 */
	public static final String NSSF_LOAN_RECEIVED_BASE_URL = "dmo/nssfloanreceived";
	
	public static final String DMO_DP_SHEET_BASE_URL = "dmo/dpentrysheet";
	
	
	/**
	 * The Constant NSSF Loan Repayments Module.
	 */
	public static final String NSSF_LOAN_REPAYMENT_BASE_URL = "dmo/nssfloanrepayment";
	
	public static final String MARKET_LOAN_RECEIVED_BASE_URL = "dmo/marketloan";
	
	/**
	 * The Constant URL_GET_ALL.
	 */
	public static final String URL_GET_ALL_REPAYMENTS = "/202";
}

