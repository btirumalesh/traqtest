package com.nsf.traqtion.business.config;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsf.traqtion.data.dao.ClientConfigurationDao;
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
import com.nsf.traqtion.model.common.LookupDTO;
import com.nsf.traqtion.model.usermgmt.SecurityQuestionsDTO;
import com.nsf.traqtion.util.NSFCommon;

@Service("clientConfigBusiness")
public class ClientConfigManagerImpl implements ClientConfigManager {
    private static final Logger log = LogManager.getLogger(ClientConfigManagerImpl.class);
    @Autowired
    private ClientConfigurationDao clientConfigDao;

    /**
     * getServiceTypesByServiceProviderId method fetches list of service
     * provider type detail records and maps DTO objects from entity objects.
     * 
     * @param servProviderId
     * @return List<LookUpDTO>
     */
    public List<LookupDTO> getServiceTypesByServiceProviderId(BigInteger servProviderId) {
        log.info(":: getServiceTypesByServiceProviderId");
        List<LookupDTO> lookUpDtoList = new ArrayList<LookupDTO>();

        List<ServiceProviderType> srvPrvdrTypeList = clientConfigDao.getServiceTypesByServiceProviderId(servProviderId);
        for (ServiceProviderType srvPrdType : srvPrvdrTypeList) {
            LookupDTO lookUpDTO = new LookupDTO();
            lookUpDTO.setId(srvPrdType.getServiceProviderTypeId().longValue());
            lookUpDTO.setCode(srvPrdType.getCode());
            lookUpDTO.setDescription(srvPrdType.getDescription());
            lookUpDtoList.add(lookUpDTO);
        }
        // List<Ser> lookUpDtoList=
        // clientConfigDao.getServiceTypesByServiceProviderId(servProviderId);

        return lookUpDtoList;
    }

    /**
     * getServiceTypesByServiceProviderId method fetches list of service
     * provider names and maps DTO objects from entity objects.
     * 
     * @param clientId
     * @return List<LookUpDTO>
     */
    public List<LookupDTO> getServiceProviderNamesByClientId(BigInteger clientId) {
        log.info(":: getServiceProviderNamesByClientId");
        List<LookupDTO> lookUpDtoList = new ArrayList<LookupDTO>();
        List<ServiceProvider> srvPrvdrTypeList = clientConfigDao.getServiceProviderNamesByClientId(clientId);
        for (ServiceProvider srvPrvdr : srvPrvdrTypeList) {
            LookupDTO lookUpDTO = new LookupDTO();
            lookUpDTO.setId(srvPrvdr.getServiceProvidersId());
            lookUpDTO.setCode(srvPrvdr.getServiceProviderCode());
            lookUpDTO.setName(srvPrvdr.getCompanyName());
            // lookUpDTO.setDescription(srvPrvdr.getDescription());
            lookUpDtoList.add(lookUpDTO);
        }
        return lookUpDtoList;
    }

    /**
     * getSupplierNamesByClientId method fetches list of suppliers and maps DTO
     * objects from entity objects.
     * 
     * @param clientId
     * @return List<LookUpDTO>
     */
    public List<LookupDTO> getSupplierNamesByClientId(BigInteger clientId) {
        log.info(":: getSupplierNamesByClientId");
        List<LookupDTO> lookUpDtoList = new ArrayList<LookupDTO>();
        List<Supplier> suplyrList = clientConfigDao.getSupplierNamesByClientId(clientId);
        for (Supplier suplyr : suplyrList) {
            LookupDTO lookUpDTO = new LookupDTO();
            lookUpDTO.setId(suplyr.getSupplierId());
            lookUpDTO.setCode(suplyr.getNsfSupplierCode());
            lookUpDTO.setName(suplyr.getSupplierName());
            // lookUpDTO.setDescription(suplyr.getDescription());
            lookUpDtoList.add(lookUpDTO);
        }
        return lookUpDtoList;
    }

    @Override
    public List<LookupDTO> geCompanyType() {
        log.info(" :: getCompanyTypes");
        List<CompanyType> userEntityList = (List<CompanyType>) clientConfigDao.geCompanyType();
        List<LookupDTO> lookupDTOList = new ArrayList<LookupDTO>();
        if (userEntityList != null) {
            LookupDTO dto = null;
            for (CompanyType cmpType : userEntityList) {
                dto = new LookupDTO();
                dto.setCode(cmpType.getCode());
                dto.setDescription(cmpType.getDescription());
                dto.setId(cmpType.getCompanyTypeId());

                lookupDTOList.add(dto);
            }
        }
        return lookupDTOList;
    }

