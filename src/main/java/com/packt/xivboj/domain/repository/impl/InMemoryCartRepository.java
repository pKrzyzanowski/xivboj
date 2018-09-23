package com.packt.xivboj.domain.repository.impl;

import com.packt.xivboj.domain.Cart;
import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.domain.repository.CartRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class InMemoryCartRepository implements CartRepository {

    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;

    public InMemoryCartRepository() {
    }

    public Cart create(Cart cart) {

        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();

        myEntityManager.persist(cart);

        myEntityManager.getTransaction().commit();
        myEntityManager.close();
//        if (listOfCarts.keySet().contains(cart.getCartId())) {
//            throw new IllegalArgumentException(String.format("Nie mo¿na utworzyæ koszyka. Koszyk o wskazanym  id (%) ju¿ istnieje.", cart.getCartId()));
//        }

        return cart;
    }


    public Cart read(String cartId) {
        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();

        Cart CartById = myEntityManager.find(Cart.class, cartId);

        myEntityManager.getTransaction().commit();
        myEntityManager.close();
        return CartById;
    }

    public void update( Cart cart) {
        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();

        myEntityManager.merge(cart);

        myEntityManager.getTransaction().commit();
        myEntityManager.close();

        //        if (!listOfCarts.keySet().contains(cartId)) {
//            throw new IllegalArgumentException("takiego koszyka nie ma");
//        }

    }


    public void delete(String cartId) {
//        if (!listOfCarts.keySet().contains(cartId)) {
//            throw new IllegalArgumentException("nie mozna usunac takigo koszyka bo on nie istnieje");
//        }
//        listOfCarts.remove(cartId);
    }

    public List<Competition> getAllCompetitionsbyCartsId(String cartId) {
        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();

//        TypedQuery<Integer> nativeQuery = myEntityManager.createQuery("SELECT e.allCartCompe_competitionId  FROM  e where e.Cart_cartId ="+cartId, Integer.class);
//        List<Integer> resultList = nativeQuery.getResultList();
//
       String query= "SELECT allCartCompe_competitionId FROM cartcompetition WHERE Cart_cartId = " +"\""+cartId+"\"";
        Query nativeQuery = myEntityManager.createNativeQuery("SELECT allCartCompe_competitionId FROM cartcompetition WHERE Cart_cartId = " +"\"cartId\"");
        List<Integer> resultList = nativeQuery.getResultList();

        myEntityManager.getTransaction().commit();
        myEntityManager.close();

        List<Competition> competitions = new ArrayList<>();

        return competitions;

    }
}
