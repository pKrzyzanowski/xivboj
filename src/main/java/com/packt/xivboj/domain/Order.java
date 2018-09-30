package com.packt.xivboj.domain;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "zamowienie")
public class Order implements Serializable {

    private static final long serialVersionUID = -3560539622417210355L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    @Transient
    private Cart cart;
    @OneToOne
    private Person person;


    public Order() {
    }

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

    @Override
    public int hashCode() {
        final int prime = 829;
        int result = 1;
        result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
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
        Order other = (Order) obj;
        if (orderId == null) {
            if (other.orderId != null)
                return false;
        } else if (!orderId.equals(other.orderId))
            return false;
        return true;
    }
}
