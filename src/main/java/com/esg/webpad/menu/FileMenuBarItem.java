package com.esg.webpad.menu;

import org.apache.log4j.Logger;

public enum FileMenuBarItem implements MenuBarItem {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(FileMenuBarItem.class);
	
	private FileMenuBarItem() {
		logger.info("File menu bar item created");
	}

	@Override
	public String getDisplayName() {
		return "File";
	}

	@Override
	public MenuBarItem[] getChildren() {
		return new MenuBarItem[]{NewMenuBarItem.INSTANCE, SaveMenuBarItem.INSTANCE, PushMenuBarItem.INSTANCE, ExitMenuBarItem.INSTANCE};
	}

	@Override
	public void onAction() {
		
	}

}
