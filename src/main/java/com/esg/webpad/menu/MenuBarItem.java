package com.esg.webpad.menu;

public interface MenuBarItem {
	
	public String getDisplayName();
	
	public MenuBarItem[] getChildren();
	
	public void onAction();

}
