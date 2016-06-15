package com.esg.webpad.view;

import com.esg.webpad.menu.MenuBarItem;

public interface ApplicationFrame<T> {

	public void display();
	
	public void setMenuBarItems(MenuBarItem...items);
	
	public T getContainer();
	
}
