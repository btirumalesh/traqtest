package com.nsf.traqtion.business;

import com.nsf.traqtion.data.entity.Client;
import com.nsf.traqtion.data.entity.ClientContact;
import com.nsf.traqtion.model.clientmgmt.ClientContactDTO;
import com.nsf.traqtion.model.clientmgmt.ClientDTO;
import com.nsf.traqtion.model.clientmgmt.ClientDocumentDTO;
import com.nsf.traqtion.model.clientmgmt.ClientSiteNotificationDTO;

/**
 * <h1>Interface for Client Management Business</h1> Provides the Implement the
 * Business service for Client Management
 * <p>
 * 
 * @author HTC Global Services
 */
public interface ClientMgmtBL {

    /**
     * Retrieve the details Get AdditionalDetailsByClientId also hanlded by this
     * mehod
     * 
     * @param clientId
     * @return ClientDTO
     */
    public Object getClientDetailsById(Integer clientId);

    /**
     * Edit a particular Client by His Identity
     * 
     * @param clientObj
     * @return
     */
    public ClientDTO editClientDetailsByClientId(ClientDTO clientDto);

    /**
     * Add an new Client
     * 
     * @param clientObj
     * @return ClientDTO
     */
    public Client addClientInfo(Client clientObj);

    /**
     * NOT Required Get the All contact Details belongs to the client
     * 
     * @param clientId
     * @return
     */

    /**
     * Get all the contact Details
     * 
     * @param clientId
     * @return Object
     */
    public Object getContactDetailsByClientId(Integer clientId);    
    /**
     * saveClientContact method maps DTO to entity objects and save Client Contact record in database by making calls to Data access classes.
     * @param ClientContactDTO
     * @return ClientContactDTO
     */
    public Object saveClientContact(Integer clientId ,ClientContactDTO clientContactDTO);
    
    /**
     * deleteClientContact method deletes Client Contact record from database by making calls to data access classes and returns boolean flag if the operation is successful or not.
     * @param clientContactId, ClientContactDTO
     * @return boolean
     */
    public boolean deleteClientContact(Integer clientContactId);

    /***
     * Get All Doc details of Client
     * 
     * @param clientId
     * @return Object
     */
    public Object getAllDocumnetDetailsByClinetId(Integer clientId);

    /**
     * Save New Doc or Update Existing Doc
     * 
     * @param clientId
     * @param clientObj
     * @return
     */
    public Object mergeDocument(Integer clientId, ClientDocumentDTO clientObj);

    public ClientDTO editDocumentDetails(ClientDTO clientObj);
    
    public boolean deleteDocumentDetails(Integer docId);
   
    
    /***
     * Get Client contacts details by contact ID
     * 
     * @param clientSiteId
     * @return Object
     */
    public Object getContactByClientId(Integer contactId);
}
