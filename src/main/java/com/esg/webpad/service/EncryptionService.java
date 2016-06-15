package com.esg.webpad.service;

import com.esg.webpad.exception.EncryptionException;

public interface EncryptionService {

	public String encrypt(String unencryptedData) throws EncryptionException;
	
	public String decrypt(String encryptedData) throws EncryptionException;
	
}
