package com.esg.webpad.service;

import org.apache.log4j.Logger;

import com.esg.webpad.service.SettingsService.Setting;

/**
 * The properties in this class should only be loaded
 * once per application launch due to the nature of the
 * UI Frameworks being used.  This is why we initialize the 
 * properties in the constructor of this singleton and allow
 * read only access to those properties via standard accessor methods.
 *
 * Created on Jun 15, 2016 10:44:16 AM
 * @author Jonathan Miller
 */
public enum UIService {

	INSTANCE;
	
	private SettingsService settingsService = SettingsServiceImpl.INSTANCE;
	private Logger logger = Logger.getLogger(UIService.class);
	private boolean javaFX = false;
	
	private UIService() {
		logger.info("Creating UIService");
		boolean javaFXUserPref = settingsService.getSetting(Setting.UI_FRAMEWORK).equals("JavaFX");
		Double version = Double.parseDouble(System.getProperty("java.version").substring(0, 3));
		javaFX = javaFXUserPref && version >= 1.8;
	}
	
	public boolean isJavaFX() {
		return javaFX;
	}
	
}
