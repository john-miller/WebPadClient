package com.esg.webpad.menu;

import org.apache.log4j.Logger;

public enum PushMenuBarItem implements MenuBarItem, IconableItem {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(PushMenuBarItem.class);
	
	private PushMenuBarItem() {
		logger.info("Push menu bar item created");
	}

	@Override
	public String getDisplayName() {
		return "Push";
	}

	@Override
	public MenuBarItem[] getChildren() {
		return new MenuBarItem[]{};
	}

	@Override
	public void onAction() {
		logger.info("User chose to push to web");
	}
	
	@Override
	public String getImageLocation() {
		return "/images/icons/cloud-computing-1.png";
	}

}
