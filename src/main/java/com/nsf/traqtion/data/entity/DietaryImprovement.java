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
 * The persistent class for the dietary_improvements database table.
 * 
 */
@Entity
@Table(name="dietary_improvements")
@NamedQuery(name="DietaryImprovement.findAll", query="SELECT d FROM DietaryImprovement d")
public class DietaryImprovement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dietary_improvements_id")
	private String dietaryImprovementsId;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	private String fat;

	@Column(name="monosodium_glutamate")
	private String monosodiumGlutamate;

	private String salt;

	@Column(name="saturated_fat")
	private String saturatedFat;

	private String sugar;

	@Column(name="tirans_fatty_acids")
	private String tiransFattyAcids;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to SupplierSpecification
	@ManyToOne
	@JoinColumn(name="supplier_spec_id")
	private SupplierSpecification supplierSpecification;

	public DietaryImprovement() {
	}

	public String getDietaryImprovementsId() {
		return this.dietaryImprovementsId;
	}

	public void setDietaryImprovementsId(String dietaryImprovementsId) {
		this.dietaryImprovementsId = dietaryImprovementsId;
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

	public String getFat() {
		return this.fat;
	}

	public void setFat(String fat) {
		this.fat = fat;
	}

	public String getMonosodiumGlutamate() {
		return this.monosodiumGlutamate;
	}

	public void setMonosodiumGlutamate(String monosodiumGlutamate) {
		this.monosodiumGlutamate = monosodiumGlutamate;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getSaturatedFat() {
		return this.saturatedFat;
	}

	public void setSaturatedFat(String saturatedFat) {
		this.saturatedFat = saturatedFat;
	}

	public String getSugar() {
		return this.sugar;
	}

	public void setSugar(String sugar) {
		this.sugar = sugar;
	}

	public String getTiransFattyAcids() {
		return this.tiransFattyAcids;
	}

	public void setTiransFattyAcids(String tiransFattyAcids) {
		this.tiransFattyAcids = tiransFattyAcids;
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