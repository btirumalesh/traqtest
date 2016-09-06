package com.nsf.traqtion.model.usermgmt;

import java.util.List;

public class UserSecurityDetailsDTO {
	
	private String token;
	private String currentPassword;
	private String newPassword;
	private List<UserSecurityQuestionAnswerDTO> securityQuestionAnswerList;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getCurrentPassword() {
		return currentPassword;
	}
	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public List<UserSecurityQuestionAnswerDTO> getSecurityQuestionAnswerList() {
		return securityQuestionAnswerList;
	}
	public void setSecurityQuestionAnswerList(List<UserSecurityQuestionAnswerDTO> securityQuestionAnswerList) {
		this.securityQuestionAnswerList = securityQuestionAnswerList;
	}
	
	
	

}