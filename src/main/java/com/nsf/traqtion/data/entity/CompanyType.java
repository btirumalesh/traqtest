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
 * The persistent class for the company_type database table.
 * 
 */
@Entity
@Table(name="company_type")
@NamedQuery(name="CompanyType.findAll", query="SELECT c FROM CompanyType c")
public class CompanyType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="company_type_id")
	private Long companyTypeId;

	private String code;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	private String description;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to BusinessRegistration
	@OneToMany(mappedBy="companyType")
	private List<BusinessRegistration> businessRegistrations;

	//bi-directional many-to-one association to ClientRegQuestion
	@OneToMany(mappedBy="companyType")
	private List<ClientRegQuestion> clientRegQuestions;

	//bi-directional many-to-one association to ClientRolePrivilage
	@OneToMany(mappedBy="companyType")
	private List<ClientRolePrivilage> clientRolePrivilages;

	//bi-directional many-to-one association to UserMapping
	@OneToMany(mappedBy="companyType")
	private List<UserMapping> userMappings;

	public CompanyType() {
	}

	public Long getCompanyTypeId() {
		return this.companyTypeId;
	}

	public void setCompanyTypeId(Long companyTypeId) {
		this.companyTypeId = companyTypeId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public List<BusinessRegistration> getBusinessRegistrations() {
		return this.businessRegistrations;
	}

	public void setBusinessRegistrations(List<BusinessRegistration> businessRegistrations) {
		this.businessRegistrations = businessRegistrations;
	}

	public BusinessRegistration addBusinessRegistration(BusinessRegistration businessRegistration) {
		getBusinessRegistrations().add(businessRegistration);
		businessRegistration.setCompanyType(this);

		return businessRegistration;
	}

	public BusinessRegistration removeBusinessRegistration(BusinessRegistration businessRegistration) {
		getBusinessRegistrations().remove(businessRegistration);
		businessRegistration.setCompanyType(null);

		return businessRegistration;
	}

	public List<ClientRegQuestion> getClientRegQuestions() {
		return this.clientRegQuestions;
	}

	public void setClientRegQuestions(List<ClientRegQuestion> clientRegQuestions) {
		this.clientRegQuestions = clientRegQuestions;
	}

	public ClientRegQuestion addClientRegQuestion(ClientRegQuestion clientRegQuestion) {
		getClientRegQuestions().add(clientRegQuestion);
		clientRegQuestion.setCompanyType(this);

		return clientRegQuestion;
	}

	public ClientRegQuestion removeClientRegQuestion(ClientRegQuestion clientRegQuestion) {
		getClientRegQuestions().remove(clientRegQuestion);
		clientRegQuestion.setCompanyType(null);

		return clientRegQuestion;
	}

	public List<ClientRolePrivilage> getClientRolePrivilages() {
		return this.clientRolePrivilages;
	}

	public void setClientRolePrivilages(List<ClientRolePrivilage> clientRolePrivilages) {
		this.clientRolePrivilages = clientRolePrivilages;
	}

	public ClientRolePrivilage addClientRolePrivilage(ClientRolePrivilage clientRolePrivilage) {
		getClientRolePrivilages().add(clientRolePrivilage);
		clientRolePrivilage.setCompanyType(this);

		return clientRolePrivilage;
	}

	public ClientRolePrivilage removeClientRolePrivilage(ClientRolePrivilage clientRolePrivilage) {
		getClientRolePrivilages().remove(clientRolePrivilage);
		clientRolePrivilage.setCompanyType(null);

		return clientRolePrivilage;
	}

	public List<UserMapping> getUserMappings() {
		return this.userMappings;
	}

	public void setUserMappings(List<UserMapping> userMappings) {
		this.userMappings = userMappings;
	}

	public UserMapping addUserMapping(UserMapping userMapping) {
		getUserMappings().add(userMapping);
		userMapping.setCompanyType(this);

		return userMapping;
	}

	public UserMapping removeUserMapping(UserMapping userMapping) {
		getUserMappings().remove(userMapping);
		userMapping.setCompanyType(null);

		return userMapping;
	}

}