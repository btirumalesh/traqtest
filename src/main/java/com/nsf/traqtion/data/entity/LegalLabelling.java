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
 * The persistent class for the legal_labelling database table.
 * 
 */
@Entity
@Table(name="legal_labelling")
@NamedQuery(name="LegalLabelling.findAll", query="SELECT l FROM LegalLabelling l")
public class LegalLabelling implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="legal_labelling_id")
	private String legalLabellingId;

	@Column(name="choc_cocoa_solids")
	private String chocCocoaSolids;

	@Column(name="choc_milk_solids")
	private String chocMilkSolids;

	@Column(name="choc_veg_fats")
	private String chocVegFats;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="jam_prepared_form")
	private String jamPreparedForm;

	@Column(name="jam_sugar")
	private String jamSugar;

	@Column(name="packaging_gas")
	private String packagingGas;

	@Column(name="prepared_with")
	private String preparedWith;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to SupplierSpecification
	@ManyToOne
	@JoinColumn(name="supplier_spec_id")
	private SupplierSpecification supplierSpecification;

	public LegalLabelling() {
	}

	public String getLegalLabellingId() {
		return this.legalLabellingId;
	}

	public void setLegalLabellingId(String legalLabellingId) {
		this.legalLabellingId = legalLabellingId;
	}

	public String getChocCocoaSolids() {
		return this.chocCocoaSolids;
	}

	public void setChocCocoaSolids(String chocCocoaSolids) {
		this.chocCocoaSolids = chocCocoaSolids;
	}

	public String getChocMilkSolids() {
		return this.chocMilkSolids;
	}

	public void setChocMilkSolids(String chocMilkSolids) {
		this.chocMilkSolids = chocMilkSolids;
	}

	public String getChocVegFats() {
		return this.chocVegFats;
	}

	public void setChocVegFats(String chocVegFats) {
		this.chocVegFats = chocVegFats;
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

	public String getJamPreparedForm() {
		return this.jamPreparedForm;
	}

	public void setJamPreparedForm(String jamPreparedForm) {
		this.jamPreparedForm = jamPreparedForm;
	}

	public String getJamSugar() {
		return this.jamSugar;
	}

	public void setJamSugar(String jamSugar) {
		this.jamSugar = jamSugar;
	}

	public String getPackagingGas() {
		return this.packagingGas;
	}

	public void setPackagingGas(String packagingGas) {
		this.packagingGas = packagingGas;
	}

	public String getPreparedWith() {
		return this.preparedWith;
	}

	public void setPreparedWith(String preparedWith) {
		this.preparedWith = preparedWith;
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