package io.ess.webpad.client.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import io.ess.webpad.client.domain.Document;
import io.ess.webpad.client.service.InMemoryApiServiceImpl;

/**
 * Handles the api calls to a web pad server using
 * springs rest template configured to conform to 
 * the hateaos specifications.
 *
 * Created On Feb 5, 2017
 * @author Jonathan Miller
 */
public class DocumentRestClientImpl implements DocumentRestClient {
	
	private RestTemplate restTemplate = HalRestTemplateBuilder.build();
	private Logger logger = LogManager.getLogger(DocumentRestClientImpl.class);
	
	@Override
	public PagedResources<Resource<Document>> getDocuments(int page, int size) {
		String url = InMemoryApiServiceImpl.INSTANCE.getDocuments();
		logger.info(String.format("Getting documents from URL %s", url));
		MultiValueMap<String, String> options = new LinkedMultiValueMap<String, String>();
		HttpEntity<?> request = new HttpEntity<>(options);
		ResponseEntity<PagedResources<Resource<Document>>> pagedDocumentResponse 
			= restTemplate.exchange(url, HttpMethod.GET, request, new ParameterizedTypeReference<PagedResources<Resource<Document>>>(){});
		if(pagedDocumentResponse.getStatusCode() == HttpStatus.OK)
			return pagedDocumentResponse.getBody();
		else
			return null;
	}
	
	@Override
	public Resource<Document> getDocumentByName(String name) {
		MultiValueMap<String, String> options = new LinkedMultiValueMap<String, String>();
		options.add("name", name);
		HttpEntity<?> request = new HttpEntity<>(options);
		ResponseEntity<Resource<Document>> pagedDocumentResponse 
			= restTemplate.exchange("http://localhost:8083/documents/search/findOneByName", HttpMethod.GET, request, new ParameterizedTypeReference<Resource<Document>>(){});
		if(pagedDocumentResponse.getStatusCode() == HttpStatus.OK)
			return pagedDocumentResponse.getBody();
		else
			return null;
	}

	@Override
	public Resource<Document> getFullDocument(Resource<Document> documentResource) {
		MultiValueMap<String, String> options = new LinkedMultiValueMap<String, String>();
		HttpEntity<?> request = new HttpEntity<>(options);
		ResponseEntity<Resource<Document>> pagedDocumentResponse 
			= restTemplate.exchange(documentResource.getId().getHref(), HttpMethod.GET, request, new ParameterizedTypeReference<Resource<Document>>(){});
		if(pagedDocumentResponse.getStatusCode() == HttpStatus.OK)
			return pagedDocumentResponse.getBody();
		else
			return null;
	}

	@Override
	public Resource<Document> updateDocument(Resource<Document> documentResource) {
		MultiValueMap<String, String> options = new LinkedMultiValueMap<String, String>();
		HttpEntity<Resource<Document>> request = new HttpEntity<Resource<Document>>(documentResource, options);
		ResponseEntity<Resource<Document>> pagedDocumentResponse 
			= restTemplate.exchange(documentResource.getId().getHref(), HttpMethod.PUT, request, new ParameterizedTypeReference<Resource<Document>>(){});
		if(pagedDocumentResponse.getStatusCode() == HttpStatus.OK)
			return pagedDocumentResponse.getBody();
		else
			return null;
	}

}
