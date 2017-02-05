package io.ess.webpad.client.editor;

import com.sun.javafx.application.PlatformImpl;

import io.ess.webpad.client.domain.Document;
import io.ess.webpad.client.view.AbstractFXWindowedView;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.HTMLEditor;

public class FXEditorViewImpl extends AbstractFXWindowedView implements EditorView {

	private Document document;
	private EditorViewListener editorViewListener;
	
	@FXML private Menu mnuUserAccount;
	@FXML private MenuItem mnuClose;
	@FXML private MenuItem mnuMyDocuments;
	@FXML private MenuItem mnuSaveAs;
	@FXML private MenuItem mnuSave;
	@FXML private MenuItem mnuOpen;
	@FXML private MenuItem mnuNew;
	@FXML private HTMLEditor editor;
	
	public FXEditorViewImpl() {
		System.out.println(mnuUserAccount);
		mnuUserAccount.setGraphic(new ImageView(new Image(FXEditorViewImpl.class.getResourceAsStream("/images/user-icon.png"), 16, 16, true, true)));
		
		mnuClose.setOnAction(event -> {
			if(editorViewListener != null)
				editorViewListener.close();
		});
		
		mnuMyDocuments.setOnAction(event -> {
			if(editorViewListener != null)
				editorViewListener.displayMyDocuments();
		});
		
		mnuNew.setOnAction(event -> {
			if(editorViewListener != null)
				editorViewListener.newDocument();
		});
		
		mnuOpen.setOnAction(event -> {
			if(editorViewListener != null)
				editorViewListener.openFile();
		});
		
		mnuSaveAs.setOnAction(event -> {
			if(editorViewListener != null && document != null)
				editorViewListener.saveAs(document);
		});
		
		mnuSave.setOnAction(event -> {
			if(editorViewListener != null && document != null)
				editorViewListener.save(document);
		});
		
	}	
				
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
		PlatformImpl.runAndWait(new Runnable() {
			@Override
			public void run() {
				setTitle(document.getName());
				editor.setHtmlText(document.getContent());
			}
		});
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
