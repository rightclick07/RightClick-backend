package com.rightclick.backend.model;

import java.util.List;

public class EmailRequest {
    private String senderEmail;
    private String receiverEmail;
    private String subject;
    private String customerName;
    private String customerId;
    private OrderRequest orderRequest;
    private List<OrderItemsRequest> orderItemsRequestList;

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public OrderRequest getOrderRequest() {
        return orderRequest;
    }

    public void setOrderRequest(OrderRequest orderRequest) {
        this.orderRequest = orderRequest;
    }

    public List<OrderItemsRequest> getOrderItemsRequestList() {
        return orderItemsRequestList;
    }

    public void setOrderItemsRequestList(List<OrderItemsRequest> orderItemsRequestList) {
        this.orderItemsRequestList = orderItemsRequestList;
    }
}
