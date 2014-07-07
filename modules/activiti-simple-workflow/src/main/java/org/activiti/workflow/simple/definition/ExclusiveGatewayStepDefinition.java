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

import org.activiti.workflow.simple.exception.SimpleWorkflowException;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * 
 */
@JsonTypeName("exclusive-gateway")
public class ExclusiveGatewayStepDefinition extends AbstractNamedStepDefinition {
    protected String  documentation;
    protected boolean asynchronous;
    protected boolean notExclusive;
    protected String  defaultFlow;

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public boolean isAsynchronous() {
        return asynchronous;
    }

    public void setAsynchronous(boolean asynchronous) {
        this.asynchronous = asynchronous;
    }

    public boolean isNotExclusive() {
        return notExclusive;
    }

    public void setNotExclusive(boolean notExclusive) {
        this.notExclusive = notExclusive;
    }

    public String getDefaultFlow() {
        return defaultFlow;
    }

    public void setDefaultFlow(String defaultFlow) {
        this.defaultFlow = defaultFlow;
    }

    @Override
    public StepDefinition clone() {
        ExclusiveGatewayStepDefinition clone = new ExclusiveGatewayStepDefinition();
        clone.setValues(this);
        return clone;
    }

    @Override
    public void setValues(StepDefinition otherDefinition) {
        if (!(otherDefinition instanceof ExclusiveGatewayStepDefinition)) {
            throw new SimpleWorkflowException("An instance of ExclusiveGatewayStepDefinition is required to set values");
        }

        ExclusiveGatewayStepDefinition stepDefinition = (ExclusiveGatewayStepDefinition) otherDefinition;
        setId(stepDefinition.getId());
        setName(stepDefinition.getName());
        setStartsWithPrevious(stepDefinition.isStartsWithPrevious());
        setAsynchronous(stepDefinition.isAsynchronous());
        setNotExclusive(stepDefinition.isNotExclusive());
        setDefaultFlow(stepDefinition.getDefaultFlow());

        setParameters(new HashMap<String, Object>(stepDefinition.getParameters()));
    }
}
