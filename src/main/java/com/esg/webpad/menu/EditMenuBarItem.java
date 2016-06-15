package com.esg.webpad.menu;

public enum EditMenuBarItem implements MenuBarItem {
	
	INSTANCE;

	@Override
	public String getDisplayName() {
		return "Edit";
	}

	@Override
	public MenuBarItem[] getChildren() {
		return new MenuBarItem[]{NewMenuBarItem.INSTANCE};
	}

	@Override
	public void onAction() {
		
	}

}
