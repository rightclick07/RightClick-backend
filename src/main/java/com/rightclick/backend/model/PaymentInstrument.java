package com.rightclick.backend.model;

import java.io.Serializable;

public class PaymentInstrument implements Serializable {
    private String type;



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PaymentInstrument(String type) {
        this.type = type;
    }

    public PaymentInstrument() {
    }

    @Override
    public String toString() {
        return "PaymentInstrument{" +
                "type='" + type + '\'' +
                '}';
    }
}
