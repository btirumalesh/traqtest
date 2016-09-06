package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the job_title database table.
 * 
 */
@Entity
@Table(name="job_title")
@NamedQuery(name="JobTitle.findAll", query="SELECT j FROM JobTitle j")
public class JobTitle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_title_id")
	private Long jobTitleId;

	@Column(name="client_id")
	private Long clientId;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	private String description;

	@Column(name="job_name")
	private String jobName;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to ClientContact
	@OneToMany(mappedBy="jobTitleBean")
	private List<ClientContact> clientContacts;

	//bi-directional many-to-one association to SpContact
	@OneToMany(mappedBy="jobTitleBean")
	private List<SpContact> spContacts;

	//bi-directional many-to-one association to SupplierContact
	@OneToMany(mappedBy="jobTitleBean")
	private List<SupplierContact> supplierContacts;

	//bi-directional many-to-one association to UserDetail
	@OneToMany(mappedBy="jobTitleBean")
	private List<UserDetail> userDetails;

	public JobTitle() {
	}

	public Long getJobTitleId() {
		return this.jobTitleId;
	}

	public void setJobTitleId(Long jobTitleId) {
		this.jobTitleId = jobTitleId;
	}

	public Long getClientId() {
		return this.clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
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

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
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

	public List<ClientContact> getClientContacts() {
		return this.clientContacts;
	}

	public void setClientContacts(List<ClientContact> clientContacts) {
		this.clientContacts = clientContacts;
	}

	public ClientContact addClientContact(ClientContact clientContact) {
		getClientContacts().add(clientContact);
		clientContact.setJobTitleBean(this);

		return clientContact;
	}

	public ClientContact removeClientContact(ClientContact clientContact) {
		getClientContacts().remove(clientContact);
		clientContact.setJobTitleBean(null);

		return clientContact;
	}

	public List<SpContact> getSpContacts() {
		return this.spContacts;
	}

	public void setSpContacts(List<SpContact> spContacts) {
		this.spContacts = spContacts;
	}

	public SpContact addSpContact(SpContact spContact) {
		getSpContacts().add(spContact);
		spContact.setJobTitleBean(this);

		return spContact;
	}

	public SpContact removeSpContact(SpContact spContact) {
		getSpContacts().remove(spContact);
		spContact.setJobTitleBean(null);

		return spContact;
	}

	public List<SupplierContact> getSupplierContacts() {
		return this.supplierContacts;
	}

	public void setSupplierContacts(List<SupplierContact> supplierContacts) {
		this.supplierContacts = supplierContacts;
	}

	public SupplierContact addSupplierContact(SupplierContact supplierContact) {
		getSupplierContacts().add(supplierContact);
		supplierContact.setJobTitleBean(this);

		return supplierContact;
	}

	public SupplierContact removeSupplierContact(SupplierContact supplierContact) {
		getSupplierContacts().remove(supplierContact);
		supplierContact.setJobTitleBean(null);

		return supplierContact;
	}

	public List<UserDetail> getUserDetails() {
		return this.userDetails;
	}

	public void setUserDetails(List<UserDetail> userDetails) {
		this.userDetails = userDetails;
	}

	public UserDetail addUserDetail(UserDetail userDetail) {
		getUserDetails().add(userDetail);
		userDetail.setJobTitleBean(this);

		return userDetail;
	}

	public UserDetail removeUserDetail(UserDetail userDetail) {
		getUserDetails().remove(userDetail);
		userDetail.setJobTitleBean(null);

		return userDetail;
	}

}