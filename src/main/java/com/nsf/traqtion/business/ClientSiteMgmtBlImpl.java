package com.nsf.traqtion.business;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsf.traqtion.data.dao.ClientSiteDao;
import com.nsf.traqtion.data.entity.Client;
import com.nsf.traqtion.data.entity.ClientContact;
import com.nsf.traqtion.data.entity.ClientContactAddress;
import com.nsf.traqtion.data.entity.ClientSite;
import com.nsf.traqtion.data.entity.ClientSiteDocument;
import com.nsf.traqtion.data.entity.ClientSiteFacility;
import com.nsf.traqtion.data.entity.ClientSiteNotification;
import com.nsf.traqtion.model.clientmgmt.ClientContactDTO;
import com.nsf.traqtion.model.clientmgmt.ClientSiteDocumentDTO;
import com.nsf.traqtion.model.clientmgmt.ClientSiteDto;
import com.nsf.traqtion.model.clientmgmt.ClientSiteFacilityDto;
import com.nsf.traqtion.model.clientmgmt.ClientSiteNotificationDTO;

/**
 * ClientSiteMgmtBlImpl Class implements business methods to perform business
 * operations on clientSite management module by making calls to Data access
 * classes.
 * 
 * @author HTC Global Services
 *
 */
@Service("clientSiteMgmtBusiness")
public class ClientSiteMgmtBlImpl implements ClientSiteMgmtBl {

    private static final Logger log = LogManager.getLogger(ClientSiteMgmtBlImpl.class);
    // auto wiring userDao class
    @Autowired
    private ClientSiteDao clientSiteDao;
    private Date date = null;

    /**
     * saveClientSite method maps DTO to entity objects and creates ClientSite
     * record in database by making calls to Data access classes.
     * 
     * @param ClientSite
     * @return ClientSite
     */
    public Object saveClientSite(ClientSiteDto clientSiteDto) {

        log.info(":: saveClientSite");
        ClientSite siteEntity = new ClientSite();
        BeanUtils.copyProperties(clientSiteDto, siteEntity);
        siteEntity = clientSiteDao.saveClientSite(siteEntity);
        BeanUtils.copyProperties(siteEntity, clientSiteDto);
        return siteEntity;
    }

    /**
     * getClientSiteInfo method fetches ClientSite entity based on provided
     * clientId and maps required properties to ClientSiteDto object.
     * 
     * @param clientId
     * @return ClientSite
     */
    public Object getClientSiteInfo(Long clientId) {
        log.info(":: clientId");
        if (log.isDebugEnabled()) {
            log.debug("clientId : " + clientId);
        }
        Object clientSiteDtoList = null;
        // call to dao method
        clientSiteDtoList = clientSiteDao.getClientSites(clientId);

        return clientSiteDtoList;
    }

    /**
     * addClientSiteFaclity method maps DTO to entity objects and creates
     * ClientSiteFaclity record in database by making calls to Data access
     * classes.
     * 
     * @param clientSiteDto
     * @param ClientSiteFaclity
     * @return ClientSiteFaclity
     */
    public boolean deleteClienSiteId(String clientSiteId, ClientSiteDto deleteSite) {
        log.info("ClientSiteMgmtImpl :: deleteClientSite");
        if (log.isDebugEnabled()) {
            log.debug("userId : " + clientSiteId);
        }
        boolean status = true;
        status = clientSiteDao.deleteClientSiteId(clientSiteId);
        return status;

    }

    public ClientSiteFacilityDto addClientSiteFaclity(Long siteId, ClientSiteFacilityDto clientSiteFacilityDto) {
        log.info(":: saveClientSitefacility");
        ClientSiteFacility clientSiteFacility = new ClientSiteFacility();
        // clientSiteFacility.setDateChanged(new Timestamp(0));
        // clientSiteFacility.setClientSiteFacilityId(222);
        // clientSiteFacility.setFacilityType(4000);
        // clientSiteFacility.setNotes("dsadsa");
        // clientSiteFacility.setChargedBy("sfsdf");
        ClientSite site = new ClientSite();
        site.setClientSitesId(siteId);
        clientSiteFacilityDto.setClientSite(site);

        BeanUtils.copyProperties(clientSiteFacilityDto, clientSiteFacility);
        clientSiteFacility = clientSiteDao.saveClientSiteFacility(clientSiteFacility);

        BeanUtils.copyProperties(clientSiteFacility, clientSiteFacilityDto);

        return clientSiteFacilityDto;
    }

    @Override
    public Object saveClientSiteFacilities(Long clientId, ClientSiteFacilityDto clientSiteFacilityDtO) {
        ClientSiteFacility clientSiteFacility = new ClientSiteFacility();
        BeanUtils.copyProperties(clientSiteFacilityDtO, clientSiteFacility);
        clientSiteFacility = clientSiteDao.saveClientSiteFacilities(clientSiteFacility);
        return clientSiteFacility;
    }

