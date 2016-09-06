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
 * The persistent class for the privilege database table.
 * 
 */
@Entity
@Table(name="privilege")
@NamedQuery(name="Privilege.findAll", query="SELECT p FROM Privilege p")
public class Privilege implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="privilege_id")
	private String privilegeId;

	private String area;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	private String edit;

	@Column(name="privilege_name")
	private String privilegeName;

	@Column(name="screen_name")
	private String screenName;

	@Column(name="section_action")
	private String sectionAction;

	@Column(name="tab_action")
	private String tabAction;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	private String view;

	//bi-directional many-to-one association to ClientRolePrivilage
	@OneToMany(mappedBy="privilege")
	private List<ClientRolePrivilage> clientRolePrivilages;

	public Privilege() {
	}

	public String getPrivilegeId() {
		return this.privilegeId;
	}

	public void setPrivilegeId(String privilegeId) {
		this.privilegeId = privilegeId;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
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

	public String getEdit() {
		return this.edit;
	}

	public void setEdit(String edit) {
		this.edit = edit;
	}

	public String getPrivilegeName() {
		return this.privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	public String getScreenName() {
		return this.screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getSectionAction() {
		return this.sectionAction;
	}

	public void setSectionAction(String sectionAction) {
		this.sectionAction = sectionAction;
	}

	public String getTabAction() {
		return this.tabAction;
	}

	public void setTabAction(String tabAction) {
		this.tabAction = tabAction;
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

	public String getView() {
		return this.view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public List<ClientRolePrivilage> getClientRolePrivilages() {
		return this.clientRolePrivilages;
	}

	public void setClientRolePrivilages(List<ClientRolePrivilage> clientRolePrivilages) {
		this.clientRolePrivilages = clientRolePrivilages;
	}

	public ClientRolePrivilage addClientRolePrivilage(ClientRolePrivilage clientRolePrivilage) {
		getClientRolePrivilages().add(clientRolePrivilage);
		clientRolePrivilage.setPrivilege(this);

		return clientRolePrivilage;
	}

	public ClientRolePrivilage removeClientRolePrivilage(ClientRolePrivilage clientRolePrivilage) {
		getClientRolePrivilages().remove(clientRolePrivilage);
		clientRolePrivilage.setPrivilege(null);

		return clientRolePrivilage;
	}

}