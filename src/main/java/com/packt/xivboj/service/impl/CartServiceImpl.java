package com.packt.xivboj.service.impl;

import com.packt.xivboj.domain.Cart;
import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.domain.repository.CartRepository;
import com.packt.xivboj.exception.InvalidCartException;
import com.packt.xivboj.exception.PersonNotFoundException;
import com.packt.xivboj.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;


    public Cart create(Cart cart) {
        return cartRepository.create(cart);
    }


    public Cart read(String cartId) {
        return cartRepository.read(cartId);
    }


    public void update(Cart cart) {
        cartRepository.update(cart);
    }


    public void delete(String cartId) {
        cartRepository.delete(cartId);
    }

    @Override
    public Cart validate(String cartId) {
        Cart cart = cartRepository.read(cartId);
        if (cart == null || cart.getCartItems().size() == 0) {
            throw new InvalidCartException(cartId);

        }
        return cart;
    }

    public List<Competition> getAllCompetitionsbyCartsId(String cartId) {
        return cartRepository.getAllCompetitionsbyCartsId(cartId);
    }
}
