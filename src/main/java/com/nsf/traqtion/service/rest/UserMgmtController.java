package com.nsf.traqtion.service.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nsf.traqtion.business.UserMgmtManager;
import com.nsf.traqtion.model.common.ResponseBody;
import com.nsf.traqtion.model.usermgmt.ResetPasswordDTO;
import com.nsf.traqtion.model.usermgmt.SecurityQuestionsDTO;
import com.nsf.traqtion.model.usermgmt.UserDTO;
import com.nsf.traqtion.model.usermgmt.UserDetailsDTO;
import com.nsf.traqtion.model.usermgmt.UserSecurityDetailsDTO;
import com.nsf.traqtion.model.usermgmt.UserSecurityQuestionAnswerDTO;

/**
 * UserRestController class is Rest Controller for User Management module. This
 * class exposes the services for creating, modifying, viewing etc.. operations.
 * 
 * @author HTC Global Services
 */

@RestController
@RequestMapping(value = "/users")
public class UserMgmtController extends BaseService {

	private static final Logger log = LogManager.getLogger(UserMgmtController.class);

	// Autowiring Business class
	@Autowired
	private UserMgmtManager userMgmtBusiness;

	/**
	 * getUserById is rest service GET method, which takes user id as path
	 * parameter and return appropriate user object.
	 * 
	 * @param userId
	 * @return RequestMapping<ResponseBody>
	 */
	@RequestMapping(value = "/isUserExist/{emailId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBody> isUserExist(@PathVariable("emailId") String emailId) {
		log.info("getUserById info:: ");

		Boolean isUserExists = true;
		HttpStatus status = HttpStatus.OK;
		// Call to business method to process the request by passing userId
		try {
			isUserExists = userMgmtBusiness.isUserExist(emailId);
		} catch (Exception ex) {
			return prepareResponse(ex, status);
		}
		return prepareResponse(isUserExists, status, isUserExists);
	}


	/**
	 * createUser is rest service POST method which takes user object and
	 * creates user in system and returns user object with unique userId.
	 * 
	 * @return ResponseEntity<ResponseBody>
	 */
	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBody> createUser(@RequestBody UserDetailsDTO saveUserRequest) {
		log.info("createUser  ::");
		HttpStatus status = HttpStatus.OK;
		try {
			// Call to business method for creating using by passing user
			// request object
			saveUserRequest = userMgmtBusiness.createUser(saveUserRequest);
		} catch (Exception ex) {
			return prepareResponse(ex, status);
		}
		return prepareResponse(saveUserRequest, status);

	}
	
	/**
	 * validateToken is rest service GET method which takes token and
	 * validations done on the token and return true or false.
	 * 
	 * @param token
	 * @return boolean flag
	 */
	@RequestMapping(value = "/validateToken/{token}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<ResponseBody> validateToken(@PathVariable("token") String token) {
		HttpStatus status = HttpStatus.OK;
		Boolean isvalidToken = false;
		try {
			log.info("validate controller token " + token);
			isvalidToken = userMgmtBusiness.validateToken(token);
		} catch (Exception ex) {
			return prepareResponse(ex, status);
		}
		return prepareResponse(isvalidToken, status);

	}
	
	/**
	 * getUserById is rest service GET method, which takes user id as path
	 * parameter and return appropriate user object.
	 * 
	 * @param userId
	 * @return RequestMapping<ResponseBody>
	 */
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBody> getUserById(@PathVariable("userId") Long userId) {
		log.info("getUserById info:: ");
		log.debug("gerUserBy Id :: " + userId);
		System.out.println("gerUserBy Id 1:: " + userId);
		UserDetailsDTO user = null;
		HttpStatus status = HttpStatus.OK;
		// Call to business method to process the request by passing userId
		try {
			user = userMgmtBusiness.getUserById(userId);
		} catch (Exception ex) {
			return prepareResponse(ex, status);
		}
		return prepareResponse(user, status);
	}

	/**
	 * getAllUsers is rest service GET method which return list of all user
	 * objects in the system.
	 * 
	 * @return ResponseEntity<ResponseBody>
	 */
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBody> getAllUsers() {
		log.info("all users  ::");

		HttpStatus status = HttpStatus.OK;
		List<UserDTO> usersList = new ArrayList<UserDTO>();
		try {
			// call to Business method to process the request
			usersList = userMgmtBusiness.getAllUsers();

			/*
			 * if(null == usersList){ status = HttpStatus.NOT_FOUND; }
			 */
		} catch (Exception ex) {
			return prepareResponse(ex, status);
		}
		return prepareResponse(usersList, status);
	}

	/**
	 * UserSecurityDetails is rest service POST method which takes
	 * token,passwords and security Questions list And save password ,security
	 * Questions ,status and return true or false.
	 * 
	 * @param UserSecurityDetailsDTO
	 * @return boolean flag
	 */

	@RequestMapping(value = "/userSecurityDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBody> createUserSecurityDetails(
			@RequestBody UserSecurityDetailsDTO userSecurityDetailsDTO) {
		log.info("createUserSecurityDetails:");

		HttpStatus status = HttpStatus.OK;
		Boolean isSuccess = false;
		try {
			isSuccess = userMgmtBusiness.createSecurityDetails(userSecurityDetailsDTO);
		} catch (Exception ex) {
			return prepareResponse(ex, status);
		}
		return prepareResponse(isSuccess, status);

	}

