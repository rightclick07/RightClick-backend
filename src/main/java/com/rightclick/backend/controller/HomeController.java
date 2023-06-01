package com.rightclick.backend.controller;

import com.rightclick.backend.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/getData")
    public String greet(){
        return "Welcome";
    }

    @GetMapping("/getFullUsername/{username}")
    public String getFullUserName(@PathVariable("username") String username){
       return userService.getFullUserNameService(username);
    }
}
