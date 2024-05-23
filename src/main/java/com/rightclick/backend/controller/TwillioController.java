package com.rightclick.backend.controller;

import com.rightclick.backend.model.MobileLoginRequest;
import com.rightclick.backend.model.OrderRequest;
import com.rightclick.backend.model.OrderResponse;
import com.rightclick.backend.model.ResponseDTO;
import com.rightclick.backend.service.services.TwillioService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class TwillioController {

    @Autowired
    TwillioService twillioService;

    private static final Logger log= LogManager.getLogger(ProductController.class);

    @PostMapping("/sendMessage")
    public ResponseDTO<String> sendMessage(@RequestBody MobileLoginRequest mobileLoginRequest) throws Exception {
        log.info("Starting Controller for method {sendMessage} Request is :{}",mobileLoginRequest);
        return  twillioService.sendMessage(mobileLoginRequest);
    }

}
