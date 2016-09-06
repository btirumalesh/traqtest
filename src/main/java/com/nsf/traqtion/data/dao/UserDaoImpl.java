package com.nsf.traqtion.data.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.nsf.traqtion.data.entity.User;
import com.nsf.traqtion.data.entity.UserSecurityQuestion;
import com.nsf.traqtion.data.entity.UserToken;

/**
 * UserDaoClass implements UserDao interface and performs operations on User
 * management module
 * 
 * @author HTC Global Services
 *
 */

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl implements UserDao {
	private static final Logger log = LogManager.getLogger(UserDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * isUserExist method verifies if given email Id exists in system or not.
	 * 
	 * @param emailId
	 * @return
	 */
	@Override
	public Boolean isUserExist(String emailId) {
		boolean isUserExists = false;
		Long count = 0l;
		try {
			Query query = entityManager.createQuery(
					"SELECT count(u.userId) FROM User u JOIN u.userDetails ud WHERE ud.emailId = :emailId");
			query.setParameter("emailId", emailId);
			count = (Long) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (count > 0) {
			isUserExists = true;
		}
		return isUserExists;
	}


	/**
	 * createUser method creates user record in database and return user entity
	 * object with generated primary key id.
	 * 
	 * @param User
	 * @return User
	 */
	public User createUser(User userEntity) {
		log.info(" :: getUserById");
		create(userEntity);
		System.out.println("userEntity id ::" + userEntity.getUserId());
		return userEntity;
	}

	/**
	 * updateUser method updates user record in database and returns updated
	 * user entity object.
	 * 
	 * @param User
	 * @return User
	 */
	public User updateUser(Integer userId, User userEntity) {
		log.info(":: updateUser");
		if (log.isDebugEnabled()) {
			log.debug("userId : " + userId);
		}
		userEntity = update(userEntity);
		return userEntity;
	}



	/**
	 * getToken method get the token from user.
	 * 
	 * @param token
	 * @return UserToken
	 */
	@Override
	public UserToken getToken(String token) {
		UserToken userToken = null;

		log.info(":: dao impl validateToken");

		Query query = entityManager.createQuery("Select u From UserToken u WHERE u.token = :token");
		query.setParameter("token", token);

		userToken = (UserToken) query.getSingleResult();

		return userToken;
	}

	/**
	 * getUserById method fetches user details based on userid.
	 * 
	 * @param userId
	 * @return User
	 */
	public User getUserById(Long userId) {
		User user = null;

		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.userId = :userId");
		query.setParameter("userId", userId);
		user = (User) query.getSingleResult();

		return user;
	}

	/**
	 * saveOrUpdatePassword method save or update the password.
	 * 
	 * @param userId,password
	 * @return int
	 */
	@Override
	public int saveOrUpdatePassword(Long userId, String password) {

		Query query = entityManager
				.createQuery("UPDATE User u SET u.passwordHash = :password WHERE u.userId = :userId");
		query.setParameter("password", password);
		query.setParameter("userId", userId);
		int updated = query.executeUpdate();
		return updated;
	}

	/**
	 * updateSecurityQuestions method update the security questions and answers.
	 * 
	 * @param userId,password
	 * @return int
	 */
	@Override
	public int updateSecurityQuestions(Long userId, Long securityQuestionId, String answer, 
			Timestamp updatedDate) {

		Query query = entityManager.createQuery(
				"UPDATE UserSecurityQuestion usq SET usq.securityQuestion.securityQuestionId = :securityQuestionId ,usq.answer = :answer ,usq.updatedDate = :updatedDate WHERE usq.user.userId = :userId AND usq.securityQuestion.securityQuestionId = :securityQuestionId");
		query.setParameter("securityQuestionId", securityQuestionId);
		query.setParameter("answer", answer);
		query.setParameter("updatedDate", updatedDate);
		query.setParameter("userId", userId);
		int updated = query.executeUpdate();
		return updated;
	}

	/**
	 * saveUserStatus method saves user status in usermapping .
	 * 
	 * @param userId
	 * @return boolean flag
	 */
	@Override
	public Boolean updateUserStatus(Long userId) {
		Boolean setStatus = false;

		Long userStatusId = 10003L;
		Query userStatusQuery = entityManager.createQuery(
				"UPDATE UserMapping um SET um.status.statusId = :userStatusId WHERE um.user.userId = :userId");
		userStatusQuery.setParameter("userStatusId", userStatusId);
		userStatusQuery.setParameter("userId", userId);
		int count = userStatusQuery.executeUpdate();

		if (count == 1) {
			setStatus = true;
		}

		return setStatus;
	}

	/**
	 * saveSecurityQuestions method saves the security Questions .
	 * 
	 * @param userSecurityQuestion
	 * @return UserSecurityQuestion
	 */
	@Override
	public UserSecurityQuestion createSecurityQuestions(UserSecurityQuestion userSecurityQuestion) {
		create(userSecurityQuestion);
		return userSecurityQuestion;
	}

	// these below 2 methods done by Deepthi
	/**
	 * getUserByEmailId method checks whether emailId exists or not.
	 * 
	 * @param emailId
	 * @return User
	 */
	@Override
	public User getUserByEmailId(String emailId) {
		log.info(" :: sendForgotPasswordNotification");
		User user = null;

		Query query = entityManager.createQuery("SELECT user FROM User user WHERE user.loginId = :emailId", User.class);
		query.setParameter("emailId", emailId);
		user = (User) query.getSingleResult();

		return user;
	}

	/**
	 * saveToken method saves token for a user.
	 * 
	 * @param userTokenEntity
	 * @return UserToken
	 */
	@Override
	public UserToken saveToken(UserToken userTokenEntity) {
		create(userTokenEntity);
		return userTokenEntity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserSecurityQuestion> getUserSecurityQuestions(Long userId) {

		List<UserSecurityQuestion> objList = null;
		Query query = entityManager
				.createQuery("Select usq From UserSecurityQuestion usq WHERE usq.user.userId = :userId)");
		query.setParameter("userId", userId);
		objList = query.getResultList();
		return objList;
	}

	@Override
	public String getSecurityAnswer(Long uesrId, Long questionId) {
		log.info("checking security question answer");
		String securityAnswer = null;

		Query query = entityManager.createQuery(
				"Select answer From UserSecurityQuestion us WHERE us.user.userId= :userId AND us.securityQuestion.securityQuestionId= :securityQuestionId");
		query.setParameter("userId", uesrId);
		query.setParameter("securityQuestionId", questionId);
		securityAnswer = (String) query.getSingleResult();

		return securityAnswer;
	}

	/**
	 * getAllUsers method fetches list of all user records available in system.
	 * 
	 * @param userId
	 * @return List<User>
	 */
	public List<User> getAllUsers() {
		log.info(" :: getUserById");
		List<User> usersList = null;
		usersList = fetchAll(User.class);
		return usersList;
	}


	@Override
	public User getUserByLoginId(String loginId) {
		log.info(" :: sendForgotPasswordNotification");
		User user = null;

		Query query = entityManager.createQuery("SELECT user FROM User user WHERE user.loginId = :loginId", User.class);
		query.setParameter("loginId", loginId);
		user = (User) query.getSingleResult();

		return user;
	}


}