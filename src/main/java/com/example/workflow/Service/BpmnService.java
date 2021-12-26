package com.example.workflow.Service;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BpmnService {
    private String processId;

    @Autowired
    public RuntimeService runtimeService;
    @Autowired
    public TaskService taskService;
    @Autowired
    public AuthenticationService authenticationService;

    public void startProcess() {
        this.processId = this.runtimeService.startProcessInstanceByKey("fyp-bp-process").getId();
    }

    public void setVariable(String processId,String variableName, String value) {
        this.runtimeService.setVariable(processId,variableName, value);
    }

    public void completeUserTask(String taskId){
        this.taskService.complete(taskId);
    }

    public String getUserTaskId(String userTaskModelereId) {
        return taskService.createTaskQuery().processInstanceId(this.processId)
                .list()
                .stream()
                .filter( task -> task.getName().equals(userTaskModelereId)).findFirst().get().getId();
    }

    public String getProcessId() {
        return this.processId;
    }


}
