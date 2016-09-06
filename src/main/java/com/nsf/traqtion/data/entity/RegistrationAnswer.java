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
 * The persistent class for the registration_answers database table.
 * 
 */
@Entity
@Table(name="registration_answers")
@NamedQuery(name="RegistrationAnswer.findAll", query="SELECT r FROM RegistrationAnswer r")
public class RegistrationAnswer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="registration_answers_id")
	private String registrationAnswersId;

	private String answers;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="service_provider_id")
	private Long serviceProviderId;

	@Column(name="service_provider_type_id")
	private Long serviceProviderTypeId;

	@Column(name="supplier_id")
	private Long supplierId;

	@Column(name="supplier_sites_id")
	private Long supplierSitesId;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	@Column(name="yes_no_flag")
	private String yesNoFlag;

	//bi-directional many-to-one association to AnswerAttachment
	@OneToMany(mappedBy="registrationAnswer")
	private List<AnswerAttachment> answerAttachments;

	//bi-directional many-to-one association to BusinessRegistration
	@ManyToOne
	@JoinColumn(name="business_reg_id")
	private BusinessRegistration businessRegistration;

	//bi-directional many-to-one association to ClientRegQuestion
	@ManyToOne
	@JoinColumn(name="client_reg_questions_id")
	private ClientRegQuestion clientRegQuestion;

	//bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name="status_id")
	private Status status;

	public RegistrationAnswer() {
	}

	public String getRegistrationAnswersId() {
		return this.registrationAnswersId;
	}

	public void setRegistrationAnswersId(String registrationAnswersId) {
		this.registrationAnswersId = registrationAnswersId;
	}

	public String getAnswers() {
		return this.answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
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

	public Long getServiceProviderId() {
		return this.serviceProviderId;
	}

	public void setServiceProviderId(Long serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}

	public Long getServiceProviderTypeId() {
		return this.serviceProviderTypeId;
	}

	public void setServiceProviderTypeId(Long serviceProviderTypeId) {
		this.serviceProviderTypeId = serviceProviderTypeId;
	}

	public Long getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Long getSupplierSitesId() {
		return this.supplierSitesId;
	}

	public void setSupplierSitesId(Long supplierSitesId) {
		this.supplierSitesId = supplierSitesId;
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

	public String getYesNoFlag() {
		return this.yesNoFlag;
	}

	public void setYesNoFlag(String yesNoFlag) {
		this.yesNoFlag = yesNoFlag;
	}

	public List<AnswerAttachment> getAnswerAttachments() {
		return this.answerAttachments;
	}

	public void setAnswerAttachments(List<AnswerAttachment> answerAttachments) {
		this.answerAttachments = answerAttachments;
	}

	public AnswerAttachment addAnswerAttachment(AnswerAttachment answerAttachment) {
		getAnswerAttachments().add(answerAttachment);
		answerAttachment.setRegistrationAnswer(this);

		return answerAttachment;
	}

	public AnswerAttachment removeAnswerAttachment(AnswerAttachment answerAttachment) {
		getAnswerAttachments().remove(answerAttachment);
		answerAttachment.setRegistrationAnswer(null);

		return answerAttachment;
	}

	public BusinessRegistration getBusinessRegistration() {
		return this.businessRegistration;
	}

	public void setBusinessRegistration(BusinessRegistration businessRegistration) {
		this.businessRegistration = businessRegistration;
	}

	public ClientRegQuestion getClientRegQuestion() {
		return this.clientRegQuestion;
	}

	public void setClientRegQuestion(ClientRegQuestion clientRegQuestion) {
		this.clientRegQuestion = clientRegQuestion;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}