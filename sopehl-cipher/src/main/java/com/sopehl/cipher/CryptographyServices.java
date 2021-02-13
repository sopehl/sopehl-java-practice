package com.sopehl.cipher;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class CryptographyServices {

	/**
	 * encrypt the plain-text with cipher AES
	 * 
	 * @param rawMessage plain text message
	 * @param key        security key
	 * 
	 * @return encrypted message as byte
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 */
	public byte[] encrypt(byte[] rawMessage, byte[] key) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		// symmetric key generator for AES algorithm.
		SecretKey secretKey = new SecretKeySpec(key, "AES");

		// AES Cipher
		// ECB(Electronic Codebook) mode of operation
		// PKCS5 padding scheme.
		// we can also instantiate the Cipher object with only the algorithm 'AES'.
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);

		return cipher.doFinal(rawMessage);
	}

	public byte[] decrypt(byte[] encryptMessage, byte[] key) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		SecretKey secretKey = new SecretKeySpec(key, "AES");
		
		// AES Cipher
		// ECB(Electronic Codebook) mode of operation
		// PKCS5 padding scheme.
		// we can also instantiate the Cipher object with only the algorithm 'AES'.
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, secretKey);

		return cipher.doFinal(encryptMessage);
	}

}
