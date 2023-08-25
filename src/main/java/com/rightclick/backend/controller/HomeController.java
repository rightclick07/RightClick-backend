package com.rightclick.backend.controller;

import com.rightclick.backend.Entity.OrdersEntity;
import com.rightclick.backend.Entity.UserEntity;
import com.rightclick.backend.model.ResponseDTO;
import com.rightclick.backend.service.Impl.UserServiceImpl;
import com.rightclick.backend.service.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController

public class HomeController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private UserService userService;

    private static final Logger log= LogManager.getLogger(HomeController.class);

    @GetMapping("/getData")
    public String greet(){
        return "Welcome";
    }

    @GetMapping("/getFullUsername/{username}")
    public String getFullUserName(@PathVariable("username") String username){
       return userServiceImpl.getFullUserNameService(username);
    }
    @GetMapping("/getUser/{userId}")
    public ResponseDTO<Optional<UserEntity>> getUserData(@PathVariable("userId") Integer userId){
        log.info("Starting Controller for method {getUserData} for userId:{}",userId);

        return userService.getUserData(userId);
    }

    @GetMapping("/getAllOrdersByUser/{userId}")
    public ResponseDTO<List<OrdersEntity>> getUserOrdersData(@PathVariable("userId") Integer userId){
        log.info("Starting Controller for method {getUserOrdersData} for userId:{}",userId);

        return userService.getUserOrders(userId);
    }
}