    @Override
    public List<LookupDTO> geRoleList(Integer clientId) {
        log.info(" :: geRoleList");
        List<Role> userEntityList = (List<Role>) clientConfigDao.geRoleList(clientId);
        List<LookupDTO> lookupDTOList = new ArrayList<LookupDTO>();
        if (userEntityList != null) {
            LookupDTO dto = null;
            for (Role cmpType : userEntityList) {
                dto = new LookupDTO();
                dto.setDescription(cmpType.getRoleDesctiption());
                dto.setName(cmpType.getRoleName());
                dto.setId(cmpType.getRoleId());

                /*
                 * dto.setId(cmpType.getRoleId());
                 * dto.setName(cmpType.getRoleName());
                 */

                lookupDTOList.add(dto);
            }
        }
        return lookupDTOList;
    }

    @Override
    public List<LookupDTO> getCategoryList(Integer clientId) {
        log.info(" :: getCategoryList");
        List<ClientCategory> userEntityList = (List<ClientCategory>) clientConfigDao.getCategoryList(clientId);
        List<LookupDTO> lookupDTOList = new ArrayList<LookupDTO>();
        if (userEntityList != null) {
            LookupDTO dto = null;
            for (ClientCategory cmpType : userEntityList) {
                dto = new LookupDTO();
                // dto.setId(cmpType.getCategory_Id());
                dto.setId(cmpType.getClientCategoryId());
                dto.setName(cmpType.getCategoryName());
                dto.setDescription(cmpType.getDescription());

                lookupDTOList.add(dto);
            }
        }
        return lookupDTOList;
    }

    /**
     * getFacilitiesBySupplierTypeId method fetches list of service provider
     * type detail records and maps DTO objects from entity objects.
     * 
     * @param servProviderId
     * @return List<LookUpDTO>
     */
    @Override
    public List<LookupDTO> getFacilitiesBySupplierTypeId(BigInteger suplirTypeId) {
        log.info(" :: getFacilitiesBySupplierTypeId");
        List<SupplierSite> splirEntityList = clientConfigDao.getFacilitiesBySupplierTypeId(suplirTypeId);
        List<LookupDTO> lookupDTOList = new ArrayList<LookupDTO>();
        LookupDTO dto = null;
        for (SupplierSite supirSite : splirEntityList) {
            dto = new LookupDTO();
            // dto.setId(cmpType.getCategory_Id());
            dto.setId(supirSite.getSupplierSitesId());
            dto.setName(supirSite.getSiteName());
            // dto.setDescription(supirSite.getDescription());
            dto.setCode(supirSite.getSiteCode());
            lookupDTOList.add(dto);
        }
        return lookupDTOList;
    }

    /**
     * getJobTitleOptionsByClientId method fetches list of job title records and
     * maps DTO objects from entity objects.
     * 
     * @param servProviderId
     * @return List<LookUpDTO>
     */
    @Override
    public List<LookupDTO> getJobTitleOptionsByClientId(BigInteger clientId) {
        log.info(" :: getJobTitleOptionsByClientId");
        List<JobTitle> jobTitleList = (List<JobTitle>) clientConfigDao.getJobTitleOptionsByClientId(clientId);
        List<LookupDTO> lookupDTOList = new ArrayList<LookupDTO>();

        LookupDTO dto = null;
        for (JobTitle jobTitle : jobTitleList) {
            dto = new LookupDTO();
            dto.setId(jobTitle.getJobTitleId());
            dto.setName(jobTitle.getJobName());
            dto.setDescription(jobTitle.getDescription());

            lookupDTOList.add(dto);
        }

        return lookupDTOList;
    }

    /**
     * getLanguageOptionsByClientId method fetches list of language records and
     * maps DTO objects from entity objects.
     * 
     * @param clientId
     * @return List<LookUpDTO>
     */
    @Override
    public List<LookupDTO> getLanguageOptionsByClientId(BigInteger clientId) {
        log.info(" :: getLanguageOptionsByClientId");
        List<Language> jobTitleList = (List<Language>) clientConfigDao.getLanguageOptionsByClientId(clientId);
        List<LookupDTO> trqLangLookupList = new ArrayList<LookupDTO>();

        LookupDTO dto = null;
        for (Language jobTitle : jobTitleList) {
            dto = new LookupDTO();
            // dto.setId(cmpType.getCategory_Id());
            dto.setId(jobTitle.getLanguagesId());
            dto.setName(jobTitle.getLanguageName());
            // dto.setDescription(jobTitle.getDescription());
            dto.setCode(jobTitle.getLanguageCode());

            trqLangLookupList.add(dto);
        }

        return trqLangLookupList;
    }

    /**
     * getSecurityQuestions method returns All security Questions list .
     * 
     * @param
     * @return List<SecurityQuestionsDTO>
     */
    public List<SecurityQuestionsDTO> getSecurityQuestions() {

        List<SecurityQuestion> questionList = clientConfigDao.getSecurityQuestions();
        List<SecurityQuestionsDTO> securityQuestionsDtoList = null;
        // mapping from Entiry to DTO
        if (questionList != null) {
            securityQuestionsDtoList = new ArrayList<SecurityQuestionsDTO>();
            for (SecurityQuestion sq : questionList) {
                SecurityQuestionsDTO securityQuestionsDto = new SecurityQuestionsDTO();
                securityQuestionsDto.setSecurityQuestionId(sq.getSecurityQuestionId());
                securityQuestionsDto.setQuestionCode(sq.getQuestionCode());
                securityQuestionsDto.setQuestion(sq.getQuestionName());

                securityQuestionsDtoList.add(securityQuestionsDto);
            }
        }
        return securityQuestionsDtoList;
    }

