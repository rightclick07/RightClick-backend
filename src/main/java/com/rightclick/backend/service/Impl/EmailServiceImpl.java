package com.rightclick.backend.service.Impl;


import com.rightclick.backend.constants.AppConstants;
import com.rightclick.backend.model.EmailRequest;
import com.rightclick.backend.model.ResponseDTO;
import com.rightclick.backend.service.services.EmailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.math.BigDecimal;
import java.util.Date;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    AppConstants appConstants;

    private static final Logger log= LogManager.getLogger(EmailServiceImpl.class);

    @Override
    public ResponseDTO<String> sendEmail(EmailRequest emailRequest) throws MessagingException {
        log.info("Starting Service for method {sendEmail} Request is :{}",emailRequest);

        ResponseDTO<String> responseDTO= new ResponseDTO<>();

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        try{

            helper.setTo(emailRequest.getReceiverEmail());
            helper.setSubject(emailRequest.getSubject());
            helper.setFrom(emailRequest.getSenderEmail());
            // Load and process the HTML template using Thymeleaf
            Context context = new Context();
            context.setVariable("customerName", emailRequest.getCustomerName());
            context.setVariable("orderId", emailRequest.getOrderRequest().getId());
            context.setVariable("customerId", emailRequest.getOrderRequest().getCustomerId());
            context.setVariable("orderDate", emailRequest.getOrderRequest().getOrderDate());
            context.setVariable("totalAmount", emailRequest.getOrderRequest().getTotalAmount());
            context.setVariable("shippingAddress", emailRequest.getOrderRequest().getShippingAddress());
            context.setVariable("paymentMethod", emailRequest.getOrderRequest().getPaymentMethod());
            context.setVariable("paymentStatus", emailRequest.getOrderRequest().getPaymentStatus());
            context.setVariable("deliveryDate", emailRequest.getOrderRequest().getDeliveryDate());
            context.setVariable("trackingNumber", emailRequest.getOrderRequest().getTrackingNumber());
            context.setVariable("orderItems",emailRequest.getOrderItemsRequestList());
            // Add more variables for other order details

            // Set the HTML content of the email
            String content = templateEngine.process("customer_order_email", context);

            // Set the HTML content of the email
            helper.setText(content, true);

            javaMailSender.send(message);
            responseDTO.setHttpStatusCode(HttpStatus.OK);
            responseDTO.setMessage(appConstants.successMsg);
            responseDTO.setPayload("Mail Sent Successfully");
        } catch (Exception e){
            e.printStackTrace();
            responseDTO.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            responseDTO.setMessage(appConstants.failureMsg);
            responseDTO.setPayload(null);
        }
        return responseDTO;
    }
}
