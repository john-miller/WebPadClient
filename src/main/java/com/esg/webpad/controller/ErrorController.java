package com.esg.webpad.controller;

import org.apache.log4j.Logger;

import com.esg.webpad.error.ErrorMessage;
import com.esg.webpad.service.UIService;
import com.esg.webpad.view.error.ErrorForm;
import com.esg.webpad.view.error.FXErrorForm;
import com.esg.webpad.view.error.SwingErrorForm;

public enum ErrorController {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(ErrorController.class);
	private ErrorForm errorForm = UIService.INSTANCE.isJavaFX() ? FXErrorForm.INSTANCE : SwingErrorForm.INSTANCE;
	
	private ErrorController() {
		logger.info("Error controller created");
	}
	
	public void showError(ErrorMessage error) {
		errorForm.display(error);
	}

}
