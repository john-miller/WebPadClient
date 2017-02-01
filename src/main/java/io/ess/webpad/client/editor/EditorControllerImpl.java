package io.ess.webpad.client.editor;

import io.ess.webpad.client.domain.Document;

public enum EditorControllerImpl implements EditorController {
	
	INSTANCE;
	
	public static void main(String[] args) {
		EditorControllerImpl.INSTANCE.openDocument(new Document());
	}
	
	private EditorView editorView = new FXEditorViewImpl();

	@Override
	public void openDocument(Document document) {
		
		/*
		 * Set the current document so the user
		 * can perform operations on it
		 */
		editorView.setDocument(document);
		
		/*
		 * Listen to events that come from the editor view
		 */
		editorView.setEditorViewListener(new EditorViewListener() {
			@Override
			public void saveAs(Document document) {
				
			}
			@Override
			public void save(Document document) {
				
			}
			@Override
			public void open() {
				
			}
			@Override
			public void newDocument() {
				
			}
			@Override
			public void close() {
				
			}
		});
		
		editorView.displayInWindow();
	}

}
