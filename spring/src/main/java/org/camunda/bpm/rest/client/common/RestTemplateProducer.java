package org.camunda.bpm.rest.client.common;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;

public class RestTemplateProducer {

  public static final ObjectMapper MAPPER = new ObjectMapper()
      .setSerializationInclusion(JsonInclude.Include.NON_NULL)
      .enable(SerializationFeature.INDENT_OUTPUT)
      .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
      .setDateFormat(new StdDateFormat().withColonInTimeZone(false))
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

  public static RestTemplate create(ClientHttpRequestFactory clientHttpRequestFactory) {

    RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);

    restTemplate.getMessageConverters().removeIf(
        m -> m.getClass().isAssignableFrom(MappingJackson2HttpMessageConverter.class));
    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter(MAPPER));

    restTemplate.setErrorHandler(new RestServiceErrorHandler());

    return restTemplate;
  }

}
