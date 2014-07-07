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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.activiti.bpmn.model.EventDefinition;
import org.activiti.workflow.simple.exception.SimpleWorkflowException;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * 
 */
@JsonTypeName("boundary-event")
public class BoundaryEventStepDefinition extends AbstractNamedStepDefinition {

    protected StepDefinition        attachedToRef;
    protected boolean               cancelActivity   = true;

    protected List<EventDefinition> eventDefinitions = new ArrayList<EventDefinition>();

    public List<EventDefinition> getEventDefinitions() {
        return eventDefinitions;
    }

    public void setEventDefinitions(List<EventDefinition> eventDefinitions) {
        this.eventDefinitions = eventDefinitions;
    }

    public void addEventDefinition(EventDefinition eventDefinition) {
        eventDefinitions.add(eventDefinition);
    }

    public StepDefinition getAttachedToRef() {
        return attachedToRef;
    }

    public void setAttachedToRef(StepDefinition attachedToRef) {
        this.attachedToRef = attachedToRef;
    }

    public boolean isCancelActivity() {
        return cancelActivity;
    }

    public void setCancelActivity(boolean cancelActivity) {
        this.cancelActivity = cancelActivity;
    }

    @Override
    public StepDefinition clone() {
        BoundaryEventStepDefinition clone = new BoundaryEventStepDefinition();
        clone.setValues(this);
        return clone;
    }

    @Override
    public void setValues(StepDefinition otherDefinition) {
        if (!(otherDefinition instanceof BoundaryEventStepDefinition)) {
            throw new SimpleWorkflowException("An instance of BoundaryEventStepDefinition is required to set values");
        }

        BoundaryEventStepDefinition stepDefinition = (BoundaryEventStepDefinition) otherDefinition;
        setId(stepDefinition.getId());
        setName(stepDefinition.getName());
        setAttachedToRef(stepDefinition.getAttachedToRef());
        setCancelActivity(stepDefinition.isCancelActivity());
        setStartsWithPrevious(stepDefinition.isStartsWithPrevious());

        setParameters(new HashMap<String, Object>(otherDefinition.getParameters()));

        eventDefinitions = new ArrayList<EventDefinition>();
        if (stepDefinition.getEventDefinitions() != null && stepDefinition.getEventDefinitions().size() > 0) {
            for (EventDefinition eventDef : stepDefinition.getEventDefinitions()) {
                eventDefinitions.add(eventDef.clone());
            }
        }
    }
}
