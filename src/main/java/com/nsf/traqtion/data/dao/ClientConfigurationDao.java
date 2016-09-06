package com.nsf.traqtion.data.dao;

import java.math.BigInteger;
import java.util.List;

import com.nsf.traqtion.data.entity.ClientBusiness;
import com.nsf.traqtion.data.entity.ClientCategory;
import com.nsf.traqtion.data.entity.ClientSite;
import com.nsf.traqtion.data.entity.CompanyType;
import com.nsf.traqtion.data.entity.JobTitle;
import com.nsf.traqtion.data.entity.Language;
import com.nsf.traqtion.data.entity.Role;
import com.nsf.traqtion.data.entity.SecurityQuestion;
import com.nsf.traqtion.data.entity.ServiceProvider;
import com.nsf.traqtion.data.entity.ServiceProviderType;
import com.nsf.traqtion.data.entity.Supplier;
import com.nsf.traqtion.data.entity.SupplierSite;

public interface ClientConfigurationDao {
    /**
     * getServiceTypesByServiceProviderId method fetches service type details
     * based on provided userId.
     * 
     * @param servProvdrId
     * @return List<ServiceProdType>
     */
    // public List<ServiceProdType>
    // getServiceTypesByServiceProviderId(BigInteger servProvdrId);
    public List<ServiceProviderType> getServiceTypesByServiceProviderId(BigInteger servProvdrId);

    /**
     * getServiceProviderNamesByClientId method fetches service provider names
     * based on clientId.
     * 
     * @param clientId
     * @return List<ServiceProdType>
     */
    public List<ServiceProvider> getServiceProviderNamesByClientId(BigInteger clientId);

    /**
     * getFacilitiesBySupplierTypeId method fetches facilities based on
     * suplirTypeId.
     * 
     * @param suplirTypeId
     * @return List<Facility>
     */
    // public List<Facility> getFacilitiesBySupplierTypeId(long suplirTypeId);
    public List<SupplierSite> getFacilitiesBySupplierTypeId(BigInteger suplirTypeId);

    /**
     * getSupplierNamesByClientId method fetches supplier names based on
     * clientId.
     * 
     * @param clientId
     * @return List<Supplier>
     */
    public List<Supplier> getSupplierNamesByClientId(BigInteger clientId);

    /**
     * geCompanyType method fetches supplier names based on clientId.
     * 
     * @param clientId
     * @return List<Supplier>
     */

    public List<CompanyType> geCompanyType();

    /**
     * geRoleList method fetches supplier names based on clientId.
     * 
     * @param clientId
     * @return List<Supplier>
     */
    public List<Role> geRoleList(Integer clientId);

    /**
     * getCategoryList method fetches supplier names based on clientId.
     * 
     * @param clientId
     * @return List<Supplier>
     */

    public List<ClientCategory> getCategoryList(Integer clientId);

    /**
     * getJobTitleOptionsByClientId method fetches job titles based on clientId.
     * 
     * @param clientId
     * @return List<JobTitle>
     */
    public List<JobTitle> getJobTitleOptionsByClientId(BigInteger clientId);

    /**
     * getLanguageOptionsByClientId method fetches language based on clientId.
     * 
     * @param clientId
     * @return List<JobTitle>
     */
    public List<Language> getLanguageOptionsByClientId(BigInteger clientId);

    /**
     * getSecurityQuestions method returns All security Questions list.
     * 
     * @param
     * @return List <SecurityQuestion>
     */

    public List<SecurityQuestion> getSecurityQuestions();

    public List<ClientSite> getSitesByClientId(BigInteger clientId);

    public List<SupplierSite> getSupplierBySupplierId(BigInteger supplierId);

    /**
     * getCategoryOptionsByBusinessId method fetches categories based on
     * businessId.
     * 
     * @param clientId,
     *            businessId
     * @return List<ClientCategory>
     */
    public List<ClientCategory> getCategoryOptionsByBusinessId(BigInteger clientId, BigInteger businessId);

    public List<SupplierSite> getSitesBySupplierId(BigInteger clientId);

    public List<ClientBusiness> getbusinessByClientId(BigInteger clientId);

    public String getClientPrivilegeByClientId(Integer clientId);

}
