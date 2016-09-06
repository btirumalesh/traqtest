package com.nsf.traqtion.util;

import com.nsf.traqtion.exception.NSFException;
import com.nsf.traqtion.exception.NSFExceptionType;
import com.nsf.traqtion.model.common.EncryptionManager;

public class NSFCommon {
	
	private static final String SEPARATOR = "_";
	
 public static long string2Long(String ipStrVal)
 {
	 return (ipStrVal != null && !ipStrVal.trim().equals("")) ? Long.parseLong(ipStrVal) : 0;
 }
 
 
 /**
  * getEpochTime() method returns string with current time milliseconds 
  * @return
  */
 public static String getEpochTime() {
		long time = System.currentTimeMillis();
		return Long.toString(time);
	}
 
 /**
	 * generateToken method takes userid and email id and generates token with separator and encrypt token and return encrypted token
	 * 
	 * @param userId
	 * @return accessKey
	 */
	public static String generateToken(Long userId, String emailId){
		
		String encryptToken = null;
		String token = new StringBuffer().append(userId).append(SEPARATOR)
				.append(DateUtil.getCurrentTimeStamp()).append(SEPARATOR).append(emailId).toString();
		try{
			encryptToken = EncryptionManager.encryptToken(token);
		}catch(Exception ex){
			throw new NSFException(NSFExceptionType.BUSINESS_EXCEPTION,ex);
		}
		return encryptToken;
	}
	
	/**
	 * This method fetches decrypts given token and split the token with seperator and fetched user Id from token
	 * @param token
	 * @return
	 */
	public static Long getUserIdFromToken(String token){
		Long userId = null;
		String decryptToken = null;
		try{
			decryptToken = EncryptionManager.decryptToken(token);
		}catch(Exception ex){
			throw new NSFException(NSFExceptionType.BUSINESS_EXCEPTION,ex);
		}
		 String[] tokens = decryptToken.split("_");
		 String userIdFromToken = tokens[0];
		 userId = Long.parseLong(userIdFromToken);
		 
		return userId;
	}
}
