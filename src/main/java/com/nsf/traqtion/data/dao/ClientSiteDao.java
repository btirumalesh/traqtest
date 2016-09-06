package com.nsf.traqtion.data.dao;

import java.util.List;

import com.nsf.traqtion.data.entity.ClientContact;
import com.nsf.traqtion.data.entity.ClientSite;
import com.nsf.traqtion.data.entity.ClientSiteDocument;
import com.nsf.traqtion.data.entity.ClientSiteFacility;
import com.nsf.traqtion.data.entity.ClientSiteNotification;

/**
 * ClientSiteDao Interface defines list of methods used to perform operations on
 * User management module
 * 
 * @author HTC Global Services
 *
 */
public interface ClientSiteDao {
    /**
     * saveClientSite method creates user record in database and return user
     * entity object with generated primary key id.
     * 
     * @param User
     * @return User
     */
    public ClientSite saveClientSite(ClientSite siteEntity);

    /**
     * getClientSites method fetches clientSite entity object based on provided
     * ClientId.
     * 
     * @param clientId
     * @return ClientSite
     */
    public List<ClientSite> getClientSites(Long clientId);

    /**
     * saveClientSiteFacility method creates sityFacility record in database and
     * return ClientSiteFacility entity object with generated primary key id.
     * 
     * @param ClientSiteId
     * @return ClientSiteFacility
     */
    /**
     * deleteClientSiteId method deletes ClientSite record from database and
     * returns boolean flag if the operation is successful or not.
     * 
     * @param clientContactId
     * @return boolean
     */
    public boolean deleteClientSiteId(String clientContactId);

    public ClientSiteFacility saveClientSiteFacility(ClientSiteFacility ClientSiteFacilit);

    /**
     * saveClientSiteFacilities method creates siteFacility record in database
     * and return ClientSiteFaclity entity object with generated primary key id.
     * 
     * @param clientSiteFacility
     * @return ClientSiteFacility
     */
    public ClientSiteFacility saveClientSiteFacilities(ClientSiteFacility clientSiteFacility);

    /***
     * Get All Facilities of Client Site
     * 
     * @param clientSiteId
     * @return Object
     */
    public List<ClientSiteFacility> getAllFacilitiesByClientSiteId(Long clientSiteId);

    /***
     * edit All Facilities of Client Site faclility
     * 
     * @param clientSiteFaclity
     * @return Object
     */
    public ClientSiteFacility editClientSiteFacilitiesByClientId(ClientSiteFacility clientSiteFacility);
    
    /**
     * Save New Client Site Notification details
     * 
     * @param clientSiteNotificationObj
     * @return ClientSiteNotification
     */
    public ClientSiteNotification saveClientSiteNotification(ClientSiteNotification clientSiteNotificationObj);
    
    /**
     *  Get All Notification details of Client Site
     * 
     * @param clientSiteId
     * @return List<ClientSiteNotification>
     */
    public List<ClientSiteNotification> getAllNotificationsByClientSiteId(Integer clientSiteId);
    
    
    public Object getContactDetailsBySite(Long siteId);
    /**
     * saveClientContact method creates ClientContact record in database and return ClientContact entity object with generated primary key id.
     * @param ClientContact
     * @return ClientContact
     */
    public ClientContact saveClientContact(ClientContact clientContactEntity);
    
    /**
     * deleteClientContact method deletes Client Contact record from database and returns boolean flag if the operation is successful or not.
     * @param clientContactId
     * @return boolean
     */
    public boolean deleteClientContact(Long clientContactId);
    
    /***
     * Get All Documents of Client Site
     * 
     * @param clientSiteId
     * @return List<ClientSiteDocument>
     */
    public List<ClientSiteDocument> getAllDocumnetDetailsByClinetSiteId(Integer clientSiteId);

    /**
     * mergeClientSiteDocumentInfo method creates siteSocument record in database
     * and return ClientSiteDocument entity object with generated primary key id.
     * 
     * @param ClientSiteDocument
     * @return ClientSiteDocument
     */
    public ClientSiteDocument mergeClientSiteDocumentInfo(ClientSiteDocument clientSiteDoc);

    /**
     * deleteClientSiteDocumentInfo method deletes ClientSite Document record from database and
     * returns boolean flag if the operation is successful or not.
     * 
     * @param docId
     * @return boolean
     */
    public boolean deleteClientSiteDocumentInfo(Integer docId);
    
}
