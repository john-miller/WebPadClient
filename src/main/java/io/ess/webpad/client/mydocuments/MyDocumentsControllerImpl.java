package io.ess.webpad.client.mydocuments;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;

import io.ess.webpad.client.domain.Document;
import io.ess.webpad.client.mydocuments.MyDocumentsView.MyDocumentsListener;
import io.ess.webpad.client.rest.AccountRestClientImpl;
import io.ess.webpad.client.rest.DocumentRestClientImpl;

public enum MyDocumentsControllerImpl implements MyDocumentsController {

	INSTANCE;
	
	private MyDocumentsView myDocumentsView = new FXMyDocumentsViewImpl();
	private Logger logger = LogManager.getLogger(MyDocumentsControllerImpl.class);
	
	private MyDocumentsControllerImpl() {
		
	}
	
	@Override
	public void showDocuments() {
		myDocumentsView.setMyDocumentsListener(new MyDocumentsListener() {
			@Override
			public Collection<Resource<Document>> getDocumentsForPage(Integer page) {
				logger.info(String.format("Getting documents for page %s", page));
				PagedResources<Resource<Document>> pagedResources = DocumentRestClientImpl.INSTANCE.getDocumentsByAccount(page, 10, AccountRestClientImpl.INSTANCE.getCurrentAccount());
				return pagedResources.getContent();
			}
		});
		myDocumentsView.setDimension(600, 450);
		myDocumentsView.setTitle("My Documents");
		myDocumentsView.displayInWindow();
	}

}
