package com.packt.xivboj.domain.repository;

import com.packt.xivboj.domain.Cart;
import com.packt.xivboj.domain.Competition;

import java.util.List;

public interface CartRepository {

    Cart create(Cart cart);

    Cart read(String cartId);

    void update(Cart cart);

    void delete(String cartId);

//    List<Competition> getAllCompetitionsbyCartsId(String cartId);

}
