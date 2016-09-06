package com.nsf.traqtion.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nsf.traqtion.data.dao.UserDao;
import com.nsf.traqtion.data.entity.SecurityQuestion;
import com.nsf.traqtion.data.entity.User;
import com.nsf.traqtion.data.entity.UserSecurityQuestion;
import com.nsf.traqtion.data.entity.UserToken;
import com.nsf.traqtion.exception.NSFException;
import com.nsf.traqtion.exception.NSFExceptionType;
import com.nsf.traqtion.mapper.usermgmt.UserMapper;
import com.nsf.traqtion.model.usermgmt.AuthenticationResponse;
import com.nsf.traqtion.model.usermgmt.ResetPasswordDTO;
import com.nsf.traqtion.model.usermgmt.SecurityQuestionsDTO;
import com.nsf.traqtion.model.usermgmt.UserDTO;
import com.nsf.traqtion.model.usermgmt.UserDetailsDTO;
import com.nsf.traqtion.model.usermgmt.UserSecurityDetailsDTO;
import com.nsf.traqtion.model.usermgmt.UserSecurityQuestionAnswerDTO;
import com.nsf.traqtion.util.DateUtil;
import com.nsf.traqtion.util.NSFCommon;

/**
 * UserMgmtBLImpl Class implements business methods to perform business
 * operations on User management module by making calls to Data access classes.
 * 
 * @author HTC Global Services
 *
 */
@Transactional
@Service("userMgmtManager")
public class UserMgmtManagerImpl implements UserMgmtManager {

	private static final Logger log = LogManager.getLogger(UserMgmtManagerImpl.class);
	// autowiring userDao class
	@Autowired
	private UserDao userDao;

	@Override
	public Boolean isUserExist(String emailId) {

		boolean isUserExists = userDao.isUserExist(emailId);

		return isUserExists;
	}

	/**
	 * saveUser method maps DTO to entity objects and creates user record in
	 * database by making calls to Data access classes.
	 * 
	 * @param User
	 * @return User
	 */
	public UserDetailsDTO createUser(UserDetailsDTO userDto) {
		log.info(":: saveUser");

		// check if user exists with given emailId
		boolean isUserExists = userDao.isUserExist(userDto.getEmailId());
		if (isUserExists) {
			throw new NSFException(NSFExceptionType.USER_ALREADY_EXISTS);
		}

		// mapping from DTO to Entity
		User userEntity = UserMapper.userDTOToEntityMapper(userDto);
		userEntity = userDao.createUser(userEntity);
		// userDto = UserMapper.userEntityToDTOMapper(userEntity);
		log.info(" :: getUserById");

		if (userEntity.getUserId() != null) {
			// Generating token with userid and email;
			String token = NSFCommon.generateToken(userEntity.getUserId(), userEntity.getLoginId());

			UserToken userToken = new UserToken();
			userToken.setUser(userEntity);
			userToken.setTokenType("REGISTRATION");
			userToken.setToken(token);
			userToken.setIsactive(new Long(1));
			userToken.setCreationDate(DateUtil.getCurrentTimeStamp());
			userToken.setUpdatedDate(DateUtil.getCurrentTimeStamp());

			saveToken(userToken);
		}

		userDto = UserMapper.userEntityToDTOMapper(userEntity);
		return userDto;
	}

	/**
	 * updateUser method updates user record in database by making calls to data
	 * access classes and returns updated user entity object.
	 * 
	 * @param User
	 * @return User
	 */
	public UserDetailsDTO updateUser(Integer userId, UserDetailsDTO userDto) {
		log.info(":: updateUser");
		if (log.isDebugEnabled()) {
			log.debug("userId : " + userId);
		}
		User userEntity = UserMapper.userDTOToEntityMapper(userDto);
		userDao.updateUser(userId, userEntity);
		return userDto;
	}

	/**
	 * validateToken method validates the token details
	 * 
	 * @param token
	 * @return boolean flag
	 */
	@Override
	public Boolean validateToken(String token) {
		log.info(":: validate token in managerimpl");
		Boolean isValid = false;

		UserToken userToken = userDao.getToken(token);

		if (userToken != null) {
			String fromDBToken = userToken.getToken();
			if (token.equals(fromDBToken)) {
				isValid = true;
			}
		}

		return isValid;
	}

	/**
	 * saveToken method saves the token after user is created
	 * 
	 * @param userToken
	 * @return UserTokenDTO
	 */
	public String saveToken(UserToken userToken) {
		String tokenSaved = null;

		userToken = userDao.saveToken(userToken);

		if (userToken.getTokenId() != null) {
			tokenSaved = userToken.getToken();
		}

		return tokenSaved;
	}

	/**
	 * createSecurityDetails method saves the password ,security Questions
	 * ,status and return true or false.
	 * 
	 * @param userSecurityDetailsDTO
	 * @return boolean flag
	 */

