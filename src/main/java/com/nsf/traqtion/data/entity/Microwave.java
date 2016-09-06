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
 * The persistent class for the microwave database table.
 * 
 */
@Entity
@Table(name="microwave")
@NamedQuery(name="Microwave.findAll", query="SELECT m FROM Microwave m")
public class Microwave implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="microwave_id")
	private String microwaveId;

	@Column(name="additional_stmt")
	private String additionalStmt;

	@Column(name="chilled_catd_750w")
	private String chilledCatd750w;

	@Column(name="chilled_catd_850w")
	private String chilledCatd850w;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="frozen_catd_750w")
	private String frozenCatd750w;

	@Column(name="frozen_catd_850w")
	private String frozenCatd850w;

	@Column(name="micro_select")
	private String microSelect;

	@Column(name="micro_stmt")
	private String microStmt;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to SupplierSpecification
	@ManyToOne
	@JoinColumn(name="supplier_spec_id")
	private SupplierSpecification supplierSpecification;

	public Microwave() {
	}

	public String getMicrowaveId() {
		return this.microwaveId;
	}

	public void setMicrowaveId(String microwaveId) {
		this.microwaveId = microwaveId;
	}

	public String getAdditionalStmt() {
		return this.additionalStmt;
	}

	public void setAdditionalStmt(String additionalStmt) {
		this.additionalStmt = additionalStmt;
	}

	public String getChilledCatd750w() {
		return this.chilledCatd750w;
	}

	public void setChilledCatd750w(String chilledCatd750w) {
		this.chilledCatd750w = chilledCatd750w;
	}

	public String getChilledCatd850w() {
		return this.chilledCatd850w;
	}

	public void setChilledCatd850w(String chilledCatd850w) {
		this.chilledCatd850w = chilledCatd850w;
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

	public String getFrozenCatd750w() {
		return this.frozenCatd750w;
	}

	public void setFrozenCatd750w(String frozenCatd750w) {
		this.frozenCatd750w = frozenCatd750w;
	}

	public String getFrozenCatd850w() {
		return this.frozenCatd850w;
	}

	public void setFrozenCatd850w(String frozenCatd850w) {
		this.frozenCatd850w = frozenCatd850w;
	}

	public String getMicroSelect() {
		return this.microSelect;
	}

	public void setMicroSelect(String microSelect) {
		this.microSelect = microSelect;
	}

	public String getMicroStmt() {
		return this.microStmt;
	}

	public void setMicroStmt(String microStmt) {
		this.microStmt = microStmt;
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