package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the contact_type database table.
 * 
 */
@Entity
@Table(name="contact_type")
@NamedQuery(name="ContactType.findAll", query="SELECT c FROM ContactType c")
public class ContactType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="contact_type_id")
	private Long contactTypeId;

	@Column(name="client_id")
	private Long clientId;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to ClientContact
	@OneToMany(mappedBy="contactType")
	private List<ClientContact> clientContacts;

	//bi-directional many-to-one association to TraqContactType
	@ManyToOne
	@JoinColumn(name="traq_contact_type_id")
	private TraqContactType traqContactType;

	//bi-directional many-to-one association to SpContact
	@OneToMany(mappedBy="contactType")
	private List<SpContact> spContacts;

	//bi-directional many-to-one association to SupplierContact
	@OneToMany(mappedBy="contactType")
	private List<SupplierContact> supplierContacts;

	public ContactType() {
	}

	public Long getContactTypeId() {
		return this.contactTypeId;
	}

	public void setContactTypeId(Long contactTypeId) {
		this.contactTypeId = contactTypeId;
	}

	public Long getClientId() {
		return this.clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
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

	public List<ClientContact> getClientContacts() {
		return this.clientContacts;
	}

	public void setClientContacts(List<ClientContact> clientContacts) {
		this.clientContacts = clientContacts;
	}

	public ClientContact addClientContact(ClientContact clientContact) {
		getClientContacts().add(clientContact);
		clientContact.setContactType(this);

		return clientContact;
	}

	public ClientContact removeClientContact(ClientContact clientContact) {
		getClientContacts().remove(clientContact);
		clientContact.setContactType(null);

		return clientContact;
	}

	public TraqContactType getTraqContactType() {
		return this.traqContactType;
	}

	public void setTraqContactType(TraqContactType traqContactType) {
		this.traqContactType = traqContactType;
	}

	public List<SpContact> getSpContacts() {
		return this.spContacts;
	}

	public void setSpContacts(List<SpContact> spContacts) {
		this.spContacts = spContacts;
	}

	public SpContact addSpContact(SpContact spContact) {
		getSpContacts().add(spContact);
		spContact.setContactType(this);

		return spContact;
	}

	public SpContact removeSpContact(SpContact spContact) {
		getSpContacts().remove(spContact);
		spContact.setContactType(null);

		return spContact;
	}

	public List<SupplierContact> getSupplierContacts() {
		return this.supplierContacts;
	}

	public void setSupplierContacts(List<SupplierContact> supplierContacts) {
		this.supplierContacts = supplierContacts;
	}

	public SupplierContact addSupplierContact(SupplierContact supplierContact) {
		getSupplierContacts().add(supplierContact);
		supplierContact.setContactType(this);

		return supplierContact;
	}

	public SupplierContact removeSupplierContact(SupplierContact supplierContact) {
		getSupplierContacts().remove(supplierContact);
		supplierContact.setContactType(null);

		return supplierContact;
	}

}