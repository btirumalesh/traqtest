package com.nsf.traqtion.service.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nsf.traqtion.exception.NSFException;
import com.nsf.traqtion.exception.NSFExceptionType;
import com.nsf.traqtion.model.common.ResponseBody;
/**
 * BaseService base/helper class which can be used across all the 
 * Rest Controllers for performing common functionalities.
 * Bases service has helper methods to prepare Response object with various attributes using overloaded methods.
 * @author HTC Global Services
 */
public class BaseService {

	private static final Logger log = LogManager.getLogger(BaseService.class);
	
	/**
	 * prepareResponse method prepares response Entity object with given response object and status codes
	 * @param responseObject
	 * @param httpStatus
	 * @return ResponseEntity<ResponseBody>
	 */
	public ResponseEntity<ResponseBody> prepareResponse(Object responseObject,HttpStatus httpStatus){
		log.info(" :: prepareResponse");
		ResponseBody responseBody = new ResponseBody();
		responseBody.data = responseObject;
		
		return new ResponseEntity<ResponseBody>(responseBody, httpStatus);
	}
	
	/**
	 * prepareResponse method prepares response Entity object with given response object and status codes
	 * @param responseObject
	 * @param httpStatus
	 * @param httpHeaders
	 * @return
	 */
	public ResponseEntity<ResponseBody> prepareResponse(Object responseObject,HttpStatus httpStatus,HttpHeaders httpHeaders){
		
		ResponseBody responseBody = new ResponseBody();
		responseBody.data = responseObject;
		
		return new ResponseEntity<ResponseBody>(responseBody,httpHeaders,httpStatus);
	}
	
	/**
	 * prepareResponse method prepares response Entity object with given response object and status codes
	 * @param responseObject
	 * @param httpStatus
	 * @param status
	 * @return
	 */
	public ResponseEntity<ResponseBody> prepareResponse(Object responseObject,HttpStatus httpStatus,Boolean status){
		
		ResponseBody responseBody = new ResponseBody();
		responseBody.isSuccess = status;
		responseBody.data = responseObject;
		
		return new ResponseEntity<ResponseBody>(responseBody,httpStatus);
	}
	
	/**
	 * prepareResponse method prepares response Entity object with given response object and status codes
	 * @param responseObject
	 * @param httpStatus
	 * @param status
	 * @param statusMsg
	 * @return
	 */
	public ResponseEntity<ResponseBody> prepareResponse(Object responseObject,HttpStatus httpStatus,Boolean status,String statusMsg){
		
		ResponseBody responseBody = new ResponseBody();
		responseBody.isSuccess = status;
		responseBody.statusMsg = statusMsg;
		responseBody.data = responseObject;
		
		return new ResponseEntity<ResponseBody>(responseBody,httpStatus);
	}
	
	/**
	 * prepareResponse method prepares response Entity object with given response object and status codes
	 * @param responseObject
	 * @param httpStatus
	 * @param status
	 * @param errorCode
	 * @param errorMsg
	 * @return
	 */
	public ResponseEntity<ResponseBody> prepareResponse(Object responseObject,HttpStatus httpStatus,Boolean status,String errorCode, String errorMsg){
		
		ResponseBody responseBody = new ResponseBody();
		responseBody.isSuccess = status;
		responseBody.errorCode = errorCode;
		responseBody.errorMsg = errorMsg;
		responseBody.data = responseObject;
		
		return new ResponseEntity<ResponseBody>(responseBody,httpStatus);
	}
	
	/**
	 * prepareResponse method prepares response Entity object with given response object and status codes
	 * @param responseObject
	 * @param Exception
	 * @return ResponseEntity<ResponseBody>
	 */
	public ResponseEntity<ResponseBody> prepareResponse(Exception e,HttpStatus httpStatus){
		log.info(" :: prepareResponse");
		ResponseBody responseBody =	prepareErrorResponse(e);
		return new ResponseEntity<ResponseBody>(responseBody, httpStatus);
	}
	
	
	private ResponseBody prepareErrorResponse(Exception ex){
		ResponseBody responseBody = new ResponseBody();
		responseBody.setIsSuccess(false);
		if(ex instanceof NSFException){
			responseBody.setErrorCode(((NSFException) ex).getNSFExceptionType().getErrorCode());
			responseBody.setErrorMsg(((NSFException) ex).getNSFExceptionType().getErrorMessage());
		}else{
			responseBody.setErrorCode(NSFExceptionType.GLOBAL_EXCEPTION.getErrorCode());
			responseBody.setErrorMsg(NSFExceptionType.GLOBAL_EXCEPTION.getErrorMessage()+" :: "+ex.getCause());
		}
		
		return responseBody;
	}
}
