package io.ess.webpad.client.rest;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HalRestTemplateBuilder {
	
	/**
	 * Creates a new rest template and configures it to work with Springboot's
	 * HAL/JSON specification
	 * @return
	 */
	public static RestTemplate build() {
		RestTemplate restTemplate = new RestTemplate();
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
        return restTemplate;
	}

}
