package org.camunda.bpm.rest.client.conf;

import org.camunda.bpm.rest.client.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CamundaRestClientTestConfig {

  @Value("${camunda.rest.url}")
  private String basePath;

  @Value("${camunda.rest.user}")
  private String user;

  @Value("${camunda.rest.password}")
  private String password;

  @Autowired
  @Qualifier("camundaRestTemplate")
  private RestTemplate restTemplate;

  @Bean
  public ApiClient apiClient() {
    var apiClient = new ApiClient(restTemplate).setBasePath(basePath);
    apiClient.setUsername(user);
    apiClient.setPassword(password);
    return apiClient;
  }

}
