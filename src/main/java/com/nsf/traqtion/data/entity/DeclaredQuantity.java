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
 * The persistent class for the declared_quantity database table.
 * 
 */
@Entity
@Table(name="declared_quantity")
@NamedQuery(name="DeclaredQuantity.findAll", query="SELECT d FROM DeclaredQuantity d")
public class DeclaredQuantity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="declared_quanity_id")
	private String declaredQuanityId;

	@Column(name="abv_percent")
	private Long abvPercent;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="declared_quantity")
	private Long declaredQuantity;

	@Column(name="declared_units")
	private String declaredUnits;

	@Column(name="drained_weight")
	private Long drainedWeight;

	@Column(name="quantity_system")
	private Long quantitySystem;

	@Column(name="subject_to_priscribed_weight")
	private Long subjectToPriscribedWeight;

	private Long t1;

	private Long t2;

	@Column(name="target_quantity")
	private Long targetQuantity;

	@Column(name="target_units")
	private String targetUnits;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to SupplierSpecification
	@ManyToOne
	@JoinColumn(name="supplier_spec_id")
	private SupplierSpecification supplierSpecification;

	public DeclaredQuantity() {
	}

	public String getDeclaredQuanityId() {
		return this.declaredQuanityId;
	}

	public void setDeclaredQuanityId(String declaredQuanityId) {
		this.declaredQuanityId = declaredQuanityId;
	}

	public Long getAbvPercent() {
		return this.abvPercent;
	}

	public void setAbvPercent(Long abvPercent) {
		this.abvPercent = abvPercent;
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

	public Long getDeclaredQuantity() {
		return this.declaredQuantity;
	}

	public void setDeclaredQuantity(Long declaredQuantity) {
		this.declaredQuantity = declaredQuantity;
	}

	public String getDeclaredUnits() {
		return this.declaredUnits;
	}

	public void setDeclaredUnits(String declaredUnits) {
		this.declaredUnits = declaredUnits;
	}

	public Long getDrainedWeight() {
		return this.drainedWeight;
	}

	public void setDrainedWeight(Long drainedWeight) {
		this.drainedWeight = drainedWeight;
	}

	public Long getQuantitySystem() {
		return this.quantitySystem;
	}

	public void setQuantitySystem(Long quantitySystem) {
		this.quantitySystem = quantitySystem;
	}

	public Long getSubjectToPriscribedWeight() {
		return this.subjectToPriscribedWeight;
	}

	public void setSubjectToPriscribedWeight(Long subjectToPriscribedWeight) {
		this.subjectToPriscribedWeight = subjectToPriscribedWeight;
	}

	public Long getT1() {
		return this.t1;
	}

	public void setT1(Long t1) {
		this.t1 = t1;
	}

	public Long getT2() {
		return this.t2;
	}

	public void setT2(Long t2) {
		this.t2 = t2;
	}

	public Long getTargetQuantity() {
		return this.targetQuantity;
	}

	public void setTargetQuantity(Long targetQuantity) {
		this.targetQuantity = targetQuantity;
	}

	public String getTargetUnits() {
		return this.targetUnits;
	}

	public void setTargetUnits(String targetUnits) {
		this.targetUnits = targetUnits;
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