package com.packt.xivboj.domain;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Cart implements Serializable{


    private static final long serialVersionUID = -53008677344258065L;

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

    public void addCartItem(CartItemCompe item) {
        String productId = item.getCompetition().getCompetitionId();

        if(cartItems.containsKey(productId)) {
            CartItemCompe existingCartItem = cartItems.get(productId);
            cartItems.put(productId, existingCartItem);
        } else {
            cartItems.put(productId, item);
        }

    }

    public void removeCartItem(CartItemCompe cartItemCompe) {
        String competitionId = cartItemCompe.getCompetition().getCompetitionId();
        cartItems.remove(competitionId);
    }

    @Override
    public int hashCode() {
        final int prime = 71;
        int result = 1;
        result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cart other = (Cart) obj;
        if (cartId == null) {
            if (other.cartId != null)
                return false;
        } else if (!cartId.equals(other.cartId))
            return false;
        return true;
    }
}
