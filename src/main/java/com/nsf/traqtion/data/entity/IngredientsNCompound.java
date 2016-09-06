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
 * The persistent class for the ingredients_n_compounds database table.
 * 
 */
@Entity
@Table(name="ingredients_n_compounds")
@NamedQuery(name="IngredientsNCompound.findAll", query="SELECT i FROM IngredientsNCompound i")
public class IngredientsNCompound implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ingredients_n_compounds_id")
	private String ingredientsNCompoundsId;

	@Column(name="alternative_name")
	private String alternativeName;

	@Column(name="countries_of_manuf")
	private String countriesOfManuf;

	@Column(name="countries_of_origin")
	private String countriesOfOrigin;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="element_type")
	private String elementType;

	@Column(name="grade_specification")
	private String gradeSpecification;

	@Column(name="item_description")
	private String itemDescription;

	@Column(name="provenance_required")
	private String provenanceRequired;

	@Column(name="supplier_address")
	private String supplierAddress;

	@Column(name="supplier_name")
	private String supplierName;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to SupplierSpecification
	@ManyToOne
	@JoinColumn(name="supplier_spec_id")
	private SupplierSpecification supplierSpecification;

	public IngredientsNCompound() {
	}

	public String getIngredientsNCompoundsId() {
		return this.ingredientsNCompoundsId;
	}

	public void setIngredientsNCompoundsId(String ingredientsNCompoundsId) {
		this.ingredientsNCompoundsId = ingredientsNCompoundsId;
	}

	public String getAlternativeName() {
		return this.alternativeName;
	}

	public void setAlternativeName(String alternativeName) {
		this.alternativeName = alternativeName;
	}

	public String getCountriesOfManuf() {
		return this.countriesOfManuf;
	}

	public void setCountriesOfManuf(String countriesOfManuf) {
		this.countriesOfManuf = countriesOfManuf;
	}

	public String getCountriesOfOrigin() {
		return this.countriesOfOrigin;
	}

	public void setCountriesOfOrigin(String countriesOfOrigin) {
		this.countriesOfOrigin = countriesOfOrigin;
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

	public String getElementType() {
		return this.elementType;
	}

	public void setElementType(String elementType) {
		this.elementType = elementType;
	}

	public String getGradeSpecification() {
		return this.gradeSpecification;
	}

	public void setGradeSpecification(String gradeSpecification) {
		this.gradeSpecification = gradeSpecification;
	}

	public String getItemDescription() {
		return this.itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getProvenanceRequired() {
		return this.provenanceRequired;
	}

	public void setProvenanceRequired(String provenanceRequired) {
		this.provenanceRequired = provenanceRequired;
	}

	public String getSupplierAddress() {
		return this.supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public String getSupplierName() {
		return this.supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
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