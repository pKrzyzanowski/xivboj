package com.packt.xivboj.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Cart implements Serializable {


    private static final long serialVersionUID = -53008677344258065L;

    @Id
    private String cartId;
    @OneToOne
    private Person person;

    //    private Collection<CartItemCompe> allCartItems = new ArrayList<>();
    @Transient
    private Collection<Competition> allCartCompe = new ArrayList<>();
    @Transient
    private Map<Integer, Competition> cartCompetitions;


    public Cart() {
        cartCompetitions = new HashMap<Integer, Competition>();
    }

    public Cart(String cartId) {
        this();
        this.cartId = cartId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Collection<Competition> getAllCartCompe() {
        return cartCompetitions.values();
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Map<Integer, Competition> getCartItems() {
        return cartCompetitions;
    }

    public void setCartItems(Map<Integer, Competition> cartCompetitions) {
        this.cartCompetitions = cartCompetitions;
    }

    public void addCartCompe(Competition item) {
        int competitionId = item.getCompetitionId();

        if (cartCompetitions.containsKey(competitionId)) {
            Competition existingCartCompe = cartCompetitions.get(competitionId);
            cartCompetitions.put(competitionId, existingCartCompe);
        } else {
            cartCompetitions.put(competitionId, item);
        }

    }

    public void removeCartCompe(Competition cartCompe) {
        int competitionId = cartCompe.getCompetitionId();
        cartCompetitions.remove(competitionId);
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
