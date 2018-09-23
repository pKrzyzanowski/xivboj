package com.packt.xivboj.service;

import com.packt.xivboj.domain.Cart;
import com.packt.xivboj.domain.Competition;

import java.util.List;

public interface CartService {
    Cart create(Cart cart);

    Cart read(String cartId);

    void update(Cart cart);

    void delete(String cartId);

    Cart validate(String cartId);

     List<Competition> getAllCompetitionsbyCartsId(String cartId);
}
