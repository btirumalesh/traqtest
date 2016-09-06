package com.nsf.traqtion.business;

import java.util.List;

import com.nsf.traqtion.model.usermgmt.AuthenticationResponse;
import com.nsf.traqtion.model.usermgmt.ResetPasswordDTO;
import com.nsf.traqtion.model.usermgmt.SecurityQuestionsDTO;
import com.nsf.traqtion.model.usermgmt.UserDTO;
import com.nsf.traqtion.model.usermgmt.UserDetailsDTO;
import com.nsf.traqtion.model.usermgmt.UserSecurityDetailsDTO;
import com.nsf.traqtion.model.usermgmt.UserSecurityQuestionAnswerDTO;

/**
 * UserMgmtBL Interface defines list of business methods used to perform business operations on User management module
 * @author HTC Global Services
 *
 */
public interface UserMgmtManager {

	
	/**
	 * isUserExist method return true if user exists with given email id or return false with error message.
	 * @param userId
	 * @return User
	 */
	public Boolean isUserExist(String emailId);
	
	

	/**
	 * createUser method maps DTO to entity objects and creates user record in database by making calls to Data access classes.
	 * @param User
	 * @return User
	 */
	public UserDetailsDTO createUser(UserDetailsDTO userDto);

		
	/**
	 * updateUser method updates user record in database by making calls to data access classes and returns updated user entity object.
	 * @param User
	 * @return User
	 */
	public UserDetailsDTO updateUser(Integer userId,UserDetailsDTO userDto);
	
	/**
	 * validateToken method validates the token details  
	 * @param token
	 * @return boolean flag
	 */
	public Boolean validateToken(String token);
	
	/**
	 * createSecurityDetails method saves the password ,security Questions ,status and return true or false. 
	 * @param userSecurityDetailsDTO
	 * @return boolean flag
	 */
	public Boolean createSecurityDetails(UserSecurityDetailsDTO userSecurityDetailsDTO);
	
	/**
     * sendForgotPasswordNotification method generates token if sent emailId exists
     * @param emailId
     * @return status
     */
    public boolean sendForgotPasswordNotification(String emailId); 
   

    /**
     *  Fetches random security question by given token for forgot password functionality
     * @param userId
     * @return
      */

    public SecurityQuestionsDTO getRandomSecurityQuestion(String token);


    /**
     * 
     * @param userSecurityDetailsDTO
     * @return
     */
    public Boolean verifySecurityAnswer(String token, UserSecurityQuestionAnswerDTO userSecurityQuestionAnswerDTO);

    
    /**
     *  Save or Update password
     * @param UserId,SecurityquestionId,Answer
     * @return
     */
    public Boolean resetPassword(ResetPasswordDTO resetPassword); 

    /**
     *  Fetches SecurityQuestions And Answers with userId
     * @param userId
     * @return
      */
    public List<UserSecurityQuestionAnswerDTO> getUserSecurityQuestionAndAnswers(Long userId);

    /**
     *  Checks SecurityAnswer with userId and securityquestionId is exists or not
     * @param UserId,SecurityquestionId,Answer
     * @return
     */

    /**
	 * updateSecurityDetails method update the password , security Questions and return true or false. 
	 * @param userSecurityDetailsDTO
	 * @return boolean flag
	 */
	public Boolean updateSecurityDetails(Long userId,UserSecurityDetailsDTO userSecurityDetailsDTO);
	
    
	/**
	 * getUserById method fetches user entity based on provided userId 
	 * and maps required properties to UserDTO object.
	 * @param userId
	 * @return User
	 */
	public UserDetailsDTO getUserById(Long userId);
	
	/**
	 * getAllUsers method fetches list of all user records and maps DTO objects from entity objects.
	 * @param userId
	 * @return List<User>
	 */
	public List<UserDTO> getAllUsers();

	public AuthenticationResponse authenticate(String loginId, String password);
}