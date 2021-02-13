package com.sopehl.cipher;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * <p>
 * Cipher java demo application, explain the how to use Cipher with AES
 * algorithm. Encrypt and Decrypt messages with key but not detail.
 * 
 * <p>
 * If we want to use many security algorithm, we can add the providers
 * statically or dynamically. For example: BouncyCastle is a security provider
 * with new algorithm. To add BouncyCastle statically, add the provider to
 * "<JAVA_HOME>/jre/lib/security/java.security" at the end of the list.
 * 
 * @author okan.pehlivan
 *
 */
public class CipherDemo {
	
	private static final String ENCRYPTION_KEY = "128bitsecretkey!";// 16*8
	
	private static final Boolean CHANGE_ENCRYPTED_DATA = Boolean.FALSE;

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException {

		CryptographyServices cryptographyServices = new CryptographyServices();

		String rawMessage = "This message must be encrypted (top secret!)";

		byte[] keyAsByte = ENCRYPTION_KEY.getBytes();
		byte[] rawMessageAsByte = rawMessage.getBytes();

		byte[] encryptedMessage = cryptographyServices.encrypt(rawMessageAsByte, keyAsByte);
		System.out.println(new String(encryptedMessage));
		
		if(CHANGE_ENCRYPTED_DATA) {
			encryptedMessage[0] = 2;
		}
		
		System.out.println("======= Start decryption =======");
		
		byte[] decryptedMessage = cryptographyServices.decrypt(encryptedMessage, keyAsByte);
		String decryptedRawMessage = new String(decryptedMessage);
		System.out.println(decryptedRawMessage);
		
		if (rawMessage.equals(decryptedRawMessage)) {
			System.out.println("Message is not changed");
		} else {
			System.out.println("Message is changed");
		}

	}

}
