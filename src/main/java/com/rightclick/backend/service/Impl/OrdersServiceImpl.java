package com.rightclick.backend.service.Impl;

import com.rightclick.backend.Entity.AddressEntity;
import com.rightclick.backend.Entity.OrderItemsEntity;
import com.rightclick.backend.Entity.OrdersEntity;
import com.rightclick.backend.Repository.OrderItemsRepository;
import com.rightclick.backend.Repository.OrdersRepository;
import com.rightclick.backend.constants.AppConstants;
import com.rightclick.backend.controller.AddressController;
import com.rightclick.backend.model.OrderItemsRequest;
import com.rightclick.backend.model.OrderRequest;
import com.rightclick.backend.model.OrderResponse;
import com.rightclick.backend.model.ResponseDTO;
import com.rightclick.backend.service.services.OrdersService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    OrderItemsRepository orderItemsRepository  ;

    AppConstants appConstants;

    private static final Logger log= LogManager.getLogger(OrdersServiceImpl.class);


    @Override
    public ResponseDTO<OrderResponse> saveOrdersData(OrderRequest orderRequest) {

        log.info("Starting Service for method {saveOrdersData} Request is :{}",orderRequest);

        ResponseDTO<OrderResponse> responseDTO=new ResponseDTO<>();
        OrdersEntity ordersEntity = new OrdersEntity();
        try{
            if(orderRequest.getCustomerId()!=null){
                ordersEntity.setCustomerId(orderRequest.getCustomerId()!=null?orderRequest.getCustomerId():0);
                ordersEntity.setShippingAddress(orderRequest.getShippingAddress()!=null?orderRequest.getShippingAddress():"");
                ordersEntity.setDeliveryDate(orderRequest.getDeliveryDate()!=null?orderRequest.getDeliveryDate():new Date());
                ordersEntity.setOrderDate(orderRequest.getOrderDate()!=null?orderRequest.getOrderDate():new Date());
                ordersEntity.setPaymentMethod(orderRequest.getPaymentMethod()!=null?orderRequest.getPaymentMethod():"");
                ordersEntity.setPaymentStatus(orderRequest.getPaymentStatus()!=null?orderRequest.getPaymentStatus():"");
                ordersEntity.setTotalAmount(orderRequest.getTotalAmount()!=null?orderRequest.getTotalAmount(): BigDecimal.valueOf(0.00));
                ordersEntity.setTrackingNumber(orderRequest.getTrackingNumber()!=null?orderRequest.getTrackingNumber():"");

            }
            OrdersEntity ordersEntity1=ordersRepository.save(ordersEntity);
            OrderResponse orderResponse=new OrderResponse();
            orderResponse.setMessage(appConstants.order_success);
            orderResponse.setOrderId(ordersEntity1.getId());

            responseDTO.setHttpStatusCode(HttpStatus.OK);
            responseDTO.setMessage(appConstants.successMsg);
            responseDTO.setPayload(orderResponse);

        } catch (Exception e){
            e.printStackTrace();
            responseDTO.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            responseDTO.setMessage(appConstants.failureMsg);
            responseDTO.setPayload(null);
        }
        return responseDTO;

    }

    @Override
    public ResponseDTO<Optional<OrdersEntity>> getOrderData(Integer id) {
            log.info("Starting Service for method {getOrderData} id is :{}",id);

            ResponseDTO<Optional<OrdersEntity>> responseDTO=new ResponseDTO<>();
            Optional<OrdersEntity> ordersEntity= Optional.of(new OrdersEntity());
            try{
                ordersEntity=ordersRepository.findById(id);
                responseDTO.setHttpStatusCode(HttpStatus.OK);
                responseDTO.setMessage(appConstants.successMsg);
                responseDTO.setPayload(ordersEntity);

            } catch (Exception e){
            e.printStackTrace();
            responseDTO.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            responseDTO.setMessage(appConstants.failureMsg);
            responseDTO.setPayload(null);
        }
            return responseDTO;

    }

    @Override
    public ResponseDTO<String> saveOrderItemsData(List<OrderItemsRequest> orderItemsRequestList) {
        log.info("Starting Service for method {saveOrderItemsData} Request is :{}",orderItemsRequestList);
        ResponseDTO<String> responseDTO=new ResponseDTO<>();

            try{
                for (OrderItemsRequest element : orderItemsRequestList) {
                    OrderItemsEntity orderItemsEntity=new OrderItemsEntity();
                    orderItemsEntity.setOrderId(element.getOrderId()!=null?element.getOrderId():0);
                    orderItemsEntity.setProductId(element.getProductId()!=null?element.getProductId():0);
                    orderItemsEntity.setCreatedAt(element.getCreatedAt()!=null?element.getCreatedAt():new Date());
                    orderItemsEntity.setDiscount(element.getDiscount()!=null?element.getDiscount(): BigDecimal.valueOf(0.0));
                    orderItemsEntity.setQuantity(element.getQuantity()!=null?element.getQuantity():0);
                    orderItemsEntity.setUnitPrice(element.getUnitPrice()!=null?element.getUnitPrice(): BigDecimal.valueOf(0.0));
                    orderItemsEntity.setSubtotal(element.getSubtotal()!=null?element.getSubtotal(): BigDecimal.valueOf(0.0));
                    orderItemsEntity.setTax(element.getTax()!=null?element.getTax(): BigDecimal.valueOf(0.0));
                    orderItemsEntity.setTotal(element.getTotal()!=null?element.getTotal(): BigDecimal.valueOf(0.0));

                    orderItemsRepository.save(orderItemsEntity);
                }
            } catch (Exception e){
                e.printStackTrace();
                responseDTO.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
                responseDTO.setMessage(appConstants.failureMsg);
                responseDTO.setPayload(null);
            }
        return responseDTO;
    }

    @Override
    public ResponseDTO<Optional<List<OrderItemsEntity>>> getOrderItemsData(Integer id) {
        log.info("Starting Service for method {getOrderData} id is :{}",id);

        ResponseDTO<Optional<List<OrderItemsEntity>>> responseDTO=new ResponseDTO<>();
        Optional<List<OrderItemsEntity>> orderItemsEntityList= Optional.of(new ArrayList<OrderItemsEntity>());
        try{
            orderItemsEntityList=orderItemsRepository.findByOrderId(id);

            responseDTO.setHttpStatusCode(HttpStatus.OK);
            responseDTO.setMessage(appConstants.successMsg);
            responseDTO.setPayload(orderItemsEntityList);

        } catch (Exception e){
            e.printStackTrace();
            responseDTO.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            responseDTO.setMessage(appConstants.failureMsg);
            responseDTO.setPayload(null);
        }
        return responseDTO;

    }
}
