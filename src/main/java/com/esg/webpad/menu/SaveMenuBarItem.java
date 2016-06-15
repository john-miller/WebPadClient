package com.esg.webpad.menu;

import org.apache.log4j.Logger;

public enum SaveMenuBarItem implements MenuBarItem {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(SaveMenuBarItem.class);
	
	private SaveMenuBarItem() {
		logger.info("Creating save menu");
	}

	@Override
	public String getDisplayName() {
		return "Save";
	}

	@Override
	public MenuBarItem[] getChildren() {
		return new MenuBarItem[]{};
	}

	@Override
	public void onAction() {
		logger.info("User clicked save");
	}

}
