package io.ess.webpad.client;

import io.ess.webpad.client.domain.Document;
import io.ess.webpad.client.editor.EditorController;
import io.ess.webpad.client.editor.EditorControllerImpl;

public class Application {

	public static void main(String[] args) {
		Document document = new Document();
		document.setName("Test Document");
		document.setContent("<b>sample content</b>");
		EditorController loginController = EditorControllerImpl.INSTANCE;
		loginController.openDocument(document);
	}
	
}
