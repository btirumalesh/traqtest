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
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name="role")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	private Long roleId;

	@Column(name="company_type_id")
	private Long companyTypeId;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="role_desctiption")
	private String roleDesctiption;

	@Column(name="role_name")
	private String roleName;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to ClientContact
	@OneToMany(mappedBy="role")
	private List<ClientContact> clientContacts;

	//bi-directional many-to-one association to ClientContactRole
	@OneToMany(mappedBy="role")
	private List<ClientContactRole> clientContactRoles;

	//bi-directional many-to-one association to ClientRolePrivilage
	@OneToMany(mappedBy="role")
	private List<ClientRolePrivilage> clientRolePrivilages;

	//bi-directional many-to-one association to SpContactRole
	@OneToMany(mappedBy="role")
	private List<SpContactRole> spContactRoles;

	//bi-directional many-to-one association to SpContact
	@OneToMany(mappedBy="role")
	private List<SpContact> spContacts;

	//bi-directional many-to-one association to SupplierContact
	@OneToMany(mappedBy="role")
	private List<SupplierContact> supplierContacts;

	//bi-directional many-to-one association to SupplierContactRole
	@OneToMany(mappedBy="role")
	private List<SupplierContactRole> supplierContactRoles;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="role")
	private List<UserRole> userRoles;

	//bi-directional many-to-one association to WfDefinition
	@OneToMany(mappedBy="role")
	private List<WfDefinition> wfDefinitions;

	//bi-directional many-to-one association to WfObject
	@OneToMany(mappedBy="role")
	private List<WfObject> wfObjects;

	public Role() {
	}

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getCompanyTypeId() {
		return this.companyTypeId;
	}

	public void setCompanyTypeId(Long companyTypeId) {
		this.companyTypeId = companyTypeId;
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

	public String getRoleDesctiption() {
		return this.roleDesctiption;
	}

	public void setRoleDesctiption(String roleDesctiption) {
		this.roleDesctiption = roleDesctiption;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
		clientContact.setRole(this);

		return clientContact;
	}

	public ClientContact removeClientContact(ClientContact clientContact) {
		getClientContacts().remove(clientContact);
		clientContact.setRole(null);

		return clientContact;
	}

	public List<ClientContactRole> getClientContactRoles() {
		return this.clientContactRoles;
	}

	public void setClientContactRoles(List<ClientContactRole> clientContactRoles) {
		this.clientContactRoles = clientContactRoles;
	}

	public ClientContactRole addClientContactRole(ClientContactRole clientContactRole) {
		getClientContactRoles().add(clientContactRole);
		clientContactRole.setRole(this);

		return clientContactRole;
	}

	public ClientContactRole removeClientContactRole(ClientContactRole clientContactRole) {
		getClientContactRoles().remove(clientContactRole);
		clientContactRole.setRole(null);

		return clientContactRole;
	}

	public List<ClientRolePrivilage> getClientRolePrivilages() {
		return this.clientRolePrivilages;
	}

	public void setClientRolePrivilages(List<ClientRolePrivilage> clientRolePrivilages) {
		this.clientRolePrivilages = clientRolePrivilages;
	}

	public ClientRolePrivilage addClientRolePrivilage(ClientRolePrivilage clientRolePrivilage) {
		getClientRolePrivilages().add(clientRolePrivilage);
		clientRolePrivilage.setRole(this);

		return clientRolePrivilage;
	}

	public ClientRolePrivilage removeClientRolePrivilage(ClientRolePrivilage clientRolePrivilage) {
		getClientRolePrivilages().remove(clientRolePrivilage);
		clientRolePrivilage.setRole(null);

		return clientRolePrivilage;
	}

	public List<SpContactRole> getSpContactRoles() {
		return this.spContactRoles;
	}

	public void setSpContactRoles(List<SpContactRole> spContactRoles) {
		this.spContactRoles = spContactRoles;
	}

	public SpContactRole addSpContactRole(SpContactRole spContactRole) {
		getSpContactRoles().add(spContactRole);
		spContactRole.setRole(this);

		return spContactRole;
	}

	public SpContactRole removeSpContactRole(SpContactRole spContactRole) {
		getSpContactRoles().remove(spContactRole);
		spContactRole.setRole(null);

		return spContactRole;
	}

	public List<SpContact> getSpContacts() {
		return this.spContacts;
	}

	public void setSpContacts(List<SpContact> spContacts) {
		this.spContacts = spContacts;
	}

	public SpContact addSpContact(SpContact spContact) {
		getSpContacts().add(spContact);
		spContact.setRole(this);

		return spContact;
	}

	public SpContact removeSpContact(SpContact spContact) {
		getSpContacts().remove(spContact);
		spContact.setRole(null);

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
		supplierContact.setRole(this);

		return supplierContact;
	}

	public SupplierContact removeSupplierContact(SupplierContact supplierContact) {
		getSupplierContacts().remove(supplierContact);
		supplierContact.setRole(null);

		return supplierContact;
	}

	public List<SupplierContactRole> getSupplierContactRoles() {
		return this.supplierContactRoles;
	}

	public void setSupplierContactRoles(List<SupplierContactRole> supplierContactRoles) {
		this.supplierContactRoles = supplierContactRoles;
	}

	public SupplierContactRole addSupplierContactRole(SupplierContactRole supplierContactRole) {
		getSupplierContactRoles().add(supplierContactRole);
		supplierContactRole.setRole(this);

		return supplierContactRole;
	}

	public SupplierContactRole removeSupplierContactRole(SupplierContactRole supplierContactRole) {
		getSupplierContactRoles().remove(supplierContactRole);
		supplierContactRole.setRole(null);

		return supplierContactRole;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setRole(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setRole(null);

		return userRole;
	}

	public List<WfDefinition> getWfDefinitions() {
		return this.wfDefinitions;
	}

	public void setWfDefinitions(List<WfDefinition> wfDefinitions) {
		this.wfDefinitions = wfDefinitions;
	}

	public WfDefinition addWfDefinition(WfDefinition wfDefinition) {
		getWfDefinitions().add(wfDefinition);
		wfDefinition.setRole(this);

		return wfDefinition;
	}

	public WfDefinition removeWfDefinition(WfDefinition wfDefinition) {
		getWfDefinitions().remove(wfDefinition);
		wfDefinition.setRole(null);

		return wfDefinition;
	}

	public List<WfObject> getWfObjects() {
		return this.wfObjects;
	}

	public void setWfObjects(List<WfObject> wfObjects) {
		this.wfObjects = wfObjects;
	}

	public WfObject addWfObject(WfObject wfObject) {
		getWfObjects().add(wfObject);
		wfObject.setRole(this);

		return wfObject;
	}

	public WfObject removeWfObject(WfObject wfObject) {
		getWfObjects().remove(wfObject);
		wfObject.setRole(null);

		return wfObject;
	}

}