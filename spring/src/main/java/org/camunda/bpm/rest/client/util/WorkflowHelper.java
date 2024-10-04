package org.camunda.bpm.rest.client.util;

import org.camunda.bpm.rest.client.api.*;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Service
@Getter
@RequiredArgsConstructor
public class WorkflowHelper {

  private final AuthorizationApi authorizationApi;
  private final BatchApi batchApi;
  private final ConditionApi conditionApi;
  private final DecisionDefinitionApi decisionDefinitionApi;
  private final DecisionRequirementsDefinitionApi decisionRequirementsDefinitionApi;
  private final DeploymentApi deploymentApi;
  private final EngineApi engineApi;
  private final EventSubscriptionApi eventSubscriptionApi;
  private final ExecutionApi executionApi;
  private final ExternalTaskApi externalTaskApi;
  private final FilterApi filterApi;
  private final GroupApi groupApi;
  private final HistoricActivityInstanceApi historicActivityInstanceApi;
  private final HistoricBatchApi historicBatchApi;
  private final HistoricDecisionDefinitionApi historicDecisionDefinitionApi;
  private final HistoricDecisionInstanceApi historicDecisionInstanceApi;
  private final HistoricDecisionRequirementsDefinitionApi historicDecisionRequirementsDefinitionApi;
  private final HistoricDetailApi historicDetailApi;
  private final HistoricExternalTaskLogApi historicExternalTaskLogApi;
  private final HistoricIdentityLinkLogApi historicIdentityLinkLogApi;
  private final HistoricIncidentApi historicIncidentApi;
  private final HistoricJobLogApi historicJobLogApi;
  private final HistoricProcessDefinitionApi historicProcessDefinitionApi;
  private final HistoricProcessInstanceApi historicProcessInstanceApi;
  private final HistoricTaskInstanceApi historicTaskInstanceApi;
  private final HistoricUserOperationLogApi historicUserOperationLogApi;
  private final HistoricVariableInstanceApi historicVariableInstanceApi;
  private final HistoryCleanupApi historyCleanupApi;
  private final IdentityApi identityApi;
  private final IncidentApi incidentApi;
  private final JobApi jobApi;
  private final JobDefinitionApi jobDefinitionApi;
  private final MessageApi messageApi;
  private final MetricsApi metricsApi;
  private final MigrationApi migrationApi;
  private final ModificationApi modificationApi;
  private final ProcessDefinitionApi processDefinitionApi;
  private final ProcessInstanceApi processInstanceApi;
  private final SchemaLogApi schemaLogApi;
  private final SignalApi signalApi;
  private final TaskApi taskApi;
  private final TaskAttachmentApi taskAttachmentApi;
  private final TaskCommentApi taskCommentApi;
  private final TaskIdentityLinkApi taskIdentityLinkApi;
  private final TaskLocalVariableApi taskLocalVariableApi;
  private final TaskVariableApi taskVariableApi;
  private final TelemetryApi telemetryApi;
  private final TenantApi tenantApi;
  private final UserApi userApi;
  private final VariableInstanceApi variableInstanceApi;
  private final VersionApi versionApi;

}
