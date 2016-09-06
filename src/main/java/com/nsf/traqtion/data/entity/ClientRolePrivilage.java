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
 * The persistent class for the client_role_privilage database table.
 * 
 */
@Entity
@Table(name="client_role_privilage")
@NamedQuery(name="ClientRolePrivilage.findAll", query="SELECT c FROM ClientRolePrivilage c")
public class ClientRolePrivilage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="client_role_privilage_id")
	private String clientRolePrivilageId;

	@Column(name="client_id")
	private Long clientId;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	private String description;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;

	//bi-directional many-to-one association to Privilege
	@ManyToOne
	@JoinColumn(name="privilege_id")
	private Privilege privilege;

	//bi-directional many-to-one association to CompanyType
	@ManyToOne
	@JoinColumn(name="company_type_id")
	private CompanyType companyType;

	public ClientRolePrivilage() {
	}

	public String getClientRolePrivilageId() {
		return this.clientRolePrivilageId;
	}

	public void setClientRolePrivilageId(String clientRolePrivilageId) {
		this.clientRolePrivilageId = clientRolePrivilageId;
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

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Privilege getPrivilege() {
		return this.privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

	public CompanyType getCompanyType() {
		return this.companyType;
	}

	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}

}