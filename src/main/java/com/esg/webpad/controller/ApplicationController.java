package com.esg.webpad.controller;

import com.esg.webpad.menu.EditMenuBarItem;
import com.esg.webpad.menu.FileMenuBarItem;
import com.esg.webpad.menu.OptionsMenuBarItem;
import com.esg.webpad.service.UIService;
import com.esg.webpad.view.ApplicationFrame;
import com.esg.webpad.view.FXApplicationFrame;
import com.esg.webpad.view.SwingApplicationFrame;

public enum ApplicationController {
	
	INSTANCE;
	
	/* Grab an instance of the application frame */
	private ApplicationFrame<?> frame = UIService.INSTANCE.isJavaFX() ? FXApplicationFrame.INSTANCE : SwingApplicationFrame.INSTANCE;
	
	public void initialize() {
		
		/* Set the menu bar items */
		frame.setMenuBarItems(FileMenuBarItem.INSTANCE, EditMenuBarItem.INSTANCE, OptionsMenuBarItem.INSTANCE);
		
		/* Display the frame */
		frame.display();
		
		//FileEditorController.INSTANCE.editFile(new NotePadFile());
		
	}

}
