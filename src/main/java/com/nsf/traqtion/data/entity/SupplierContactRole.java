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
 * The persistent class for the supplier_contact_role database table.
 * 
 */
@Entity
@Table(name="supplier_contact_role")
@NamedQuery(name="SupplierContactRole.findAll", query="SELECT s FROM SupplierContactRole s")
public class SupplierContactRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="supplier_contact_role_id")
	private String supplierContactRoleId;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;

	//bi-directional many-to-one association to SupplierContact
	@ManyToOne
	@JoinColumn(name="supplier_contact_id")
	private SupplierContact supplierContact;

	public SupplierContactRole() {
	}

	public String getSupplierContactRoleId() {
		return this.supplierContactRoleId;
	}

	public void setSupplierContactRoleId(String supplierContactRoleId) {
		this.supplierContactRoleId = supplierContactRoleId;
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

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public SupplierContact getSupplierContact() {
		return this.supplierContact;
	}

	public void setSupplierContact(SupplierContact supplierContact) {
		this.supplierContact = supplierContact;
	}

}