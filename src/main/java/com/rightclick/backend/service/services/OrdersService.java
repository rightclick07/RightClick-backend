package com.rightclick.backend.service.services;

import com.rightclick.backend.Entity.OrderItemsEntity;
import com.rightclick.backend.Entity.OrdersEntity;
import com.rightclick.backend.model.OrderItemsRequest;
import com.rightclick.backend.model.OrderRequest;
import com.rightclick.backend.model.OrderResponse;
import com.rightclick.backend.model.ResponseDTO;

import java.util.List;
import java.util.Optional;

public interface OrdersService {

    ResponseDTO<OrderResponse> saveOrdersData(OrderRequest orderRequest);
    ResponseDTO<Optional<OrdersEntity>> getOrderData(Integer id);
    ResponseDTO<String> saveOrderItemsData(List<OrderItemsRequest> orderItemsRequestList);
    ResponseDTO<Optional<List<OrderItemsEntity>>>  getOrderItemsData(Integer id);
}
