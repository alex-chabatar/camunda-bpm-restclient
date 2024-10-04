package org.camunda.bpm.rest.client.autoconfigure;

import org.camunda.bpm.rest.client.ApiClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Configuration
@ConditionalOnProperty(prefix = "camunda.rest", value = "url")
@EnableConfigurationProperties(CamundaRestClientProperties.class)
@ComponentScan("org.camunda.bpm.rest.client")
@RequiredArgsConstructor
public class CamundaRestClientAutoConfiguration {

  private final CamundaRestClientProperties properties;

  @Bean
  public ApiClient apiClient(@Qualifier("camundaRestTemplate") RestTemplate restTemplate) {
    var apiClient = new ApiClient(restTemplate).setBasePath(properties.getUrl());
    apiClient.setUsername(properties.getUser());
    apiClient.setPassword(properties.getPassword());
    return apiClient;
  }

}
