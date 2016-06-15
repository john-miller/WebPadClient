package com.esg.webpad.controller;

import org.apache.log4j.Logger;

import com.esg.webpad.service.UIService;
import com.esg.webpad.view.newfile.FXNewFileForm;
import com.esg.webpad.view.newfile.NewFileForm;
import com.esg.webpad.view.newfile.SwingNewFileForm;

public enum OpenFileController {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(OpenFileController.class);
	private NewFileForm newFileForm = UIService.INSTANCE.isJavaFX() ? FXNewFileForm.INSTANCE : SwingNewFileForm.INSTANCE;
	
	private OpenFileController() {
		logger.info("New File Controller Created");
	}
	
	public void openFile() {
		newFileForm.display();
	}

}
