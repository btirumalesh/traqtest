package com.nsf.traqtion.service.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nsf.traqtion.model.common.ResponseBody;
import com.nsf.traqtion.model.usermgmt.AuthenticationRequest;
import com.nsf.traqtion.model.usermgmt.AuthenticationResponse;


@RestController
@RequestMapping(value = "/")
public class AuthenticationController extends BaseService{
	
	private static final Logger log = LogManager.getLogger(AuthenticationController.class);
	
	/**
	 * createUser is rest service POST method which takes user object and creates user in system and returns user object with unique userId.
	 * @return ResponseEntity<ResponseBody>
	 */
	@RequestMapping(value = "authenticate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBody> authenticate(@RequestBody AuthenticationRequest authRequest) {
		log.info("authenticate  ::");
		HttpStatus status = HttpStatus.OK;
		AuthenticationResponse response = new AuthenticationResponse();
		// toDO send access token if generated.
		// Get User Details with his client details, and his roles and permissions.
		if(authRequest.getUserName()!=null && authRequest.getPassword()!=null){
			
			if(authRequest.getUserName().equals("mike") && authRequest.getPassword().equals("test123")){
				//TODO success filter
			}else{
				// failure filter
				//return  prepareResponse(null, status,false,1001,"Invalid username password");
			}
		}else{
			//failure filter
			//return  prepareResponse(null, status,false,1001,"Username and Password cannot be empty");
		}
		
		// Call to business method for creating using by passing user request object
		
		return  prepareResponse(null, status);
	
	}
}