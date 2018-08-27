package com.demo.automation.customexception;

public class CustomException extends RuntimeException {
	
	//private static final long serialVersionUID = 1L;
	
	public CustomException() {}
	
	public CustomException(String message){
       super(message);
    }

}
// use for custom exception
//DriverClass.SetExceptionDetails(Thread.currentThread().getStackTrace()[1].getLineNumber()+1, Thread.currentThread().getStackTrace()[1].getClassName()); 