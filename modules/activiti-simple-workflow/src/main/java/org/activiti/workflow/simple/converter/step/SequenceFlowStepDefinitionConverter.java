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

import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.workflow.simple.converter.WorkflowDefinitionConversion;
import org.activiti.workflow.simple.definition.SequenceFlowStepDefinition;
import org.activiti.workflow.simple.definition.StepDefinition;

/**
 * 
 */
public class SequenceFlowStepDefinitionConverter extends
        BaseStepDefinitionConverter<SequenceFlowStepDefinition, SequenceFlow> {

    @Override
    public Class<? extends StepDefinition> getHandledClass() {
        return SequenceFlowStepDefinition.class;
    }

    @Override
    protected SequenceFlow createProcessArtifact(SequenceFlowStepDefinition stepDefinition,
            WorkflowDefinitionConversion conversion) {

        SequenceFlow flow = addSequenceFlow(conversion, stepDefinition.getSourceRef(), stepDefinition.getTargetRef(),
                stepDefinition.getConditionExpression());
        flow.setName(stepDefinition.getName());
        return flow;
    }

}
