package io.ess.webpad.client.editor;

import io.ess.webpad.client.domain.Document;

public interface EditorView {
	
	public void setDocument(Document document);
	
	public Document getDocument();
	
	public void setEditorViewListener(EditorViewListener editorViewListener);
	
	public EditorViewListener getEditorViewListener();

}

