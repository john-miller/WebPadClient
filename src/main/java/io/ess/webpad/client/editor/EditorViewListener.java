package io.ess.webpad.client.editor;

import io.ess.webpad.client.domain.Document;

public interface EditorViewListener {
	
	public void openFile();
	
	public void displayMyDocuments();
	
	public void save(Document document);
	
	public void newDocument();
	
	public void saveAs(Document document);
	
	public void close();

}
