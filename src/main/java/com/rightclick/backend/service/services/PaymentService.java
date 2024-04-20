package com.rightclick.backend.service.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rightclick.backend.model.PaymentRequest;
import com.rightclick.backend.model.ResponseDTO;
import org.springframework.http.ResponseEntity;

public interface PaymentService {

    ResponseDTO preparePayment(PaymentRequest paymentRequest) ;
}
