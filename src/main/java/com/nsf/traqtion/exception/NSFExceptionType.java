package com.nsf.traqtion.exception;

import java.util.HashMap;

public enum NSFExceptionType {
	INVALID_USER_DATA("200"),
	GLOBAL_EXCEPTION("500"),
	INVALID_DATA("RE001"),
	BUSINESS_EXCEPTION("BE001"),
	DATA_EXCEPTION("DE001"),
	USER_NOT_FOUND("UM001"),
	INVALID_TOKEN("UM002"),
	INVALID_CREDENTIALS("UM003"),
	USER_ALREADY_EXISTS("UM004"),;
	
	private String errorCode;
	
	private NSFExceptionType(String errorCode){
		this.errorCode = errorCode;
	}
	
	private HashMap<String,String> errorMessageMap;
	
	public String getErrorMessage(){
		String message = null;
		if(errorMessageMap==null){
			errorMessageMap = new HashMap<String,String>();
			
			errorMessageMap.put("RE001","Invalid Data.");
			errorMessageMap.put("BE001","Error occured while processing request");
			errorMessageMap.put("DE001","Error occured while process data.");
			
			errorMessageMap.put("UM001","User does not exist.");
			errorMessageMap.put("UM002","Invalid token");
			errorMessageMap.put("UM003","Invalid user credentials");
			errorMessageMap.put("UM004","User exists with given email id.");
			
			errorMessageMap.put("100","No User Found With The Given Id" );
			errorMessageMap.put("200","Provided Date Has Invalid Content");
			errorMessageMap.put("500", "Exception occured while processing");
		}else{
			message = errorMessageMap.get(this.errorCode);
		}
		return message;
	}

	public String getErrorCode() {
		return errorCode;
	}

}