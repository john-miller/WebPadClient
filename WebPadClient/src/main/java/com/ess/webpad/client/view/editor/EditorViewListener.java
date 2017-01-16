package com.ess.webpad.client.view.editor;

import com.ess.webpad.client.domain.Document;

public interface EditorViewListener {
	
	public void open();
	
	public void save(Document document);
	
	public void newDocument();
	
	public void saveAs(Document document);
	
	public void close();

}
