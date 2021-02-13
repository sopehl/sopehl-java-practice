package com.sopehl.rsa.security;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class AsymmetricCryptoRSA {

	private Cipher cipher;

	public AsymmetricCryptoRSA() throws NoSuchAlgorithmException, NoSuchPaddingException {
		super();
		this.cipher = Cipher.getInstance("RSA");
	}

	private PrivateKey getPrivateKey() {
		PrivateKey privateKey = null;
		try {
			byte[] privateBytes = Files.readAllBytes(new File("keys" + File.separator + "privateKey").toPath());
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateBytes);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			privateKey = keyFactory.generatePrivate(keySpec);
		} catch (Exception e) {
			System.err.println("Error message - " + e.getMessage());
		}

		return privateKey;
	}

	private PublicKey getPublicKey() {
		PublicKey publicKey = null;
		try {
			byte[] publicBytes = Files.readAllBytes(new File("keys" + File.separator + "publicKey").toPath());
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			publicKey = keyFactory.generatePublic(keySpec);
		} catch (Exception e) {
			System.err.println("Error message - " + e.getMessage());
		}

		return publicKey;
	}

	public byte[] encrypt(byte[] input) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
		try {
			this.cipher.init(Cipher.ENCRYPT_MODE, getPrivateKey());
		}catch (InvalidKeyException e) {
			System.err.println("Please save key pair to the file - message : " + e.getMessage());
		}
		return this.cipher.doFinal(input);
	}

	public byte[] decrypt(byte[] encryptedData) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, UnsupportedEncodingException {
		this.cipher.init(Cipher.DECRYPT_MODE, getPublicKey());
		return this.cipher.doFinal(encryptedData);
	}

}
