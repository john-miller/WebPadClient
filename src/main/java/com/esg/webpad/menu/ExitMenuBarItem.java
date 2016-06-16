package com.esg.webpad.menu;

import org.apache.log4j.Logger;

public enum ExitMenuBarItem implements MenuBarItem, IconableItem {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(ExitMenuBarItem.class);
	
	private ExitMenuBarItem() {
		logger.info("Exit menu bar created");
	}

	@Override
	public String getDisplayName() {
		return "Exit";
	}

	@Override
	public MenuBarItem[] getChildren() {
		return new MenuBarItem[]{};
	}

	@Override
	public void onAction() {
		logger.info("User exited program");
		System.exit(0);
	}

	@Override
	public String getImageLocation() {
		return "/images/icons/log-out.png";
	}

}
