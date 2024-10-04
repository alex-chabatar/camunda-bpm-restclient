package org.camunda.bpm.rest.client.conf;

import javax.annotation.PostConstruct;

import org.camunda.bpm.rest.client.common.RestTemplateProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CamundaRestTemplateFactory {

  @Value("${camunda.rest.timeout.connect:10000}")
  private int connectTimeout;

  @Value("${camunda.rest.timeout.request:10000}")
  private int connectionRequestTimeout;

  @Value("${camunda.rest.timeout.read:10000}")
  private int readTimeout;

  private RestTemplate restTemplate;

  @Bean(name = "camundaRestTemplate")
  public RestTemplate getObject() {
    return restTemplate;
  }

  @PostConstruct
  public void afterPropertiesSet() {

    HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
    requestFactory.setReadTimeout(this.readTimeout);
    requestFactory.setConnectTimeout(this.connectTimeout);
    requestFactory.setConnectionRequestTimeout(connectionRequestTimeout);

    restTemplate = RestTemplateProducer.create(requestFactory);

  }

}
