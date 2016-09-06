package com.nsf.traqtion.data.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

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

@Component("clientConfigDao")
@Transactional
public class ClientConfigurationDaoImpl extends BaseDaoImpl implements ClientConfigurationDao {
    private static final Logger log = LogManager.getLogger(ClientConfigurationDaoImpl.class);
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * getServiceTypesByServiceProviderId method fetches list service type
     * details available in system.
     * 
     * @param servProvdrId
     * @return List<ServiceProdType>
     */
    public List<ServiceProviderType> getServiceTypesByServiceProviderId(BigInteger servProvdrId) {
        log.info(" :: getServiceTypesByServiceProviderId");
        // Query query = entityManager.createNativeQuery("select
        // spt.Service_prod_type_id as id , spt.code as code, spt.description as
        // description from service_prod_type spt join service_provider sp on
        // sp.service_prod_type_id = spt.Service_prod_type_id where
        // sp.service_prod_id= :serviceProdId","ServiceProdType");
        Query query = entityManager.createNativeQuery(
                "select spt  from BusinessRegistration br JOIN br.spTypeRegs str JOIN str.serviceProviderType spt WHERE br.serviceProvider.serviceProvidersId= :serviceProvidersId");
        query.setParameter("serviceProvidersId", servProvdrId.longValue());

        // Object ob = query.getResultList();
        List<ServiceProviderType> servPrvdrList = query.getResultList();
        return servPrvdrList;
    }

    /**
     * getFacilitiesBySupplierTypeId method fetche facilities available in
     * system.
     * 
     * @param suplyrTypeId
     * @return List<Facility>
     */
    public List<SupplierSite> getFacilitiesBySupplierTypeId(BigInteger suplirTypeId) {
        log.info(" :: getFacilitiesBySupplierTypeId");
        Query query = entityManager
                .createQuery("SELECT ss From SupplierSite ss WHERE ss.supplier.supplierId= :supplier_Id");

        query.setParameter("supplier_Id", suplirTypeId.longValue());
        // List<Facility> facilityList = query.getResultList();
        List<SupplierSite> facilityList = query.getResultList();

        return facilityList;
    }

    /**
     * getSupplierNamesByClientId method fetche supplier list available in
     * system.
     * 
     * @param clientId
     * @return List<Supplier>
     */
    public List<Supplier> getSupplierNamesByClientId(BigInteger clientId) {
        log.info(" :: getSupplierNamesByClientId");
        Query query = entityManager.createQuery(
                "Select splyr From Supplier splyr WHERE splyr.client.clientId = :clientId", Supplier.class);
        // Query query2 = entityManager.createNativeQuery("select * from
        // supplier where client_id = "+clientId,Supplier.class);
        query.setParameter("clientId", clientId.longValue());
        List<Supplier> suplyrList = query.getResultList();

        return suplyrList;
    }

    /**
     * getServiceProviderNamesByClientId method fetche serviceprovider list
     * available in system.
     * 
     * @param clientId
     * @return List<Supplier>
     */
    public List<ServiceProvider> getServiceProviderNamesByClientId(BigInteger clientId) {
        log.info(" :: getServiceProviderNamesByClientId");
        Query query = entityManager.createQuery("FROM ServiceProvider sp WHERE sp.client.clientId= :clientId");
        query.setParameter("clientId", clientId.longValue());
        List<ServiceProvider> servceProdTypeList = query.getResultList();

        return servceProdTypeList;
    }

    public List<CompanyType> geCompanyType() {
        // Session session = sessionFactory.getCurrentSession();
        return fetchAll(CompanyType.class);
    }

    @Override
    public List<Role> geRoleList(Integer clientId) {

        // BigInteger bint=BigInteger.valueOf(clientId);

        // Query query = entityManager.createQuery(" select rle from Role rle
        // ,ClientRole cltr where rle.roleId=cltr.roleId and cltr.clientId=
        // :clientId");
        Query query = entityManager.createQuery(" select rle from Role rle WHERE rle.companyTypeId= :clientId");
        query.setParameter("clientId", Long.valueOf(clientId));

        /*
         * // TODO Auto-generated method stub Query query =
         * getSession().createQuery("from Business where id= :id");
         * query.setString("id", id); businessList= query.list(); for(Business
         * emp4 : businessList){
         * System.out.println("Paginated Employees::"+emp4.getBusinessCode()+","
         * +emp4.getBusinessId()); } return businessList;
         * 
         * return query.getResultList();
         */
        return query.getResultList();
    }

    @Override
    public List<ClientCategory> getCategoryList(Integer clientId) {
        // TODO Auto-generated method stub
        BigInteger bint = BigInteger.valueOf(clientId);
        Query query = entityManager.createQuery("select cctg from ClientCategory cctg where cctg.clientId= :clientId");
        query.setParameter("clientId", bint);
        // BigInteger bint=BigInteger.valueOf(clientId);
        // List<ClientCategory> categoryList=null;

        return query.getResultList();
    }

    /**
     * getJobTitleOptionsByClientId method fetche Jobtitles available in system.
     * 
     * @param clientId
     * @return List<JobTitle>
     */

    @Override
    public List<JobTitle> getJobTitleOptionsByClientId(BigInteger clientId) {

        Query query = entityManager.createQuery("select jt from JobTitle jt where jt.clientId= :clientId");
        query.setParameter("clientId", clientId.longValue());

        return query.getResultList();
    }

    /**
     * getLanguageOptionsByClientId method fetche languages available in system.
     * 
     * @param clientId
     * @return List<JobTitle>
     */

