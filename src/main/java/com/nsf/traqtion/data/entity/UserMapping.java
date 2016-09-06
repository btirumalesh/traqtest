package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
 * The persistent class for the user_mapping database table.
 * 
 */
@Entity
@Table(name="user_mapping")
@NamedQuery(name="UserMapping.findAll", query="SELECT u FROM UserMapping u")
public class UserMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_mapping_id")
	private Long userMappingId;

	@Column(name="active_flag")
	private String activeFlag;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="assign_temporary_from")
	private Date assignTemporaryFrom;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="assign_temporary_to")
	private Date assignTemporaryTo;

	private String attribute1;

	private String attribute2;

	private String attribute3;

	private String attribute4;

	private String attribute5;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="last_login_date")
	private Timestamp lastLoginDate;

	@Column(name="primary_contact_flag")
	private String primaryContactFlag;

	private String reason;

	@ManyToOne
	@JoinColumn(name="status_id")
	private Status status;

	@Column(name="temporary_access_flag")
	private String temporaryAccessFlag;

	@Column(name="updated_by")		
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to UserBusinessCategory
	@OneToMany(mappedBy="userMapping")
	private List<UserBusinessCategory> userBusinessCategories;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	//bi-directional many-to-one association to CompanyType
	@ManyToOne
	@JoinColumn(name="company_type_id")
	private CompanyType companyType;

	//bi-directional many-to-one association to Supplier
	@ManyToOne
	@JoinColumn(name="supplier_id")
	private Supplier supplier;

	//bi-directional many-to-one association to ServiceProvider
	@ManyToOne
	@JoinColumn(name="service_providers_id")
	private ServiceProvider serviceProvider;

	//bi-directional many-to-one association to UserRole
	@OneToMany(cascade=CascadeType.ALL,mappedBy="userMapping")
	private List<UserRole> userRoles;

	//bi-directional many-to-one association to UserSpType
	@OneToMany(cascade=CascadeType.ALL,mappedBy="userMapping")
	private List<UserSpType> userSpTypes;

	//bi-directional many-to-one association to UserSuppSite
	@OneToMany(cascade=CascadeType.ALL,mappedBy="userMapping")
	private List<UserSuppSite> userSuppSites;

	//bi-directional many-to-one association to UsersStatusLog
	@OneToMany(cascade=CascadeType.ALL, mappedBy="userMapping")
	private List<UsersStatusLog> usersStatusLogs;

	public UserMapping() {
	}

	public Long getUserMappingId() {
		return this.userMappingId;
	}

	public void setUserMappingId(Long userMappingId) {
		this.userMappingId = userMappingId;
	}

	public String getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Date getAssignTemporaryFrom() {
		return this.assignTemporaryFrom;
	}

	public void setAssignTemporaryFrom(Date assignTemporaryFrom) {
		this.assignTemporaryFrom = assignTemporaryFrom;
	}

	public Date getAssignTemporaryTo() {
		return this.assignTemporaryTo;
	}

	public void setAssignTemporaryTo(Date assignTemporaryTo) {
		this.assignTemporaryTo = assignTemporaryTo;
	}

	public String getAttribute1() {
		return this.attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	public String getAttribute2() {
		return this.attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	public String getAttribute3() {
		return this.attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	public String getAttribute4() {
		return this.attribute4;
	}

	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}

	public String getAttribute5() {
		return this.attribute5;
	}

	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
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

	public Timestamp getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getPrimaryContactFlag() {
		return this.primaryContactFlag;
	}

	public void setPrimaryContactFlag(String primaryContactFlag) {
		this.primaryContactFlag = primaryContactFlag;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTemporaryAccessFlag() {
		return this.temporaryAccessFlag;
	}

	public void setTemporaryAccessFlag(String temporaryAccessFlag) {
		this.temporaryAccessFlag = temporaryAccessFlag;
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

	public List<UserBusinessCategory> getUserBusinessCategories() {
		return this.userBusinessCategories;
	}

	public void setUserBusinessCategories(List<UserBusinessCategory> userBusinessCategories) {
		this.userBusinessCategories = userBusinessCategories;
	}

	public UserBusinessCategory addUserBusinessCategory(UserBusinessCategory userBusinessCategory) {
		getUserBusinessCategories().add(userBusinessCategory);
		userBusinessCategory.setUserMapping(this);

		return userBusinessCategory;
	}

	public UserBusinessCategory removeUserBusinessCategory(UserBusinessCategory userBusinessCategory) {
		getUserBusinessCategories().remove(userBusinessCategory);
		userBusinessCategory.setUserMapping(null);

		return userBusinessCategory;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setUserMapping(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setUserMapping(null);

		return userRole;
	}

	public List<UserSpType> getUserSpTypes() {
		return this.userSpTypes;
	}

	public void setUserSpTypes(List<UserSpType> userSpTypes) {
		this.userSpTypes = userSpTypes;
	}

	public UserSpType addUserSpType(UserSpType userSpType) {
		getUserSpTypes().add(userSpType);
		userSpType.setUserMapping(this);

		return userSpType;
	}

	public UserSpType removeUserSpType(UserSpType userSpType) {
		getUserSpTypes().remove(userSpType);
		userSpType.setUserMapping(null);

		return userSpType;
	}

	public List<UserSuppSite> getUserSuppSites() {
		return this.userSuppSites;
	}

	public void setUserSuppSites(List<UserSuppSite> userSuppSites) {
		this.userSuppSites = userSuppSites;
	}

	public UserSuppSite addUserSuppSite(UserSuppSite userSuppSite) {
		getUserSuppSites().add(userSuppSite);
		userSuppSite.setUserMapping(this);

		return userSuppSite;
	}

	public UserSuppSite removeUserSuppSite(UserSuppSite userSuppSite) {
		getUserSuppSites().remove(userSuppSite);
		userSuppSite.setUserMapping(null);

		return userSuppSite;
	}

	public List<UsersStatusLog> getUsersStatusLogs() {
		return this.usersStatusLogs;
	}

	public void setUsersStatusLogs(List<UsersStatusLog> usersStatusLogs) {
		this.usersStatusLogs = usersStatusLogs;
	}

	public UsersStatusLog addUsersStatusLog(UsersStatusLog usersStatusLog) {
		getUsersStatusLogs().add(usersStatusLog);
		usersStatusLog.setUserMapping(this);

		return usersStatusLog;
	}

	public UsersStatusLog removeUsersStatusLog(UsersStatusLog usersStatusLog) {
		getUsersStatusLogs().remove(usersStatusLog);
		usersStatusLog.setUserMapping(null);

		return usersStatusLog;
	}

}