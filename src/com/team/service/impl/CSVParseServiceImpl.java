package com.team.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.team.exception.CSVProcessingException;
import com.team.model.CompanyData;
import com.team.service.CSVParseService;
import com.team.util.CSVProcessorUtil;

/**
 * Implementation of {@link CSVParseService} 
 */
public class CSVParseServiceImpl implements CSVParseService {

	public static Logger logger = Logger.getLogger(CSVParseServiceImpl.class);
	
	public CSVParseServiceImpl() {
	}
	
	public List<CompanyData> getCompanyList(String fileName) throws CSVProcessingException {
		//PropertiesConfigurator is used to configure logger from properties file
        PropertyConfigurator.configure("log4j.properties");
		BufferedReader br = null;
		String line = "";
		List<CompanyData> companyDataList = null;
		
		if (fileName == null || fileName.isEmpty()) {
			return companyDataList;
		}
		
		try {
			br = new BufferedReader(new FileReader(fileName));
			final String header = br.readLine();
			companyDataList = new ArrayList<CompanyData>();
			
			// Initializes company data list with company names if header is not null
			if(header != null)
			{
				CSVProcessorUtil.initializeCompanyList(header, companyDataList);
			}
			
			while ((line = br.readLine()) != null && !companyDataList.isEmpty()) {
				CSVProcessorUtil.updateCompanyList(line, companyDataList);
			}
		
		} catch (FileNotFoundException e) { 
			logger.debug("Could not find file: " + fileName, e);
			throw new CSVProcessingException("Could not find file:" + fileName, e);
		} catch (IOException e) {
			logger.debug("IO exception while reading the file: " + fileName, e);
			throw new CSVProcessingException("IO exception while reading the file", e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					logger.debug("IO exception while closing reader: " + fileName, e);
					throw new CSVProcessingException("IO exception while closing reader", e);
				}
			}
		}
		
		return companyDataList;
	}
}
