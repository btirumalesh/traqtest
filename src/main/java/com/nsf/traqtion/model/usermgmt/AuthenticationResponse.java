package com.nsf.traqtion.model.usermgmt;

import java.util.List;

public class AuthenticationResponse {

	public String accessToken;
	public UserDetailsDTO userDetails;
	public Boolean hasMultipleProfiles = false;
	public List<UserMappingDTO> userMappingList;
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public UserDetailsDTO getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetailsDTO userDetails) {
		this.userDetails = userDetails;
	}
	public Boolean getHasMultipleProfiles() {
		return hasMultipleProfiles;
	}
	public void setHasMultipleProfiles(Boolean hasMultipleProfiles) {
		this.hasMultipleProfiles = hasMultipleProfiles;
	}
	public List<UserMappingDTO> getUserMappingList() {
		return userMappingList;
	}
	public void setUserMappingList(List<UserMappingDTO> userMappingList) {
		this.userMappingList = userMappingList;
	}
	
	
}