package com.esg.webpad.service;

public interface SettingsService {

	public String getSetting(Setting setting);
	
	public void setSetting(Setting setting, String value);
	
	public enum Setting {
		UI_FRAMEWORK, 
		SWING_STYLE, 
		JAVAFX_STYLE
	}
	
}
