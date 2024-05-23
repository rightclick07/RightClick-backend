package com.rightclick.backend.service.Impl;


import com.rightclick.backend.constants.AppConstants;
import com.rightclick.backend.model.MobileLoginRequest;

import com.rightclick.backend.model.ResponseDTO;
import com.rightclick.backend.service.services.TwillioService;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Service
public class TwillioServiceImpl implements TwillioService {
    AppConstants appConstants;

    @Override
    public ResponseDTO<String> sendMessage(MobileLoginRequest mobileLoginRequest) {

        ResponseDTO<String> responseDTO=new ResponseDTO<>();
        Map<String, String> otpMap = new HashMap<>();
        try {
            PhoneNumber to = new PhoneNumber(mobileLoginRequest.getMobileNumber());
            PhoneNumber from = new PhoneNumber("+918620038489");
            String otp = generateOTP();
            String otpMessage = "Dear Customer, Your OTP is ##" + otp + "Use this to Log in to Everse";
            Message message = Message
                    .creator(to, from,
                            otpMessage)
                    .create();
            otpMap.put(mobileLoginRequest.getName(), otp);
            responseDTO.setHttpStatusCode(HttpStatus.OK);
            responseDTO.setPayload("DELIVERED");
            responseDTO.setMessage("OTP Successfully Delivered!");
        } catch (Exception e){
            e.printStackTrace();
            responseDTO.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            responseDTO.setMessage(appConstants.failureMsg);
            responseDTO.setPayload(null);
        }
        return responseDTO;

    }


    //4 digit otp
    private String generateOTP() {
        return new DecimalFormat("0000")
                .format(new Random().nextInt(9999));
    }

}
