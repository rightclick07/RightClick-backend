package com.rightclick.backend.controller;

import com.rightclick.backend.Repository.UsersRepository;
import com.rightclick.backend.Util.JwtUtil;
import com.rightclick.backend.model.JwtRequest;
import com.rightclick.backend.model.JwtResponse;
import com.rightclick.backend.model.ResponseDTO;
import com.rightclick.backend.model.SignupRequest;
import com.rightclick.backend.service.Impl.CustomUserDetailsServiceImpl;
import com.rightclick.backend.service.services.JwtService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class JwtController {


    @Autowired
    private JwtService jwtService;



    private static final Logger log= LogManager.getLogger(JwtController.class);

    @PostMapping("/login")
    public ResponseDTO<JwtResponse> onLogin(@RequestBody JwtRequest jwtRequest) throws Exception {
        log.info("Starting Controller for method {onSignup} Request is :{}",jwtRequest);
        return  jwtService.onLogin(jwtRequest);
    }


    @PostMapping("/signup")
    public ResponseDTO<String> onSignup(@RequestBody SignupRequest signupRequest) {
        log.info("Starting Controller for method {onSignup} Request is :{}",signupRequest);
        return jwtService.submitSignupData(signupRequest);
    }
}
