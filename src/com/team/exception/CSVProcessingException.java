package com.team.exception;

/**
 * This exception should be thrown if CSV file could not be found or data in CSV file
 * could not be processed.
 */
public class CSVProcessingException extends Exception {

	private String message;
	private Exception exception;
	
	public CSVProcessingException(String message) {
		this.message = message;
	}

	public CSVProcessingException(String message, Exception exception) {
		this.message = message;
		this.exception = exception;
	}
}
