package com.packt.xivboj.domain;


import com.packt.xivboj.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    //    private Collection<CartItemCompe> allCartItems = new ArrayList<>();


    @OneToMany
    @JoinTable(name = "CartCompetition")
//    private List<Competition> allCartCompe =
    private List<Competition> allCartCompe = new ArrayList<>();

    @Transient
    private Map<Integer, Competition> cartCompetitions;

    public Cart() {
        cartCompetitions = new HashMap<Integer, Competition>();
    }

    public Cart(String cartId) {
        this();
        this.cartId = cartId;
    }

    public Map<Integer, Competition> getCartCompetitions() {
        return cartCompetitions;
    }

    public void setCartCompetitions(Map<Integer, Competition> cartCompetitions) {
        this.cartCompetitions = cartCompetitions;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Competition> getAllCartCompe() {

        List<Competition> competitionList = cartService.getAllCompetitionsbyCartsId(getCartId());
//        List<Competition> competitionList = new ArrayList<>(cartCompetitions.values());
        return competitionList;
    }

    public void setAllCartCompe(List<Competition> allCartCompe) {
        this.allCartCompe = allCartCompe;
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

    public void addCartCompe(Competition competition) {
        int competitionId = competition.getCompetitionId();

//        if (cartCompetitions.containsKey(competitionId)) {
//            Competition existingCartCompe = cartCompetitions.get(competitionId);
//            cartCompetitions.put(competitionId, existingCartCompe);
//        } else {
//            cartCompetitions.put(competitionId, item);
//        }

//        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
//        myEntityManager.getTransaction().begin();
//
//
//
//
//        myEntityManager.getTransaction().commit();
//        myEntityManager.close();


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
