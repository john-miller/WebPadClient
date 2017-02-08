package io.ess.webpad.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.ess.webpad.client.domain.Document;
import io.ess.webpad.client.editor.EditorController;
import io.ess.webpad.client.editor.EditorControllerImpl;

public class Application {

	private Logger logger = LogManager.getLogger(Application.class);
	
	public static void main(String[] args) {
		Application application = new Application();
		application.initialize();
	}
	
	public void initialize() {
		logger.info("Initializing application");
		Document document = new Document();
		document.setName("Test Document");
		document.setContent("<b>sample content</b>");
		EditorController loginController = EditorControllerImpl.INSTANCE;
		loginController.openDocument(document);
	}
	
}
