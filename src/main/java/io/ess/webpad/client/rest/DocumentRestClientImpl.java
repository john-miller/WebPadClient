package io.ess.webpad.client.rest;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.ess.webpad.client.domain.Document;

public class DocumentRestClientImpl implements DocumentRestClient {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public static void main(String[] args) {
		PagedResources<Resource<Document>> pagedDocuments = new DocumentRestClientImpl().getDocuments(0, 5);
		Collection<Resource<Document>> documents = pagedDocuments.getContent();
		for(Resource<Document> documentResource : documents) {
			System.out.println(documentResource.getContent().getName());
			
		}
	}
	
	public DocumentRestClientImpl() {
        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jackson2HalModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MappingJackson2HttpMessageConverter halConverter = new MappingJackson2HttpMessageConverter();
        halConverter.setObjectMapper(mapper);
        halConverter.setSupportedMediaTypes(Arrays.asList(MediaTypes.HAL_JSON));
        converters.add(halConverter);
        restTemplate.setMessageConverters(converters);
	}

	@Override
	public PagedResources<Resource<Document>> getDocuments(int page, int size) {
		MultiValueMap<String, String> options = new LinkedMultiValueMap<String, String>();
		HttpEntity<?> request = new HttpEntity<>(options);
		ResponseEntity<PagedResources<Resource<Document>>> pagedDocumentResponse 
			= restTemplate.exchange("http://localhost:8083/documents", HttpMethod.GET, request, new ParameterizedTypeReference<PagedResources<Resource<Document>>>(){});
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
