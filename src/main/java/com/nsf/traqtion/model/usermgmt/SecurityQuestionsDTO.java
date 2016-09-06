package com.nsf.traqtion.model.usermgmt;

public class SecurityQuestionsDTO {

	private Long securityQuestionId;
	private String questionCode;
	private String question;
	public Long getSecurityQuestionId() {
		return securityQuestionId;
	}
	public void setSecurityQuestionId(Long securityQuestionId) {
		this.securityQuestionId = securityQuestionId;
	}
	public String getQuestionCode() {
		return questionCode;
	}
	public void setQuestionCode(String questionCode) {
		this.questionCode = questionCode;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	
	
}