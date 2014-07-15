package com.team.util;

import java.util.List;

import com.team.model.CompanyData;

/**
 * Utility class to initialize and update company data list.
 */
public class CSVProcessorUtil {

	private static String CSV_TOKENIZER = ",";
	
	/**
	 * Splits given header based on tokenizer and initializes given companyDataList
	 * with Company name present in the header and default share price, year and month
	 * 
	 * @param header
	 * @param companyDataList
	 */
	public static void initializeCompanyList(String header, List<CompanyData> companyDataList) {
		
		String[] fields = split(header);
		
		// year, month and at least one company must be present.
		if(fields == null || fields.length < 3)
		{
			return;		
		}
		
		for (int i = 2; i < fields.length; i++) {
			CompanyData companyData = new CompanyData(fields[i]);
			companyDataList.add(companyData);
		}
	}
	
	/**
	 * Updates given company list if current share price is less than the share price 
	 * value in given data string, year and month else skip
	 * 
	 * @param dataStr
	 * @param companyDataList
	 */
	public static void updateCompanyList(String dataStr, List<CompanyData> companyDataList) {
		String[] data = split(dataStr);

		// year, month and at least one company must be present.
		if (data.length < 3) {
			return;
		}

		for (int i = 2; i < data.length; i++) {
			CompanyData companyData = companyDataList.get(i - 2);
			int sharePrice = Integer.parseInt(data[i]);
			if (companyData.getMaxSharePrice() < sharePrice) {
				companyData.setMaxSharePrice(sharePrice);
				companyData.setYear(Integer.parseInt(data[0]));
				companyData.setMonth(data[1]);
			}
		}
	}
	
	/**
	 * Split given string based on the tokenizer
	 * 
	 * @param data
	 */
	private static String[] split(String data) {
		if (data == null || data.trim().equals(""))
			return null;

		return data.split(CSV_TOKENIZER);
	}
}
