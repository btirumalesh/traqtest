package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the client_email_template database table.
 * 
 */
@Entity
@Table(name="client_email_template")
@NamedQuery(name="ClientEmailTemplate.findAll", query="SELECT c FROM ClientEmailTemplate c")
public class ClientEmailTemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="client_email_template_id")
	private String clientEmailTemplateId;

	@Column(name="attachment_name")
	private String attachmentName;

	@Lob
	@Column(name="body_text")
	private byte[] bodyText;

	private String code;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	private String description;

	@Column(name="email_cc")
	private String emailCc;

	@Column(name="email_from")
	private String emailFrom;

	@Column(name="email_to")
	private String emailTo;

	@Column(name="mail_type")
	private String mailType;

	private String name;

	@Column(name="need_attachment")
	private String needAttachment;

	@Column(name="reply_to")
	private String replyTo;

	private String signature;

	private String subject;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	//bi-directional many-to-one association to ClientSiteNotification
/*	@OneToMany(mappedBy="clientEmailTemplate")
	private List<ClientSiteNotification> clientSiteNotifications;
*/
	public ClientEmailTemplate() {
	}

	public String getClientEmailTemplateId() {
		return this.clientEmailTemplateId;
	}

	public void setClientEmailTemplateId(String clientEmailTemplateId) {
		this.clientEmailTemplateId = clientEmailTemplateId;
	}

	public String getAttachmentName() {
		return this.attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public byte[] getBodyText() {
		return this.bodyText;
	}

	public void setBodyText(byte[] bodyText) {
		this.bodyText = bodyText;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmailCc() {
		return this.emailCc;
	}

	public void setEmailCc(String emailCc) {
		this.emailCc = emailCc;
	}

	public String getEmailFrom() {
		return this.emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public String getEmailTo() {
		return this.emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getMailType() {
		return this.mailType;
	}

	public void setMailType(String mailType) {
		this.mailType = mailType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNeedAttachment() {
		return this.needAttachment;
	}

	public void setNeedAttachment(String needAttachment) {
		this.needAttachment = needAttachment;
	}

	public String getReplyTo() {
		return this.replyTo;
	}

	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	public String getSignature() {
		return this.signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
/*
	public List<ClientSiteNotification> getClientSiteNotifications() {
		return this.clientSiteNotifications;
	}

	public void setClientSiteNotifications(List<ClientSiteNotification> clientSiteNotifications) {
		this.clientSiteNotifications = clientSiteNotifications;
	}

	public ClientSiteNotification addClientSiteNotification(ClientSiteNotification clientSiteNotification) {
		getClientSiteNotifications().add(clientSiteNotification);
		clientSiteNotification.setClientEmailTemplate(this);

		return clientSiteNotification;
	}

	public ClientSiteNotification removeClientSiteNotification(ClientSiteNotification clientSiteNotification) {
		getClientSiteNotifications().remove(clientSiteNotification);
		clientSiteNotification.setClientEmailTemplate(null);

		return clientSiteNotification;
	}*/

}