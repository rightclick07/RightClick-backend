package com.rightclick.backend.service.Impl;

import com.rightclick.backend.Entity.AddressEntity;
import com.rightclick.backend.Entity.UserEntity;
import com.rightclick.backend.Repository.AddressRepository;
import com.rightclick.backend.constants.AppConstants;
import com.rightclick.backend.model.AddressRequest;
import com.rightclick.backend.model.ResponseDTO;
import com.rightclick.backend.model.SignupRequest;
import com.rightclick.backend.service.services.AddressService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    AppConstants appConstants;

    private static final Logger log= LogManager.getLogger(AddressServiceImpl.class);


    @Override
    public ResponseDTO<String> submitAddressData(AddressRequest addressRequest) {
        log.info("Starting Service for method {submitAddressData} Request is :{}",addressRequest);

        ResponseDTO<String> responseDTO=new ResponseDTO<>();
        AddressEntity addressEntity = new AddressEntity();
        try{
            if(addressRequest.getUsername()!=null){
              addressEntity.setUserId(addressRequest.getUserId()!=null?addressRequest.getUserId():0);
              addressEntity.setUsername(addressRequest.getUsername()!=null?addressRequest.getUsername():"");
              addressEntity.setAddress(addressRequest.getAddress()!=null?addressRequest.getAddress():"");
              addressEntity.setCity(addressRequest.getCity()!=null?addressRequest.getCity():"");
              addressEntity.setState(addressRequest.getState()!=null?addressRequest.getState():"");
              addressEntity.setCountry(addressRequest.getCountry()!=null?addressRequest.getCountry():"");
              addressEntity.setPostalCode(addressRequest.getPostalCode()!=null?addressRequest.getPostalCode():"");
              addressEntity.setPhoneNumber(addressRequest.getPhoneNumber()!=null?addressRequest.getPhoneNumber():"");


            }
            addressRepository.save(addressEntity);
            responseDTO.setHttpStatusCode(HttpStatus.OK);
            responseDTO.setMessage(appConstants.successMsg);
            responseDTO.setPayload(appConstants.address_success);

        } catch (Exception e){
            e.printStackTrace();
            responseDTO.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            responseDTO.setMessage(appConstants.failureMsg);
            responseDTO.setPayload(null);
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO<List<AddressEntity>> getAddressByUser(Integer id) {
        log.info("Starting Service for method {getAddressByUser} Request is :{}",id);

        ResponseDTO<List<AddressEntity>> responseDTO=new ResponseDTO<>();
        List<AddressEntity> addressEntityList=new ArrayList<>();
        try{
            addressEntityList = addressRepository.findAllByUserId(id);
            responseDTO.setHttpStatusCode(HttpStatus.OK);
            responseDTO.setMessage(appConstants.successMsg);
            responseDTO.setPayload(addressEntityList);

        } catch (Exception e){
            e.printStackTrace();
            responseDTO.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            responseDTO.setMessage(appConstants.failureMsg);
            responseDTO.setPayload(null);
        }
        return responseDTO;

    }
}
