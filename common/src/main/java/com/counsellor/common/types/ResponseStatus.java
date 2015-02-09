package com.counsellor.common.types;

public enum ResponseStatus {

	//================================================= 
	// Enums
	//=================================================    
	/**
	 * All attributes served successfully without errors
	 */
	SUCCESS(1,"SUCCESS"),
	/**
	 * One or more attributes had exceptions/validation errors
	 */
	PARTIAL_FAILURE(2,"PARTIAL_FAILURE"),
	/**
	 * The entire request failed (had errors)
	 */
	FAILURE(3, "FAILURE");

	//================================================= 
	// Class Variables 
	//=================================================    
	
	//================================================= 
	// Instance Variables 
	//=================================================    
	private final String status;
	private final int code;

	//================================================= 
	// Constructors 
	//=================================================    
	private ResponseStatus(int code, String status) {
		this.code = code;
		this.status = status;
	}
	
	//================================================= 
	// Class Methods 
	//=================================================    
	
	//================================================= 
	// Instance Methods 
	//=================================================    
	@Override
	public String toString() {
		return status;
	}

	//================================================= 
	// Accessors 
	//=================================================
	public String getStatus() {
		return status;
	}

	public int getCode() {
		return code;
	}
	
	public static ResponseStatus getResponseByStatus(String statusStr){
		if(statusStr!=null){
			for (ResponseStatus status : ResponseStatus.values()) {
				return status;
			}
		}
		return null;
	}
}
