package com.rightclick.backend.service.Impl;

import com.rightclick.backend.Entity.OrdersEntity;
import com.rightclick.backend.Entity.UserEntity;
import com.rightclick.backend.Repository.OrdersRepository;
import com.rightclick.backend.Repository.UsersRepository;
import com.rightclick.backend.constants.AppConstants;
import com.rightclick.backend.controller.HomeController;
import com.rightclick.backend.model.ResponseDTO;
import com.rightclick.backend.service.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
     private OrdersRepository ordersRepository;

    private static final Logger log= LogManager.getLogger(UserServiceImpl.class);

    AppConstants appConstants;

    @Override
    public String getFullUserNameService(String username) {
        UserEntity user=this.usersRepository.findByUsername(username);
        String fullname=user.getFullName();
        return fullname;
    }

    @Override
    public ResponseDTO<Optional<UserEntity>> getUserData(Integer userId) {
        log.info("Starting service for method {getUserData} for userId:{}",userId);
        ResponseDTO<Optional<UserEntity>> responseDTO=new ResponseDTO<>();
       UserEntity user=new UserEntity();
        Optional<UserEntity> userEntity= Optional.of(user);
        try{
            if(userId!=null){
                 userEntity=usersRepository.findById(userId);
            }
            responseDTO.setHttpStatusCode(HttpStatus.OK);
            responseDTO.setMessage(appConstants.successMsg);
            responseDTO.setPayload(userEntity);
        } catch (UsernameNotFoundException e){
            e.printStackTrace();
            responseDTO.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            responseDTO.setMessage(appConstants.bad_credential);
            responseDTO.setPayload(null);
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO<List<OrdersEntity>> getUserOrders(Integer userId) {
        log.info("Starting service for method {getUserOrders} for userId:{}",userId);
        ResponseDTO<List<OrdersEntity>> listResponseDTO=new ResponseDTO<>();
        List<OrdersEntity> ordersEntityList=new ArrayList<>();
        try{
            if(userId!=null){
                ordersEntityList=ordersRepository.findAllByCustomerId(userId);
            }
            listResponseDTO.setHttpStatusCode(HttpStatus.OK);
            listResponseDTO.setMessage(appConstants.successMsg);
            listResponseDTO.setPayload(ordersEntityList);
        } catch (UsernameNotFoundException e){
            e.printStackTrace();
            listResponseDTO.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            listResponseDTO.setMessage(appConstants.bad_credential);
            listResponseDTO.setPayload(null);
        }
        return listResponseDTO;
    }


}
