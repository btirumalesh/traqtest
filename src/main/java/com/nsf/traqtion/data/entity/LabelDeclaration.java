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
 * The persistent class for the label_declaration database table.
 * 
 */
@Entity
@Table(name="label_declaration")
@NamedQuery(name="LabelDeclaration.findAll", query="SELECT l FROM LabelDeclaration l")
public class LabelDeclaration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="label_declaration_id")
	private String labelDeclarationId;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="final_declaration")
	private String finalDeclaration;

	@Column(name="meat_content")
	private String meatContent;

	@Column(name="system_generated")
	private String systemGenerated;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to SupplierSpecification
	@ManyToOne
	@JoinColumn(name="supplier_spec_id")
	private SupplierSpecification supplierSpecification;

	public LabelDeclaration() {
	}

	public String getLabelDeclarationId() {
		return this.labelDeclarationId;
	}

	public void setLabelDeclarationId(String labelDeclarationId) {
		this.labelDeclarationId = labelDeclarationId;
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

	public String getFinalDeclaration() {
		return this.finalDeclaration;
	}

	public void setFinalDeclaration(String finalDeclaration) {
		this.finalDeclaration = finalDeclaration;
	}

	public String getMeatContent() {
		return this.meatContent;
	}

	public void setMeatContent(String meatContent) {
		this.meatContent = meatContent;
	}

	public String getSystemGenerated() {
		return this.systemGenerated;
	}

	public void setSystemGenerated(String systemGenerated) {
		this.systemGenerated = systemGenerated;
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