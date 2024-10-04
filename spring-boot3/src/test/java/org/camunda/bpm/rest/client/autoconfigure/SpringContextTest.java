package org.camunda.bpm.rest.client.autoconfigure;

import static org.assertj.core.api.Assertions.assertThat;

import org.camunda.bpm.rest.client.ApiClient;
import org.camunda.bpm.rest.client.util.WorkflowHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest(classes = SpringContextTest.TestConfig.class)
class SpringContextTest {

  @Autowired
  private WorkflowHelper workflowHelper;

  @Autowired
  private ApiClient apiClient;

  @Value("${camunda.rest.url}")
  private String basePath;

  @Test
  void contextLoaded() {
    assertThat(workflowHelper).isNotNull();
    assertThat(apiClient).isNotNull();
    assertThat(apiClient.getBasePath()).isEqualTo(basePath);
  }

  @SpringBootConfiguration
  @ComponentScan("org.camunda.bpm.rest.client")
  public static class TestConfig {
  }

}
