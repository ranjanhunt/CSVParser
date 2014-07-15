package com.team.model;
/**
 * Represents company data includes company name, max share price,
 * year and month.
 */
public class CompanyData {
	
	private String companyName;
	private int maxSharePrice;
	private int year;
	private String month;
	
	
	public CompanyData(String companyName) {
		this.companyName = companyName;
	}
	
	/**
	 * @return company name
 	 */
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	/**
	 * @return the max share price of the company
	 */
	public int getMaxSharePrice() {
		return maxSharePrice;
	}
	
	public void setMaxSharePrice(int maxSharePrice) {
		this.maxSharePrice = maxSharePrice;
	}
	
	/**
	 * @return the year in which share price is max
	 */
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * @return the month in which share price is max
	 */
	public String getMonth() {
		return month;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}
}