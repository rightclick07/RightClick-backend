package com.rightclick.backend.model;

import java.io.Serializable;

public class PaymentRequest implements Serializable {

    private String merchantId;

    private String merchantTransactionId;

    private String merchantUserId;

    private Integer amount;

    private String redirectUrl;

    private String redirectMode;

    private String callbackUrl;

    private String mobileNumber;

    private PaymentInstrument paymentInstrument;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantTransactionId() {
        return merchantTransactionId;
    }

    public void setMerchantTransactionId(String merchantTransactionId) {
        this.merchantTransactionId = merchantTransactionId;
    }

    public String getMerchantUserId() {
        return merchantUserId;
    }

    public void setMerchantUserId(String merchantUserId) {
        this.merchantUserId = merchantUserId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getRedirectMode() {
        return redirectMode;
    }

    public void setRedirectMode(String redirectMode) {
        this.redirectMode = redirectMode;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public PaymentInstrument getPaymentInstrument() {
        return paymentInstrument;
    }

    public void setPaymentInstrument(PaymentInstrument paymentInstrument) {
        this.paymentInstrument = paymentInstrument;
    }

    public PaymentRequest(String merchantId, String merchantTransactionId, String merchantUserId, Integer amount, String redirectUrl, String redirectMode, String callbackUrl, String mobileNumber, PaymentInstrument paymentInstrument) {
        this.merchantId = merchantId;
        this.merchantTransactionId = merchantTransactionId;
        this.merchantUserId = merchantUserId;
        this.amount = amount;
        this.redirectUrl = redirectUrl;
        this.redirectMode = redirectMode;
        this.callbackUrl = callbackUrl;
        this.mobileNumber = mobileNumber;
        this.paymentInstrument = paymentInstrument;
    }

    public PaymentRequest() {
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "merchantId='" + merchantId + '\'' +
                ", merchantTransactionId='" + merchantTransactionId + '\'' +
                ", merchantUserId='" + merchantUserId + '\'' +
                ", amount=" + amount +
                ", redirectUrl='" + redirectUrl + '\'' +
                ", redirectMode='" + redirectMode + '\'' +
                ", callbackUrl='" + callbackUrl + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", paymentInstrument=" + paymentInstrument +
                '}';
    }
}
