package com.team.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.team.exception.CSVProcessingException;
import com.team.model.CompanyData;
import com.team.service.impl.CSVParseServiceImpl;

/**
 * Test cases for all methods in {@link CSVParseServiceImpl}
 */
public class TestCSVParseService {

	private final static String CSV_FILE = "resources/test_shares_data.csv";
	private final static String INVALID_CSV_FILE_LOCATION = "res/test_shares_data.csv";
	private final static String VALID_CSV_FILE_WITH_NO_DATA = "resources/test_shares_data_blankFile.csv";
	private final static String CSV_FILE_WITH_NO_COMPANY = "resources/test_shares_data_illFormatted.csv";
	
	private CSVParseServiceImpl serviceImpl;
	
	@Before
	public void initialize(){
		serviceImpl = new CSVParseServiceImpl();
	}
	
	/**
	 * Case: Null file location
	 * Input: fileName = null
	 * Output: CompanyData list
	 * Assertion: CompanyData list should be null
	 */
	@Test
	public void TestGetCompanyListForNullFileLocation() throws Exception {
		final List<CompanyData> companyDataList = serviceImpl.getCompanyList(null);
		assertNull("Company data list is not null", companyDataList);
	}
	
	/**
	 * Case: Blank file location
	 * Input: fileName = ""
	 * Output: CompanyData list
	 * Assertion: CompanyData list should be null
	 */
	@Test
	public void TestGetCompanyListForBlankFileLocation() throws Exception {
		final List<CompanyData> companyDataList = serviceImpl.getCompanyList("");
		assertNull("Company data list is not null", companyDataList);
	}
	
	/**
	 * Case: Invalid file location
	 * Input: fileName = [invalid location]
	 * Output: Nothing
	 * Assertion: throws CSVProcessingException
	 */
	@Test(expected = CSVProcessingException.class)
	public void TestGetCompanyListForInvalidFileLocation() throws Exception {
		serviceImpl.getCompanyList(INVALID_CSV_FILE_LOCATION);
	}
	
	/**
	 * Case: Valid file location but file has no data
	 * Input: fileName = [valid]
	 * Output: CompanyData list
	 * Assertion: CompanyData list should be empty
	 */
	@Test
	public void TestGetCompanyListForValidFileLocationButNoData() throws Exception {
		final List<CompanyData> companyDataList = serviceImpl.getCompanyList(VALID_CSV_FILE_WITH_NO_DATA);
		assertTrue("Company List size did not match", companyDataList.isEmpty());
	}
	
	/**
	 * Case: Given file has no company listed
	 * Input: fileName = [valid]
	 * Output: CompanyData list
	 * Assertion: CompanyData list should be empty
	 */
	@Test
	public void TestGetCompanyListForInvalidFileFormat() throws Exception {
		final List<CompanyData> companyDataList = serviceImpl.getCompanyList(CSV_FILE_WITH_NO_COMPANY);
		assertTrue("Company List size did not match", companyDataList.isEmpty());
	}
	
	/**
	 * Case: Valid file location
	 * Input: fileName = [valid]
	 * Output: CompanyData list
	 * Assertion: Actual company data should match excepted values
	 */
	@Test
	public void TestGetCompanyListForValidValue() throws Exception {
		final List<CompanyData> companyDataList = serviceImpl.getCompanyList(CSV_FILE);
		
		assertEquals("Company List size did not match", companyDataList.size(), 5);
		assertEquals("Company A max share price did not match", 
					 companyDataList.get(0).getMaxSharePrice(),
					 1000);
		assertEquals("Company B max share price did not match", 
					 companyDataList.get(1).getMaxSharePrice(),
					 986);
		assertEquals("Company C max share price did not match", 
					 companyDataList.get(2).getMaxSharePrice(),
					 995);
		assertEquals("Company D max share price did not match", 
					 companyDataList.get(3).getMaxSharePrice(),
					 999);
		assertEquals("Company E max share price did not match", 
					 companyDataList.get(4).getMaxSharePrice(),
					 997);
		
		// Asserts for month and year for respective year and month
							
	}

}
