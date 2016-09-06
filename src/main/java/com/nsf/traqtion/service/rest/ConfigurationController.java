package com.nsf.traqtion.service.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nsf.traqtion.exception.NSFException;
import com.nsf.traqtion.model.common.ResponseBody;


@RestController
@RequestMapping(value = "/config")
public class ConfigurationController extends BaseService{
	
	private static final Logger log = LogManager.getLogger(ConfigurationController.class);
	
	/**
	 * createUser is rest service POST method which takes user object and creates user in system and returns user object with unique userId.
	 * @return ResponseEntity<ResponseBody>
	 */
	@RequestMapping(value = "/{clientId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBody> getJobTitleByClientId(@PathVariable("clientId") Integer ClientId) {
		log.info("getJobTitleByClientId  ::");
		HttpStatus status = HttpStatus.OK;
		try{
			
		}catch(NSFException nsfEx){
			//return  prepareResponse(null, status,false,1001,"Invalid username password");
		}catch(Exception ex){
			//return  prepareResponse(null, status,false,1001,"Invalid username password");
		}
		//	return  prepareResponse(null, status,false,1001,"Invalid username password");
		return  prepareResponse(null, status);
	
	}
}