package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the business_registration database table.
 * 
 */
@Entity
@Table(name="business_registration")
@NamedQuery(name="BusinessRegistration.findAll", query="SELECT b FROM BusinessRegistration b")
public class BusinessRegistration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="business_reg_id")
	private String businessRegId;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Temporal(TemporalType.DATE)
	@Column(name="registered_date")
	private Date registeredDate;

	@Column(name="service_end_date")
	private Timestamp serviceEndDate;

	@Column(name="service_start_date")
	private Timestamp serviceStartDate;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to CompanyType
	@ManyToOne
	@JoinColumn(name="company_type_id")
	private CompanyType companyType;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	//bi-directional many-to-one association to Supplier
	@ManyToOne
	@JoinColumn(name="supplier_id")
	private Supplier supplier;

	//bi-directional many-to-one association to ServiceProvider
	@ManyToOne
	@JoinColumn(name="service_providers_id")
	private ServiceProvider serviceProvider;

	//bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name="status_id")
	private Status status;

	//bi-directional many-to-one association to RegistrationAnswer
	@OneToMany(mappedBy="businessRegistration")
	private List<RegistrationAnswer> registrationAnswers;

	//bi-directional many-to-one association to SpTypeReg
	@OneToMany(mappedBy="businessRegistration")
	private List<SpTypeReg> spTypeRegs;

	public BusinessRegistration() {
	}

	public String getBusinessRegId() {
		return this.businessRegId;
	}

	public void setBusinessRegId(String businessRegId) {
		this.businessRegId = businessRegId;
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

	public Date getRegisteredDate() {
		return this.registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public Timestamp getServiceEndDate() {
		return this.serviceEndDate;
	}

	public void setServiceEndDate(Timestamp serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}

	public Timestamp getServiceStartDate() {
		return this.serviceStartDate;
	}

	public void setServiceStartDate(Timestamp serviceStartDate) {
		this.serviceStartDate = serviceStartDate;
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

	public CompanyType getCompanyType() {
		return this.companyType;
	}

	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public ServiceProvider getServiceProvider() {
		return this.serviceProvider;
	}

	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<RegistrationAnswer> getRegistrationAnswers() {
		return this.registrationAnswers;
	}

	public void setRegistrationAnswers(List<RegistrationAnswer> registrationAnswers) {
		this.registrationAnswers = registrationAnswers;
	}

	public RegistrationAnswer addRegistrationAnswer(RegistrationAnswer registrationAnswer) {
		getRegistrationAnswers().add(registrationAnswer);
		registrationAnswer.setBusinessRegistration(this);

		return registrationAnswer;
	}

	public RegistrationAnswer removeRegistrationAnswer(RegistrationAnswer registrationAnswer) {
		getRegistrationAnswers().remove(registrationAnswer);
		registrationAnswer.setBusinessRegistration(null);

		return registrationAnswer;
	}

	public List<SpTypeReg> getSpTypeRegs() {
		return this.spTypeRegs;
	}

	public void setSpTypeRegs(List<SpTypeReg> spTypeRegs) {
		this.spTypeRegs = spTypeRegs;
	}

	public SpTypeReg addSpTypeReg(SpTypeReg spTypeReg) {
		getSpTypeRegs().add(spTypeReg);
		spTypeReg.setBusinessRegistration(this);

		return spTypeReg;
	}

	public SpTypeReg removeSpTypeReg(SpTypeReg spTypeReg) {
		getSpTypeRegs().remove(spTypeReg);
		spTypeReg.setBusinessRegistration(null);

		return spTypeReg;
	}

}