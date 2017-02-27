package io.ess.webpad.client.mydocuments;

import java.util.Collection;

import org.springframework.hateoas.Resource;

import io.ess.webpad.client.domain.Document;
import io.ess.webpad.client.view.AbstractFXWindowedView;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class FXMyDocumentsViewImpl extends AbstractFXWindowedView implements MyDocumentsView {

	@FXML private Pagination pagination;
	private MyDocumentsListener myDocumentsListener;
	
	public FXMyDocumentsViewImpl() {
		pagination.setPageFactory(new Callback<Integer, Node>() {
			@Override
			public Node call(Integer param) {
				if(myDocumentsListener != null) {
					Collection<Resource<Document>> documents = myDocumentsListener.getDocumentsForPage(param);
					TableView<Resource<Document>> tableView = new TableView<Resource<Document>>();
					TableColumn<Resource<Document>, String> nameColumn = new TableColumn<Resource<Document>, String>("Name");
					nameColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getContent().getName()));
					tableView.getColumns().add(nameColumn);
					tableView.getItems().addAll(documents);
					return tableView;
				}
				return null;
			}
		});
	}
	
	@Override
	public String getFXMLDocument() {
		return "/fxml/my-documents-view.fxml";
	}

	@Override
	public String getCSSLocation() {
		return null;
	}

	@Override
	public void setMyDocumentsListener(MyDocumentsListener myDocumentsListener) {
		this.myDocumentsListener = myDocumentsListener;
	}

}
