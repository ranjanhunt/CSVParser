package com.team.service;

import java.util.List;

import com.team.exception.CSVProcessingException;
import com.team.model.CompanyData;

public interface CSVParseService {

	/**
	 * Reads the given file and returns list of {@link CompanyData} with max share price,
	 * year and month
	 * 
	 * @param fileName
	 * @return {@link CompanyData} list
	 * @throws CSVProcessingException if given file could not be found or data could not be processed
	 */
	public List<CompanyData> getCompanyList(String fileName) throws CSVProcessingException ;
}
