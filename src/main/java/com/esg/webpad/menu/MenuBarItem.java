package com.esg.webpad.menu;

import java.util.Observer;
import java.util.Observable;

public interface MenuBarItem {
	
	public String getDisplayName();
	
	public MenuBarItem[] getChildren();
	
	public void onAction();

}
