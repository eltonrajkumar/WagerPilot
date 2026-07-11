package com.elton.wagerpilot.service;

import com.elton.wagerpilot.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

public String  printMessage(){
       return "Our service is working!!";
}
}
