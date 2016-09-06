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
 * The persistent class for the status database table.
 * 
 */
@Entity
@Table(name="status")
@NamedQuery(name="Status.findAll", query="SELECT s FROM Status s")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="status_id")
	private Long statusId;

	private String code;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	private String discription;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to BusinessRegistration
	@OneToMany(mappedBy="status")
	private List<BusinessRegistration> businessRegistrations;

	//bi-directional many-to-one association to RegistrationAnswer
	@OneToMany(mappedBy="status")
	private List<RegistrationAnswer> registrationAnswers;

	//bi-directional many-to-one association to StatusType
	@ManyToOne
	@JoinColumn(name="status_type_id")
	private StatusType statusType;

	//bi-directional many-to-one association to Supplier
	@OneToMany(mappedBy="status")
	private List<Supplier> suppliers;

	//bi-directional many-to-one association to UserStatusLog
	@OneToMany(mappedBy="status")
	private List<UserStatusLog> userStatusLogs;

	//bi-directional many-to-one association to UsersStatusLog
	@OneToMany(mappedBy="status")
	private List<UsersStatusLog> usersStatusLogs;
	
	//bi-directional many-to-one association to UserMapping
		@OneToMany(mappedBy="status")
		private List<UserMapping> userMappings;

	public Status() {
	}

	public Long getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
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

	public String getDiscription() {
		return this.discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
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
		businessRegistration.setStatus(this);

		return businessRegistration;
	}

	public BusinessRegistration removeBusinessRegistration(BusinessRegistration businessRegistration) {
		getBusinessRegistrations().remove(businessRegistration);
		businessRegistration.setStatus(null);

		return businessRegistration;
	}

	public List<RegistrationAnswer> getRegistrationAnswers() {
		return this.registrationAnswers;
	}

	public void setRegistrationAnswers(List<RegistrationAnswer> registrationAnswers) {
		this.registrationAnswers = registrationAnswers;
	}

	public RegistrationAnswer addRegistrationAnswer(RegistrationAnswer registrationAnswer) {
		getRegistrationAnswers().add(registrationAnswer);
		registrationAnswer.setStatus(this);

		return registrationAnswer;
	}

	public RegistrationAnswer removeRegistrationAnswer(RegistrationAnswer registrationAnswer) {
		getRegistrationAnswers().remove(registrationAnswer);
		registrationAnswer.setStatus(null);

		return registrationAnswer;
	}

	public StatusType getStatusType() {
		return this.statusType;
	}

	public void setStatusType(StatusType statusType) {
		this.statusType = statusType;
	}

	public List<Supplier> getSuppliers() {
		return this.suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public Supplier addSupplier(Supplier supplier) {
		getSuppliers().add(supplier);
		supplier.setStatus(this);

		return supplier;
	}

	public Supplier removeSupplier(Supplier supplier) {
		getSuppliers().remove(supplier);
		supplier.setStatus(null);

		return supplier;
	}

	public List<UserStatusLog> getUserStatusLogs() {
		return this.userStatusLogs;
	}

	public void setUserStatusLogs(List<UserStatusLog> userStatusLogs) {
		this.userStatusLogs = userStatusLogs;
	}

	public UserStatusLog addUserStatusLog(UserStatusLog userStatusLog) {
		getUserStatusLogs().add(userStatusLog);
		userStatusLog.setStatus(this);

		return userStatusLog;
	}

	public UserStatusLog removeUserStatusLog(UserStatusLog userStatusLog) {
		getUserStatusLogs().remove(userStatusLog);
		userStatusLog.setStatus(null);

		return userStatusLog;
	}

	public List<UsersStatusLog> getUsersStatusLogs() {
		return this.usersStatusLogs;
	}

	public void setUsersStatusLogs(List<UsersStatusLog> usersStatusLogs) {
		this.usersStatusLogs = usersStatusLogs;
	}

	public UsersStatusLog addUsersStatusLog(UsersStatusLog usersStatusLog) {
		getUsersStatusLogs().add(usersStatusLog);
		usersStatusLog.setStatus(this);

		return usersStatusLog;
	}

	public UsersStatusLog removeUsersStatusLog(UsersStatusLog usersStatusLog) {
		getUsersStatusLogs().remove(usersStatusLog);
		usersStatusLog.setStatus(null);

		return usersStatusLog;
	}

	public List<UserMapping> getUserMappings() {
		return userMappings;
	}

	public void setUserMappings(List<UserMapping> userMappings) {
		this.userMappings = userMappings;
	}

}