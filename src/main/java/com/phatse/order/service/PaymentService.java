package com.phatse.order.service;

import com.phatse.order.dto.request.PaymentDetails;
import com.phatse.order.dto.response.PaymentResponse;

public interface PaymentService {


    PaymentResponse initiatePayment(PaymentDetails paymentDetails);
}
