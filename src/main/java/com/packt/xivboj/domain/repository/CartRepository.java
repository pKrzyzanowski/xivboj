package com.packt.xivboj.domain.repository;

import com.packt.xivboj.domain.Cart;

public interface CartRepository {
    Cart create(Cart cart);

    Cart read(String cartId);

    void update(String cartId, Cart cart);

    void delete(String cartId);
}