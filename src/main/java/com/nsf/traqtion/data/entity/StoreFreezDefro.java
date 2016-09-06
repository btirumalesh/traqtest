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
 * The persistent class for the store_freez_defros database table.
 * 
 */
@Entity
@Table(name="store_freez_defros")
@NamedQuery(name="StoreFreezDefro.findAll", query="SELECT s FROM StoreFreezDefro s")
public class StoreFreezDefro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="store_freez_defros_id")
	private String storeFreezDefrosId;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="defrosting_sele_stmt")
	private String defrostingSeleStmt;

	@Column(name="defrosting_stmt_opt")
	private String defrostingStmtOpt;

	@Column(name="freezing_sele_stmt")
	private String freezingSeleStmt;

	@Column(name="freezing_stmt_opt")
	private String freezingStmtOpt;

	@Column(name="how_to_store_sele_stmt")
	private String howToStoreSeleStmt;

	@Column(name="how_to_store_stmt_opt")
	private String howToStoreStmtOpt;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to SupplierSpecification
	@ManyToOne
	@JoinColumn(name="supplier_spec_id")
	private SupplierSpecification supplierSpecification;

	public StoreFreezDefro() {
	}

	public String getStoreFreezDefrosId() {
		return this.storeFreezDefrosId;
	}

	public void setStoreFreezDefrosId(String storeFreezDefrosId) {
		this.storeFreezDefrosId = storeFreezDefrosId;
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

	public String getDefrostingSeleStmt() {
		return this.defrostingSeleStmt;
	}

	public void setDefrostingSeleStmt(String defrostingSeleStmt) {
		this.defrostingSeleStmt = defrostingSeleStmt;
	}

	public String getDefrostingStmtOpt() {
		return this.defrostingStmtOpt;
	}

	public void setDefrostingStmtOpt(String defrostingStmtOpt) {
		this.defrostingStmtOpt = defrostingStmtOpt;
	}

	public String getFreezingSeleStmt() {
		return this.freezingSeleStmt;
	}

	public void setFreezingSeleStmt(String freezingSeleStmt) {
		this.freezingSeleStmt = freezingSeleStmt;
	}

	public String getFreezingStmtOpt() {
		return this.freezingStmtOpt;
	}

	public void setFreezingStmtOpt(String freezingStmtOpt) {
		this.freezingStmtOpt = freezingStmtOpt;
	}

	public String getHowToStoreSeleStmt() {
		return this.howToStoreSeleStmt;
	}

	public void setHowToStoreSeleStmt(String howToStoreSeleStmt) {
		this.howToStoreSeleStmt = howToStoreSeleStmt;
	}

	public String getHowToStoreStmtOpt() {
		return this.howToStoreStmtOpt;
	}

	public void setHowToStoreStmtOpt(String howToStoreStmtOpt) {
		this.howToStoreStmtOpt = howToStoreStmtOpt;
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