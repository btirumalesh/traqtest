package com.nsf.traqtion.business;


import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.nsf.traqtion.data.dao.UserDao;
 
@ContextConfiguration(locations = "classpath:spring-config-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMgmtDaoTest 
{
     
	@Autowired
	private UserDao userDao;

     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddDepartment()
    {
        
    	boolean isUserExists = userDao.isUserExist("pradeep.madasu@htcindia.com");
    			assertTrue(isUserExists);
    }
     
    }
