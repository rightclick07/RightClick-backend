package com.rightclick.backend.service.services;

import com.rightclick.backend.Entity.OrdersEntity;
import com.rightclick.backend.Entity.UserEntity;
import com.rightclick.backend.model.ResponseDTO;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface UserService {
    public String getFullUserNameService(String username);
     ResponseDTO<Optional<UserEntity>> getUserData(Integer userId);
    ResponseDTO<List<OrdersEntity>> getUserOrders(Integer userId);
}
