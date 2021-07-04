package com.hcl.foodordering.exception;

public class FoodOrderException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public FoodOrderException(String message) {
		this.message=message;
	}
	
	public String getMessage() {
		return this.message;
	}

}
