package com.rightclick.backend.controller;

import com.rightclick.backend.model.EmailRequest;
import com.rightclick.backend.model.ResponseDTO;
import com.rightclick.backend.service.services.EmailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@CrossOrigin(origins = "*")
@RestController
public class EmailController {


    @Autowired
    EmailService emailService;

    private static final Logger log= LogManager.getLogger(OrdersController.class);

    @PostMapping("/sendMail")
    public ResponseDTO<String> sendEmail(@RequestBody EmailRequest emailRequest) throws MessagingException {
        log.info("Starting Controller for method {sendEmail} Request is :{}",emailRequest);
        return emailService.sendEmail(emailRequest);
    }

}
