package io.ess.webpad.client.rest;

import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;

import io.ess.webpad.client.domain.Document;

public interface DocumentRestClient {
	
	public PagedResources<Resource<Document>> getDocuments(int page, int size);
	
	public Resource<Document> getFullDocument(Resource<Document> documentResource);
	
	public Resource<Document> getDocumentByName(String name);
	
	public Resource<Document> updateDocument(Resource<Document> document);

}
