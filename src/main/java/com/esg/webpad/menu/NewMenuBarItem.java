package com.esg.webpad.menu;

import org.apache.log4j.Logger;

import com.esg.webpad.controller.NewFileController;

public enum NewMenuBarItem implements MenuBarItem {
	
	INSTANCE;

	private Logger logger = Logger.getLogger(NewMenuBarItem.class);
	
	private NewMenuBarItem() {
		logger.info("Creating 'New' Menu Item");
	}

	@Override
	public String getDisplayName() {
		return "New";
	}

	@Override
	public void onAction() {
		logger.info("New button clicked");
		NewFileController.INSTANCE.newFile();
	}

	@Override
	public MenuBarItem[] getChildren() {
		return new MenuBarItem[]{};
	}

}
