package com.rightclick.backend.model;

public class Data {
        private InstrumentResponse instrumentResponse;
        private String merchantId;
        private String merchantTransactionId;

        public InstrumentResponse getInstrumentResponse() {
            return instrumentResponse;
        }

        public void setInstrumentResponse(InstrumentResponse instrumentResponse) {
            this.instrumentResponse = instrumentResponse;
        }

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
}

