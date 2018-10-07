package com.packt.xivboj.service.impl;

import com.packt.xivboj.domain.Cart;
import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.domain.repository.CartRepository;
import com.packt.xivboj.exception.InvalidCartException;
import com.packt.xivboj.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;


    public Cart create(Cart cart) {
        return cartRepository.create(cart);
    }


    public Cart read() {
        return cartRepository.read();
    }


    public void update(Cart cart) {
        cartRepository.update(cart);
    }


    public void delete(String cartId) {
        cartRepository.delete(cartId);
    }

    @Override
    public Cart validate(String cartId) {
        Cart cart = cartRepository.read();
        if (cart == null || cart.getAllCartCompetition().size() == 0) {
            throw new InvalidCartException(cartId);

        }
        return cart;
    }

    @Override
    public void removeCompetitionFromCart(Cart cart, Competition competition) {
        cartRepository.removeCompetitionFromCart(cart, competition);
    }

    @Override
    public void addCompetitionToCart(Cart cart, Competition competition) {
        cartRepository.addCompetitionToCart(cart, competition);
    }
}
