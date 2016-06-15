package com.esg.webpad.controller;

import org.apache.log4j.Logger;

import com.esg.webpad.file.NotePadFile;
import com.esg.webpad.service.UIService;
import com.esg.webpad.view.editfile.EditFileForm;
import com.esg.webpad.view.editfile.FXEditFileForm;
import com.esg.webpad.view.editfile.SwingEditFileForm;

public enum EditFileController {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(EditFileController.class);
	private EditFileForm editForm = UIService.INSTANCE.isJavaFX() ? FXEditFileForm.INSTANCE : SwingEditFileForm.INSTANCE;
	
	private EditFileController() {
		logger.info("Created file editor controller");
	}
	
	public void editFile(NotePadFile file) {
		editForm.display();
		editForm.setFile(file);
	}
	
	
}
