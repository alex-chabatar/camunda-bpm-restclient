package org.camunda.bpm.rest.client;

import static org.assertj.core.api.Assertions.assertThat;

import org.camunda.bpm.rest.client.util.WorkflowHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:test-context-it.xml")
class CamundaRestClientTest {

  @Autowired
  private WorkflowHelper workflowHelper;

  @Test
  void contentLoaded() {
    assertThat(workflowHelper).isNotNull();
    assertThat(workflowHelper.getProcessInstanceApi()).isNotNull();
    assertThat(workflowHelper.getTaskApi()).isNotNull();
    assertThat(workflowHelper.getMessageApi()).isNotNull();
  }

}
