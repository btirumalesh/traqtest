package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the terms_conditions database table.
 * 
 */
@Entity
@Table(name="terms_conditions")
@NamedQuery(name="TermsCondition.findAll", query="SELECT t FROM TermsCondition t")
public class TermsCondition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="terms_conditions_id")
	private String termsConditionsId;

	@Column(name="client_terms_cond_ind")
	private String clientTermsCondInd;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="delete_indentifier")
	private String deleteIndentifier;

	private String description;

	@Column(name="end_date")
	private Timestamp endDate;

	@Column(name="start_date")
	private Timestamp startDate;

	@Column(name="traqtion_terms_cond_ind")
	private String traqtionTermsCondInd;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	public TermsCondition() {
	}

	public String getTermsConditionsId() {
		return this.termsConditionsId;
	}

	public void setTermsConditionsId(String termsConditionsId) {
		this.termsConditionsId = termsConditionsId;
	}

	public String getClientTermsCondInd() {
		return this.clientTermsCondInd;
	}

	public void setClientTermsCondInd(String clientTermsCondInd) {
		this.clientTermsCondInd = clientTermsCondInd;
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

	public String getDeleteIndentifier() {
		return this.deleteIndentifier;
	}

	public void setDeleteIndentifier(String deleteIndentifier) {
		this.deleteIndentifier = deleteIndentifier;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public String getTraqtionTermsCondInd() {
		return this.traqtionTermsCondInd;
	}

	public void setTraqtionTermsCondInd(String traqtionTermsCondInd) {
		this.traqtionTermsCondInd = traqtionTermsCondInd;
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

}