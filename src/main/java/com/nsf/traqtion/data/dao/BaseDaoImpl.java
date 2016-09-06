package com.nsf.traqtion.data.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * BaseDaoImpl class acts as a base class for all data access implementation class which has
 * common methods to perform CURD operation and 
 * @author HTC Global Services
 *
 */
public class BaseDaoImpl {

	    @PersistenceContext
	    private EntityManager entityManager;
	        
	    protected EntityManager getEntityManager() {
            return entityManager;
        }

        /**
	     * Create method take entity object as parameter and persists entity to database.
	     * @param entity
	     * @return <T>
	     */
	    public <T> Serializable create(final T entity) {
	    	entityManager.persist(entity);      
    		return (Serializable) entity;      
	    }
	    
	    /**
	     * Create method take entity object as parameter and updates entity to database.
	     * @param entity
	     * @return <T>
	     */
	    public <T> T update(final T entity) {
	    	entityManager.merge(entity);    
	        return entity;
	    }
	    
	    /**
	     * delete method take entity class object as parameter and removed row matching the entity from database.
	     * @param id
	     * @param entityClass
	     */
	    public <T> void delete(final T entity) {
	    	entityManager.remove(entity);
	    }

	    /**
	     * delete method take primary key id and entity class type as parameter and removed the entry from database.
	     * @param id
	     * @param entityClass
	     */
	    public <T> boolean delete(Serializable id, Class<T> entityClass) {
	        boolean status = true;
	    	T entity = fetchById(id, entityClass);
	        if(null == entity){
	        	status = false;
	        }
	    	delete(entity);
	        return status;
	    }
	    
	    /**
	     * fetchAll method retrieves list of all entity object available in system 
	     * @param entityClass
	     * @return
	     */
	    @SuppressWarnings("unchecked")  
	    public <T> List<T> fetchAll(Class<T> entityClass) {        
	    	 return entityManager.createQuery(" FROM "+entityClass.getName()).getResultList();        
	    }
	  
	    /**
	     * fetchAll method retrieves list entity objects based on query passed as parameter.
	     * @param entityClass
	     * @return
	     */
	    @SuppressWarnings("rawtypes")
	    public <T> List fetchAll(String query) {        
	    	return entityManager.createQuery(query).getResultList();        
	    }
	    
	    /**
	     * fetchById method retrieves single entity object based on primary key id and entiry class type provided
	     * @param entityClass
	     * @return
	     */
	    @SuppressWarnings("unchecked")
	    public <T> T fetchById(Serializable id, Class<T> entityClass) {
	    	return entityManager.find(entityClass, id);
	    }   
	    
	    @SuppressWarnings("unchecked")
	    public <T> T fetchByName(String name,String mappingName) {
	    	T t = null;
	    	Query query = entityManager.createNativeQuery("select id , firstName ,lastName from NSF_USERS where firstName = :name",mappingName);
	    	query.setParameter("name", name);
	    	
	        return (T) query.getResultList();
	    }  
}
