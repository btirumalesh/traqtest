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
 * The persistent class for the supp_site_othr_cert database table.
 * 
 */
@Entity
@Table(name="supp_site_othr_cert")
@NamedQuery(name="SuppSiteOthrCert.findAll", query="SELECT s FROM SuppSiteOthrCert s")
public class SuppSiteOthrCert implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="supplier_othr_cert_id")
	private String supplierOthrCertId;

	@Column(name="certificate_no")
	private String certificateNo;

	private String comments;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="date_certified")
	private Timestamp dateCertified;

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

	public SuppSiteOthrCert() {
	}

	public String getSupplierOthrCertId() {
		return this.supplierOthrCertId;
	}

	public void setSupplierOthrCertId(String supplierOthrCertId) {
		this.supplierOthrCertId = supplierOthrCertId;
	}

	public String getCertificateNo() {
		return this.certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
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

	public Timestamp getDateCertified() {
		return this.dateCertified;
	}

	public void setDateCertified(Timestamp dateCertified) {
		this.dateCertified = dateCertified;
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