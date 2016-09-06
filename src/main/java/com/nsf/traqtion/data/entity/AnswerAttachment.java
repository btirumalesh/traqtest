package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the answer_attachment database table.
 * 
 */
@Entity
@Table(name="answer_attachment")
@NamedQuery(name="AnswerAttachment.findAll", query="SELECT a FROM AnswerAttachment a")
public class AnswerAttachment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="answer_attachment_id")
	private String answerAttachmentId;

	@Column(name="attachment_path")
	private String attachmentPath;

	@Lob
	private byte[] attachments;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	private String description;

	@Column(name="document_code")
	private String documentCode;

	@Column(name="document_name")
	private String documentName;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to RegistrationAnswer
	@ManyToOne
	@JoinColumn(name="registration_answers_id")
	private RegistrationAnswer registrationAnswer;

	public AnswerAttachment() {
	}

	public String getAnswerAttachmentId() {
		return this.answerAttachmentId;
	}

	public void setAnswerAttachmentId(String answerAttachmentId) {
		this.answerAttachmentId = answerAttachmentId;
	}

	public String getAttachmentPath() {
		return this.attachmentPath;
	}

	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}

	public byte[] getAttachments() {
		return this.attachments;
	}

	public void setAttachments(byte[] attachments) {
		this.attachments = attachments;
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

	public String getDocumentCode() {
		return this.documentCode;
	}

	public void setDocumentCode(String documentCode) {
		this.documentCode = documentCode;
	}

	public String getDocumentName() {
		return this.documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
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

	public RegistrationAnswer getRegistrationAnswer() {
		return this.registrationAnswer;
	}

	public void setRegistrationAnswer(RegistrationAnswer registrationAnswer) {
		this.registrationAnswer = registrationAnswer;
	}

}