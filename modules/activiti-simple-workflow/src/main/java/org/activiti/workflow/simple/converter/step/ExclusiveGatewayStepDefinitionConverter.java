/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.activiti.workflow.simple.converter.step;

import org.activiti.bpmn.model.ExclusiveGateway;
import org.activiti.workflow.simple.converter.WorkflowDefinitionConversion;
import org.activiti.workflow.simple.definition.ExclusiveGatewayStepDefinition;
import org.activiti.workflow.simple.definition.StepDefinition;

public class ExclusiveGatewayStepDefinitionConverter extends
        BaseStepDefinitionConverter<ExclusiveGatewayStepDefinition, ExclusiveGateway> {

    private static final String EXCLUSIVE_GATEWAY_PREFIX = "exclusiveGateway";

    public Class<? extends StepDefinition> getHandledClass() {
        return ExclusiveGatewayStepDefinition.class;
    }

    protected ExclusiveGateway createProcessArtifact(ExclusiveGatewayStepDefinition stepDefinition,
            WorkflowDefinitionConversion conversion) {

        // First choice gateway
        ExclusiveGateway forkGateway = createExclusiveGateway(stepDefinition, conversion);
        forkGateway.setName(stepDefinition.getName());
        forkGateway.setDefaultFlow(stepDefinition.getDefaultFlow());

        // Sequence flow from last activity to first gateway
        addSequenceFlow(conversion, conversion.getLastActivityId(), forkGateway.getId());
        conversion.setLastActivityId(forkGateway.getId());

        return forkGateway;
    }

    protected ExclusiveGateway createExclusiveGateway(ExclusiveGatewayStepDefinition stepDefinition,
            WorkflowDefinitionConversion conversion) {
        ExclusiveGateway exclusiveGateway = new ExclusiveGateway();
        if (stepDefinition != null && stepDefinition.getId() != null) {
            exclusiveGateway.setId(stepDefinition.getId());
        } else {
            exclusiveGateway.setId(conversion.getUniqueNumberedId(EXCLUSIVE_GATEWAY_PREFIX));
        }
        conversion.getProcess().addFlowElement(exclusiveGateway);
        return exclusiveGateway;
    }

}
