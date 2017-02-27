package io.ess.webpad.client.mydocuments;

import java.util.Collection;

import org.springframework.hateoas.Resource;

import io.ess.webpad.client.domain.Document;
import io.ess.webpad.client.view.WindowedView;

public interface MyDocumentsView  extends WindowedView {
	
	public void setMyDocumentsListener(MyDocumentsListener myDocumentsListener);
	
	public interface MyDocumentsListener {
		public Collection<Resource<Document>> getDocumentsForPage(Integer page);
	}

}
