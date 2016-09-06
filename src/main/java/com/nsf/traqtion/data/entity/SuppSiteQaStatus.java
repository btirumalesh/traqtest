package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the supp_site_qa_status database table.
 * 
 */
@Entity
@Table(name="supp_site_qa_status")
@NamedQuery(name="SuppSiteQaStatus.findAll", query="SELECT s FROM SuppSiteQaStatus s")
public class SuppSiteQaStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="supp_site_qa_status_id")
	private String suppSiteQaStatusId;

	@Column(name="audit_status_flag")
	private String auditStatusFlag;

	private String comments;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="date_passed")
	private Timestamp datePassed;

	@Column(name="expiry_date")
	private Timestamp expiryDate;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to TrqMasterValue
	@ManyToOne
	@JoinColumn(name="trq_master_values_id")
	private TrqMasterValue trqMasterValue;

	//bi-directional many-to-one association to SupplierSite
	@ManyToOne
	@JoinColumn(name="supplier_sites_id")
	private SupplierSite supplierSite;

	public SuppSiteQaStatus() {
	}

	public String getSuppSiteQaStatusId() {
		return this.suppSiteQaStatusId;
	}

	public void setSuppSiteQaStatusId(String suppSiteQaStatusId) {
		this.suppSiteQaStatusId = suppSiteQaStatusId;
	}

	public String getAuditStatusFlag() {
		return this.auditStatusFlag;
	}

	public void setAuditStatusFlag(String auditStatusFlag) {
		this.auditStatusFlag = auditStatusFlag;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	public Timestamp getDatePassed() {
		return this.datePassed;
	}

	public void setDatePassed(Timestamp datePassed) {
		this.datePassed = datePassed;
	}

	public Timestamp getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
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

	public TrqMasterValue getTrqMasterValue() {
		return this.trqMasterValue;
	}

	public void setTrqMasterValue(TrqMasterValue trqMasterValue) {
		this.trqMasterValue = trqMasterValue;
	}

	public SupplierSite getSupplierSite() {
		return this.supplierSite;
	}

	public void setSupplierSite(SupplierSite supplierSite) {
		this.supplierSite = supplierSite;
	}

}