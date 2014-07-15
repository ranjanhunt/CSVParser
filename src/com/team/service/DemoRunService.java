package com.team.service;

import java.util.ArrayList;
import java.util.List;

import com.team.exception.CSVProcessingException;
import com.team.model.CompanyData;
import com.team.service.impl.CSVParseServiceImpl;

public class DemoRunService {

	private final static String CSV_FILE = "resources/test_shares_data.csv";
	private static List<CompanyData> companyDataList = new ArrayList<CompanyData>();
	
	public static void main(String[] args) throws CSVProcessingException {

		CSVParseServiceImpl service = new CSVParseServiceImpl();
		companyDataList = service.getCompanyList(CSV_FILE);
		
		if (companyDataList == null || companyDataList.isEmpty()) {
			System.out.println("No valid data found in the file");
		} else {
			for(CompanyData companyData : companyDataList){
				System.out.println("CompanyName: " + companyData.getCompanyName() + 
						           ", Max Share Price: " + companyData.getMaxSharePrice() + 
						           ", Year: " + companyData.getYear() + 
						           ", Month: " + companyData.getMonth());
			}
		}
	}
}
