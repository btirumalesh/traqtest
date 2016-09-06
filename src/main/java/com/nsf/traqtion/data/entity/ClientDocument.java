package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the client_document database table.
 * 
 */
@Entity
@Table(name="client_document")

@NamedQueries({
    @NamedQuery(name="ClientDocument.findAll", query="SELECT c FROM ClientDocument c"),
    @NamedQuery(name="ClientDocument.findByClientId",
                query="SELECT c FROM ClientDocument c WHERE c.client = :client"),
}) 
public class ClientDocument implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="client_document_id")
	private String clientDocumentId;

	@Column(name="attachment_path")
	private String attachmentPath;

	@Lob
	private byte[] attachments;

	@Column(name="client_document_type_id")
	private Long clientDocumentTypeId;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	private String description;

	@Column(name="document_code")
	private String documentCode;

	@Column(name="document_name")
	private String documentName;

	@Column(name="public_flag")
	private String publicFlag;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to Client
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="client_id")
	private Client client;

	public ClientDocument() {
	}

	public String getClientDocumentId() {
		return this.clientDocumentId;
	}

	public void setClientDocumentId(String clientDocumentId) {
		this.clientDocumentId = clientDocumentId;
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

	public Long getClientDocumentTypeId() {
		return this.clientDocumentTypeId;
	}

	public void setClientDocumentTypeId(Long clientDocumentTypeId) {
		this.clientDocumentTypeId = clientDocumentTypeId;
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

	public String getPublicFlag() {
		return this.publicFlag;
	}

	public void setPublicFlag(String publicFlag) {
		this.publicFlag = publicFlag;
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

}