	/**
	 *
	 * @param emailId
	 * @return
	 */
	@RequestMapping(value = "/{emailId}/forgotPassword", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBody> sendForgotPasswordNotification(@PathVariable("emailId") String emailId) {
		log.info(":: sendForgotPasswordNotification");
		boolean notificationStatus;
		HttpStatus status = HttpStatus.OK;
		// Call to business method to process the request by passing emailId
		try {
			notificationStatus = userMgmtBusiness.sendForgotPasswordNotification(emailId);

		} catch (Exception ex) {
			return prepareResponse(ex, status);
		}
		return prepareResponse(notificationStatus, status);
	}

	@RequestMapping(value = "/{token}/randomSecurityQuestion", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBody> getRandomSecurityQuestion(@PathVariable("token") String token) {
		log.info("getSecurityQuestionsandAnswers:");
		if (log.isDebugEnabled()) {
			log.debug("userId : " + token);
		}
		HttpStatus status = HttpStatus.OK;
		SecurityQuestionsDTO securityQuestionsDTO = null;
		try {
			securityQuestionsDTO = userMgmtBusiness.getRandomSecurityQuestion(token);
		} catch (Exception ex) {
			return prepareResponse(ex, status);
		}
		return prepareResponse(securityQuestionsDTO, status);
	}

	/**
	 *
	 * @param userSecurityDetailsDTO
	 * @return
	 */
	@RequestMapping(value = "/{token}/verifySecurityAnswer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBody> verifySecurityAnswer(@PathVariable("token") String token, 
			@RequestBody UserSecurityQuestionAnswerDTO userSecurityQuestionAnswerDTO) {
		HttpStatus status = HttpStatus.OK;
		Boolean userSecurity = false;
		try {
			userSecurity = userMgmtBusiness.verifySecurityAnswer(token, userSecurityQuestionAnswerDTO);
			if (!userSecurity)
				status = HttpStatus.NOT_FOUND;
		} catch (Exception ex) {
			return prepareResponse(ex, status);
		}
		return prepareResponse(userSecurity, status);
	}

	/**
	 *
	 * @param resetPassword
	 * @return
	 */
	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBody> resetPassword(@RequestBody ResetPasswordDTO resetPassword) {
		HttpStatus status = HttpStatus.OK;
		Boolean passwordSucess = false;
		try {
			passwordSucess = userMgmtBusiness.resetPassword(resetPassword);
			if (!passwordSucess)
				status = HttpStatus.NOT_MODIFIED;
		} catch (Exception ex) {
			return prepareResponse(ex, status);
		}
		return prepareResponse(passwordSucess, status);

	}



	/**
	 * UserSecurityDetails is rest service PUT method which takes
	 * token,passwords and security Questions list And update password ,
	 * security Questions and return true or false.
	 * 
	 * @param UserSecurityDetailsDTO
	 * @return boolean flag
	 */
	@RequestMapping(value = "/{userId}/userSecurityDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBody> getUserSecurityDetails(@PathVariable("userId") Long userId) {
		log.info("updateUserSecurityDetails:");
		List<UserSecurityQuestionAnswerDTO> userSecurityDetailsList = null;
		HttpStatus status = HttpStatus.OK;
		try {
			userSecurityDetailsList = userMgmtBusiness.getUserSecurityQuestionAndAnswers(userId);
		} catch (Exception ex) {
			return prepareResponse(ex, status);
		}
		return prepareResponse(userSecurityDetailsList, status);

	}

	
	/**
	 * UserSecurityDetails is rest service PUT method which takes
	 * token,passwords and security Questions list And update password ,
	 * security Questions and return true or false.
	 * 
	 * @param UserSecurityDetailsDTO
	 * @return boolean flag
	 */
	@RequestMapping(value = "/{userId}/userSecurityDetails", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBody> updateUserSecurityDetails(@PathVariable("userId") Long userId,
			@RequestBody UserSecurityDetailsDTO userSecurityDetailsDTO) {
		log.info("updateUserSecurityDetails:");

		HttpStatus status = HttpStatus.OK;
		Boolean isSuccess = false;
		try {
			isSuccess = userMgmtBusiness.updateSecurityDetails(userId, userSecurityDetailsDTO);
		} catch (Exception ex) {
			return prepareResponse(ex, status);
		}
		return prepareResponse(isSuccess, status);

	}


	/**
	 * This method fetches user details based on search criteria passed to
	 * request parameters.
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/search/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBody> searchUser(@RequestParam("firstName") String firstName,
			@RequestParam("sortBy") String sortBy, @RequestParam("orderBy") String orderBy) {
		log.info(":: updateUser");
		HttpStatus status = HttpStatus.OK;
		/*
		 * boolean deleteStatus = userMgmtBusiness.deleteUser(userId);
		 * if(!deleteStatus){ status = HttpStatus.NOT_FOUND; }
		 */

		return prepareResponse(null, status);
	}

	/**
	 * This method fetches user details based on search criteria passed to
	 * request parameters.
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/sendBulkNotifications/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBody> sendBulkNotifications() {
		log.info(":: updateUser");
		HttpStatus status = HttpStatus.OK;
		/*
		 * boolean deleteStatus = userMgmtBusiness.deleteUser(userId);
		 * if(!deleteStatus){ status = HttpStatus.NOT_FOUND; }
		 */

		return prepareResponse(null, status);
	}



}