package com.rightclick.backend.service.services;

import com.rightclick.backend.Entity.AddressEntity;
import com.rightclick.backend.model.AddressRequest;
import com.rightclick.backend.model.ResponseDTO;
import com.rightclick.backend.model.SignupRequest;

import java.util.List;

public interface AddressService {
    ResponseDTO<String> submitAddressData(AddressRequest addressRequest);
    ResponseDTO<List<AddressEntity>> getAddressByUser(Integer id);
}
