package com.elton.wagerpilot.service;

import com.elton.wagerpilot.dto.RegisterRequest;
import com.elton.wagerpilot.entity.User;
import com.elton.wagerpilot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

public String  printMessage(){
    return "HELLO 12345";
}
    public String registerUser(RegisterRequest request) {

        try {

            User user = new User();

            user.setUsername(request.getUsername());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            user.setCreatedAt(LocalDateTime.now());

            userRepository.save(user);

            return "User Registered Successfully";

        } catch (Exception e) {

            e.printStackTrace();

            return e.getClass().getName() + " : " + e.getMessage();

        }
    }
}
