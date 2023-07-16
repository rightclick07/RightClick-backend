package com.rightclick.backend.controller;


import com.rightclick.backend.Entity.OrderItemsEntity;
import com.rightclick.backend.Entity.OrdersEntity;
import com.rightclick.backend.model.*;
import com.rightclick.backend.service.services.OrdersService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    private static final Logger log= LogManager.getLogger(OrdersController.class);


    @PostMapping("/saveOrder")
    public ResponseDTO<OrderResponse> saveOrder(@RequestBody OrderRequest orderRequest) throws Exception {
        log.info("Starting Controller for method {saveOrders} Request is :{}",orderRequest);
        return  ordersService.saveOrdersData(orderRequest);
    }

    @GetMapping("/getOrder/{id}")
    public ResponseDTO<Optional<OrdersEntity>> getOrderById(@PathVariable Integer id) throws Exception {
        log.info("Starting Controller for method {getOrderById} Id is :{}",id);
        return  ordersService.getOrderData(id);
    }

    @PostMapping("/saveOrderItems")
    public ResponseDTO<String> saveOrderItems(@RequestBody List<OrderItemsRequest> orderRequestList) throws Exception {
        log.info("Starting Controller for method {saveOrders} Request is :{}",orderRequestList);
        return  ordersService.saveOrderItemsData(orderRequestList);
    }
    @GetMapping("/getOrderItems/{id}")
    public ResponseDTO<Optional<List<OrderItemsEntity>>> getOrderItemsByOrderId(@PathVariable Integer id) throws Exception {
        log.info("Starting Controller for method {getOrderById} Id is :{}",id);
        return  ordersService.getOrderItemsData(id);
    }

}