    @Override
    public List<Language> getLanguageOptionsByClientId(BigInteger clientId) {
        // Query query = entityManager.createQuery("select tl from TraqLanguage
        // tl JOIN ClientLanguage cl ON tl.traqLanguageId = cl.traqLanguageId
        // WHERE cl.clientId= :clientId");
        // Query query = entityManager.createQuery("select
        // tl.traqLanguageId,tl.languageCode, tl.languageName from TraqLanguage
        // tl, ClientLanguage cl WHERE tl.traqLanguageId = cl.traqLanguageId AND
        // cl.clientId= :clientId");
        // Query query = entityManager.createQuery("select tl from TraqLanguage
        // tl, ClientLanguage cl WHERE tl.traqLanguageId = cl.traqLanguageId AND
        // cl.clientId= :clientId"); //Here
        Query query = entityManager.createQuery(
                "select tl from Language tl, ClientLanguage cl WHERE tl.languagesId = cl.language.languagesId AND cl.client.clientId= :clientId");
        query.setParameter("clientId", clientId.longValue());

        return query.getResultList();
    }

    /**
     * getSecurityQuestions method returns All security Questions list.
     * 
     * @param
     * @return List <SecurityQuestion>
     */
    @Override
    public List<SecurityQuestion> getSecurityQuestions() {
        List<SecurityQuestion> questionList = fetchAll(SecurityQuestion.class);
        return questionList;
    }

    @Override
    public List<ClientSite> getSitesByClientId(BigInteger clientId) {
        Query query = entityManager.createQuery("select cs from ClientSite cs WHERE cs.client.clientId=  :clientId");
        query.setParameter("clientId", clientId.longValue());

        return query.getResultList();
    }

    @Override
    public List<SupplierSite> getSupplierBySupplierId(BigInteger supplierId) {
        Query query = entityManager
                .createQuery("select cs from SupplierSite cs WHERE cs.supplierSitesId=  :supplierId");
        query.setParameter("supplierId", supplierId.longValue());

        return query.getResultList();
    }

    /**
     * getCategoryOptionsByBusinessId method fetch categories available in
     * system.
     * 
     * @param clientId,
     *            businessId
     * @return List<ClientCategory>
     */
    @Override
    public List<ClientCategory> getCategoryOptionsByBusinessId(BigInteger clientId, BigInteger businessId) {
        List<ClientCategory> clientCatgryList = new ArrayList<ClientCategory>();
        // -1 Query query = entityManager.createQuery("select cctg from
        // ClientCategory cctg, ClientBusinessCategory cbCatgry WHERE
        // cctg.clientCategoryId = cbCatgry.clientCategory.clientCategoryId AND
        // cbCatgry.client.clientId= :clientId AND
        // cbCatgry.clientBusiness.clientBusinessId= :clientBusinessId");
        // Query query = entityManager.createQuery("select cctg from
        // ClientCategory cctg WHERE cctg.clientId= :clientId");
        Query query = entityManager.createQuery(
                "select cctg from ClientCategory cctg JOIN cctg.clientBusinessCategories cbCatgry  WHERE cbCatgry.client.clientId= :clientId AND cbCatgry.clientBusiness.clientBusinessId= :clientBusinessId");
        query.setParameter("clientId", clientId.longValue());
        query.setParameter("clientBusinessId", "" + businessId);
        // TODO
        // List<Object[]> rowArry = query.getResultList();

        return query.getResultList();
    }

    @Override
    public List<SupplierSite> getSitesBySupplierId(BigInteger supplierId) {
        Query query = entityManager
                .createQuery("select cs from SupplierSite cs WHERE cs.supplier.supplierId=  :supplierId");
        query.setParameter("supplierId", supplierId.longValue());

        return query.getResultList();
    }

    @Override
    public List<ClientBusiness> getbusinessByClientId(BigInteger clientId) {

        Query query = entityManager
                .createQuery("select cs from ClientBusiness cs WHERE cs.client.clientId=  :clientId");
        query.setParameter("clientId", clientId.longValue());

        return query.getResultList();
    }

    /**
     * getClientPrivilege method connect to database and return privilege of
     * particular client.
     * 
     * @param clientId
     * @return String
     */
    public String getClientPrivilegeByClientId(Integer clientId) {
        String clientPrivilege = "";

        BigInteger bint = BigInteger.valueOf(clientId);
        Query query1 = entityManager
                .createNativeQuery("SELECT client_id FROM client_business_categories WHERE client_id= :clientId");
        query1.setParameter("clientId", bint);
        List list;
        list = query1.getResultList();

        if (!(list.isEmpty())) {
            clientPrivilege = "Coupled";

        } else if (list.isEmpty()) {
            Query query2 = entityManager.createNativeQuery(
                    "select cc.client_id from client_category cc , client_business cb where cc.client_id = cb.client_id and cc.client_id= :clientId");
            query2.setParameter("clientId", bint);
            List list1;
            list1 = query2.getResultList();
            if (!(list1.isEmpty())) {
                clientPrivilege = "Decoupled";
            } else {
                Query query3 = entityManager.createNativeQuery(
                        "SELECT client_id FROM client_category WHERE client_id NOT IN (SELECT client_id FROM client_business) and client_id= :clientId");
                query3.setParameter("clientId", bint);
                List list2;
                list2 = query3.getResultList();

                if (list2.get(0) != null) {
                    clientPrivilege = "CategoryOnly";
                }
            }
        }
        return clientPrivilege;
    }

}
