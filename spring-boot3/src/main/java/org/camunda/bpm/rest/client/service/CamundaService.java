package org.camunda.bpm.rest.client.service;

import java.util.Map;

import org.camunda.bpm.rest.client.model.CompleteTaskDto;
import org.camunda.bpm.rest.client.model.VariableValueDto;
import org.camunda.bpm.rest.client.util.WorkflowHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CamundaService {

  @Autowired
  private WorkflowHelper workflowHelper;

  public void completeTask(String taskId, Map<String, Object> variables) {

    log.info("Completing task '{}': {}", taskId, variables);

    Map<String, VariableValueDto> taskVariables = Maps.newHashMap();
    variables.forEach((key, value) -> taskVariables.put(key, new VariableValueDto().value(value)));

    var taskDto = new CompleteTaskDto()
        .variables(taskVariables);

    workflowHelper.getTaskApi().complete(taskId, taskDto);

  }

}
