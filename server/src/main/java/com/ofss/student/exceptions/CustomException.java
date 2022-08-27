package com.ofss.student.exceptions;

public class CustomException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomException(String message) {
	    // calling the constructor of Exception class
	    super(message);
	  }

}
