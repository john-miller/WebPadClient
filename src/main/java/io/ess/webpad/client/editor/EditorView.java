package io.ess.webpad.client.editor;

import io.ess.webpad.client.domain.Document;
import io.ess.webpad.client.view.WindowedView;

/**
 * The editor view is responsible for providing
 * a UI to the user, allowing them to perform operations
 * on the document and other parts of the application
 * 
 * @author John Miller
 *
 */
public interface EditorView extends WindowedView {
	
	public void setDocument(Document document);
	
	public Document getDocument();
	
	public void setEditorViewListener(EditorViewListener editorViewListener);
	
	public EditorViewListener getEditorViewListener();

}

