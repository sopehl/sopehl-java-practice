package com.sopehl.rsa.key;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * 
 * @author okan.pehlivan
 *
 */
public class KeyGenerator {

	private Integer keyLength;

	private KeyPairGenerator keyPairGenerator;

	private KeyPair keyPair;

	private PrivateKey privateKey;

	private PublicKey publicKey;

	public KeyGenerator(Integer keyLength) throws NoSuchAlgorithmException {
		super();
		this.keyLength = keyLength;
		this.keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		this.keyPairGenerator.initialize(this.keyLength);

		this.keyPair = this.keyPairGenerator.generateKeyPair();
		this.privateKey = this.keyPair.getPrivate();
		this.publicKey = this.keyPair.getPublic();
	}

	/**
	 * To create new key generator
	 * 
	 * @param keyLength key length for RSA like 1024 or 2048
	 * @param saveToFile save private and public key to file as a default
	 * 
	 * @throws NoSuchAlgorithmException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public KeyGenerator(Integer keyLength, Boolean saveToFile)
			throws NoSuchAlgorithmException, FileNotFoundException, IOException {
		this(keyLength);
		if (saveToFile) {
			saveKeyPairs();
		}
	}

	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(PrivateKey privateKey) {
		this.privateKey = privateKey;
	}

	public PublicKey getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(PublicKey publicKey) {
		this.publicKey = publicKey;
	}

	public void saveKeyPairs() throws IOException {
		// private key
		Boolean privateKeySuccess = saveToFile("keys" + File.separator + "privateKey", KeyType.PRIVATE);
		if (privateKeySuccess) {
			System.out.println("Private key saved success");
		} else {
			System.err.println("Private key didn't save");
		}

		Boolean publicKeySuccess = saveToFile("keys" + File.separator + "publicKey", KeyType.PUBLIC);
		if (publicKeySuccess) {
			System.out.println("Public key saved success");
		} else {
			System.err.println("Public key didn't save");
		}

	}

	private Boolean saveToFile(String path, KeyType keyType) throws FileNotFoundException, IOException {
		File keyFile = new File(path);
		keyFile.getParentFile().mkdirs();

		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(keyFile);
			switch (keyType) {
			case PRIVATE:
				fos.write(this.privateKey.getEncoded());
				break;
			default:
				fos.write(this.publicKey.getEncoded());
				break;
			}
		} catch (Exception e) {
			System.err.println("File problem - message: " + e.getMessage());
			return Boolean.FALSE;
		} finally {
			if (fos != null) {
				fos.flush();
				fos.close();
			}
		}

		return Boolean.TRUE;
	}

}
