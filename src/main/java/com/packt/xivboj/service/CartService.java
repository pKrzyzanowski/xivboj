package com.packt.xivboj.service;

import com.packt.xivboj.domain.Cart;
import com.packt.xivboj.domain.Competition;

import java.util.List;

public interface CartService {
    Cart create(Cart cart);

    Cart read();

    void update(Cart cart);

    void delete(String cartId);

    Cart validate(String cartId);

    void removeCompetitionFromCart(Cart cart, Competition competition);

    void addCompetitionToCart(Cart cart, Competition competition);
}
