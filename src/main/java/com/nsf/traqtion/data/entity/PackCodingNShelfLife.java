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
 * The persistent class for the pack_coding_n_shelf_life database table.
 * 
 */
@Entity
@Table(name="pack_coding_n_shelf_life")
@NamedQuery(name="PackCodingNShelfLife.findAll", query="SELECT p FROM PackCodingNShelfLife p")
public class PackCodingNShelfLife implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="coding_shell_id")
	private String codingShellId;

	private String comments;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="date_formate")
	private Timestamp dateFormate;

	@Column(name="display_unit")
	private String displayUnit;

	@Column(name="have_shelf_life_compleded_units")
	private String haveShelfLifeComplededUnits;

	@Column(name="have_shelf_life_compleded_value")
	private Long haveShelfLifeComplededValue;

	@Column(name="shelf_life_once_defrosted_units")
	private String shelfLifeOnceDefrostedUnits;

	@Column(name="shelf_life_once_defrosted_value")
	private Long shelfLifeOnceDefrostedValue;

	@Column(name="shelf_life_once_open_units")
	private Long shelfLifeOnceOpenUnits;

	@Column(name="shelf_life_once_open_value")
	private String shelfLifeOnceOpenValue;

	@Column(name="shelf_life_units")
	private String shelfLifeUnits;

	@Column(name="shelf_life_value")
	private Long shelfLifeValue;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	@Column(name="used_by_best_before")
	private String usedByBestBefore;

	//bi-directional many-to-one association to SupplierSpecification
	@ManyToOne
	@JoinColumn(name="supplier_spec_id")
	private SupplierSpecification supplierSpecification;

	public PackCodingNShelfLife() {
	}

	public String getCodingShellId() {
		return this.codingShellId;
	}

	public void setCodingShellId(String codingShellId) {
		this.codingShellId = codingShellId;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	public Timestamp getDateFormate() {
		return this.dateFormate;
	}

	public void setDateFormate(Timestamp dateFormate) {
		this.dateFormate = dateFormate;
	}

	public String getDisplayUnit() {
		return this.displayUnit;
	}

	public void setDisplayUnit(String displayUnit) {
		this.displayUnit = displayUnit;
	}

	public String getHaveShelfLifeComplededUnits() {
		return this.haveShelfLifeComplededUnits;
	}

	public void setHaveShelfLifeComplededUnits(String haveShelfLifeComplededUnits) {
		this.haveShelfLifeComplededUnits = haveShelfLifeComplededUnits;
	}

	public Long getHaveShelfLifeComplededValue() {
		return this.haveShelfLifeComplededValue;
	}

	public void setHaveShelfLifeComplededValue(Long haveShelfLifeComplededValue) {
		this.haveShelfLifeComplededValue = haveShelfLifeComplededValue;
	}

	public String getShelfLifeOnceDefrostedUnits() {
		return this.shelfLifeOnceDefrostedUnits;
	}

	public void setShelfLifeOnceDefrostedUnits(String shelfLifeOnceDefrostedUnits) {
		this.shelfLifeOnceDefrostedUnits = shelfLifeOnceDefrostedUnits;
	}

	public Long getShelfLifeOnceDefrostedValue() {
		return this.shelfLifeOnceDefrostedValue;
	}

	public void setShelfLifeOnceDefrostedValue(Long shelfLifeOnceDefrostedValue) {
		this.shelfLifeOnceDefrostedValue = shelfLifeOnceDefrostedValue;
	}

	public Long getShelfLifeOnceOpenUnits() {
		return this.shelfLifeOnceOpenUnits;
	}

	public void setShelfLifeOnceOpenUnits(Long shelfLifeOnceOpenUnits) {
		this.shelfLifeOnceOpenUnits = shelfLifeOnceOpenUnits;
	}

	public String getShelfLifeOnceOpenValue() {
		return this.shelfLifeOnceOpenValue;
	}

	public void setShelfLifeOnceOpenValue(String shelfLifeOnceOpenValue) {
		this.shelfLifeOnceOpenValue = shelfLifeOnceOpenValue;
	}

	public String getShelfLifeUnits() {
		return this.shelfLifeUnits;
	}

	public void setShelfLifeUnits(String shelfLifeUnits) {
		this.shelfLifeUnits = shelfLifeUnits;
	}

	public Long getShelfLifeValue() {
		return this.shelfLifeValue;
	}

	public void setShelfLifeValue(Long shelfLifeValue) {
		this.shelfLifeValue = shelfLifeValue;
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

	public String getUsedByBestBefore() {
		return this.usedByBestBefore;
	}

	public void setUsedByBestBefore(String usedByBestBefore) {
		this.usedByBestBefore = usedByBestBefore;
	}

	public SupplierSpecification getSupplierSpecification() {
		return this.supplierSpecification;
	}

	public void setSupplierSpecification(SupplierSpecification supplierSpecification) {
		this.supplierSpecification = supplierSpecification;
	}

}