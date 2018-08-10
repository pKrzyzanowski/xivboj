package com.packt.xivboj.domain;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private String cartId;
    private Map<String, CartItemCompe> cartItems;

    public Cart() {
        cartItems = new HashMap<String, CartItemCompe>();
    }

    public Cart(String cartId) {
        this();
        this.cartId = cartId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Map<String, CartItemCompe> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<String, CartItemCompe> cartItems) {
        this.cartItems = cartItems;
    }

    public void addCartItem(CartItemCompe cartItemCompe) {
        String competitionId = cartItemCompe.getCompetition().getCompetitionId();

        if (cartItems.containsKey(competitionId)) {

            // tutaj bedzie raczej, ze jezeli istnieje juz taki produkt to pojawia sie okienko ze taki juz istnieje
        }
        else{
            cartItems.put(competitionId, cartItemCompe);
        }
    }

    public void removeCartItem(CartItemCompe cartItemCompe) {
        String competitionId = cartItemCompe.getCompetition().getCompetitionId();
        cartItems.remove(competitionId);
    }
}
