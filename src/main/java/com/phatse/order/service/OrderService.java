package com.phatse.order.service;

import com.phatse.order.dto.request.OrderRequest;
import com.phatse.order.dto.response.PaymentResponse;

public interface OrderService {

    /**
     * this will accept orderRequest, call payment service and return payment response.
     */
    PaymentResponse placeOrder(OrderRequest orderRequest);


    /**
     * will update the order status
     * @param orderId
     */
    void handlePaymentSuccess(long orderId);
}
