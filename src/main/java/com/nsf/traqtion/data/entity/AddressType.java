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
 * The persistent class for the address_type database table.
 * 
 */
@Entity
@Table(name="address_type")
@NamedQuery(name="AddressType.findAll", query="SELECT a FROM AddressType a")
public class AddressType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="address_type_id")
	private String addressTypeId;

	private String code;

	@Column(name="Created_BY")
	private Long created_BY;

	@Column(name="Creation_Date")
	private Timestamp creation_Date;

	private String description;

	@Column(name="Updated_By")
	private Long updated_By;

	@Column(name="Updated_Date")
	private Timestamp updated_Date;

	//bi-directional many-to-one association to SupplierAddress
	@OneToMany(mappedBy="addressType")
	private List<SupplierAddress> supplierAddresses;

	public AddressType() {
	}

	public String getAddressTypeId() {
		return this.addressTypeId;
	}

	public void setAddressTypeId(String addressTypeId) {
		this.addressTypeId = addressTypeId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getCreated_BY() {
		return this.created_BY;
	}

	public void setCreated_BY(Long created_BY) {
		this.created_BY = created_BY;
	}

	public Timestamp getCreation_Date() {
		return this.creation_Date;
	}

	public void setCreation_Date(Timestamp creation_Date) {
		this.creation_Date = creation_Date;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getUpdated_By() {
		return this.updated_By;
	}

	public void setUpdated_By(Long updated_By) {
		this.updated_By = updated_By;
	}

	public Timestamp getUpdated_Date() {
		return this.updated_Date;
	}

	public void setUpdated_Date(Timestamp updated_Date) {
		this.updated_Date = updated_Date;
	}

	public List<SupplierAddress> getSupplierAddresses() {
		return this.supplierAddresses;
	}

	public void setSupplierAddresses(List<SupplierAddress> supplierAddresses) {
		this.supplierAddresses = supplierAddresses;
	}

	public SupplierAddress addSupplierAddress(SupplierAddress supplierAddress) {
		getSupplierAddresses().add(supplierAddress);
		supplierAddress.setAddressType(this);

		return supplierAddress;
	}

	public SupplierAddress removeSupplierAddress(SupplierAddress supplierAddress) {
		getSupplierAddresses().remove(supplierAddress);
		supplierAddress.setAddressType(null);

		return supplierAddress;
	}

}