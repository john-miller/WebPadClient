package io.ess.webpad.client.editor;

import com.sun.istack.internal.logging.Logger;

import io.ess.webpad.client.domain.Document;

public enum EditorControllerImpl implements EditorController {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(EditorControllerImpl.class);
	
	public static void main(String[] args) {
		EditorControllerImpl.INSTANCE.openDocument(new Document());
	}
	
	private EditorView editorView = new FXEditorViewImpl();
	
	private EditorControllerImpl() {
		logger.info("Created Editor Controller Implementation");
	}

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
			public void openFile() {
				
			}
			@Override
			public void newDocument() {
				
			}
			@Override
			public void close() {
				System.exit(0);
			}
			@Override
			public void displayMyDocuments() {
				
			}
		});
		
		editorView.displayInWindow();
	}

}
