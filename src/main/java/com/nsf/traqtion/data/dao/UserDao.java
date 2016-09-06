package com.nsf.traqtion.data.dao;

import java.sql.Timestamp;
import java.util.List;

import com.nsf.traqtion.data.entity.User;
import com.nsf.traqtion.data.entity.UserSecurityQuestion;
import com.nsf.traqtion.data.entity.UserToken;


/**
 * UserDao Interface defines list of methods used to perform operations on User management module
 * @author HTC Global Services
 *
 */
public interface UserDao {


    
    /**
     * isUserExist method verifies if given email Id exists in system or not.
     * @param emailId
     * @return
     */
    public Boolean isUserExist(String emailId);

	/**
	 * saveUser method creates user record in database and return user entity object with generated primary key id.
	 * @param User
	 * @return User
	 */
	public User createUser(User userEntity);
	
	
	/**
	 * updateUser method updates user record in database and returns updated user entity object.
	 * @param User
	 * @return User
	 */
	public User updateUser(Integer userId, User userEntity);

    /**
     * getToken method get the token from user.
     * @param token
     * @return UserToken
     */
    public UserToken getToken(String token);
    
    
     /**
     * saveSecurityQuestions method saves the security Questions .
     * @param userSecurityQuestion
     * @return UserSecurityQuestion
     */
    public UserSecurityQuestion createSecurityQuestions(UserSecurityQuestion userSecurityQuestion);
    /**
     * updateSecurityQuestions method update the security questions and answers.
     * @param userId,password
     * @return int
     */
    public int updateSecurityQuestions(Long userId,Long securityQuestionId,String answer,Timestamp updatedDate);
    /**
     * saveOrUpdatePassword method save or update the password.
     * @param userId,password
     * @return int
     */
    public int saveOrUpdatePassword(Long userId,String password);
    
    /**
     * saveUserStatus method saves user status in usermapping .
     * @param userId
     * @return boolean flag
     */
    public Boolean updateUserStatus(Long userId);
   
    /**
     * getUserByEmailId method fetches user details based on emailId.
     * @param emailId
     * @return User
     */
    public User getUserByEmailId(String emailId);
    
     /**

     * saveToken method saves token for a user.
     * @param userTokenEntity
     * @return UserToken
     */
    public UserToken saveToken(UserToken userTokenEntity); 


    /**
     * verifySecurityQuestionsAndAnswers method checks the security question and answer  based on provided UserId,SecurityQuestionId,Answer.
     * @param UserID,SecurityQuestionId,Answer
     * @return boolean
     */

    public String getSecurityAnswer(Long userId,Long questionId);


    /**
     * 
     * @param userId
     * @return
     */
    public List<UserSecurityQuestion> getUserSecurityQuestions(Long userId);

    /**
	 * getUserById method fetches user entity object based on provided userId.
	 * @param userId
	 * @return User
	 */
	public User getUserById(Long userId);
	
	/**
	 * getAllUsers method fetches list of all user records available in system.
	 * @param userId
	 * @return List<User>
	 */
	public List<User> getAllUsers();

	/**
     * getUserByEmailId method fetches user details based on emailId.
     * @param emailId
     * @return User
     */
    public User getUserByLoginId(String loginId);

}