    @Override
    public Object getAllFacilitiesByClientSiteId(Long clientSiteId) {
        List<ClientSiteFacility> facilitiesList = clientSiteDao.getAllFacilitiesByClientSiteId(clientSiteId);
        return facilitiesList;
    }

    @Override
    public ClientSiteFacilityDto editClientSiteFacilitiesByClientId(ClientSiteFacilityDto clientSiteFacilityDto) {
        ClientSiteFacility facilityObj = new ClientSiteFacility();
        BeanUtils.copyProperties(clientSiteFacilityDto, facilityObj);
        facilityObj = clientSiteDao.editClientSiteFacilitiesByClientId(facilityObj);
        BeanUtils.copyProperties(facilityObj, clientSiteFacilityDto);

        return clientSiteFacilityDto;
    }
    
    @Override
    public Object saveClientSiteNotification(Integer clientId, ClientSiteNotificationDTO clientSiteNotificationDtoObj) {
        ClientSiteNotification clientSiteNotification = new ClientSiteNotification();
        BeanUtils.copyProperties(clientSiteNotificationDtoObj, clientSiteNotification);
        clientSiteNotification.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        clientSiteNotification = clientSiteDao.saveClientSiteNotification(clientSiteNotification);
        return clientSiteNotification;
    }

    @Override
    public Object getAllNotificationsByClientSiteId(Integer clientSiteId) {
        List<ClientSiteNotification> notificationList = clientSiteDao.getAllNotificationsByClientSiteId(clientSiteId);
        return notificationList;
    }
    

    @Override
    public Object getContactDetailsBySite(Long siteId) {
        Object clientContactList = clientSiteDao.getContactDetailsBySite(siteId);
        log.debug("ClientMgmtImpl getContactDetailsByClientId Obj :: " + clientContactList);
        return clientContactList;
    }
    
    /**
     * saveClientContact method maps DTO to entity objects and save Client Contact record in database by making calls to Data access classes.
     * @param ClientContactDTO
     * @return Object
     */
    @Override
    public Object saveClientContact(Long clientId ,Long siteId ,ClientContactDTO clientContactDTO) {
        log.info("ClientMgmtManagerImpl :: saveClientContact");
        
        ClientContact clientContactEntity = new ClientContact();        
        
        ClientSite siteObj = new ClientSite();
        siteObj.setClientSitesId(siteId);
        clientContactDTO.setClientSite(siteObj);
        
        Client clientObj = new Client();
        clientObj.setClientId(clientId);
        siteObj.setClient(clientObj);
        clientContactDTO.setClient(clientObj);
        
        BeanUtils.copyProperties(clientContactDTO, clientContactEntity);
        ClientContactAddress clAdrr = clientContactDTO.getClientContactAddresses();
        clientContactEntity.addClientContactAddress(clAdrr);
        clientContactEntity = clientSiteDao.saveClientContact(clientContactEntity);
        BeanUtils.copyProperties(clientContactEntity,clientContactDTO);
        return clientContactDTO;
    }
    
    /**
     * deleteClientContact method deletes Client Contact record from database by making calls to data access classes and returns boolean flag if the operation is successful or not.
     * @param clientContactId, ClientContactDTO
     * @return boolean
     */
    @Override
    public boolean deleteClientContact(Long clientContactId) {
        log.info("ClientMgmtManagerImpl :: deleteClientContact");
        if(log.isDebugEnabled()){
            log.debug("userId : "+clientContactId);
        }
        boolean status = true;
        status = clientSiteDao.deleteClientContact(clientContactId);
        return status;
    }
    
    @Override
    public Object getAllDocumnetDetailsByClinetSiteId(Integer clientSiteId) {
        List<ClientSiteDocument> listDoc = clientSiteDao.getAllDocumnetDetailsByClinetSiteId(clientSiteId);
        List<ClientSiteDocumentDTO> listDocDto = new ArrayList<ClientSiteDocumentDTO>(listDoc.size());
        for (ClientSiteDocument clientDoc : listDoc) {
            ClientSiteDocumentDTO _docDto = new ClientSiteDocumentDTO();
            BeanUtils.copyProperties(clientDoc, _docDto);
            listDocDto.add(_docDto);
        }
        return listDocDto;
    }

    @Override
    public Object mergeClientSiteDocumentInfo(Integer clientSiteId, ClientSiteDocumentDTO clientSiteDocDTO) {
        ClientSiteDocument clientSiteDoc = new ClientSiteDocument();
        BeanUtils.copyProperties(clientSiteDocDTO, clientSiteDoc);
        clientSiteDoc.setClientSite(new ClientSite());
        clientSiteDoc.getClientSite().setClientSitesId(clientSiteId.longValue());
        clientSiteDoc = clientSiteDao.mergeClientSiteDocumentInfo(clientSiteDoc);
        BeanUtils.copyProperties(clientSiteDoc,clientSiteDocDTO);
        return clientSiteDocDTO;
    }

    @Override
    public boolean deleteClientSiteDocumentInfo(Integer docId) {
        return clientSiteDao.deleteClientSiteDocumentInfo(docId);
    }
}
