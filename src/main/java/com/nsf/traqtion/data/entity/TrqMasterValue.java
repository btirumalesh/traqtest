package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the trq_master_values database table.
 * 
 */
@Entity
@Table(name="trq_master_values")
@NamedQuery(name="TrqMasterValue.findAll", query="SELECT t FROM TrqMasterValue t")
public class TrqMasterValue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="trq_master_values_id")
	private String trqMasterValuesId;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	private String description;

	@Column(name="trq_master_sets_id")
	private Long trqMasterSetsId;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	private String value;

	//bi-directional many-to-one association to SpAddress
	@OneToMany(mappedBy="trqMasterValue")
	private List<SpAddress> spAddresses;

	//bi-directional many-to-one association to SpInsurance
	@OneToMany(mappedBy="trqMasterValue")
	private List<SpInsurance> spInsurances;

	//bi-directional many-to-one association to SpOthrCert
	@OneToMany(mappedBy="trqMasterValue")
	private List<SpOthrCert> spOthrCerts;

	//bi-directional many-to-one association to SpQaStatus
	@OneToMany(mappedBy="trqMasterValue")
	private List<SpQaStatus> spQaStatuses;

	//bi-directional many-to-one association to SuppSiteInsurance
	@OneToMany(mappedBy="trqMasterValue")
	private List<SuppSiteInsurance> suppSiteInsurances;

	//bi-directional many-to-one association to SuppSiteOthrCert
	@OneToMany(mappedBy="trqMasterValue")
	private List<SuppSiteOthrCert> suppSiteOthrCerts;

	//bi-directional many-to-one association to SuppSiteQaStatus
	@OneToMany(mappedBy="trqMasterValue")
	private List<SuppSiteQaStatus> suppSiteQaStatuses;

	//bi-directional many-to-one association to SupplierInsurance
	@OneToMany(mappedBy="trqMasterValue")
	private List<SupplierInsurance> supplierInsurances;

	//bi-directional many-to-one association to SupplierOthrCert
	@OneToMany(mappedBy="trqMasterValue")
	private List<SupplierOthrCert> supplierOthrCerts;

	//bi-directional many-to-one association to SupplierQaStatus
	@OneToMany(mappedBy="trqMasterValue")
	private List<SupplierQaStatus> supplierQaStatuses;

	public TrqMasterValue() {
	}

	public String getTrqMasterValuesId() {
		return this.trqMasterValuesId;
	}

	public void setTrqMasterValuesId(String trqMasterValuesId) {
		this.trqMasterValuesId = trqMasterValuesId;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getTrqMasterSetsId() {
		return this.trqMasterSetsId;
	}

	public void setTrqMasterSetsId(Long trqMasterSetsId) {
		this.trqMasterSetsId = trqMasterSetsId;
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

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<SpAddress> getSpAddresses() {
		return this.spAddresses;
	}

	public void setSpAddresses(List<SpAddress> spAddresses) {
		this.spAddresses = spAddresses;
	}

	public SpAddress addSpAddress(SpAddress spAddress) {
		getSpAddresses().add(spAddress);
		spAddress.setTrqMasterValue(this);

		return spAddress;
	}

	public SpAddress removeSpAddress(SpAddress spAddress) {
		getSpAddresses().remove(spAddress);
		spAddress.setTrqMasterValue(null);

		return spAddress;
	}

	public List<SpInsurance> getSpInsurances() {
		return this.spInsurances;
	}

	public void setSpInsurances(List<SpInsurance> spInsurances) {
		this.spInsurances = spInsurances;
	}

	public SpInsurance addSpInsurance(SpInsurance spInsurance) {
		getSpInsurances().add(spInsurance);
		spInsurance.setTrqMasterValue(this);

		return spInsurance;
	}

	public SpInsurance removeSpInsurance(SpInsurance spInsurance) {
		getSpInsurances().remove(spInsurance);
		spInsurance.setTrqMasterValue(null);

		return spInsurance;
	}

	public List<SpOthrCert> getSpOthrCerts() {
		return this.spOthrCerts;
	}

	public void setSpOthrCerts(List<SpOthrCert> spOthrCerts) {
		this.spOthrCerts = spOthrCerts;
	}

	public SpOthrCert addSpOthrCert(SpOthrCert spOthrCert) {
		getSpOthrCerts().add(spOthrCert);
		spOthrCert.setTrqMasterValue(this);

		return spOthrCert;
	}

	public SpOthrCert removeSpOthrCert(SpOthrCert spOthrCert) {
		getSpOthrCerts().remove(spOthrCert);
		spOthrCert.setTrqMasterValue(null);

		return spOthrCert;
	}

	public List<SpQaStatus> getSpQaStatuses() {
		return this.spQaStatuses;
	}

	public void setSpQaStatuses(List<SpQaStatus> spQaStatuses) {
		this.spQaStatuses = spQaStatuses;
	}

	public SpQaStatus addSpQaStatus(SpQaStatus spQaStatus) {
		getSpQaStatuses().add(spQaStatus);
		spQaStatus.setTrqMasterValue(this);

		return spQaStatus;
	}

	public SpQaStatus removeSpQaStatus(SpQaStatus spQaStatus) {
		getSpQaStatuses().remove(spQaStatus);
		spQaStatus.setTrqMasterValue(null);

		return spQaStatus;
	}

	public List<SuppSiteInsurance> getSuppSiteInsurances() {
		return this.suppSiteInsurances;
	}

	public void setSuppSiteInsurances(List<SuppSiteInsurance> suppSiteInsurances) {
		this.suppSiteInsurances = suppSiteInsurances;
	}

	public SuppSiteInsurance addSuppSiteInsurance(SuppSiteInsurance suppSiteInsurance) {
		getSuppSiteInsurances().add(suppSiteInsurance);
		suppSiteInsurance.setTrqMasterValue(this);

		return suppSiteInsurance;
	}

	public SuppSiteInsurance removeSuppSiteInsurance(SuppSiteInsurance suppSiteInsurance) {
		getSuppSiteInsurances().remove(suppSiteInsurance);
		suppSiteInsurance.setTrqMasterValue(null);

		return suppSiteInsurance;
	}

	public List<SuppSiteOthrCert> getSuppSiteOthrCerts() {
		return this.suppSiteOthrCerts;
	}

	public void setSuppSiteOthrCerts(List<SuppSiteOthrCert> suppSiteOthrCerts) {
		this.suppSiteOthrCerts = suppSiteOthrCerts;
	}

	public SuppSiteOthrCert addSuppSiteOthrCert(SuppSiteOthrCert suppSiteOthrCert) {
		getSuppSiteOthrCerts().add(suppSiteOthrCert);
		suppSiteOthrCert.setTrqMasterValue(this);

		return suppSiteOthrCert;
	}

	public SuppSiteOthrCert removeSuppSiteOthrCert(SuppSiteOthrCert suppSiteOthrCert) {
		getSuppSiteOthrCerts().remove(suppSiteOthrCert);
		suppSiteOthrCert.setTrqMasterValue(null);

		return suppSiteOthrCert;
	}

	public List<SuppSiteQaStatus> getSuppSiteQaStatuses() {
		return this.suppSiteQaStatuses;
	}

	public void setSuppSiteQaStatuses(List<SuppSiteQaStatus> suppSiteQaStatuses) {
		this.suppSiteQaStatuses = suppSiteQaStatuses;
	}

	public SuppSiteQaStatus addSuppSiteQaStatus(SuppSiteQaStatus suppSiteQaStatus) {
		getSuppSiteQaStatuses().add(suppSiteQaStatus);
		suppSiteQaStatus.setTrqMasterValue(this);

		return suppSiteQaStatus;
	}

	public SuppSiteQaStatus removeSuppSiteQaStatus(SuppSiteQaStatus suppSiteQaStatus) {
		getSuppSiteQaStatuses().remove(suppSiteQaStatus);
		suppSiteQaStatus.setTrqMasterValue(null);

		return suppSiteQaStatus;
	}

	public List<SupplierInsurance> getSupplierInsurances() {
		return this.supplierInsurances;
	}

	public void setSupplierInsurances(List<SupplierInsurance> supplierInsurances) {
		this.supplierInsurances = supplierInsurances;
	}

	public SupplierInsurance addSupplierInsurance(SupplierInsurance supplierInsurance) {
		getSupplierInsurances().add(supplierInsurance);
		supplierInsurance.setTrqMasterValue(this);

		return supplierInsurance;
	}

	public SupplierInsurance removeSupplierInsurance(SupplierInsurance supplierInsurance) {
		getSupplierInsurances().remove(supplierInsurance);
		supplierInsurance.setTrqMasterValue(null);

		return supplierInsurance;
	}

	public List<SupplierOthrCert> getSupplierOthrCerts() {
		return this.supplierOthrCerts;
	}

	public void setSupplierOthrCerts(List<SupplierOthrCert> supplierOthrCerts) {
		this.supplierOthrCerts = supplierOthrCerts;
	}

	public SupplierOthrCert addSupplierOthrCert(SupplierOthrCert supplierOthrCert) {
		getSupplierOthrCerts().add(supplierOthrCert);
		supplierOthrCert.setTrqMasterValue(this);

		return supplierOthrCert;
	}

	public SupplierOthrCert removeSupplierOthrCert(SupplierOthrCert supplierOthrCert) {
		getSupplierOthrCerts().remove(supplierOthrCert);
		supplierOthrCert.setTrqMasterValue(null);

		return supplierOthrCert;
	}

	public List<SupplierQaStatus> getSupplierQaStatuses() {
		return this.supplierQaStatuses;
	}

	public void setSupplierQaStatuses(List<SupplierQaStatus> supplierQaStatuses) {
		this.supplierQaStatuses = supplierQaStatuses;
	}

	public SupplierQaStatus addSupplierQaStatus(SupplierQaStatus supplierQaStatus) {
		getSupplierQaStatuses().add(supplierQaStatus);
		supplierQaStatus.setTrqMasterValue(this);

		return supplierQaStatus;
	}

	public SupplierQaStatus removeSupplierQaStatus(SupplierQaStatus supplierQaStatus) {
		getSupplierQaStatuses().remove(supplierQaStatus);
		supplierQaStatus.setTrqMasterValue(null);

		return supplierQaStatus;
	}

}