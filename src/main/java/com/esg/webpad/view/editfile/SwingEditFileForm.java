package com.esg.webpad.view.editfile;

import org.apache.log4j.Logger;

import com.esg.webpad.model.NotePadFile;

public enum SwingEditFileForm implements EditFileForm {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(SwingEditFileForm.class);
		
	private SwingEditFileForm() {
		logger.info("Edit file form created");
	}

	@Override
	public void display() {
		
	}

	@Override
	public void setFile(NotePadFile file) {
		
	}

}
