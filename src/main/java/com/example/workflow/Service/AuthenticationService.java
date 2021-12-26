package com.example.workflow.Service;

import com.example.workflow.Model.User;
import com.example.workflow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService appUserService;

    public boolean isAvailable(String username) {
        return this.userRepository.findByUsername(username) != null;
    }

    public boolean isProfessor(String email) {
        return this.userRepository.findByUsername(email).getIsProfessor();
    }

    public String signUp(User user) {
        userRepository.save(new User("adam","jaber",true));
        userRepository.save(new User("ali","hammoud",true));
        userRepository.save(new User("hussein","bassal",false));
        userRepository.save(new User("joe","mechref",false));
        return "successful";
    }
}