	@Override
	@Transactional
	public Boolean createSecurityDetails(UserSecurityDetailsDTO userSecurityDetailsDTO) {
		log.info(":: createSecurityDetails in managerimpl");
		Boolean isValid = true;
		String newPassword = userSecurityDetailsDTO.getNewPassword();
		String token = userSecurityDetailsDTO.getToken();

		if (validateToken(token)) {
			log.info(":: createSecurityDetails token" + token);

			Long userId = NSFCommon.getUserIdFromToken(token);
			List<UserSecurityQuestionAnswerDTO> securityQuestionAnswerList = userSecurityDetailsDTO
					.getSecurityQuestionAnswerList();
			// update password method
			int updated = userDao.saveOrUpdatePassword(userId, newPassword);
			if (updated == 1) {
				for (UserSecurityQuestionAnswerDTO usq : securityQuestionAnswerList) {
					UserSecurityQuestion userSecurityQuestion = new UserSecurityQuestion();

					SecurityQuestion securityQuestion = new SecurityQuestion();
					securityQuestion.setSecurityQuestionId(usq.getQuestionId());
					userSecurityQuestion.setSecurityQuestion(securityQuestion);

					User user = new User();
					user.setUserId(userId);
					userSecurityQuestion.setUser(user);

					userSecurityQuestion.setAnswer(usq.getAnswer());
					userSecurityQuestion.setCreationDate(DateUtil.getCurrentTimeStamp());
					userSecurityQuestion.setUpdatedDate(DateUtil.getCurrentTimeStamp());

					// save security Questions method
					userSecurityQuestion = userDao.createSecurityQuestions(userSecurityQuestion);

					if (userSecurityQuestion.getUserSecurityQuestionsId() == null) {
						isValid = false;
						break;
					}
				}
				// save user status
				isValid = userDao.updateUserStatus(userId);

			} else {
				throw new NSFException(NSFExceptionType.GLOBAL_EXCEPTION);
			}
		} else {
			throw new NSFException(NSFExceptionType.INVALID_TOKEN);
		}

		return isValid;
	}

	/**
	 * sendForgotPasswordNotification method checks user exists in database,if
	 * exists it will generate a token and returns true if token created.
	 * 
	 * @param emailId
	 * @return status
	 */
	@Override
	public boolean sendForgotPasswordNotification(String emailId) {
		// TODO Auto-generated method stub
		log.info(":: sendForgotPasswordNotification");
		UserToken userTokenEntity = null;
		boolean isSuccess = true;
		String token = null;

		User user = userDao.getUserByEmailId(emailId);

		if (user != null) {
			userTokenEntity = new UserToken();
			userTokenEntity.setUser(user);
			token = NSFCommon.generateToken(user.getUserId(), user.getLoginId());
			userTokenEntity.setToken(token);
			userTokenEntity.setTokenType("FORGOTPASSWORD");
			userTokenEntity.setCreationDate(DateUtil.getCurrentTimeStamp());
			userTokenEntity.setUpdatedDate(DateUtil.getCurrentTimeStamp());
			// call to dao method to save token
			userTokenEntity = userDao.saveToken(userTokenEntity);
			log.info(":: saveForgotPasswordToken");
			if (userTokenEntity.getTokenId() != null) {
				// TODO send Email notification

				return true;
			} else {
				isSuccess = false;
			}
		} else {
			throw new NSFException(NSFExceptionType.USER_NOT_FOUND);
		}
		return isSuccess;
	}

	@Override
	public SecurityQuestionsDTO getRandomSecurityQuestion(String token) {

		Long userId = NSFCommon.getUserIdFromToken(token);

		List<UserSecurityQuestion> userSQList = userDao.getUserSecurityQuestions(userId);
		int randnum = new Random().nextInt(userSQList.size());
		UserSecurityQuestion usq = userSQList.get(randnum);
		SecurityQuestionsDTO securityQuestiondto = new SecurityQuestionsDTO();
		if (usq != null) {
			securityQuestiondto.setSecurityQuestionId(usq.getSecurityQuestion().getSecurityQuestionId());
			securityQuestiondto.setQuestionCode(usq.getSecurityQuestion().getQuestionCode());
			securityQuestiondto.setQuestion(usq.getSecurityQuestion().getQuestionName());
		}
		return securityQuestiondto;
	}

	@Override
	public Boolean verifySecurityAnswer(String token, UserSecurityQuestionAnswerDTO userSecurityQuestionAnswerDTO) {
		boolean flag = true;
		Long userId = NSFCommon.getUserIdFromToken(token);
		String actualAnswer = userSecurityQuestionAnswerDTO.getAnswer();
		Long questionId = userSecurityQuestionAnswerDTO.getQuestionId();
		String answer = userDao.getSecurityAnswer(userId, questionId);
		if (!answer.equals(actualAnswer)) {
			flag = false;
			throw new NSFException(NSFExceptionType.INVALID_USER_DATA);
		}
		return flag;
	}

	@Override
	public Boolean resetPassword(ResetPasswordDTO resetPassword) {

		boolean isSuccess = true;
		String token = resetPassword.getToken();
		Long userId = NSFCommon.getUserIdFromToken(token);
		int updated = userDao.saveOrUpdatePassword(userId, resetPassword.getPassword());
		if (updated <= 0) {
			isSuccess = false;
		}
		return isSuccess;
	}

