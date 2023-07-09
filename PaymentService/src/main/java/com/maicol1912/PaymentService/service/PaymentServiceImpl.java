package com.maicol1912.PaymentService.service;

import com.maicol1912.PaymentService.entity.TransactionDetails;
import com.maicol1912.PaymentService.model.PaymentRequest;
import com.maicol1912.PaymentService.repository.TransactionDetailsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
@Slf4j
public class PaymentServiceImpl implements PaymentService{

    private TransactionDetailsRepository detailsRepository;
    @Override
    public long doPayment(PaymentRequest paymentRequest) {
        log.info("Recording Payment Details: {}",paymentRequest);

        TransactionDetails transactionDetails =
                TransactionDetails.builder()
                        .paymentDate(Instant.now())
                        .paymentMode(paymentRequest.getPaymentMode().name())
                        .paymentStatus("SUCCESS")
                        .orderId(paymentRequest.getOrderId())
                        .referenceNumber(paymentRequest.getReferenceNumber())
                        .amount(paymentRequest.getAmount())
                        .build();

        detailsRepository.save(transactionDetails);
        log.info("Transaction Completed with Id: {}",transactionDetails.getId());
        return transactionDetails.getId();
    }
}
