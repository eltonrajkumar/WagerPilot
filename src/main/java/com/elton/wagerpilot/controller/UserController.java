package com.elton.wagerpilot.controller;


import com.elton.wagerpilot.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;

    }
@GetMapping("/test")
public String test(){
        return userService.printMessage();
}
}
