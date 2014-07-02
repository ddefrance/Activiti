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
package org.activiti.workflow.simple.definition;

import java.util.HashMap;
import java.util.Map;

import org.activiti.workflow.simple.exception.SimpleWorkflowException;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

/**
 * 
 */
@JsonTypeName("sequence-flow")
public class SequenceFlowStepDefinition implements StepDefinition {

    protected String              id;
    protected String              conditionExpression;
    protected String              sourceRef;
    protected String              targetRef;
    protected Map<String, Object> parameters = new HashMap<String, Object>();

    public SequenceFlowStepDefinition() {

    }

    public SequenceFlowStepDefinition(String sourceRef, String targetRef) {
        this.sourceRef = sourceRef;
        this.targetRef = targetRef;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConditionExpression() {
        return conditionExpression;
    }

    public void setConditionExpression(String conditionExpression) {
        this.conditionExpression = conditionExpression;
    }

    public String getSourceRef() {
        return sourceRef;
    }

    public void setSourceRef(String sourceRef) {
        this.sourceRef = sourceRef;
    }

    public String getTargetRef() {
        return targetRef;
    }

    public void setTargetRef(String targetRef) {
        this.targetRef = targetRef;
    }

    @Override
    @JsonSerialize(include = Inclusion.NON_EMPTY)
    public Map<String, Object> getParameters() {
        return parameters;
    }

    @Override
    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public String toString() {
        return sourceRef + " --> " + targetRef;
    }

    public SequenceFlowStepDefinition clone() {
        SequenceFlowStepDefinition clone = new SequenceFlowStepDefinition();
        clone.setValues(this);
        return clone;
    }

    public void setValues(StepDefinition otherDefinition) {
        if (!(otherDefinition instanceof SequenceFlowStepDefinition)) {
            throw new SimpleWorkflowException("An instance of ServiceStepDefinition is required to set values");
        }
        SequenceFlowStepDefinition stepDefinition = (SequenceFlowStepDefinition) otherDefinition;
        setId(stepDefinition.getId());
        setConditionExpression(stepDefinition.getConditionExpression());
        setSourceRef(stepDefinition.getSourceRef());
        setTargetRef(stepDefinition.getTargetRef());
    }

}
