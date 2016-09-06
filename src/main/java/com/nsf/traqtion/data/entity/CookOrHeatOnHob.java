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
 * The persistent class for the cook_or_heat_on_hob database table.
 * 
 */
@Entity
@Table(name="cook_or_heat_on_hob")
@NamedQuery(name="CookOrHeatOnHob.findAll", query="SELECT c FROM CookOrHeatOnHob c")
public class CookOrHeatOnHob implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cook_or_heat_on_hob_id")
	private String cookOrHeatOnHobId;

	@Column(name="cook_or_heat_hob")
	private String cookOrHeatHob;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="hob_tempurature")
	private String hobTempurature;

	@Column(name="hob_time")
	private String hobTime;

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

	public CookOrHeatOnHob() {
	}

	public String getCookOrHeatOnHobId() {
		return this.cookOrHeatOnHobId;
	}

	public void setCookOrHeatOnHobId(String cookOrHeatOnHobId) {
		this.cookOrHeatOnHobId = cookOrHeatOnHobId;
	}

	public String getCookOrHeatHob() {
		return this.cookOrHeatHob;
	}

	public void setCookOrHeatHob(String cookOrHeatHob) {
		this.cookOrHeatHob = cookOrHeatHob;
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

	public String getHobTempurature() {
		return this.hobTempurature;
	}

	public void setHobTempurature(String hobTempurature) {
		this.hobTempurature = hobTempurature;
	}

	public String getHobTime() {
		return this.hobTime;
	}

	public void setHobTime(String hobTime) {
		this.hobTime = hobTime;
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