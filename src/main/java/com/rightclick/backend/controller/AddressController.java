package com.rightclick.backend.controller;

import com.rightclick.backend.Entity.AddressEntity;
import com.rightclick.backend.model.AddressRequest;
import com.rightclick.backend.model.JwtRequest;
import com.rightclick.backend.model.JwtResponse;
import com.rightclick.backend.model.ResponseDTO;
import com.rightclick.backend.service.services.AddressService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class AddressController {

  @Autowired
  AddressService addressService;

  private static final Logger log= LogManager.getLogger(AddressController.class);


  @PostMapping("/saveAddress")
  public ResponseDTO<String> OnSubmitAddress(@RequestBody AddressRequest addressRequest) throws Exception {
    log.info("Starting Controller for method {OnSubmitAddress} Request is :{}",addressRequest);
    return  addressService.submitAddressData(addressRequest);
  }

  @GetMapping("/getAddress/{id}")
  public ResponseDTO<List<AddressEntity>> getAddressByUserId(@PathVariable Integer id) {
    log.info("Starting Controller for method {getAddressByUserId} Request is :{}",id);
    return  addressService.getAddressByUser(id);
  }

}
