package com.nsf.traqtion.business.config;

import java.math.BigInteger;
import java.util.List;

import com.nsf.traqtion.model.common.LookupDTO;
import com.nsf.traqtion.model.usermgmt.SecurityQuestionsDTO;

public interface ClientConfigManager {
	/**
	 * getServiceTypesByServiceProviderId method fetches list of all service provider type details records .
	 * @param servProviderId
	 * @return List<LookUpDTO>
	 */
	public List<LookupDTO> getServiceTypesByServiceProviderId(BigInteger servProviderId);

	/**
	 * getServiceProviderNamesByClientId method fetches list of all service provider names.
	 * @param clientId
	 * @return List<LookUpDTO>
	 * 
	 * 
	 */
	public List<LookupDTO> getServiceProviderNamesByClientId(BigInteger clientId);

	/**
	 * getSupplierNamesByClientId method fetches supplier list.
	 * @param clientId
	 * @return List<LookUpDTO>
	 */
	public List<LookupDTO> getSupplierNamesByClientId(BigInteger clientId);

	/**
	 * geCompanyType method fetches supplier list.
	 * @param clientId
	 * @return List<LookUpDTO>
	 */
	public List<LookupDTO> geCompanyType();
	/**
	 * geRoleList method fetches supplier list.
	 * @param clientId
	 * @return List<LookUpDTO>
	 * 
	 */
	public List<LookupDTO> geRoleList(Integer clientId);
	/**
	 * getCategoryList method fetches supplier list.
	 * @param clientId
	 * @return List<LookUpDTO>
	 */
	public List<LookupDTO> getCategoryList(Integer clientId);
	/**
	 * getFacilitiesBySupplierTypeId method fetches list of Facilities .
	 * @param servProviderId
	 * @return List<LookUpDTO>
	 */
	public List<LookupDTO> getFacilitiesBySupplierTypeId(BigInteger servProviderId);

	/**
	 * getJobTitleOptionsByClientId method fetches JobT itles.
	 * @param clientId
	 * @return List<LookUpDTO>
	 */
	public List<LookupDTO> getJobTitleOptionsByClientId(BigInteger clientId);

	/**
	 * getLanguageOptionsByClientId method fetches languages.
	 * @param clientId
	 * @return List<LookUpDTO>
	 */
	public List<LookupDTO> getLanguageOptionsByClientId(BigInteger clientId);

	/**
	 * getSecurityQuestions method returns All security Questions list .
	 * @param 
	 * @return List<SecurityQuestionsDTO>
	 */
	public List <SecurityQuestionsDTO> getSecurityQuestions();


	public List<LookupDTO> getSitesByClientId(BigInteger clientId);

	public List<LookupDTO> getSupplierBySupplierId(BigInteger supplierId);


	/**
	 * getCategoryOptionsByBusinessId method fetches categories.
	 * @param clientId, businessId
	 * @return List<LookupDTO>
	 */
	public List<LookupDTO> getCategoryOptionsByBusinessId(BigInteger clientId, BigInteger businessId);

	public List<LookupDTO> getSitesBySupplierId(BigInteger supplierId);

	public List<LookupDTO> getbusinessByClientId(BigInteger supplierId); 
	
	public String getClientPrivilegeByClientId(Integer clientId);


}
