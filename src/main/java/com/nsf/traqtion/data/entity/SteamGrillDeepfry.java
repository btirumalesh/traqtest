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
 * The persistent class for the steam_grill_deepfry database table.
 * 
 */
@Entity
@Table(name="steam_grill_deepfry")
@NamedQuery(name="SteamGrillDeepfry.findAll", query="SELECT s FROM SteamGrillDeepfry s")
public class SteamGrillDeepfry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="steam_grill_deepfry_id")
	private String steamGrillDeepfryId;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="statment_option")
	private String statmentOption;

	@Column(name="statment_select")
	private String statmentSelect;

	private String time;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to SupplierSpecification
	@ManyToOne
	@JoinColumn(name="supplier_spec_id")
	private SupplierSpecification supplierSpecification;

	public SteamGrillDeepfry() {
	}

	public String getSteamGrillDeepfryId() {
		return this.steamGrillDeepfryId;
	}

	public void setSteamGrillDeepfryId(String steamGrillDeepfryId) {
		this.steamGrillDeepfryId = steamGrillDeepfryId;
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

	public String getStatmentOption() {
		return this.statmentOption;
	}

	public void setStatmentOption(String statmentOption) {
		this.statmentOption = statmentOption;
	}

	public String getStatmentSelect() {
		return this.statmentSelect;
	}

	public void setStatmentSelect(String statmentSelect) {
		this.statmentSelect = statmentSelect;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
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