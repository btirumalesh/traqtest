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
 * The persistent class for the supplier_distribution database table.
 * 
 */
@Entity
@Table(name="supplier_distribution")
@NamedQuery(name="SupplierDistribution.findAll", query="SELECT s FROM SupplierDistribution s")
public class SupplierDistribution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="distribution_id")
	private String distributionId;

	private String comments;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="minimum_life_into_depot_units")
	private String minimumLifeIntoDepotUnits;

	@Column(name="minimum_life_into_depot_value")
	private Long minimumLifeIntoDepotValue;

	@Column(name="minimum_life_into_store_units")
	private String minimumLifeIntoStoreUnits;

	@Column(name="minimum_life_into_store_value")
	private Long minimumLifeIntoStoreValue;

	@Column(name="special_export_condition")
	private String specialExportCondition;

	@Column(name="storage_or_packing_temp")
	private Long storageOrPackingTemp;

	@Column(name="storage_temp_at_store_max")
	private Long storageTempAtStoreMax;

	@Column(name="storage_temp_at_store_min")
	private Long storageTempAtStoreMin;

	@Column(name="temp_into_depot_max")
	private Long tempIntoDepotMax;

	@Column(name="temp_into_depot_min")
	private Long tempIntoDepotMin;

	@Column(name="trac_code_or_lot_marking_format")
	private Long tracCodeOrLotMarkingFormat;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to SupplierSpecification
	@ManyToOne
	@JoinColumn(name="supplier_spec_id")
	private SupplierSpecification supplierSpecification;

	public SupplierDistribution() {
	}

	public String getDistributionId() {
		return this.distributionId;
	}

	public void setDistributionId(String distributionId) {
		this.distributionId = distributionId;
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

	public String getMinimumLifeIntoDepotUnits() {
		return this.minimumLifeIntoDepotUnits;
	}

	public void setMinimumLifeIntoDepotUnits(String minimumLifeIntoDepotUnits) {
		this.minimumLifeIntoDepotUnits = minimumLifeIntoDepotUnits;
	}

	public Long getMinimumLifeIntoDepotValue() {
		return this.minimumLifeIntoDepotValue;
	}

	public void setMinimumLifeIntoDepotValue(Long minimumLifeIntoDepotValue) {
		this.minimumLifeIntoDepotValue = minimumLifeIntoDepotValue;
	}

	public String getMinimumLifeIntoStoreUnits() {
		return this.minimumLifeIntoStoreUnits;
	}

	public void setMinimumLifeIntoStoreUnits(String minimumLifeIntoStoreUnits) {
		this.minimumLifeIntoStoreUnits = minimumLifeIntoStoreUnits;
	}

	public Long getMinimumLifeIntoStoreValue() {
		return this.minimumLifeIntoStoreValue;
	}

	public void setMinimumLifeIntoStoreValue(Long minimumLifeIntoStoreValue) {
		this.minimumLifeIntoStoreValue = minimumLifeIntoStoreValue;
	}

	public String getSpecialExportCondition() {
		return this.specialExportCondition;
	}

	public void setSpecialExportCondition(String specialExportCondition) {
		this.specialExportCondition = specialExportCondition;
	}

	public Long getStorageOrPackingTemp() {
		return this.storageOrPackingTemp;
	}

	public void setStorageOrPackingTemp(Long storageOrPackingTemp) {
		this.storageOrPackingTemp = storageOrPackingTemp;
	}

	public Long getStorageTempAtStoreMax() {
		return this.storageTempAtStoreMax;
	}

	public void setStorageTempAtStoreMax(Long storageTempAtStoreMax) {
		this.storageTempAtStoreMax = storageTempAtStoreMax;
	}

	public Long getStorageTempAtStoreMin() {
		return this.storageTempAtStoreMin;
	}

	public void setStorageTempAtStoreMin(Long storageTempAtStoreMin) {
		this.storageTempAtStoreMin = storageTempAtStoreMin;
	}

	public Long getTempIntoDepotMax() {
		return this.tempIntoDepotMax;
	}

	public void setTempIntoDepotMax(Long tempIntoDepotMax) {
		this.tempIntoDepotMax = tempIntoDepotMax;
	}

	public Long getTempIntoDepotMin() {
		return this.tempIntoDepotMin;
	}

	public void setTempIntoDepotMin(Long tempIntoDepotMin) {
		this.tempIntoDepotMin = tempIntoDepotMin;
	}

	public Long getTracCodeOrLotMarkingFormat() {
		return this.tracCodeOrLotMarkingFormat;
	}

	public void setTracCodeOrLotMarkingFormat(Long tracCodeOrLotMarkingFormat) {
		this.tracCodeOrLotMarkingFormat = tracCodeOrLotMarkingFormat;
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