package org.camunda.bpm.rest.client.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(prefix = "camunda.rest")
public class CamundaRestClientProperties {

  private String url;
  private String user;
  private String password;

}
