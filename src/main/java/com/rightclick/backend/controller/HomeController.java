package com.rightclick.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/getData")
    public String greet(){
        return "Welcome";
    }
}
