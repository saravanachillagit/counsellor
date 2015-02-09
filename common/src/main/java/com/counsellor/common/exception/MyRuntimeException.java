/**
 * General Runtime exception for Rest Layer
 * @author chills
 *
 */
package com.counsellor.common.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import com.counsellor.common.types.MyError;

public class MyRuntimeException extends RuntimeException {
	
	//================================================= 
	// Class Variables 
	//=================================================    
	/**
	 * Generated SerialVersionUID
	 */
	private static final long serialVersionUID = -8143797474915105633L;
	

	//================================================= 
	// Instance Variables 
	//=================================================    

	//================================================= 
	// Constructors 
	//=================================================    
	public  MyRuntimeException() {
		super();
	}
	
	public MyRuntimeException(MyError beError) {
		this(beError, null);
	}
	
	public MyRuntimeException(MyError beError, Throwable t) {
		this(beError.getErrorCode(), beError.getErrorString(), t);
	}
	
	/**
	 * Constructor accepting errorCode and errorMessage. Most Vinci Exceptions use this constructor 
	 * @param errorCode
	 * @param errorMessage
	 */
	public MyRuntimeException(String errorCode,String errorMessage) {
		this(errorCode,errorMessage,null);
	}
	
	/**
	 * Constructor acception an errorMessage and the cause
	 * @param message
	 * @param cause
	 */
	public MyRuntimeException(String message, Throwable cause) {
		this(null,message,cause);
	}
	
	public MyRuntimeException(String errorCode,String errorMessage,Throwable t) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	//================================================= 
	// Class Methods 
	//=================================================    
	
	//================================================= 
	// Instance Methods 
	//=================================================    
	private String errorCode;
	private String errorMessage;

	//================================================= 
	// Accessors 
	//================================================= 
	public String getErrorCode() {
		return errorCode;
	}
	
	public String getErrorMessage() {
		//return errorMessage + "\n "+ (getStackTraceString().length()<150?getStackTraceString():getStackTraceString().substring(0, 150));
		
		return null;
	}
	
	
	
	public static String getStackTraceString(Throwable aThrowable) {
		final Writer result = new StringWriter();
	    final PrintWriter printWriter = new PrintWriter(result);
	    aThrowable.printStackTrace(printWriter);
	    return result.toString();
	}
	
}
