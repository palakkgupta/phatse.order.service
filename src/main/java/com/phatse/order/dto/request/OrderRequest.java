package com.phatse.order.dto.request;

import java.util.List;

public class OrderRequest {
    private Long userId;
    private List<ProductRequest> products;
    private PaymentDetails paymentDetails;
}
