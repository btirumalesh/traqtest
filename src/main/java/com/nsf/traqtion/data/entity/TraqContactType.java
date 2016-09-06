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
 * The persistent class for the traq_contact_type database table.
 * 
 */
@Entity
@Table(name="traq_contact_type")
@NamedQuery(name="TraqContactType.findAll", query="SELECT t FROM TraqContactType t")
public class TraqContactType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="traq_contact_type_id")
	private String traqContactTypeId;

	@Column(name="contact_type_code")
	private String contactTypeCode;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	private String description;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to ContactType
	@OneToMany(mappedBy="traqContactType")
	private List<ContactType> contactTypes;

	public TraqContactType() {
	}

	public String getTraqContactTypeId() {
		return this.traqContactTypeId;
	}

	public void setTraqContactTypeId(String traqContactTypeId) {
		this.traqContactTypeId = traqContactTypeId;
	}

	public String getContactTypeCode() {
		return this.contactTypeCode;
	}

	public void setContactTypeCode(String contactTypeCode) {
		this.contactTypeCode = contactTypeCode;
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

	public List<ContactType> getContactTypes() {
		return this.contactTypes;
	}

	public void setContactTypes(List<ContactType> contactTypes) {
		this.contactTypes = contactTypes;
	}

	public ContactType addContactType(ContactType contactType) {
		getContactTypes().add(contactType);
		contactType.setTraqContactType(this);

		return contactType;
	}

	public ContactType removeContactType(ContactType contactType) {
		getContactTypes().remove(contactType);
		contactType.setTraqContactType(null);

		return contactType;
	}

}