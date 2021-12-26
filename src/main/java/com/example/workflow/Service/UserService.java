package com.example.workflow.Service;

import com.example.workflow.Model.User;
import com.example.workflow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository UserRepository;

    public User getUserByUsername(String username) {
        return this.UserRepository.findByUsername(username);
    }
}
