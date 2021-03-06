package io.ess.webpad.client.view;

import java.io.IOException;
import java.net.URL;

import com.sun.javafx.application.PlatformImpl;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Abstracts basic functionality of an FX window
 *
 * Created On Jan 14, 2017
 * @author Jonathan Miller
 */
public abstract class AbstractFXWindowedView implements WindowedView {

	private WindowedViewListener windowedViewListener;
	private Pane root;
	private Scene scene;
	private Stage primaryStage;
	
	public AbstractFXWindowedView() {
		PlatformImpl.startup(new Runnable() {
			@Override
			public void run() {
				
			}
		});

		/* If this is not set then FX Platform will exit when there are no
		 * more FX elements shown on screen. (not really the desired  
		 */
		PlatformImpl.setImplicitExit(false);
		
		URL fxmlURL = AbstractFXWindowedView.class.getResource(getFXMLDocument());
		FXMLLoader loader = new FXMLLoader(fxmlURL);
		loader.setController(this);
		
		PlatformImpl.runAndWait(new Runnable() {
			@Override
			public void run() {
				try {
					root = loader.load();
					scene = new Scene(root, 250, 300);
					primaryStage = new Stage();
				} catch (IOException e) {
					root = new AnchorPane();
				} catch(IllegalStateException e) {
					root = new AnchorPane();
				}
			}
		});
	}
	
	public void displayInWindow() {
		PlatformImpl.runAndWait(new Runnable() {
			@Override
			public void run() {
				primaryStage.setScene(scene);
				primaryStage.setAlwaysOnTop(true);
				primaryStage.initModality(Modality.WINDOW_MODAL);
				primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
					@Override
					public void handle(WindowEvent event) {
						
					}
				});
				try {
					URL logoUrl = AbstractFXWindowedView.class.getResource("/images/icon-web.png");
					if(logoUrl != null) {
						Image image = new Image(logoUrl.toExternalForm());
						primaryStage.getIcons().add(image);
					}
				}
				catch(IllegalArgumentException e) {
					
				}
				
				String cssLocation = getCSSLocation();
				if(cssLocation != null)
					scene.getStylesheets().add(cssLocation);
				primaryStage.show();
			}
		});
	}
	
	@Override
	public void setLocationRelativeTo(double x, double y) {
		PlatformImpl.runAndWait(new Runnable() {
			@Override
			public void run() {
				primaryStage.setX(x + (primaryStage.getWidth()/2));
				primaryStage.setY(y + (primaryStage.getHeight()/2));
			}
		});
	}

	@Override
	public void setDimension(double width, double height) {
		PlatformImpl.runAndWait(new Runnable() {
			@Override
			public void run() {
				primaryStage.setWidth(width);
				primaryStage.setHeight(height);
			}
		});
	}
	
	public void closeWindow() {
		root.setVisible(true);
	}
				
	public void setWindowedViewListener(WindowedViewListener windowedViewListener) {
		this.windowedViewListener = windowedViewListener;
	}

	public WindowedViewListener getWindowedViewListener() {
		return windowedViewListener;
	}
	
	public String getTitle() {
		return primaryStage.getTitle();
	}
	
	public void setTitle(String title) {
		primaryStage.setTitle(title);
	}
	
	public abstract String getFXMLDocument();
	
	public abstract String getCSSLocation();
}
