package com.rightclick.backend.service.services;

import com.rightclick.backend.model.MobileLoginRequest;
import com.rightclick.backend.model.OrderResponse;
import com.rightclick.backend.model.ResponseDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface TwillioService {

    public ResponseDTO<String> sendMessage( MobileLoginRequest mobileLoginRequest);
}
