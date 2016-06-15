package com.esg.webpad.view.editfile;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.esg.webpad.file.NotePadFile;
import com.esg.webpad.view.FXApplicationFrame;
import com.esg.webpad.view.FXContentInjector;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

public enum FXEditFileForm implements EditFileForm {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(FXEditFileForm.class);
	
	private SimpleStringProperty propName = new SimpleStringProperty();
	private SimpleStringProperty propDescription = new SimpleStringProperty();
	private SimpleStringProperty propContent = new SimpleStringProperty();
	
	private Pane pane;
	
	@FXML
	private TextArea txtContent;
	
	private FXEditFileForm() {
		logger.info("Creating edit file form");
		try {
			FXMLLoader loader = new FXMLLoader(FXApplicationFrame.class.getResource("/fxml/edit-file-form.fxml"));
			loader.setController(this);
			pane = loader.load();
			txtContent.textProperty().bindBidirectional(propContent);
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

	@Override
	public void setFile(NotePadFile file) {
		propName.set(file.getName());
		propDescription.set(file.getDescription());
		propContent.set(file.getContent());
	}

}
