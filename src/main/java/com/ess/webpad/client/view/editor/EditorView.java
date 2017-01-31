package com.ess.webpad.client.view.editor;

import com.ess.webpad.client.domain.Document;

public interface EditorView {
	
	public void setDocument(Document document);
	
	public Document getDocument();
	
	public void setEditorViewListener(EditorViewListener editorViewListener);
	
	public EditorViewListener getEditorViewListener();

}

