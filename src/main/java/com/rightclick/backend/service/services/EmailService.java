package com.rightclick.backend.service.services;

import com.rightclick.backend.model.EmailRequest;
import com.rightclick.backend.model.OrderRequest;
import com.rightclick.backend.model.OrderResponse;
import com.rightclick.backend.model.ResponseDTO;

import javax.mail.MessagingException;

public interface EmailService {

    ResponseDTO<String> sendEmail(EmailRequest emailRequest) throws MessagingException;

}
