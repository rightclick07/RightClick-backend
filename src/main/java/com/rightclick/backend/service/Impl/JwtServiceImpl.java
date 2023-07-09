package com.rightclick.backend.service.Impl;

import com.rightclick.backend.Entity.UserEntity;
import com.rightclick.backend.Repository.UsersRepository;
import com.rightclick.backend.Util.JwtUtil;
import com.rightclick.backend.constants.AppConstants;
import com.rightclick.backend.model.JwtRequest;
import com.rightclick.backend.model.JwtResponse;
import com.rightclick.backend.model.ResponseDTO;
import com.rightclick.backend.model.SignupRequest;
import com.rightclick.backend.service.services.JwtService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class JwtServiceImpl  implements JwtService {



    @Autowired
    private CustomUserDetailsServiceImpl customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UsersRepository usersRepository;

    private final PasswordEncoder passwordEncoder;
    @Autowired
    public JwtServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    AppConstants appConstants;

    private static final Logger log= LogManager.getLogger(JwtServiceImpl.class);

    @Override
    public ResponseDTO<JwtResponse> onLogin(JwtRequest jwtRequest) throws Exception {
        log.info("Starting Service for method {onLogin} Request is :{}",jwtRequest);
        ResponseDTO<JwtResponse> responseDTO=new ResponseDTO<>();
        try{
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
                    (jwtRequest.getUsername(),jwtRequest.getPassword()));
            UserDetails userDetails=this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
            String token=this.jwtUtil.generateToken(userDetails);

            UserEntity userEntity =usersRepository.findByUsername(jwtRequest.getUsername());
            JwtResponse jwtResponse=new JwtResponse();

            jwtResponse.setId(userEntity.getId());
            jwtResponse.setToken(token);
            jwtResponse.setUsername(userEntity.getUsername());
            jwtResponse.setEmail(userEntity.getEmail());
            jwtResponse.setRole(userEntity.getRole());

            responseDTO.setHttpStatusCode(HttpStatus.OK);
            responseDTO.setMessage(appConstants.successMsg);
            responseDTO.setPayload(jwtResponse);

        } catch (UsernameNotFoundException e){
            e.printStackTrace();
            responseDTO.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            responseDTO.setMessage(appConstants.bad_credential);
            responseDTO.setPayload(null);
        } catch (BadCredentialsException e){
            responseDTO.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            responseDTO.setMessage(appConstants.bad_credential);
            responseDTO.setPayload(null);
        }catch (Exception e) {
            e.printStackTrace();
            responseDTO.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            responseDTO.setMessage(appConstants.failureMsg);
            responseDTO.setPayload(null);
        }
        return responseDTO;

    }

    @Override
    public ResponseDTO<String> submitSignupData(SignupRequest signupRequest) {
        log.info("Starting Service for method {submitSignupData} Request is :{}",signupRequest);

        ResponseDTO<String> responseDTO=new ResponseDTO<>();
        UserEntity userEntity = new UserEntity();
        try{
            if(signupRequest.getUsername()!=null) {
                String rawPassword = signupRequest.getPassword()!=null?signupRequest.getPassword():"";
                String hashedPassword = passwordEncoder.encode(rawPassword);

                userEntity.setUsername(signupRequest.getUsername()!=null?signupRequest.getUsername():"");
                userEntity.setFullName(signupRequest.getFullname()!=null?signupRequest.getFullname():"");
                userEntity.setEmail(signupRequest.getEmailId()!=null?signupRequest.getEmailId():"");
                userEntity.setPassword(hashedPassword!=null?hashedPassword:"");
                userEntity.setAddress(signupRequest.getAddress()!=null?signupRequest.getAddress():"");
                userEntity.setMobileNumber(signupRequest.getMobileNumber()!=null?signupRequest.getMobileNumber():"");
                userEntity.setRole("customer");
                userEntity.setActive(signupRequest.getActive() != null ? signupRequest.getActive() : true);
                userEntity.setCreatedAt(signupRequest.getCreatedAt()!=null?signupRequest.getCreatedAt():  new Timestamp(System.currentTimeMillis()));
                userEntity.setUpdatedAt(signupRequest.getUpdatedAt()!=null?signupRequest.getUpdatedAt():new Timestamp(System.currentTimeMillis()));
            }
            usersRepository.save(userEntity);

            responseDTO.setHttpStatusCode(HttpStatus.OK);
            responseDTO.setMessage(appConstants.successMsg);
            responseDTO.setPayload(appConstants.signup_success);

        } catch (Exception e){
            e.printStackTrace();
            responseDTO.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            responseDTO.setMessage(appConstants.failureMsg);
            responseDTO.setPayload(null);
        }
        return responseDTO;
    }
}
