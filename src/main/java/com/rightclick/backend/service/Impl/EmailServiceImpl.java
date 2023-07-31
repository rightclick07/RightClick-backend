package com.rightclick.backend.service.Impl;


import com.rightclick.backend.model.EmailRequest;
import com.rightclick.backend.model.ResponseDTO;
import com.rightclick.backend.service.services.EmailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private static final Logger log= LogManager.getLogger(EmailServiceImpl.class);

    @Override
    public ResponseDTO<String> sendEmail(EmailRequest emailRequest) {
        log.info("Starting Service for method {sendEmail} Request is :{}",emailRequest);
        return null;
    }
}
