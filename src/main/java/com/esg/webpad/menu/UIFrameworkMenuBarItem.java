package com.esg.webpad.menu;

public enum UIFrameworkMenuBarItem implements MenuBarItem {
	
	INSTANCE;

	@Override
	public String getDisplayName() {
		return "UI FrameWork";
	}

	@Override
	public MenuBarItem[] getChildren() {
		return new MenuBarItem[]{JavaFXMenuBarItem.INSTANCE, SwingMenuBarItem.INSTANCE};
	}

	@Override
	public void onAction() {
		
	}

}
