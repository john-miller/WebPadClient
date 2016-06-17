package com.esg.webpad.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.esg.webpad.exception.EncryptionException;
import com.esg.webpad.exception.NotePadFileException;
import com.esg.webpad.model.NotePadFile;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public enum NotePadFileServiceImpl implements NotePadFileService {

	INSTANCE;
	
	private Logger logger = Logger.getLogger(NotePadFileServiceImpl.class);
	private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private final EncryptionService encryptionService = EncryptionServiceImpl.INSTANCE;
	
	public static void main(String[] args) throws NotePadFileException {
		File testFile = new File("C:\\Users\\dev3\\Desktop\\Test File.etxt");
		if(testFile.exists())
			testFile.delete();
		
		NotePadFile file1 = new NotePadFile();
		file1.setName("Test File");
		file1.setDescription("A Test");
		file1.setContent("This is test content 12345."
				+ "This is test content 12345."
				+ "This is test content 12345."
				+ "This is test content 12345."
				+ "This is test content 12345.");
		
		NotePadFileServiceImpl.INSTANCE.save(file1, "C:\\Users\\dev3\\Desktop");
		
		NotePadFile file = NotePadFileServiceImpl.INSTANCE.read("C:\\Users\\dev3\\Desktop\\Test File.etxt");
		System.out.println(file.getContent());
	}
	
	private NotePadFileServiceImpl() {
		logger.info("Creating note pad file service");
	}
	
	@Override
	public void save(NotePadFile file, String location) throws NotePadFileException {
		try {
		
			logger.info("Encrypting file " + file);
			
			/* Get the content to be encrypted */
			String content = file.getContent();
			
			/* Encrypt the content */
			String encryptedContent = encryptionService.encrypt(content);
			
			file.setEncryptedData(encryptedContent);
			
			String fileString = gson.toJson(file);
			
			File writableFile = new File(location + File.separator + file.getName() + ".etxt");
			
			if(!writableFile.exists()) {
				writableFile.getParentFile().mkdirs();
				writableFile.createNewFile();
			}
			
			PrintWriter writer = new PrintWriter(writableFile, "UTF-8");
			writer.println(fileString);
			writer.close();
			
		} catch(FileNotFoundException e) {
			logger.error("Could not find file to write to", e);
		} catch (UnsupportedEncodingException e) {
			logger.error("Could not save file", e);
		} catch (IOException e) {
			logger.error("Error creating new file", e);
		} catch(EncryptionException e) {
			throw new NotePadFileException("Could not encrypt file content", e);
		}
		
	}
	
	@Override
	public NotePadFile read(String notepadFileWithLocation) throws NotePadFileException {
		try {
			File notepadFile = new File(notepadFileWithLocation);
			NotePadFile file = gson.fromJson(FileUtils.readFileToString(notepadFile, "UTF-8"), NotePadFile.class);
			
			logger.info("Decrypting file " + file);
			
			/* Get the content to be encrypted */
			String encryptedData = file.getEncryptedData();
			
			/* Encrypt the content */
			String unencryptedContent = encryptionService.decrypt(encryptedData);
			
			file.setContent(unencryptedContent);
			return file;
		} catch(IOException e) {
			throw new NotePadFileException("Could not read file content", e);
		} catch(EncryptionException e) {
			throw new NotePadFileException("Could not decrypt file content", e);
		}
	}
	
	


}
