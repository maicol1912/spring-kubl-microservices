package com.maicol1912.PaymentService.service;

import com.maicol1912.PaymentService.model.PaymentRequest;

public interface PaymentService {
    long doPayment(PaymentRequest paymentRequest);
}
