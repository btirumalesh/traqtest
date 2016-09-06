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
 * The persistent class for the origin_of_meat database table.
 * 
 */
@Entity
@Table(name="origin_of_meat")
@NamedQuery(name="OriginOfMeat.findAll", query="SELECT o FROM OriginOfMeat o")
public class OriginOfMeat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="origin_of_meat_id")
	private String originOfMeatId;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="origin_statements")
	private String originStatements;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to SupplierSpecification
	@ManyToOne
	@JoinColumn(name="supplier_spec_id")
	private SupplierSpecification supplierSpecification;

	public OriginOfMeat() {
	}

	public String getOriginOfMeatId() {
		return this.originOfMeatId;
	}

	public void setOriginOfMeatId(String originOfMeatId) {
		this.originOfMeatId = originOfMeatId;
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

	public String getOriginStatements() {
		return this.originStatements;
	}

	public void setOriginStatements(String originStatements) {
		this.originStatements = originStatements;
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