package com.packt.xivboj.domain.repository.impl;

import com.packt.xivboj.domain.Cart;
import com.packt.xivboj.domain.repository.CartRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository
public class InMemoryCartRepository implements CartRepository {

    private Map<String, Cart> listOfCarts;


    public InMemoryCartRepository() {
        listOfCarts = new HashMap<String, Cart>();
    }


    public Cart create(Cart cart) {
        if(listOfCarts.keySet().contains(cart.getCartId())) {
            throw new IllegalArgumentException(String.format("Nie mo¿na utworzyæ koszyka. Koszyk o wskazanym  id (%) ju¿ istnieje.",cart.getCartId()));
        }

        listOfCarts.put(cart.getCartId(), cart);
        return cart;
    }


    public Cart read(String cartId) {
        return listOfCarts.get(cartId);
    }


    public void update(String cartId, Cart cart) {

        if (!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException("takiego koszyka nie ma");
        }
        listOfCarts.put(cartId, cart);
    }


    public void delete(String cartId) {
        if (!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException("nie mozna usunac takigo koszyka bo on nie istnieje");
        }
        listOfCarts.remove(cartId);
    }
}
