package io.ess.webpad.client.editor;

import io.ess.webpad.client.view.AbstractFXWindowedView;

public class FXEditorViewImpl extends AbstractFXWindowedView {

	@Override
	public void setDimension(double width, double height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getFXMLDocument() {
		return "/fxml/editor-view.fxml";
	}

	@Override
	public String getCSSLocation() {
		return "/css/editor-view.css";
	}

}
