package com.packt.xivboj.service.impl;

import com.packt.xivboj.domain.Order;
import com.packt.xivboj.domain.repository.OrderRepository;
import com.packt.xivboj.service.CartService;
import com.packt.xivboj.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CartService cartService;


    @Override
    public Long saveOrder(Order order) {
        Long orderId = orderRepository.saveOrder(order);
        cartService.delete(order.getCart().getCartId());
        return orderId;
    }
}
