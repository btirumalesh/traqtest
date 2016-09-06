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
 * The persistent class for the frying database table.
 * 
 */
@Entity
@Table(name="frying")
@NamedQuery(name="Frying.findAll", query="SELECT f FROM Frying f")
public class Frying implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="frying_id")
	private String fryingId;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="fry_tempurature")
	private String fryTempurature;

	@Column(name="fry_time")
	private String fryTime;

	@Column(name="pan_shallow_stir_fry")
	private String panShallowStirFry;

	@Column(name="statment_option")
	private String statmentOption;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to SupplierSpecification
	@ManyToOne
	@JoinColumn(name="supplier_spec_id")
	private SupplierSpecification supplierSpecification;

	public Frying() {
	}

	public String getFryingId() {
		return this.fryingId;
	}

	public void setFryingId(String fryingId) {
		this.fryingId = fryingId;
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

	public String getFryTempurature() {
		return this.fryTempurature;
	}

	public void setFryTempurature(String fryTempurature) {
		this.fryTempurature = fryTempurature;
	}

	public String getFryTime() {
		return this.fryTime;
	}

	public void setFryTime(String fryTime) {
		this.fryTime = fryTime;
	}

	public String getPanShallowStirFry() {
		return this.panShallowStirFry;
	}

	public void setPanShallowStirFry(String panShallowStirFry) {
		this.panShallowStirFry = panShallowStirFry;
	}

	public String getStatmentOption() {
		return this.statmentOption;
	}

	public void setStatmentOption(String statmentOption) {
		this.statmentOption = statmentOption;
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

	public SupplierSpecification getSupplierSpecification() {
		return this.supplierSpecification;
	}

	public void setSupplierSpecification(SupplierSpecification supplierSpecification) {
		this.supplierSpecification = supplierSpecification;
	}

}