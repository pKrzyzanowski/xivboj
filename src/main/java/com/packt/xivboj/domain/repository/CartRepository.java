package com.packt.xivboj.domain.repository;

import com.packt.xivboj.domain.Cart;
import com.packt.xivboj.domain.Competition;

public interface CartRepository {

    Cart create(Cart cart);

    Cart read();

    void update(Cart cart);

    void delete(String cartId);

    void removeCompetitionFromCart(Cart cart, Competition competition);

    void addCompetitionToCart(Cart cart, Competition competition);

}
