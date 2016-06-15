package com.esg.webpad.menu;

import org.apache.log4j.Logger;

public enum OptionsMenuBarItem implements MenuBarItem {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(OptionsMenuBarItem.class);
	
	private OptionsMenuBarItem() {
		logger.info("Creating options menu");
	}
	
	@Override
	public String getDisplayName() {
		return "Options";
	}

	@Override
	public MenuBarItem[] getChildren() {
		return new MenuBarItem[]{UIFrameworkMenuBarItem.INSTANCE, StylesMenuBarItem.INSTANCE};
	}

	@Override
	public void onAction() {
		
	}

}
