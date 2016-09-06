package com.nsf.traqtion.data.dao;

import java.util.List;

import com.nsf.traqtion.data.entity.Client;
import com.nsf.traqtion.data.entity.ClientContact;
import com.nsf.traqtion.data.entity.ClientDocument;
import com.nsf.traqtion.data.entity.ClientSiteNotification;

/**
 * UserDao Interface defines list of methods used to perform operations on Client Management
 * management module
 * 
 * @author HTC Global Services
 *
 */
public interface ClientDao {

    /**
     * getClientById method fetches user entity object based on provided userId.
     * 
     * @param clientId
     * @return User
     */
    public Client getClientById(Integer clientId);

    public Client editClientDetailsByClientId(Client clientObj);

    public Client addClientInfo(Client clientObj);

    public List<ClientContact> getContactByClientId(Integer clientId);
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
    public boolean deleteClientContact(Integer clientContactId);
    

    public List<ClientDocument> getAllDocumnetDetailsByClinetId(Integer clientId);

    public ClientDocument mergeDocument(ClientDocument clientDocument);

    ClientDocument editDocumentDetails(ClientDocument clientDocument);
    
    public boolean deleteDocumentDetails(Integer docId);

}
