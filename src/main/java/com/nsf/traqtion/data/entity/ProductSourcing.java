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
 * The persistent class for the product_sourcing database table.
 * 
 */
@Entity
@Table(name="product_sourcing")
@NamedQuery(name="ProductSourcing.findAll", query="SELECT p FROM ProductSourcing p")
public class ProductSourcing implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_sourcing")
	private String productSourcing;

	@Column(name="countree_origin_statement")
	private String countreeOriginStatement;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="product_sourcing_statement")
	private String productSourcingStatement;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to SupplierSpecification
	@ManyToOne
	@JoinColumn(name="supplier_spec_id")
	private SupplierSpecification supplierSpecification;

	public ProductSourcing() {
	}

	public String getProductSourcing() {
		return this.productSourcing;
	}

	public void setProductSourcing(String productSourcing) {
		this.productSourcing = productSourcing;
	}

	public String getCountreeOriginStatement() {
		return this.countreeOriginStatement;
	}

	public void setCountreeOriginStatement(String countreeOriginStatement) {
		this.countreeOriginStatement = countreeOriginStatement;
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

	public String getProductSourcingStatement() {
		return this.productSourcingStatement;
	}

	public void setProductSourcingStatement(String productSourcingStatement) {
		this.productSourcingStatement = productSourcingStatement;
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