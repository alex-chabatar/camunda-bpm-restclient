package org.camunda.bpm.rest.client.conf;

import java.util.concurrent.TimeUnit;

import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.core5.http.io.SocketConfig;
import org.camunda.bpm.rest.client.common.RestTemplateProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import jakarta.annotation.PostConstruct;

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

    var httpClient = HttpClientBuilder.create()
        .setConnectionManager(PoolingHttpClientConnectionManagerBuilder.create()
            .setDefaultSocketConfig(SocketConfig.custom()
                .setSoTimeout(readTimeout, TimeUnit.MILLISECONDS)
                .build())
            .build())
        .build();

    var requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
    requestFactory.setConnectTimeout(this.connectTimeout);
    requestFactory.setConnectionRequestTimeout(connectionRequestTimeout);

    restTemplate = RestTemplateProducer.create(requestFactory);

  }

}
