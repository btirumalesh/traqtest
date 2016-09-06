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
 * The persistent class for the oven database table.
 * 
 */
@Entity
@Table(name="oven")
@NamedQuery(name="Oven.findAll", query="SELECT o FROM Oven o")
public class Oven implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="oven_id")
	private String ovenId;

	@Column(name="chilled_additional_stmt")
	private String chilledAdditionalStmt;

	@Column(name="chilled_electricity")
	private String chilledElectricity;

	@Column(name="chilled_gas")
	private String chilledGas;

	@Column(name="chilled_standard_select")
	private String chilledStandardSelect;

	@Column(name="chilled_standard_stmt")
	private String chilledStandardStmt;

	@Column(name="chilled_time_hours")
	private String chilledTimeHours;

	@Column(name="chilled_time_min")
	private String chilledTimeMin;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="forzen_standard_select")
	private String forzenStandardSelect;

	@Column(name="fronen_additional_stmt")
	private String fronenAdditionalStmt;

	@Column(name="fronen_electricity")
	private String fronenElectricity;

	@Column(name="fronen_gas")
	private String fronenGas;

	@Column(name="fronen_standard_stmt")
	private String fronenStandardStmt;

	@Column(name="fronen_time_hours")
	private String fronenTimeHours;

	@Column(name="fronen_time_min")
	private String fronenTimeMin;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to SupplierSpecification
	@ManyToOne
	@JoinColumn(name="supplier_spec_id")
	private SupplierSpecification supplierSpecification;

	public Oven() {
	}

	public String getOvenId() {
		return this.ovenId;
	}

	public void setOvenId(String ovenId) {
		this.ovenId = ovenId;
	}

	public String getChilledAdditionalStmt() {
		return this.chilledAdditionalStmt;
	}

	public void setChilledAdditionalStmt(String chilledAdditionalStmt) {
		this.chilledAdditionalStmt = chilledAdditionalStmt;
	}

	public String getChilledElectricity() {
		return this.chilledElectricity;
	}

	public void setChilledElectricity(String chilledElectricity) {
		this.chilledElectricity = chilledElectricity;
	}

	public String getChilledGas() {
		return this.chilledGas;
	}

	public void setChilledGas(String chilledGas) {
		this.chilledGas = chilledGas;
	}

	public String getChilledStandardSelect() {
		return this.chilledStandardSelect;
	}

	public void setChilledStandardSelect(String chilledStandardSelect) {
		this.chilledStandardSelect = chilledStandardSelect;
	}

	public String getChilledStandardStmt() {
		return this.chilledStandardStmt;
	}

	public void setChilledStandardStmt(String chilledStandardStmt) {
		this.chilledStandardStmt = chilledStandardStmt;
	}

	public String getChilledTimeHours() {
		return this.chilledTimeHours;
	}

	public void setChilledTimeHours(String chilledTimeHours) {
		this.chilledTimeHours = chilledTimeHours;
	}

	public String getChilledTimeMin() {
		return this.chilledTimeMin;
	}

	public void setChilledTimeMin(String chilledTimeMin) {
		this.chilledTimeMin = chilledTimeMin;
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

	public String getForzenStandardSelect() {
		return this.forzenStandardSelect;
	}

	public void setForzenStandardSelect(String forzenStandardSelect) {
		this.forzenStandardSelect = forzenStandardSelect;
	}

	public String getFronenAdditionalStmt() {
		return this.fronenAdditionalStmt;
	}

	public void setFronenAdditionalStmt(String fronenAdditionalStmt) {
		this.fronenAdditionalStmt = fronenAdditionalStmt;
	}

	public String getFronenElectricity() {
		return this.fronenElectricity;
	}

	public void setFronenElectricity(String fronenElectricity) {
		this.fronenElectricity = fronenElectricity;
	}

	public String getFronenGas() {
		return this.fronenGas;
	}

	public void setFronenGas(String fronenGas) {
		this.fronenGas = fronenGas;
	}

	public String getFronenStandardStmt() {
		return this.fronenStandardStmt;
	}

	public void setFronenStandardStmt(String fronenStandardStmt) {
		this.fronenStandardStmt = fronenStandardStmt;
	}

	public String getFronenTimeHours() {
		return this.fronenTimeHours;
	}

	public void setFronenTimeHours(String fronenTimeHours) {
		this.fronenTimeHours = fronenTimeHours;
	}

	public String getFronenTimeMin() {
		return this.fronenTimeMin;
	}

	public void setFronenTimeMin(String fronenTimeMin) {
		this.fronenTimeMin = fronenTimeMin;
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