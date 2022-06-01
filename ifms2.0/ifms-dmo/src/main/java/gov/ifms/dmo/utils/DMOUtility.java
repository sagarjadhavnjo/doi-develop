package gov.ifms.dmo.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.dmo.dto.DMONSSFLoanPostDto;
import gov.ifms.dmo.dto.DMONSSFLoanRePaymentDto;

/**
 * The Class DMOUtility.
 * 
 * @version v 1.0.
 * @created 2021/07/13 11:40:45.
 *
 */
public class DMOUtility {

	/**
	 * Populate arguments.
	 *
	 * @param pageDetail the page detail
	 * @param index      the index
	 * @return the map
	 */
	public static Map<String, Object> populateArguments(PageDetails pageDetail, int index) {
		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		argsMap.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(
					search -> argsMap.put(DMODBConstants.getDPSheetListing().get(search.getKey()), search.getValue()));
		} else {
			DMODBConstants.getDPSheetListing()
					.forEach((k, v) -> argsMap.put(DMODBConstants.getDPSheetListing().get(k), 0));
		}
		return argsMap;
	}
	
	
	public static List<DMONSSFLoanRePaymentDto> rePaymentUtility(DMONSSFLoanPostDto dto) {
		List<DMONSSFLoanRePaymentDto> repayments = new ArrayList<DMONSSFLoanRePaymentDto>();
		Double openingBal = dto.getLoanAmount();
		Double principalAmount = 0.00;
		int year = dto.getLoanTenure() * dto.getPrncplInstallYear(); //25
		int count = 1;
		while (count <= year) {
			DMONSSFLoanRePaymentDto repayment = new DMONSSFLoanRePaymentDto();		
			repayment.setInstallDueDate(dto.getFirstInstallDate().plusYears(count));	
			repayment.setOpeningBalanceAmount(openingBal);
			Double interestAmount =  dto.getLoanAmount() * dto.getLoanROI() / 100; //50,000 * 9.5/100 = 4750
			if(count > dto.getMoratariumPeriod()) {
				principalAmount = dto.getLoanAmount() / (year - dto.getMoratariumPeriod()); //E.g. 50000 / 20 = 2500
				interestAmount = openingBal * dto.getLoanROI() / 100; //50,000 * 9.5/100 = 4750
			}
		    Double closingBal = openingBal - principalAmount;
		    openingBal = openingBal - principalAmount;
		    repayment.setPrincipalAmount(principalAmount);
		    repayment.setIntrestAmount(interestAmount);
		    repayment.setClosingBalAmount(closingBal);
		    repayment.setRePaymentNo(count);
		    repayment.setDpSheetRecDate(dto.getDpSheetRecDate());
		    repayment.setLoanNumber(dto.getLoanNumber());
		    repayment.setDpSheetEntity(dto.getDpSheetId());
		    repayment.setNssfLoanId(dto.getNssfLoanId());
		    repayments.add(repayment);	
		    count++;
		}
		return repayments;
	}
	
	/**
	 * Gets the string value.
	 *
	 * @param obj the obj
	 * @return the string value
	 */
	public static String convertObjectToString(Object obj) {
		try {
			if (obj == null || String.valueOf(obj).isEmpty())
				return "";
			else {
				return String.valueOf(obj);
			}
		} catch (Exception ex) {
			return "";
		}
	}
}
