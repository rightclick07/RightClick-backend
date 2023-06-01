package com.rightclick.backend.model;

import org.springframework.http.HttpStatus;

public class ResponseDTO<T> {

    private HttpStatus httpStatusCode;

    private  String Message;

    private T payload;

    public HttpStatus getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(HttpStatus httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
