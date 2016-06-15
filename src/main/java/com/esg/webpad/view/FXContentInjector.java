package com.esg.webpad.view;

import com.sun.javafx.application.PlatformImpl;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public enum FXContentInjector implements ContentInjector<Pane> {
	
	INSTANCE;
	
	private final long transitionTimeMillis = 200;

	@Override
	public void inject(Pane content) {
		PlatformImpl.runAndWait(new Runnable() {
			@Override
			public void run() {
				BorderPane borderPane = (BorderPane) FXApplicationFrame.INSTANCE.getContainer();
				Node currentContent = borderPane.getCenter();
				fadeNodes(borderPane, currentContent, content);
			}
		});
	}
	
	/**
	 * Transitions the panes in and out of the parent frame
	 * @param parentPane
	 * @param out
	 * @param in
	 */
	public void fadeNodes(final BorderPane parentPane, final Node out, final Pane in) {
		FadeTransition transitionOut = new FadeTransition(Duration.millis(transitionTimeMillis), out);
		transitionOut.setFromValue(1.0);
		transitionOut.setToValue(0.0);
		transitionOut.setCycleCount(1);
		transitionOut.setAutoReverse(false);
		transitionOut.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				in.prefWidthProperty().bind(parentPane.widthProperty());
				in.prefHeightProperty().bind(parentPane.heightProperty().subtract(parentPane.getTop().getBoundsInParent().getHeight()));
				in.setOpacity(0);
				parentPane.setCenter(in);
				FadeTransition transitionIn = new FadeTransition(Duration.millis(transitionTimeMillis), in);
				transitionIn.setFromValue(0);
				transitionIn.setToValue(1);
				transitionIn.setCycleCount(1);
				transitionIn.setAutoReverse(false);
				transitionIn.play();
			}
		});
		 
		transitionOut.play();
	}
	

}
