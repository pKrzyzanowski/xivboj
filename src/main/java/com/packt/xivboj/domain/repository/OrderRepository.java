package com.packt.xivboj.domain.repository;

import com.packt.xivboj.domain.Order;

public interface OrderRepository {
    public long saveOrder(Order order);
}
