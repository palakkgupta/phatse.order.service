package com.phatse.order.controller;

import com.phatse.order.dto.request.PaymentNotification;
import com.phatse.order.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentWebhookController {


    private OrderService orderService;

    public PaymentWebhookController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/webhook")
    public ResponseEntity<Void> handlePaymentWebhook(@RequestBody PaymentNotification notification) {
        if ("SUCCESS".equals(notification.getStatus())) {
            orderService.handlePaymentSuccess(notification.getOrderId());
        }
        return ResponseEntity.ok().build();
    }
}