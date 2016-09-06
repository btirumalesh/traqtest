package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the security_question database table.
 * 
 */
@Entity
@Table(name="security_question")
@NamedQuery(name="SecurityQuestion.findAll", query="SELECT s FROM SecurityQuestion s")
public class SecurityQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="security_question_id")
	private Long securityQuestionId;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="question_code")
	private String questionCode;

	@Column(name="question_name")
	private String questionName;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to UserSecurityQuestion
	@OneToMany(mappedBy="securityQuestion")
	private List<UserSecurityQuestion> userSecurityQuestions;

	public SecurityQuestion() {
	}

	public Long getSecurityQuestionId() {
		return this.securityQuestionId;
	}

	public void setSecurityQuestionId(Long securityQuestionId) {
		this.securityQuestionId = securityQuestionId;
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

	public String getQuestionCode() {
		return this.questionCode;
	}

	public void setQuestionCode(String questionCode) {
		this.questionCode = questionCode;
	}

	public String getQuestionName() {
		return this.questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
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

	public List<UserSecurityQuestion> getUserSecurityQuestions() {
		return this.userSecurityQuestions;
	}

	public void setUserSecurityQuestions(List<UserSecurityQuestion> userSecurityQuestions) {
		this.userSecurityQuestions = userSecurityQuestions;
	}

	public UserSecurityQuestion addUserSecurityQuestion(UserSecurityQuestion userSecurityQuestion) {
		getUserSecurityQuestions().add(userSecurityQuestion);
		userSecurityQuestion.setSecurityQuestion(this);

		return userSecurityQuestion;
	}

	public UserSecurityQuestion removeUserSecurityQuestion(UserSecurityQuestion userSecurityQuestion) {
		getUserSecurityQuestions().remove(userSecurityQuestion);
		userSecurityQuestion.setSecurityQuestion(null);

		return userSecurityQuestion;
	}

}