    @Override
    public List<LookupDTO> getSitesByClientId(BigInteger clientId) {
        log.info(" :: getSitesByClientId");
        List<ClientSite> jobTitleList = (List<ClientSite>) clientConfigDao.getSitesByClientId(clientId);
        List<LookupDTO> trqSiteLookupList = new ArrayList<LookupDTO>();

        LookupDTO dto = null;
        for (ClientSite jobTitle : jobTitleList) {
            dto = new LookupDTO();
            dto.setId(jobTitle.getClientSitesId());

            dto.setCode(jobTitle.getSiteCode());
            dto.setName(jobTitle.getSiteName());

            trqSiteLookupList.add(dto);
        }

        return trqSiteLookupList;
    }

    @Override
    public List<LookupDTO> getSupplierBySupplierId(BigInteger supplierId) {
        log.info(" :: getSitesByClientId");
        List<SupplierSite> jobTitleList = (List<SupplierSite>) clientConfigDao.getSupplierBySupplierId(supplierId);
        List<LookupDTO> trqSiteLookupList = new ArrayList<LookupDTO>();

        LookupDTO dto = null;
        for (SupplierSite jobTitle : jobTitleList) {
            dto = new LookupDTO();
            dto.setId(jobTitle.getSupplierSitesId());
            dto.setCode(jobTitle.getSiteCode());
            dto.setName(jobTitle.getSiteName());

            trqSiteLookupList.add(dto);
        }

        return trqSiteLookupList;
    }

    /**
     * getCategoryOptionsByBusinessId method fetches list of categories records
     * and maps DTO objects from entity objects.
     * 
     * @param clientId,
     *            businessId
     * @return List<Business>
     */
    @Override
    public List<LookupDTO> getCategoryOptionsByBusinessId(BigInteger clientId, BigInteger businessId) {
        log.info(" :: getCategoryList");
        List<ClientCategory> catgryList = (List<ClientCategory>) clientConfigDao
                .getCategoryOptionsByBusinessId(clientId, businessId);
        List<LookupDTO> lookupDTOList = new ArrayList<LookupDTO>();
        LookupDTO dto = null;
        for (ClientCategory cmpType : catgryList) {
            dto = new LookupDTO();
            // dto.setId(cmpType.getCategory_Id());
            // dto.setId(NSFCommon.string2Long(cmpType.getClient().getClientId()));
            // dto.setName(cmpType.getCategoryName());

            dto.setId(cmpType.getClientCategoryId());
            dto.setName(cmpType.getCategoryName());
            dto.setDescription(cmpType.getDescription());

            lookupDTOList.add(dto);
        }
        return lookupDTOList;
    }

    @Override
    public List<LookupDTO> getSitesBySupplierId(BigInteger supplierId) {
        log.info(" :: getSitesByClientId");
        List<SupplierSite> jobTitleList = (List<SupplierSite>) clientConfigDao.getSitesBySupplierId(supplierId);
        List<LookupDTO> trqSiteLookupList = new ArrayList<LookupDTO>();

        LookupDTO dto = null;
        for (SupplierSite jobTitle : jobTitleList) {
            dto = new LookupDTO();
            // dto.setId(cmpType.getCategory_Id());

            dto.setCode(jobTitle.getSiteCode());
            dto.setName(jobTitle.getSiteName());

            trqSiteLookupList.add(dto);
        }

        return trqSiteLookupList;
    }

    @Override
    public List<LookupDTO> getbusinessByClientId(BigInteger clientId) {
        log.info(" :: getSitesByClientId");
        List<ClientBusiness> jobTitleList = (List<ClientBusiness>) clientConfigDao.getbusinessByClientId(clientId);
        List<LookupDTO> trqSiteLookupList = new ArrayList<LookupDTO>();

        LookupDTO dto = null;
        for (ClientBusiness jobTitle : jobTitleList) {
            dto = new LookupDTO();
            // dto.setId(cmpType.getCategory_Id());

            dto.setCode(jobTitle.getBusinessCode());
            dto.setName(jobTitle.getBusinessCode());

            trqSiteLookupList.add(dto);
        }

        return trqSiteLookupList;
    }

    /**
     * getClientPrivilege method making calls to Data access classes.
     * 
     * @param clientId
     * @return String
     */

    @Override
    public String getClientPrivilegeByClientId(Integer clientId) {
        return clientConfigDao.getClientPrivilegeByClientId(clientId);

    }

}
