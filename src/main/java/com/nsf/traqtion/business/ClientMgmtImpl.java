package com.nsf.traqtion.business;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsf.traqtion.data.dao.ClientDao;
import com.nsf.traqtion.data.entity.Client;
import com.nsf.traqtion.data.entity.ClientAddress;
import com.nsf.traqtion.data.entity.ClientContact;
import com.nsf.traqtion.data.entity.ClientContactAddress;
import com.nsf.traqtion.data.entity.ClientDocument;
import com.nsf.traqtion.data.entity.ClientSiteNotification;
import com.nsf.traqtion.data.entity.Country;
import com.nsf.traqtion.data.entity.State;
import com.nsf.traqtion.model.clientmgmt.ClientAddressDTO;
import com.nsf.traqtion.model.clientmgmt.ClientContactDTO;
import com.nsf.traqtion.model.clientmgmt.ClientDTO;
import com.nsf.traqtion.model.clientmgmt.ClientDocumentDTO;
import com.nsf.traqtion.model.clientmgmt.ClientSiteNotificationDTO;

@Service("clientMgmt")
public class ClientMgmtImpl implements ClientMgmtBL {

    private static final Logger log = LogManager.getLogger(ClientMgmtImpl.class);

    @Autowired
    private ClientDao clientDAO;

    private ModelMapper modelMapper;

    public ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
        }
        return modelMapper;
    }

    @Override
    public Object getClientDetailsById(Integer clientId) {
        return clientDAO.getClientById(clientId);
    }

    @Override
    public ClientDTO editClientDetailsByClientId(ClientDTO clientDto) {
        Client clientObj = new Client();
        State stateObj = new State();
        stateObj.setStateId(String.valueOf(clientDto.getClientAddress().getStateId()));
        Country countryObj = new Country();
        countryObj.setCountryId(String.valueOf(clientDto.getClientAddress().getCountryId()));        
        BeanUtils.copyProperties(clientDto, clientObj);
        
        ClientAddress ctAddr =  new ClientAddress();
        ClientAddressDTO clAdrDto = clientDto.getClientAddress();
        BeanUtils.copyProperties(clAdrDto, ctAddr);
        clientObj.setClientAddresses(ctAddr);
        clientObj.getClientAddresses().setCountry(countryObj);
        clientObj.getClientAddresses().setState(stateObj);
        clientObj = clientDAO.editClientDetailsByClientId(clientObj);
        BeanUtils.copyProperties(clientObj, clientDto);

        return clientDto;
    }

    @Override
    public Client addClientInfo(Client clientObj) {
        clientObj = clientDAO.addClientInfo(clientObj);
        return clientObj;
    }

    @Override
    public Object getAllDocumnetDetailsByClinetId(Integer clientId) {
        List<ClientDocument> listDoc = clientDAO.getAllDocumnetDetailsByClinetId(clientId);
        List<ClientDocumentDTO> listDocDto = new ArrayList<>(listDoc.size());
        for(ClientDocument clientDoc : listDoc){
            ClientDocumentDTO _docDto = new ClientDocumentDTO();
            BeanUtils.copyProperties(clientDoc, _docDto);
            listDocDto.add(_docDto);
        }
        return listDocDto;
    }

    @Override
    public Object mergeDocument(Integer clientId, ClientDocumentDTO clientDto) {
        ClientDocument clientDoc = new ClientDocument();
        BeanUtils.copyProperties(clientDto, clientDoc);
        clientDoc.setClient(new Client());
        clientDoc.getClient().setClientId(clientId.longValue());
        clientDoc = clientDAO.mergeDocument(clientDoc);
        BeanUtils.copyProperties(clientDoc,clientDto);
        return clientDto;
    }

    @Override
    public ClientDTO editDocumentDetails(ClientDTO clientObj) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getContactDetailsByClientId(Integer clientId) {
        Object clientContactList = clientDAO.getContactByClientId(clientId);
        log.debug("ClientMgmtImpl getContactDetailsByClientId Obj :: " + clientContactList);
        return clientContactList;
    }
    
    /**
     * saveClientContact method maps DTO to entity objects and save Client Contact record in database by making calls to Data access classes.
     * @param ClientContactDTO
     * @return Object
     */
    public Object saveClientContact(Integer clientId,ClientContactDTO clientContactDTO) {
        log.info("ClientMgmtManagerImpl :: saveClientContact");
        Client clientObj = new Client();
        clientObj.setClientId(clientId.longValue());
        ClientContact clientContactEntity = new ClientContact();
        clientContactDTO.setClient(clientObj);
        clientContactEntity.setClient(clientObj);
        //clientContactEntity.setClientContactAddresses(new ClientContactAddress());
        BeanUtils.copyProperties(clientContactDTO, clientContactEntity);
        ClientContactAddress clAdrr = clientContactDTO.getClientContactAddresses();
       // BeanUtils.copyProperties(clientContactDTO.getClientContactAddresses(), _clentContact);
        clientContactEntity.addClientContactAddress(clAdrr);
        clientContactEntity = clientDAO.saveClientContact(clientContactEntity);
        BeanUtils.copyProperties(clientContactEntity,clientContactDTO);
        return clientContactDTO;
    }
    
    
    /**
     * deleteClientContact method deletes Client Contact record from database by making calls to data access classes and returns boolean flag if the operation is successful or not.
     * @param clientContactId, ClientContactDTO
     * @return boolean
     */
    public boolean deleteClientContact(Integer clientContactId) {
        log.info("ClientMgmtManagerImpl :: deleteClientContact");
        if(log.isDebugEnabled()){
            log.debug("userId : "+clientContactId);
        }
        boolean status = true;
        status = clientDAO.deleteClientContact(clientContactId);
        return status;
    }

    @Override
    public boolean deleteDocumentDetails(Integer docId) {
        return clientDAO.deleteDocumentDetails(docId);
    }

    @Override
    public Object getContactByClientId(Integer contactId) {
        List<ClientContact> contactList = clientDAO.getContactByClientId(contactId);
        return contactList;
    }
}
