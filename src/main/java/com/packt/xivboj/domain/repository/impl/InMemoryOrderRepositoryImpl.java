package com.packt.xivboj.domain.repository.impl;


import com.packt.xivboj.domain.Order;
import com.packt.xivboj.domain.repository.OrderRepository;
import com.packt.xivboj.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryOrderRepositoryImpl implements OrderRepository {
    @Autowired
    CartService cartService;


    private Map<Long, Order> listOfOrders;
    private long nextOrderId;

    public InMemoryOrderRepositoryImpl() {
        listOfOrders = new HashMap<Long, Order>();
        nextOrderId = 1000;
    }

    public long saveOrder(Order order) {
//        order.setOrderId(getNextOrderId());
        listOfOrders.put(order.getOrderId(), order);
        cartService.delete(order.getCart().getCartId());
        return order.getOrderId();
    }

    private synchronized long getNextOrderId() {
        return nextOrderId++;
    }
}
