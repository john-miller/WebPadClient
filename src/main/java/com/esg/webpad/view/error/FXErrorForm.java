package com.esg.webpad.view.error;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.esg.webpad.error.ErrorMessage;
import com.esg.webpad.view.FXApplicationFrame;
import com.esg.webpad.view.FXContentInjector;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public enum FXErrorForm implements ErrorForm {
	
	INSTANCE;

	private Logger logger = Logger.getLogger(FXErrorForm.class);
	private AnchorPane pane;
	private SimpleStringProperty nameProperty = new SimpleStringProperty();
	private SimpleStringProperty descriptionProperty = new SimpleStringProperty();
	
	private FXErrorForm() {
		logger.info("Creating error message form");
		try {
			FXMLLoader loader = new FXMLLoader(FXApplicationFrame.class.getResource("/fxml/error-form.fxml"));
			loader.setController(this);
			pane = loader.load();
		} catch (IOException e) {
			logger.error("Could not load FXML document", e);
		} catch(IllegalStateException e) {
			logger.error("Could not load FXML document", e);
		}
	}
	
	@Override
	public void display(ErrorMessage message) {
		logger.info("Display error message " + message);
		nameProperty.set(message.getName());
		descriptionProperty.set(message.getDescription());
		FXContentInjector.INSTANCE.inject(pane);
	}

}
