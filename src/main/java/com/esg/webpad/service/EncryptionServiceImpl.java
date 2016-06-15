package com.esg.webpad.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.esg.webpad.exception.EncryptionException;

public enum EncryptionServiceImpl implements EncryptionService {
	
	INSTANCE;
	
	private PrivateKey privateKey;
	private PublicKey publicKey;
	private Cipher cipher;
	private Logger logger = Logger.getLogger(EncryptionServiceImpl.class);
	
	private EncryptionServiceImpl() {
		try {
			File privateKeyFile = new File(System.getProperty("user.home") + File.separator + "notepad_priv_key.prv");
			File publicKeyFile = new File(System.getProperty("user.home") + File.separator + "notepad_pub_key.pub");
			cipher = Cipher.getInstance("RSA");
			if(privateKeyFile.exists()) {
				X509EncodedKeySpec publicSpec = new X509EncodedKeySpec(FileUtils.readFileToByteArray(publicKeyFile));
				PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(FileUtils.readFileToByteArray(privateKeyFile));
				KeyFactory keyFactory = KeyFactory.getInstance(cipher.getAlgorithm());
				publicKey = keyFactory.generatePublic(publicSpec);
				privateKey = keyFactory.generatePrivate(privateKeySpec);
			}
			else {
				KeyPairGenerator keyGen = KeyPairGenerator.getInstance(cipher.getAlgorithm());
				SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
				keyGen.initialize(1204, random);
				KeyPair pair = keyGen.generateKeyPair();
				privateKey = pair.getPrivate();
				publicKey = pair.getPublic();
				FileUtils.writeByteArrayToFile(privateKeyFile, privateKey.getEncoded());
				FileUtils.writeByteArrayToFile(publicKeyFile, publicKey.getEncoded());
			}
		} catch(IOException e) {
			logger.error("Could not initialize private/public key", e);
		} catch (NoSuchAlgorithmException e) {
			logger.error("Could not initialize private/public key", e);
		} catch (InvalidKeySpecException e) {
			logger.error("Could not initialize private/public key", e);
		} catch (NoSuchPaddingException e) {
			logger.error("Could not initialize private/public key", e);
		} 
	}
	
	@Override
	public String encrypt(String unencryptedData) throws EncryptionException {
		try {
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			byte[] encryptedMessage = blockCipher(unencryptedData.getBytes(StandardCharsets.UTF_8), Cipher.ENCRYPT_MODE);
			byte[] encodedBytes = Base64.getEncoder().encode(encryptedMessage);
			return new String(encodedBytes);
		} catch (InvalidKeyException e) {
			throw new EncryptionException("Could not encrypt data", e);
		} catch (IllegalBlockSizeException e) {
			throw new EncryptionException("Could not encrypt data", e);
		} catch (BadPaddingException e) {
			throw new EncryptionException("Could not encrypt data", e);
		}
	}

	@Override
	public String decrypt(String encryptedData) throws EncryptionException {
		try {
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] decodedBytes = Base64.getDecoder().decode(encryptedData.getBytes(StandardCharsets.UTF_8));
			byte[] decryptedBytes = blockCipher(decodedBytes, Cipher.DECRYPT_MODE);
			return new String(decryptedBytes);
		} catch (InvalidKeyException e) {
			throw new EncryptionException("Could not decrypt data", e);
		} catch (IllegalBlockSizeException e) {
			throw new EncryptionException("Could not decrypt data", e);
		} catch (BadPaddingException e) {
			throw new EncryptionException("Could not decrypt data", e);
		} 
	}
	
	private byte[] blockCipher(byte[] bytes, int mode) throws IllegalBlockSizeException, BadPaddingException {
		byte[] scrambled = new byte[0];
		byte[] toReturn = new byte[0];

		int length = (mode == Cipher.ENCRYPT_MODE)? 100 : 128;

		// another buffer. this one will hold the bytes that have to be modified in this step
		byte[] buffer = new byte[length];

		for (int i=0; i< bytes.length; i++){

			// if we filled our buffer array we have our block ready for de- or encryption
			if ((i > 0) && (i % length == 0)){
				//execute the operation
				scrambled = cipher.doFinal(buffer);
				// add the result to our total result.
				toReturn = append(toReturn,scrambled);
				// here we calculate the length of the next buffer required
				int newlength = length;

				// if newlength would be longer than remaining bytes in the bytes array we shorten it.
				if (i + length > bytes.length) {
					 newlength = bytes.length - i;
				}
				// clean the buffer array
				buffer = new byte[newlength];
			}
			// copy byte into our buffer.
			buffer[i%length] = bytes[i];
		}

		// this step is needed if we had a trailing buffer. should only happen when encrypting.
		// example: we encrypt 110 bytes. 100 bytes per run means we "forgot" the last 10 bytes. they are in the buffer array
		scrambled = cipher.doFinal(buffer);

		// final step before we can return the modified data.
		toReturn = append(toReturn,scrambled);

		return toReturn;
	}
	
	private byte[] append(byte[] prefix, byte[] suffix){
		byte[] toReturn = new byte[prefix.length + suffix.length];
		for (int i=0; i< prefix.length; i++){
			toReturn[i] = prefix[i];
		}
		for (int i=0; i< suffix.length; i++){
			toReturn[i+prefix.length] = suffix[i];
		}
		return toReturn;
	}

}
