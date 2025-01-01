package com.phatse.order.service.impl;

import com.phatse.order.dao.Order;
import com.phatse.order.dao.OrderItem;
import com.phatse.order.dto.request.OrderRequest;
import com.phatse.order.dto.response.PaymentResponse;
import com.phatse.order.enums.OrderStatus;
import com.phatse.order.repository.OrderRepository;
import com.phatse.order.service.OrderService;
import com.phatse.order.service.PaymentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    private PaymentService paymentService;

    public OrderServiceImpl(OrderRepository orderRepository,PaymentService paymentService) {
        this.orderRepository = orderRepository;
        this.paymentService=paymentService;
    }

    @Override
    public PaymentResponse placeOrder(OrderRequest orderRequest) {

        // Create Order
        Order order = new Order();
        order.setUserId(orderRequest.getUserId());
        order.setOrderDate(LocalDateTime.now());
        order.setOrderItems(orderRequest.getProducts().stream()
                .map(product -> {
                    OrderItem item = new OrderItem();
                    item.setProductId(product.getProductId());
                    item.setQuantity(product.getQuantity());
                    item.setPrice(product.getTotalAmt());
                    return item;
                }).collect(Collectors.toList()));
        order.setTotalAmount(orderRequest.getOrderAmt());

        // Save Order in Pending State
        Order savedOrder = orderRepository.save(order);

        // Initiate Payment
        PaymentResponse paymentResponse = paymentService.initiatePayment(orderRequest.getPaymentDetails());

        // Return Payment Link/Status
        return paymentResponse;

    }

    @Override
    public void handlePaymentSuccess(long orderId) {
        // Update order status to PAID
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(OrderStatus.PAID);
        orderRepository.save(order);
    }

}
