package com.phatse.order.dto.request;

import java.util.List;

public class OrderRequest {
    private Long userId;
    private List<ProductRequest> products;
    private PaymentDetails paymentDetails;
    private double orderAmt;

    public double getOrderAmt() {
        return orderAmt;
    }

    public void setOrderAmt(double orderAmt) {
        this.orderAmt = orderAmt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<ProductRequest> getProducts() {
        return products;
    }

    public void setProducts(List<ProductRequest> products) {
        this.products = products;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }
}
