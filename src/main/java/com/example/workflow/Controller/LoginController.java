package com.example.workflow.Controller;

import com.example.workflow.Model.User;
import com.example.workflow.Service.UserService;
import com.example.workflow.Service.AuthenticationService;
import com.example.workflow.Service.BpmnService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.inject.Named;


@Named
@RequestMapping("home")
public class LoginController {
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserService appUserService;

    @Autowired
    private BpmnService bmpnService;

    private String processId;

    public LoginController(){}

    @PostMapping("/login")
    public @ResponseBody
    User login(@RequestBody User user) throws Exception {
        if (this.authenticationService.isAvailable(user.getUsername())) {
            this.bmpnService.startProcess();
            String taskId = this.bmpnService.getUserTaskId("login");
            Boolean isProfessor = this.authenticationService.isProfessor(user.getUsername());
            this.bmpnService.setVariable(this.bmpnService.getProcessId(),"isProfessor",isProfessor.toString());
            this.bmpnService.completeUserTask(taskId);
            return appUserService.getUserByUsername(user.getUsername());
        } else {
            throw new Exception("email-not-exist");
        }
    }

    @PostMapping("/register")
    private @ResponseBody String register(@RequestBody User user) {
        return this.authenticationService.signUp(user);
    }
}
