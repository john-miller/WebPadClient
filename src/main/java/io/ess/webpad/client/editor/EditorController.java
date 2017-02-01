package io.ess.webpad.client.editor;

import io.ess.webpad.client.domain.Document;

/**
 * Describes the functionality of an editor controller
 * 
 * @author John Miller
 */
public interface EditorController {
	
	/**
	 * Loads and displays a document to the user and
	 * allows the user to perform operations on the 
	 * document.
	 * 
	 * @param document
	 */
	public void openDocument(Document document);

}
