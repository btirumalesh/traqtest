package com.nsf.traqtion.data.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nsf.traqtion.data.entity.Client;
import com.nsf.traqtion.data.entity.ClientContact;
import com.nsf.traqtion.data.entity.ClientSite;
import com.nsf.traqtion.data.entity.ClientSiteDocument;
import com.nsf.traqtion.data.entity.ClientSiteFacility;
import com.nsf.traqtion.data.entity.ClientSiteNotification;

/**
 * ClientSiteDao implements ClientSiteDaoImpl interface and performs operations
 * on ClientSite management module
 * 
 * @author HTC Global Services
 *
 */

@Transactional
@Repository("ClientSiteDao")
public class ClientSiteDaoImpl extends BaseDaoImpl implements ClientSiteDao {

    private static final Logger log = LogManager.getLogger(ClientSiteDaoImpl.class);

    /**
     * saveClientSite method creates ClientSite record in database and return
     * ClientSite entity object with generated primary key id.
     * 
     * @param ClientSite
     * @return ClientSite
     */
    public ClientSite saveClientSite(ClientSite siteEntity) {
        if (log.isDebugEnabled()) {
            log.info("ClientSiteMgmtDaoImpl :: saveClientSite");
        }
        Long clientId = siteEntity.getClient().getClientId();
        Client clientObj=fetchById(clientId, Client.class);
        siteEntity.setClient(clientObj);
        siteEntity = getEntityManager().merge(siteEntity);
        return siteEntity;
    }

    /**
     * getClientSites method fetches list of all clientSite records available in
     * system.
     * 
     * @param clientId
     * @return List<ClientSite>
     */
    public List<ClientSite> getClientSites(Long clientId) {
        Client clientObj = fetchById(clientId, Client.class);
        TypedQuery<ClientSite> query = getEntityManager().createNamedQuery("ClientSite.findByClient", ClientSite.class);
        query.setParameter("client", clientObj);
        List<ClientSite> results = query.getResultList();

        return results;

    }

    public boolean deleteClientSiteId(String siteId) {
        if (log.isDebugEnabled()) {
            log.info("ClientSiteMgmtDaoImpl :: deleteClientSiteId");
        }
        boolean status = delete(siteId, ClientSite.class);
        return status;
    }

    /**
     * saveClientSiteFacility method creates sityFacility record in database and
     * return ClientSiteFacility entity object with generated primary key id.
     * 
     * @param ClientSiteId
     * @return ClientSiteFacility
     */
    public ClientSiteFacility saveClientSiteFacility(ClientSiteFacility clientSiteFacility) {
        create(clientSiteFacility);
        return clientSiteFacility;

    }

    @Override
    public ClientSiteFacility saveClientSiteFacilities(ClientSiteFacility clientSiteFacility) {
        if (log.isDebugEnabled()) {
            log.debug("ClientSiteFacility :: saveClientSiteFacilities ");
        }
        clientSiteFacility = getEntityManager().merge(clientSiteFacility);
        return clientSiteFacility;
    }

    @Override
    public List<ClientSiteFacility> getAllFacilitiesByClientSiteId(Long clientSiteId) {
        if (log.isDebugEnabled()) {
            log.debug("clientSiteId : " + clientSiteId);
        }
        ClientSite clientSite = fetchById(clientSiteId, ClientSite.class);
        TypedQuery<ClientSiteFacility> query = getEntityManager()
                .createNamedQuery("ClientSiteFacility.findByClientSiteId", ClientSiteFacility.class);
        query.setParameter("clientSite", clientSite);
        List<ClientSiteFacility> results = query.getResultList();
        return results;
    }

    @Override
    public ClientSiteFacility editClientSiteFacilitiesByClientId(ClientSiteFacility clientSiteFacility) {
        if (log.isDebugEnabled()) {
            log.debug("editClientDetailsByClientId : " + clientSiteFacility.getClientSiteFacilityId());
        }
        clientSiteFacility = update(clientSiteFacility);
        return clientSiteFacility;
    }
    
    @Override
    public ClientSiteNotification saveClientSiteNotification(ClientSiteNotification clientSiteNotification) {
        if (log.isDebugEnabled()) {
            log.debug("ClientDaoImpl :: saveClientSiteNotification ");
        }
        clientSiteNotification = getEntityManager().merge(clientSiteNotification);
        return clientSiteNotification;
    }

    @Override
    public List<ClientSiteNotification> getAllNotificationsByClientSiteId(Integer clientSiteId) {
        if (log.isDebugEnabled()) {
            log.debug("clientSiteId : " + clientSiteId);
        }
        TypedQuery<ClientSiteNotification> query = getEntityManager().createNamedQuery("ClientSiteNotification.findByClientSiteId",ClientSiteNotification.class);
        query.setParameter("clientSiteId", new BigInteger(String.valueOf(clientSiteId)));
        List<ClientSiteNotification> results = query.getResultList();
        return results;
    }
    
    
    @Override
    public List<ClientContact> getContactDetailsBySite(Long siteId) {
        log.info(" :: getUserById");
        if(log.isDebugEnabled()){
            log.debug("siteId : "+siteId);
        }
        TypedQuery<ClientContact> query = getEntityManager().createNamedQuery("ClientContact.findBySiteId",ClientContact.class);
        query.setParameter("siteId", siteId);
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
    public boolean deleteClientContact(Long clientContactId) {
        if(log.isDebugEnabled()){
            log.info("ClientMgmtDaoImpl :: deleteClientContact");
        }
        boolean status = delete(clientContactId, ClientContact.class);
        return status;
    }
    
    @Override
    public List<ClientSiteDocument> getAllDocumnetDetailsByClinetSiteId(Integer clientSiteId) {
        log.info(" :: clientSiteId");
        if (log.isDebugEnabled()) {
            log.debug("clientSiteId : " + clientSiteId);
        }
        TypedQuery<ClientSiteDocument> query = getEntityManager().createNamedQuery("ClientSiteDocument.findByClientSiteId",
                ClientSiteDocument.class);
        query.setParameter("clientSite",fetchById(clientSiteId.longValue(), ClientSite.class));
        List<ClientSiteDocument> results = query.getResultList();
        return results;
    }

    @Override
    public ClientSiteDocument mergeClientSiteDocumentInfo(ClientSiteDocument clientSiteDoc) {
        log.info(" :: clientSiteDoc");
        if (log.isDebugEnabled()) {
            log.debug("clientSiteDoc : " + clientSiteDoc);
        }
        Long clientSiteId = clientSiteDoc.getClientSite().getClientSitesId();
        ClientSite clientObj = fetchById(clientSiteId, ClientSite.class);
        clientSiteDoc.setClientSite(clientObj);
        clientSiteDoc = getEntityManager().merge(clientSiteDoc);
        return clientSiteDoc;
    }

    @Override
    public boolean deleteClientSiteDocumentInfo(Integer docId) {
        return delete(BigInteger.valueOf(docId), ClientSiteDocument.class);
    }

}
