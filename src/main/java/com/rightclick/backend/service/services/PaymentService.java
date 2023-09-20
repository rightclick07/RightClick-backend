package com.rightclick.backend.service.services;

import com.rightclick.backend.model.PaymentRequest;

public interface PaymentService {

    void preparePayment(PaymentRequest paymentRequest);
}
