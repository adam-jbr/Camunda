package com.example.workflow.Service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;

@Named
public class projectValidator implements JavaDelegate {

    @Autowired
    public BpmnService bpmnService;

    @Autowired
    public ProjectService projectService;
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("hello");
        Boolean isValid = this.projectService.checkProjectIfValid();
        this.projectService.setProjectAsInvalid(this.projectService.getSelectedProject());
        this.bpmnService.setVariable(this.bpmnService.getProcessId(),"projectIsValid",isValid.toString());
    }
}
