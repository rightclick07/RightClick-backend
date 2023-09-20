package com.rightclick.backend.controller;

import com.rightclick.backend.model.PaymentRequest;
import com.rightclick.backend.service.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/api/payment")
    public void initiatePayment(@RequestBody PaymentRequest paymentRequest){
        System.out.println("Payment intiated");

        paymentService.preparePayment(paymentRequest);

        System.out.println("Payment successfully");
    }

    @PostMapping(value = "/api/phonepe-callback")
    public void callbackPayment(@RequestBody PaymentRequest paymentRequest){
        System.out.println("Payment intiated"+paymentRequest);

        System.out.println("callbackPayment successfully");
    }

}
