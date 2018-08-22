package com.packt.xivboj.service;

import com.packt.xivboj.domain.Cart;

public interface CartService {
    Cart create(Cart cart);

    Cart read(String cartId);

    void update(String cartId, Cart cart);

    void delete(String cartId);

    Cart validate(String cartId);
}
