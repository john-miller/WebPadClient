package com.esg.webpad.view;

import java.io.IOException;
import java.net.URL;

import org.apache.log4j.Logger;

import com.esg.webpad.menu.MenuBarItem;
import com.esg.webpad.service.SettingsService;
import com.esg.webpad.service.SettingsServiceImpl;
import com.esg.webpad.service.SettingsService.Setting;
import com.sun.javafx.application.PlatformImpl;
import com.sun.javafx.application.PlatformImpl.FinishListener;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public enum FXApplicationFrame implements ApplicationFrame<Pane> {
	
	INSTANCE;

	private AnchorPane pane;
	
	@FXML
	private MenuBar menuBar;
	
	@FXML 
	private BorderPane container;
	private SettingsService settingsService = SettingsServiceImpl.INSTANCE;
	private Logger logger = Logger.getLogger(FXApplicationFrame.class);
	
	private FXApplicationFrame() {

		logger.info("Starting up platform");
		PlatformImpl.startup(new Runnable() {
			@Override
			public void run() {
				logger.info("Starting up JavaFX platform");
			}
		});
		
		logger.info("Setting up resources");
		PlatformImpl.addListener(new FinishListener() {
			@Override
			public void idle(boolean arg0) {
				logger.info("Platform is idle");
			}
			@Override
			public void exitCalled() {
				logger.info("Platform exit has been initiated");
			}
		});
			
		logger.info("Loading stage fxml document");

		try {
			FXMLLoader loader = new FXMLLoader(FXApplicationFrame.class.getResource("/fxml/application-frame.fxml"));
			loader.setController(this);
			pane = loader.load();
		} catch (IOException e) {
			logger.error("Could not load FXML document", e);
		} catch(IllegalStateException e) {
			logger.error("Could not load FXML document", e);
		}
	
	}
	
	public void display() {
		PlatformImpl.runAndWait(new Runnable() {
			@Override
			public void run() {
				logger.info("Showing primary stage");
				Stage primaryStage = new Stage();
				Scene scene = new Scene(pane);
				URL style = FXApplicationFrame.class.getResource(settingsService.getSetting(Setting.JAVAFX_STYLE));
				if(style != null)
					scene.getStylesheets().add(style.toExternalForm());
				primaryStage.getIcons().add(new Image(FXApplicationFrame.class.getResourceAsStream("/images/icon-web.png")));
				primaryStage.setTitle("ESG Notepad");
				primaryStage.setScene(scene);
				primaryStage.show();
			}
		});
	}

	public Pane getContainer() {
		return container;
	}

	@Override
	public void setMenuBarItems(MenuBarItem... items) {
		for(MenuBarItem item : items) {
			menuBar.getMenus().add((Menu) addMenuBarItems(item));
		}
	}
	
	private MenuItem addMenuBarItems(final MenuBarItem item) {
		/* Check for children */
		if(item.getChildren() != null && item.getChildren().length > 0) {
			Menu menu = new Menu(item.getDisplayName());
			for(MenuBarItem childItem : item.getChildren())
				menu.getItems().add(addMenuBarItems(childItem));
			return menu;
		} else {
			
			MenuItem menu = new MenuItem(item.getDisplayName());
			
			/* When menu item it clicked the item action will be triggered */
			menu.setOnAction((event) -> {
				item.onAction();
			});
			return menu;
		}
	}
	

}
