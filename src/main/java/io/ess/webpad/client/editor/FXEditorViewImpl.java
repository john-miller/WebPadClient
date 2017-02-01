package io.ess.webpad.client.editor;

import io.ess.webpad.client.domain.Document;
import io.ess.webpad.client.view.AbstractFXWindowedView;

public class FXEditorViewImpl extends AbstractFXWindowedView implements EditorView {

	private Document document;
	private EditorViewListener editorViewListener;
	
	@Override
	public String getFXMLDocument() {
		return "/fxml/editor-view.fxml";
	}

	@Override
	public String getCSSLocation() {
		return "/css/editor-view.css";
	}

	@Override
	public void setDocument(Document document) {
		this.document = document;
	}

	@Override
	public Document getDocument() {
		return this.document;
	}

	@Override
	public void setEditorViewListener(EditorViewListener editorViewListener) {
		this.editorViewListener = editorViewListener;
	}

	@Override
	public EditorViewListener getEditorViewListener() {
		return this.editorViewListener;
	}

}
