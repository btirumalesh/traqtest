package com.nsf.traqtion.data.dao;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nsf.traqtion.data.entity.Client;
import com.nsf.traqtion.data.entity.ClientAddress;
import com.nsf.traqtion.data.entity.ClientContact;
import com.nsf.traqtion.data.entity.ClientDocument;
import com.nsf.traqtion.data.entity.ClientSiteNotification;
import com.nsf.traqtion.data.entity.Country;
import com.nsf.traqtion.data.entity.State;

/**
 * ClientDaoImpl implements ClientDao interface and performs operations on Client Management
 * Client management module
 * 
 * @author HTC Global Services
 *
 */

@Transactional
@Repository("clientDAO")
public class ClientDaoImpl extends BaseDaoImpl implements ClientDao {
    private static final Logger log = LogManager.getLogger(ClientDaoImpl.class);

    @Override
    public Client getClientById(Integer clientId) {
        log.info(" :: clientId");
        if (log.isDebugEnabled()) {
            log.debug("ClientDaoImpl clientId : " + clientId);
        }
        return fetchById(clientId.longValue(), Client.class);
    }

    @Override
    public Client editClientDetailsByClientId(Client clientObj) {
        if (log.isDebugEnabled()) {
            log.debug("editClientDetailsByClientId : " + clientObj.getClientId());
        }
        State siteObj = fetchById(clientObj.getClientAddresses().getState().getStateId(), State.class);
        Country countryObj = fetchById(clientObj.getClientAddresses().getCountry().getCountryId(), Country.class);
        
        ClientAddress clAddr = clientObj.getClientAddresses();
        
        clAddr.setState(siteObj);
        clAddr.setCountry(countryObj);
        clAddr.setClient(clientObj);
        clientObj.setClientAddresses(clAddr);
        clientObj = getEntityManager().merge(clientObj);
        return clientObj;
    }

    @Override
    public Client addClientInfo(Client clientObj) {
        if (log.isDebugEnabled()) {
            log.debug("editClientDetailsByClientId : " + clientObj.getClientId());
        }
        clientObj = (Client) create(clientObj);
        return clientObj;
    }
       
    @Override
    public List<ClientContact> getContactByClientId(Integer clientId) {
        log.info(" :: getUserById");
        if(log.isDebugEnabled()){
            log.debug("userId : "+clientId);
        }
        TypedQuery<ClientContact> query = getEntityManager().createNamedQuery("ClientContact.findByClientId",ClientContact.class);
        query.setParameter("clientId", new Long(String.valueOf(clientId)));
        List<ClientContact> results = query.getResultList();
        return results;
    }
    
    /**
     * saveClientContact method creates ClientContact record in database and return ClientContact entity object with generated primary key id.
     * @param ClientContact
     * @return ClientContact
     */
    public ClientContact saveClientContact(ClientContact clientContactEntity) {
        if(log.isDebugEnabled()){
            log.info("ClientMgmtDaoImpl :: saveClientContact");
        }
        System.out.println(">>>>clientContactEntity clientContactEntity clientContactEntity");
        //create(clientContactEntity);
        //getEntityManager().persist(clientContactEntity);
        clientContactEntity = getEntityManager().merge(clientContactEntity);
        return clientContactEntity;
    }
    
    /**
     * deleteClientContact method deletes Client Contact record from database and returns boolean flag if the operation is successful or not.
     * @param clientContactId
     * @return boolean
     */
    public boolean deleteClientContact(Integer clientContactId) {
        if(log.isDebugEnabled()){
            log.info("ClientMgmtDaoImpl :: deleteClientContact");
        }
        boolean status = delete(clientContactId, ClientContact.class);
        return status;
    }

    @Override
    public List<ClientDocument> getAllDocumnetDetailsByClinetId(Integer clientId) {
        log.info(" :: clientId");
        if (log.isDebugEnabled()) {
            log.debug("clientId : " + clientId);
        }
        TypedQuery<ClientDocument> query = getEntityManager().createNamedQuery("ClientDocument.findByClientId",
                ClientDocument.class);
        query.setParameter("client",fetchById(clientId.longValue(), Client.class));
        List<ClientDocument> results = query.getResultList();

        return results;
    }

    @Override
    public ClientDocument mergeDocument(ClientDocument clientDocument) {
       
        Long clientId = clientDocument.getClient().getClientId();
        Client clientObj = fetchById(clientId, Client.class);
        clientDocument.setClient(clientObj);
        clientDocument = getEntityManager().merge(clientDocument);
        return clientDocument;
    }

    @Override
    public ClientDocument editDocumentDetails(ClientDocument clientDocument) {
        if (log.isDebugEnabled()) {
            log.debug("editDocumentDetails : ");
        }
        clientDocument = update(clientDocument);
        return clientDocument;
    }

    @Override
    public boolean deleteDocumentDetails(Integer docId) {
        return delete(String.valueOf(docId), ClientDocument.class);
    }

}
