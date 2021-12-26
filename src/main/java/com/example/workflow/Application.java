package com.example.workflow;

import com.example.workflow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
  @Autowired
  private UserRepository appUserRepository;

  public static void main(String... args) {
    SpringApplication.run(Application.class, args);
  }

}