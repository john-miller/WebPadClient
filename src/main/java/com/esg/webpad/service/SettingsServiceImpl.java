package com.esg.webpad.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public enum SettingsServiceImpl implements SettingsService {
	
	INSTANCE;

	private Map<String, String> properties = new HashMap<String, String>();
	private Logger logger = Logger.getLogger(SettingsServiceImpl.class);
	private final File settingsFile = new File(System.getProperty("user.home") + File.separator + "notepad_settings.conf");
	private Gson gson =  new GsonBuilder().setPrettyPrinting().create();
	
	private SettingsServiceImpl() {
		logger.info("Creating settings service");
		read();
	}
	
	@SuppressWarnings("unchecked")
	public synchronized void read() {
		
		/* Attempt to create the settings file */
		try {
			if(!settingsFile.exists()) {
				logger.info("Settings file does not exist so creating it");
				settingsFile.getParentFile().mkdirs();
				settingsFile.createNewFile();
				settingsFile.setReadable(true);
				settingsFile.setWritable(true);
			} else {
				logger.info("Settings file already exists");
			}
		}
		catch(IOException e) {
			logger.error("Could not create settings file", e);
		}
		
		BufferedReader br =null;
		try {			
			br = new BufferedReader(new FileReader(settingsFile));
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    logger.info("Loading properties from json");
		    
		    properties = (Map<String, String>) gson.fromJson(sb.toString(), HashMap.class);
		  
		    /* Just incase gson returns null */
		    if(properties == null)
		    	properties = new HashMap<String, String>();
		    
		    logger.info("Properties loaded from json");
		} catch (IOException e) {
			logger.error("Could not read file", e);
		} finally {
		    try {
		    	if(br != null)
		    		br.close();
			} catch (IOException e) {
				logger.error("Could not close stream", e);
			}
		}
	}
	
	public synchronized void save() {
		try {
			String propertiesAsJson = gson.toJson(properties);
			if(!settingsFile.exists()) {
				settingsFile.mkdirs();
				settingsFile.createNewFile();
			}
			PrintWriter writer = new PrintWriter(settingsFile, "UTF-8");
			writer.println(propertiesAsJson);
			writer.close();
		} catch(FileNotFoundException e) {
			logger.error("Could not find file to write to", e);
		} catch (UnsupportedEncodingException e) {
			logger.error("Could not save file", e);
		} catch (IOException e) {
			logger.error("Error creating new file", e);
		}
	}
	
	@Override
	public synchronized String getSetting(Setting setting) {
		String property = properties.get(setting.toString());
		if(property != null)
			return property;
		else
			return "";
	}

	@Override
	public synchronized void setSetting(Setting setting, String value) {
		properties.put(setting.toString(), value);
		save();
	}

}
