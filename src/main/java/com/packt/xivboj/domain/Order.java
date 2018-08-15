package com.packt.xivboj.domain;


import java.io.Serializable;

public class Order implements Serializable {

    private static final long serialVersionUID = -3560539622417210365L;

    private Long orderId;
    private Cart cart;
    private Person person;


    public Order(Person person) {
        this.person = person;
    }


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
