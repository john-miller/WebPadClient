package com.esg.webpad.style;

import org.apache.log4j.Logger;

import com.esg.webpad.service.SettingsService;
import com.esg.webpad.service.SettingsServiceImpl;
import com.esg.webpad.service.SettingsService.Setting;
import com.esg.webpad.view.FXApplicationFrame;

/**
 * Holds all the styles for JavaFX via
 * enum singletons.  When adding a style, make sure
 * the style sheet is in src/main/resources/css (or other accessible directory) and
 * that there is an enumerated instance associated with the
 * style.
 *
 * Created on Jun 15, 2016 11:33:10 AM
 * @author Jonathan Miller
 */
public enum FXStyle implements Style {
	
	BLUE("Blue", "/css/blue.css"),
	RED("Red", "/css/red.css");
	
	private String name;
	private String location;
	private Logger logger = Logger.getLogger(FXStyle.class);
	private SettingsService settingsService = SettingsServiceImpl.INSTANCE;
	
	private FXStyle(String name, String location) {
		this.name = name;
		this.location = location;
		logger.info("Creating style " + name + ":" + location);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void apply() {
		logger.info("Applying " + name + " style");
		
		FXApplicationFrame.INSTANCE.getContainer()
			.getScene().getStylesheets().removeAll(FXApplicationFrame.INSTANCE.getContainer().getScene().getStylesheets());
		
		FXApplicationFrame.INSTANCE.getContainer().getScene().getStylesheets().add(location);
		
		settingsService.setSetting(Setting.JAVAFX_STYLE, location);
		
	}

}
