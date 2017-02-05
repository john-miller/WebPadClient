package io.ess.webpad.client.service;
import org.apache.log4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import io.ess.webpad.client.rest.HalRestTemplateBuilder;

/**
 * 
 *
 * Created On Feb 5, 2017
 * @author Jonathan Miller
 */
public enum InMemoryApiServiceImpl implements ApiService {
	
	INSTANCE;
	
	private RestTemplate restTemplate = HalRestTemplateBuilder.build();
	private final String baseUrl = System.getProperty("webpad.client.baseUrl");
	private Link documents;
	private Logger logger = Logger.getLogger(InMemoryApiServiceImpl.class);
	
	private InMemoryApiServiceImpl() {
		MultiValueMap<String, String> options = new LinkedMultiValueMap<String, String>();
		HttpEntity<?> request = new HttpEntity<>(options);
		ResponseEntity<Resource<Object>> response 
			= restTemplate.exchange(baseUrl, HttpMethod.GET, request, new ParameterizedTypeReference<Resource<Object>>(){});
		logger.info(String.format("Got response from server %s", response));
		if(response.getStatusCode() == HttpStatus.OK) 
			documents = response.getBody().getLink("documents");
	}

	@Override
	public String getDocuments() {
		if(documents.isTemplated())
			return documents.getHref().substring(0, documents.getHref().indexOf("{"));
		else
			return documents.getHref();
	}

}
