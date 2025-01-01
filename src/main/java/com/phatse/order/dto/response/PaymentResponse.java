package com.phatse.order.dto.response;


public class PaymentResponse {
    private String status;
    private String paymentUrl; // for redirect-based payment

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
