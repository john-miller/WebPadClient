package com.esg.webpad.view.error;

import org.apache.log4j.Logger;

import com.esg.webpad.error.ErrorMessage;

public enum SwingErrorForm implements ErrorForm {
	
	INSTANCE;

	private Logger logger = Logger.getLogger(SwingErrorForm.class);

	private SwingErrorForm() {
		logger.info("Creating error message form");
		
	}
	
	@Override
	public void display(ErrorMessage message) {
		logger.info("Display error message " + message);

	}

}