	/**
	 * 
	 */
	@Override
	public List<UserSecurityQuestionAnswerDTO> getUserSecurityQuestionAndAnswers(Long userId) {

		List<UserSecurityQuestionAnswerDTO> usqList = new ArrayList<UserSecurityQuestionAnswerDTO>();
		List<UserSecurityQuestion> userSQList = userDao.getUserSecurityQuestions(userId);
		if (userSQList != null) {
			for (UserSecurityQuestion usq : userSQList) {
				UserSecurityQuestionAnswerDTO usqa = new UserSecurityQuestionAnswerDTO();
				usqa.setAnswer(usq.getAnswer());
				usqa.setCode(usq.getSecurityQuestion().getQuestionCode());
				usqa.setQuestionId(usq.getSecurityQuestion().getSecurityQuestionId());
				usqa.setQuestionName(usq.getSecurityQuestion().getQuestionName());
				usqList.add(usqa);
			}
		}
		return usqList;
	}

	/**
	 * updateSecurityDetails method update the password , security Questions and
	 * return true or false.
	 * 
	 * @param userSecurityDetailsDTO
	 * @return boolean flag
	 */
	@Override
	public Boolean updateSecurityDetails(Long userId, UserSecurityDetailsDTO userSecurityDetailsDTO) {
		log.info(":: updateSecurityDetails in managerimpl");
		Boolean isValid = true;

		String oldPassword = userSecurityDetailsDTO.getCurrentPassword();
		String newPassword = userSecurityDetailsDTO.getNewPassword();
		List<UserSecurityQuestionAnswerDTO> securityQuestionAnswerList = userSecurityDetailsDTO
				.getSecurityQuestionAnswerList();

		User user = userDao.getUserById(userId);

		if (oldPassword.equals(user.getPasswordHash())) {
			int updated = userDao.saveOrUpdatePassword(userId, newPassword);
			if (updated == 1) {
				for (UserSecurityQuestionAnswerDTO usq : securityQuestionAnswerList) {
					int isUpdated = userDao.updateSecurityQuestions(userId, usq.getQuestionId(),
							usq.getAnswer(), DateUtil.getCurrentTimeStamp());
					if (isUpdated != 1) {
						isValid = false;
						break;
					}
				}
			} else {
				isValid = false;
			}
		} else {
			isValid = false;
			throw new NSFException(NSFExceptionType.INVALID_CREDENTIALS);
		}
		return isValid;
	}

	/**
	 * getUserById method fetches user entity based on provided userId and maps
	 * required properties to UserDTO object.
	 * 
	 * @param userId
	 * @return User
	 */
	public UserDetailsDTO getUserById(Long userId) {
		log.info(":: getUserById");
		if (log.isDebugEnabled()) {
			log.debug("userId : " + userId);
		}
		UserDetailsDTO userDto = null;
		// call to dao method
		User user = userDao.getUserById(userId);
		userDto = UserMapper.userEntityToDTOMapper(user);

		// userDto = getModelMapper().map(user, UserDTO.class);

		return userDto;
	}

	/**
	 * getAllUsers method fetches list of all user records and maps DTO objects
	 * from entity objects.
	 * 
	 * @param userId
	 * @return List<User>
	 */
	public List<UserDTO> getAllUsers() {
		log.info(":: getAllUsers");
		// call to dao method
		List<User> userEntityList = userDao.getAllUsers();
		List<UserDTO> userDtoList = null;
		// mapping from Entiry to DTO
		if (userEntityList != null) {
			userDtoList = new ArrayList<UserDTO>();
			/*
			 * for (User user : userEntityList) { UserDTO userDto = new
			 * UserDTO(); userDto.setUserId(user.getId());
			 * userDto.setFirstName(user.getFirstName());
			 * userDto.setLastName(user.getLastName());
			 * userDto.setEmail(user.getEmail());
			 * userDto.setPhone(user.getPhone());
			 * 
			 * userDtoList.add(userDto); }
			 */
		}
		return userDtoList;
	}

	@Override
	public AuthenticationResponse authenticate(String loginId, String password) {
		AuthenticationResponse authResponse = new AuthenticationResponse();
		
		User userEntity = userDao.getUserByLoginId(loginId);
		if(null != userEntity){
			if(password.equals(userEntity.getPasswordHash())){
		
				if(null != userEntity && userEntity.getUserMappings()!=null && userEntity.getUserMappings().size()>1){
					authResponse.setHasMultipleProfiles(true);
					// TODO get mapping list
				}else{
					authResponse.setUserDetails(UserMapper.userEntityToDTOMapper(userEntity));
				}
			}else{
				throw new NSFException(NSFExceptionType.INVALID_CREDENTIALS);
			}
		}else{
			throw new NSFException(NSFExceptionType.USER_NOT_FOUND);
		}
		
		return authResponse;
	}

}