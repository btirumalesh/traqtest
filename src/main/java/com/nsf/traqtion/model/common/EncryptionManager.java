package com.nsf.traqtion.model.common;

import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * EncryptionManager
 * 
 * This class is used to encrypt and decrypt a content by AES 128 Algorithm. SHA-256 Hashing technique to hashing the passwords
 * 
 * 
 * @author HTC Global Services
 *
 */
public class EncryptionManager {

	// AES algorithm
	private static final String AES_ALGORITHM = "AES";
	// SHA256 algorithm
	private static final String SHA_256_ALGORITHM = "SHA-256";
	// Secret Key with (16 bytes * 8) 128 bits
	private static final byte[] SECRET_KEY = new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r', 'e',
			't', 'K', 'e', 'y' };

	/**
	 * encrypt
	 * 
	 * method to encrypt the content by using secret key value and AES Algorithm
	 * 
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String content) throws Exception {
		Key key = generateSecretKey();
		Cipher c = Cipher.getInstance(AES_ALGORITHM);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(content.getBytes());
		encVal = Base64.getEncoder().encode(encVal);
		// encVal = BASE64EncoderStream.encode(encVal);
		return new String(encVal);
	}

	/**
	 * decrypt
	 * 
	 * method to decrypt the content by AES and secret key
	 * 
	 * @param encryptedData
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String encryptedData) throws Exception {
		Key key = generateSecretKey();
		Cipher c = Cipher.getInstance(AES_ALGORITHM);
		c.init(Cipher.DECRYPT_MODE, key);
		byte[] decordedValue = Base64.getDecoder().decode(encryptedData.getBytes());
		// byte[] decordedValue =
		// BASE64DecoderStream.decode(encryptedData.getBytes());
		byte[] decValue = c.doFinal(decordedValue);
		String decryptedValue = new String(decValue);
		return decryptedValue;
	}

	/**
	 * generateSecretKey
	 * 
	 * method to generate a secret key
	 * 
	 * @return
	 * @throws Exception
	 */
	private static Key generateSecretKey() throws Exception {
		Key key = new SecretKeySpec(SECRET_KEY, AES_ALGORITHM);
		return key;
	}

	/**
	 * convertStringToHex
	 * 
	 * @param str
	 * @return
	 */
	public static String convertStringToHex(String str) {
		char[] chars = str.toCharArray();
		StringBuffer hex = new StringBuffer();
		for (int i = 0; i < chars.length; i++) {
			hex.append(Integer.toHexString((int) chars[i]));
		}
		return hex.toString();
	}

	/**
	 * convertHexToString
	 * 
	 * @param hex
	 * @return
	 */
	public static String convertHexToString(String hex) {

		StringBuilder sb = new StringBuilder();
		// 49204c6f7665204a617661 split into two characters 49, 20, 4c...
		for (int i = 0; i < hex.length() - 1; i += 2) {
			// grab the hex in pairs
			String output = hex.substring(i, (i + 2));
			// convert hex to decimal
			int decimal = Integer.parseInt(output, 16);
			// convert the decimal to character
			sb.append((char) decimal);
		}
		return sb.toString();
	}

	/**
	 * encryptToken method encrypt given string with AES encryption and convert
	 * encryption string to hex code
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public static String encryptToken(String value) throws Exception {
		String encryptString = null;
		encryptString = EncryptionManager.encrypt(value);
		encryptString = EncryptionManager.convertStringToHex(encryptString);
		return encryptString;
	}

	/**
	 * decryptToken method decrypt give string and convert hex code to string
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public static String decryptToken(String value) throws Exception {
		String decryptString = null;
		decryptString = EncryptionManager.convertHexToString(value);
		decryptString = EncryptionManager.decrypt(decryptString);
		return decryptString;
	}

	/**
	 * securePassword method uses SHA-256 algorithm to hash the given string
	 * with give salt key
	 * 
	 * @param passwordToHash
	 * @param salt
	 * @return
	 * @throws Exception
	 */
	public static String securePassword(String passwordToHash, byte[] salt) throws Exception {
		String generatedPassword = null;
		MessageDigest md = MessageDigest.getInstance(SHA_256_ALGORITHM);
		md.update(salt);
		byte[] bytes = md.digest(passwordToHash.getBytes());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		generatedPassword = sb.toString();
		return generatedPassword;
	}

	/**
	 * getSalt method return static salt key bytes
	 * 
	 * @return
	 * @throws Exception
	 */
	public static byte[] getSalt() throws Exception {

		byte[] salt = new byte[] { 'N', 'S', 'F', 'T', 'r', 'a', 'Q', 't', 'i', 'o', 'n', 'S', 'L', 'K', 'e', 'y' };
		;
		return salt;
	}

	/**
	 * getRandomSalt() method generates random salt each time method is called
	 * 
	 * @return
	 * @throws Exception
	 */
	public static byte[] getRandomSalt() throws Exception {
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[16];
		sr.nextBytes(salt);
		return salt;
	}

	public static void main(String a[]) {

		String str1 = "001-198201611:03:44:33-test@test.com";
		try {
			String encryptString = EncryptionManager.encrypt(str1);
			String HexString = convertStringToHex(encryptString);
			System.out.println("encryptString ::" + encryptString);
			System.out.println("Str to Hex ::" + HexString);
			System.out.println("encryptToken String str1 :" + encryptToken(str1));
			String decryptString = EncryptionManager.decrypt(encryptString);
			System.out.println("Hex to Str ::" + convertHexToString(HexString));
			System.out.println("decryptString ::" + decryptString);
			System.out.println("decryptToken String hex to string ::" + decryptToken(HexString));
			System.out.println("salt " + Arrays.toString(getSalt()));

			System.out.println("password hash 1: " + securePassword("NSF", getSalt()));
			System.out.println("password hash 2: " + securePassword("NSF", getSalt()));
			System.out.println("password hash 3: " + securePassword("Traqtion", getSalt()));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}