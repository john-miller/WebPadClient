package com.esg.webpad.menu;

public enum FileMenuBarItem implements MenuBarItem {
	
	INSTANCE;

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
