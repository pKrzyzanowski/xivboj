package com.packt.xivboj.domain;


import com.packt.xivboj.service.CartService;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart implements Serializable {

    private static final long serialVersionUID = -53008677344258065L;

    @Autowired
    @Transient
    CartService cartService;

    @Id
    private String cartId;

    @OneToOne
    private Person person;

    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "CartCompetition")
    private List<Competition> allCartCompetition = new ArrayList<>();

    public Cart() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Competition> getAllCartCompetition() {
        return allCartCompetition;
    }

    public void setAllCartCompetition(List<Competition> allCartCompe) {
        this.allCartCompetition = allCartCompe;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
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
            return other.cartId == null;
        } else return cartId.equals(other.cartId);
    }
}
