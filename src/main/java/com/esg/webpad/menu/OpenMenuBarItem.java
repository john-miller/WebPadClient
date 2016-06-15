package com.esg.webpad.menu;

import org.apache.log4j.Logger;

public enum OpenMenuBarItem implements MenuBarItem {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(OpenMenuBarItem.class);
	
	private OpenMenuBarItem() {
		logger.info("Open menu bar created");
	}

	@Override
	public String getDisplayName() {
		return "Open";
	}

	@Override
	public MenuBarItem[] getChildren() {
		return new MenuBarItem[]{};
	}

	@Override
	public void onAction() {
		logger.info("User chose to open file");
		
	}

}
