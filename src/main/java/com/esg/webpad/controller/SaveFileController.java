package com.esg.webpad.controller;

import org.apache.log4j.Logger;

import com.esg.webpad.file.NotePadFile;
import com.esg.webpad.service.UIService;
import com.esg.webpad.view.savefile.FXSaveFileForm;
import com.esg.webpad.view.savefile.SaveFileForm;
import com.esg.webpad.view.savefile.SwingSaveFileForm;

public enum SaveFileController {

	INSTANCE;
	
	private Logger logger = Logger.getLogger(SaveFileController.class);
	private SaveFileForm saveFileForm = UIService.INSTANCE.isJavaFX() ? FXSaveFileForm.INSTANCE : SwingSaveFileForm.INSTANCE;
	
	private SaveFileController() {
		logger.info("Save Controller Created!");
	}
	
	public void save(NotePadFile file) {
		saveFileForm.display(file);
	}
	
}
