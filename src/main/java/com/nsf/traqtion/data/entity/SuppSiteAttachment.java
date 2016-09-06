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
 * The persistent class for the supp_site_attachment database table.
 * 
 */
@Entity
@Table(name="supp_site_attachment")
@NamedQuery(name="SuppSiteAttachment.findAll", query="SELECT s FROM SuppSiteAttachment s")
public class SuppSiteAttachment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="supp_site_attachment_id")
	private String suppSiteAttachmentId;

	@Column(name="attachment_path")
	private String attachmentPath;

	@Lob
	private byte[] attachments;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	private String description;

	@Column(name="document_name")
	private String documentName;

	@Column(name="entity_id")
	private Long entityId;

	@Column(name="entity_name")
	private Long entityName;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	@Column(name="valid_from")
	private Timestamp validFrom;

	@Column(name="valid_to")
	private Timestamp validTo;

	//bi-directional many-to-one association to SupplierSite
	@ManyToOne
	@JoinColumn(name="supplier_sites_id")
	private SupplierSite supplierSite;

	public SuppSiteAttachment() {
	}

	public String getSuppSiteAttachmentId() {
		return this.suppSiteAttachmentId;
	}

	public void setSuppSiteAttachmentId(String suppSiteAttachmentId) {
		this.suppSiteAttachmentId = suppSiteAttachmentId;
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

	public String getDocumentName() {
		return this.documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public Long getEntityId() {
		return this.entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	public Long getEntityName() {
		return this.entityName;
	}

	public void setEntityName(Long entityName) {
		this.entityName = entityName;
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

	public Timestamp getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Timestamp validFrom) {
		this.validFrom = validFrom;
	}

	public Timestamp getValidTo() {
		return this.validTo;
	}

	public void setValidTo(Timestamp validTo) {
		this.validTo = validTo;
	}

	public SupplierSite getSupplierSite() {
		return this.supplierSite;
	}

	public void setSupplierSite(SupplierSite supplierSite) {
		this.supplierSite = supplierSite;
	}

}