package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="lock_count")
	private Long lockCount;

	@Column(name="lockcount_date")
	private Timestamp lockcountDate;

	@Column(name="login_id")
	private String loginId;

	@Column(name="password_hash")
	private String passwordHash;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to UserDetail
	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	private List<UserDetail> userDetails;

	//bi-directional many-to-one association to UserMapping
	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	private List<UserMapping> userMappings;

	//bi-directional many-to-one association to UserSecurityQuestion
	@OneToMany(mappedBy="user")
	private List<UserSecurityQuestion> userSecurityQuestions;

	//bi-directional many-to-one association to UserToken
	@OneToMany(mappedBy="user")
	private List<UserToken> userTokens;

	public User() {
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Long getLockCount() {
		return this.lockCount;
	}

	public void setLockCount(Long lockCount) {
		this.lockCount = lockCount;
	}

	public Timestamp getLockcountDate() {
		return this.lockcountDate;
	}

	public void setLockcountDate(Timestamp lockcountDate) {
		this.lockcountDate = lockcountDate;
	}

	public String getLoginId() {
		return this.loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<UserDetail> getUserDetails() {
		return this.userDetails;
	}

	public void setUserDetails(List<UserDetail> userDetails) {
		this.userDetails = userDetails;
	}

	public UserDetail addUserDetail(UserDetail userDetail) {
		getUserDetails().add(userDetail);
		userDetail.setUser(this);

		return userDetail;
	}

	public UserDetail removeUserDetail(UserDetail userDetail) {
		getUserDetails().remove(userDetail);
		userDetail.setUser(null);

		return userDetail;
	}

	public List<UserMapping> getUserMappings() {
		return this.userMappings;
	}

	public void setUserMappings(List<UserMapping> userMappings) {
		this.userMappings = userMappings;
	}

	public UserMapping addUserMapping(UserMapping userMapping) {
		getUserMappings().add(userMapping);
		userMapping.setUser(this);

		return userMapping;
	}

	public UserMapping removeUserMapping(UserMapping userMapping) {
		getUserMappings().remove(userMapping);
		userMapping.setUser(null);

		return userMapping;
	}

	public List<UserSecurityQuestion> getUserSecurityQuestions() {
		return this.userSecurityQuestions;
	}

	public void setUserSecurityQuestions(List<UserSecurityQuestion> userSecurityQuestions) {
		this.userSecurityQuestions = userSecurityQuestions;
	}

	public UserSecurityQuestion addUserSecurityQuestion(UserSecurityQuestion userSecurityQuestion) {
		getUserSecurityQuestions().add(userSecurityQuestion);
		userSecurityQuestion.setUser(this);

		return userSecurityQuestion;
	}

	public UserSecurityQuestion removeUserSecurityQuestion(UserSecurityQuestion userSecurityQuestion) {
		getUserSecurityQuestions().remove(userSecurityQuestion);
		userSecurityQuestion.setUser(null);

		return userSecurityQuestion;
	}

	public List<UserToken> getUserTokens() {
		return this.userTokens;
	}

	public void setUserTokens(List<UserToken> userTokens) {
		this.userTokens = userTokens;
	}

	public UserToken addUserToken(UserToken userToken) {
		getUserTokens().add(userToken);
		userToken.setUser(this);

		return userToken;
	}

	public UserToken removeUserToken(UserToken userToken) {
		getUserTokens().remove(userToken);
		userToken.setUser(null);

		return userToken;
	}

}