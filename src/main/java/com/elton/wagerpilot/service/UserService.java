package com.elton.wagerpilot.service;

import com.elton.wagerpilot.dto.RegisterRequest;
import com.elton.wagerpilot.entity.User;
import com.elton.wagerpilot.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

public String  printMessage(){
    return "HELLO 12345";
}

    public String registerUser(RegisterRequest request) {
        if(userRepository.existsByEmail(request.getEmail())) {
            return "Email already exists";
        }
        if(userRepository.existsByUsername(request.getUsername())){
            return "Username already exists";
        }


        try {

            User user = new User();

            user.setUsername(request.getUsername());
            user.setEmail(request.getEmail());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setCreatedAt(LocalDateTime.now());

            userRepository.save(user);

            return "User Registered Successfully";

        } catch (Exception e) {

            e.printStackTrace();

            return e.getClass().getName() + " : " + e.getMessage();

        }

    }
}
