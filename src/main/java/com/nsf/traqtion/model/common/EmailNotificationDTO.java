package com.nsf.traqtion.model.common;

import java.util.List;

public class EmailNotificationDTO {

	public Long templateId;
	public String templateName;
	public String subject;
	public String emailContent;
	public List<String> toRecipientsList;
	public List<String> ccRecipientsList;
	
	
}
