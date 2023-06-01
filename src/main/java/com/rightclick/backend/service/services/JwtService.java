package com.rightclick.backend.service.services;

import com.rightclick.backend.model.JwtRequest;
import com.rightclick.backend.model.JwtResponse;
import com.rightclick.backend.model.ResponseDTO;
import com.rightclick.backend.model.SignupRequest;

public interface JwtService {

    public ResponseDTO<JwtResponse> onLogin(JwtRequest jwtRequest) throws Exception;

    ResponseDTO<String> submitSignupData(SignupRequest signupRequest);
}
