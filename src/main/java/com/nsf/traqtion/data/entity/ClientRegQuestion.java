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
 * The persistent class for the client_reg_questions database table.
 * 
 */
@Entity
@Table(name="client_reg_questions")
@NamedQuery(name="ClientRegQuestion.findAll", query="SELECT c FROM ClientRegQuestion c")
public class ClientRegQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="client_reg_questions_id")
	private String clientRegQuestionsId;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	private String description;

	@Column(name="facility_quest_flag")
	private String facilityQuestFlag;

	@Column(name="mandatory_flag")
	private String mandatoryFlag;

	@Column(name="question_code")
	private String questionCode;

	@Column(name="service_provider_type_id")
	private Long serviceProviderTypeId;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	//bi-directional many-to-one association to CompanyType
	@ManyToOne
	@JoinColumn(name="company_type_id")
	private CompanyType companyType;

	//bi-directional many-to-one association to RegistrationAnswer
	@OneToMany(mappedBy="clientRegQuestion")
	private List<RegistrationAnswer> registrationAnswers;

	public ClientRegQuestion() {
	}

	public String getClientRegQuestionsId() {
		return this.clientRegQuestionsId;
	}

	public void setClientRegQuestionsId(String clientRegQuestionsId) {
		this.clientRegQuestionsId = clientRegQuestionsId;
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

	public String getFacilityQuestFlag() {
		return this.facilityQuestFlag;
	}

	public void setFacilityQuestFlag(String facilityQuestFlag) {
		this.facilityQuestFlag = facilityQuestFlag;
	}

	public String getMandatoryFlag() {
		return this.mandatoryFlag;
	}

	public void setMandatoryFlag(String mandatoryFlag) {
		this.mandatoryFlag = mandatoryFlag;
	}

	public String getQuestionCode() {
		return this.questionCode;
	}

	public void setQuestionCode(String questionCode) {
		this.questionCode = questionCode;
	}

	public Long getServiceProviderTypeId() {
		return this.serviceProviderTypeId;
	}

	public void setServiceProviderTypeId(Long serviceProviderTypeId) {
		this.serviceProviderTypeId = serviceProviderTypeId;
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

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public CompanyType getCompanyType() {
		return this.companyType;
	}

	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}

	public List<RegistrationAnswer> getRegistrationAnswers() {
		return this.registrationAnswers;
	}

	public void setRegistrationAnswers(List<RegistrationAnswer> registrationAnswers) {
		this.registrationAnswers = registrationAnswers;
	}

	public RegistrationAnswer addRegistrationAnswer(RegistrationAnswer registrationAnswer) {
		getRegistrationAnswers().add(registrationAnswer);
		registrationAnswer.setClientRegQuestion(this);

		return registrationAnswer;
	}

	public RegistrationAnswer removeRegistrationAnswer(RegistrationAnswer registrationAnswer) {
		getRegistrationAnswers().remove(registrationAnswer);
		registrationAnswer.setClientRegQuestion(null);

		return registrationAnswer;
	}

}