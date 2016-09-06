package com.nsf.traqtion.business;

import java.math.BigInteger;
import java.util.List;

import com.nsf.traqtion.model.clientmgmt.ClientContactDTO;
import com.nsf.traqtion.model.clientmgmt.ClientSiteDocumentDTO;
import com.nsf.traqtion.model.clientmgmt.ClientSiteDto;
import com.nsf.traqtion.model.clientmgmt.ClientSiteFacilityDto;
import com.nsf.traqtion.model.clientmgmt.ClientSiteNotificationDTO;
import com.nsf.traqtion.model.usermgmt.UserDTO;

public interface ClientSiteMgmtBl {

    /**
     * saveUser method maps DTO to entity objects and creates user record in
     * database by making calls to Data access classes.
     * 
     * @param clientSiteDto
     * @param User
     * @return User
     */
    public Object saveClientSite(ClientSiteDto clientSiteDto);

    /**
     * getClientSiteInfo method fetches clientSites entity based on provided
     * ClientId and maps required properties to ClientSiteDto object.
     * 
     * @param ClientId
     * @return clientSites
     */
    public Object getClientSiteInfo(Long clientId);

    /**
     * addClientSiteFaclity method maps DTO to entity objects and creates
     * ClientSiteFaclity record in database by making calls to Data access
     * classes.
     * 
     * @param clientSiteDto
     * @param ClientSiteFaclity
     * @return ClientSiteFaclity
     */
    public ClientSiteFacilityDto addClientSiteFaclity(Long siteId, ClientSiteFacilityDto ClientSiteFacilityDto);

    /**
     * addClientSiteFaclity method maps DTO to entity objects and delete
     * ClientSite record in database by making calls to Data access classes.
     * 
     * @param clientSiteId
     * @param clientSiteId
     * @return status
     */
    public boolean deleteClienSiteId(String clientSiteId, ClientSiteDto deleteSite);

    /**
     * Save New Client Site Facilities
     * 
     * @param clientId
     * @param clientSiteNotificationDtoObj
     * @return
     */
    public Object saveClientSiteFacilities(Long clientId, ClientSiteFacilityDto clientSiteFacilityDtO);

    /***
     * Get All Facility details of Client Site
     * 
     * @param clientSiteId
     * @return Object
     */
    public Object getAllFacilitiesByClientSiteId(Long clientSiteId);

    /***
     * edit Site Facility details of ClientSite
     * 
     * @param CLientSiteFaclility
     * @return Object
     */
    public ClientSiteFacilityDto editClientSiteFacilitiesByClientId(ClientSiteFacilityDto clientSiteFacilityDto);
    
    
    /**
     * saveClientSiteNotification method maps DTO to entity objects and creates Client Site Notification record in database by making calls to Data access classes.
     * @param clientSiteNotificationDtoObj 
     * 
     * @return Object
     */
    
    public Object saveClientSiteNotification(Integer clientId, ClientSiteNotificationDTO clientSiteNotificationDtoObj);
    
    /***
     * Get All Notification details of Client Site
     * 
     * @param clientSiteId
     * @return Object
     */
    public Object getAllNotificationsByClientSiteId(Integer clientSiteId);
    
    /**
     * Get all the contact Details
     * 
     * @param clientId
     * @return Object
     */
    public Object getContactDetailsBySite(Long clientId);    
    /**
     * saveClientContact method maps DTO to entity objects and save Client Contact record in database by making calls to Data access classes.
     * @param ClientContactDTO
     * @return ClientContactDTO
     */
    public Object saveClientContact(Long clientId ,Long siteId ,ClientContactDTO clientContactDTO);
    
    /**
     * deleteClientContact method deletes Client Contact record from database by making calls to data access classes and returns boolean flag if the operation is successful or not.
     * @param clientContactId, ClientContactDTO
     * @return boolean
     */
    public boolean deleteClientContact(Long clientContactId);
    
    /***
     * Get All Documents of ClientSite
     * 
     * @param clientSiteId
     * @return Object
     */
    public Object getAllDocumnetDetailsByClinetSiteId(Integer clientSiteId);
    
    /**
     * Save New Client Site Documents
     * 
     * @param clientSiteId
     * @param ClientSiteDocumentDTO
     * @return Object
     */
    public Object mergeClientSiteDocumentInfo(Integer clientSiteId, ClientSiteDocumentDTO clientSiteDoc);
    
    /**
     * Delete Client Site Documents Information based on ClientSiteId and docId
     * 
     * @param docId
     * @return Boolean
     */
    public boolean deleteClientSiteDocumentInfo(Integer docId);

}
