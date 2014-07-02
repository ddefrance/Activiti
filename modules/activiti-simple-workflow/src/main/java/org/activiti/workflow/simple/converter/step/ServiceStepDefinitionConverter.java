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

import org.activiti.bpmn.model.ServiceTask;
import org.activiti.workflow.simple.converter.WorkflowDefinitionConversion;
import org.activiti.workflow.simple.definition.ServiceStepDefinition;
import org.activiti.workflow.simple.definition.StepDefinition;

/**
 * 
 */
public class ServiceStepDefinitionConverter extends BaseStepDefinitionConverter<ServiceStepDefinition, ServiceTask> {

    @Override
    public Class<? extends StepDefinition> getHandledClass() {
        return ServiceStepDefinition.class;
    }

    @Override
    protected ServiceTask createProcessArtifact(ServiceStepDefinition stepDefinition,
            WorkflowDefinitionConversion conversion) {
        ServiceTask serviceTask = new ServiceTask();
        serviceTask.setId(stepDefinition.getId());
        serviceTask.setName(stepDefinition.getName());

        serviceTask.setImplementation(stepDefinition.getImplementation());
        serviceTask.setImplementationType(stepDefinition.getImplementationType());
        serviceTask.setResultVariableName(stepDefinition.getResultVariableName());
        serviceTask.setType(stepDefinition.getType());
        serviceTask.setOperationRef(stepDefinition.getOperationRef());
        serviceTask.setExtensionId(stepDefinition.getExtensionId());
        serviceTask.setFieldExtensions(stepDefinition.getFieldExtensions());
        serviceTask.setCustomProperties(stepDefinition.getCustomProperties());

        
        conversion.setUpdateLastActivityEnabled(false);
        
        addFlowElement(conversion, serviceTask, false);
        
        conversion.setUpdateLastActivityEnabled(true);

        return serviceTask;
    }

}
