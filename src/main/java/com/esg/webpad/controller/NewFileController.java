package com.esg.webpad.controller;

import org.apache.log4j.Logger;

import com.esg.webpad.service.UIService;
import com.esg.webpad.view.newfile.FXNewFileForm;
import com.esg.webpad.view.newfile.NewFileForm;
import com.esg.webpad.view.newfile.SwingNewFileForm;

public enum NewFileController {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(NewFileController.class);
	private NewFileForm fileForm = UIService.INSTANCE.isJavaFX() ? FXNewFileForm.INSTANCE : SwingNewFileForm.INSTANCE;
	
	private NewFileController() {
		logger.info("New File Controller Created");
	}
	
	public void newFile() {
		fileForm.display();
	}

}
