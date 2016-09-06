package com.nsf.traqtion.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.nsf.traqtion.data.dao.UserDaoImpl;
import com.nsf.traqtion.data.entity.User;
import com.nsf.traqtion.model.usermgmt.UserDetailsDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"spring-config.xml"})
public class UserMgmImpl_IT {	
		@Test
		public void getUserById(){
		UserMgmtManagerImpl userMgmtBusinessImpl = new UserMgmtManagerImpl();
		UserDaoImpl userDaoImpl = Mockito.mock(UserDaoImpl.class);
	//	userMgmtBusinessImpl.setUserDao(userDaoImpl);
		User user = new User();
		//user.setEmailId("test@test.com");
		Mockito.when(userDaoImpl.getUserById(new Long(1))).thenReturn(user);
		UserDetailsDTO newUserDto = userMgmtBusinessImpl.getUserById(new Long(1));
		Assert.notNull(newUserDto);	
		}

	}


