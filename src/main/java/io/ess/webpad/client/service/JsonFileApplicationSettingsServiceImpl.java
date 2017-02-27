package io.ess.webpad.client.service;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.ess.webpad.client.domain.ApplicationSettings;

public enum JsonFileApplicationSettingsServiceImpl implements ApplicationSettingsService {
	
	INSTANCE;
	
	private Logger logger = LogManager.getLogger(JsonFileApplicationSettingsServiceImpl.class);
	private final String applicationSettingsPath = System.getProperty("user.home");
	private final String applicationSettingsFileName = "webpad.conf";
	private final File applicationSettingsFile = new File(applicationSettingsPath + File.separator + applicationSettingsFileName);
	
	private JsonFileApplicationSettingsServiceImpl() {
		logger.info("Instantiated JsonFileApplicationSettingsService");
	}
	
	@Override
	public ApplicationSettings load() throws ApplicationSettingsServiceException {
		if(applicationSettingsFile.exists()) {
			
		} else {
			
		}
		return null;
	}

	@Override
	public void save(ApplicationSettings applicationSettings) throws ApplicationSettingsServiceException {
		// TODO Auto-generated method stub
		
	}

}
