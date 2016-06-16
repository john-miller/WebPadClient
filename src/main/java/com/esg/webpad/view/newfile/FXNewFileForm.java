package com.esg.webpad.view.newfile;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.esg.webpad.controller.EditFileController;
import com.esg.webpad.file.NotePadFile;
import com.esg.webpad.view.FXApplicationFrame;
import com.esg.webpad.view.FXContentInjector;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public enum FXNewFileForm implements NewFileForm {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(FXNewFileForm.class);
	
	private AnchorPane pane;

	private FXNewFileForm() {
		try {
			FXMLLoader loader = new FXMLLoader(FXApplicationFrame.class.getResource("/fxml/new-file-form.fxml"));
			loader.setController(this);
			pane = loader.load();
		} catch (IOException e) {
			logger.error("Could not load FXML document", e);
		} catch(IllegalStateException e) {
			logger.error("Could not load FXML document", e);
		}
	}
	
	@Override
	public void display() {
		FXContentInjector.INSTANCE.inject(pane);		
	}

	
	@FXML
	public void create() {
		logger.info("User chose to create new file");
		NotePadFile file = new NotePadFile();
		file.setName("Test");
		file.setDescription("Description");
		file.setContent("Test <b>Content</b>");
		EditFileController.INSTANCE.editFile(file);
	}
	
	@FXML
	public void cancel() {
		logger.info("User chose to cancel");
	}
	
}
