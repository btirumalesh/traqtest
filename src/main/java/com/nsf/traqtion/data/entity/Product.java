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
 * The persistent class for the product database table.
 * 
 */
@Entity
@Table(name="product")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private String productId;

	private String action;

	@Column(name="actual_launch_date")
	private Timestamp actualLaunchDate;

	private String brand;

	private String category;

	private String code;

	@Column(name="code_name")
	private String codeName;

	private String comment;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	private String event;

	@Column(name="first_production_date")
	private Timestamp firstProductionDate;

	@Column(name="national_brand_target")
	private String nationalBrandTarget;

	@Column(name="product_legal_name")
	private String productLegalName;

	@Column(name="product_range_name")
	private String productRangeName;

	@Column(name="secondary_title")
	private String secondaryTitle;

	@Column(name="set_product_availability")
	private String setProductAvailability;

	@Column(name="sub_brand")
	private String subBrand;

	@Column(name="target_launch_date")
	private Timestamp targetLaunchDate;

	private String title;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	public Product() {
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Timestamp getActualLaunchDate() {
		return this.actualLaunchDate;
	}

	public void setActualLaunchDate(Timestamp actualLaunchDate) {
		this.actualLaunchDate = actualLaunchDate;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeName() {
		return this.codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public String getEvent() {
		return this.event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Timestamp getFirstProductionDate() {
		return this.firstProductionDate;
	}

	public void setFirstProductionDate(Timestamp firstProductionDate) {
		this.firstProductionDate = firstProductionDate;
	}

	public String getNationalBrandTarget() {
		return this.nationalBrandTarget;
	}

	public void setNationalBrandTarget(String nationalBrandTarget) {
		this.nationalBrandTarget = nationalBrandTarget;
	}

	public String getProductLegalName() {
		return this.productLegalName;
	}

	public void setProductLegalName(String productLegalName) {
		this.productLegalName = productLegalName;
	}

	public String getProductRangeName() {
		return this.productRangeName;
	}

	public void setProductRangeName(String productRangeName) {
		this.productRangeName = productRangeName;
	}

	public String getSecondaryTitle() {
		return this.secondaryTitle;
	}

	public void setSecondaryTitle(String secondaryTitle) {
		this.secondaryTitle = secondaryTitle;
	}

	public String getSetProductAvailability() {
		return this.setProductAvailability;
	}

	public void setSetProductAvailability(String setProductAvailability) {
		this.setProductAvailability = setProductAvailability;
	}

	public String getSubBrand() {
		return this.subBrand;
	}

	public void setSubBrand(String subBrand) {
		this.subBrand = subBrand;
	}

	public Timestamp getTargetLaunchDate() {
		return this.targetLaunchDate;
	}

	public void setTargetLaunchDate(Timestamp targetLaunchDate) {
		this.targetLaunchDate = targetLaunchDate;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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