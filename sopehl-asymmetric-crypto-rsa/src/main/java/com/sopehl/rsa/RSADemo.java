package com.sopehl.rsa;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.sopehl.rsa.key.KeyGenerator;
import com.sopehl.rsa.security.AsymmetricCryptoRSA;

public class RSADemo {

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		KeyGenerator keyGenerator = new KeyGenerator(1024);
		keyGenerator.saveKeyPairs();
		// alternatively, you can save key pairs with constructor(integer, boolean);

		AsymmetricCryptoRSA cryptoRSA = new AsymmetricCryptoRSA();
		System.out.println("------- RSA Crypto Started -------");
		
		String rawData = "Hello RSA!";
		System.out.println("Raw Data to encrypt : " + rawData);
		
		byte[] encryptInput = cryptoRSA.encrypt(rawData.getBytes());
		System.out.println(new String(encryptInput));

		System.out.println("------- After Decryption -------");
		System.out.println(new String(cryptoRSA.decrypt(encryptInput)));
	}

}
