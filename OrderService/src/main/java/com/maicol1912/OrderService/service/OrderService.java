package com.maicol1912.OrderService.service;


import com.maicol1912.OrderService.model.OrderRequest;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);
}
