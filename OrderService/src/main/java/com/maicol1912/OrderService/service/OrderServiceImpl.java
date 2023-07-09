package com.maicol1912.OrderService.service;

import com.maicol1912.OrderService.entity.Order;
import com.maicol1912.OrderService.external.client.ProductService;
import com.maicol1912.OrderService.model.OrderRequest;
import com.maicol1912.OrderService.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;
    private ProductService productService;
    @Override
    public long placeOrder(OrderRequest orderRequest) {

        log.info("Placing Order Request: {}",orderRequest);

        productService.reduceQuantity(orderRequest.getProductId(),orderRequest.getQuantity());

        log.info("Creating Order with Status CREATED");
        Order order = Order.builder()
                .amount(orderRequest.getTotalAmount())
                .orderStatus("CREATED")
                .productId(orderRequest.getProductId())
                .orderDate(Instant.now())
                .quantity(orderRequest.getQuantity())
                .build();

        order = orderRepository.save(order);

        log.info("Order Places successfully with Order Id: {}",order.getId());
        return order.getId();
    }
}
