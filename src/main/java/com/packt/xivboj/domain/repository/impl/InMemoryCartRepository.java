package com.packt.xivboj.domain.repository.impl;

import com.packt.xivboj.domain.Cart;
import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.domain.repository.CartRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;


@Repository
public class InMemoryCartRepository implements CartRepository {

    final String QueryString = "SELECT allCartCompe_competitionId FROM cart_competition";
    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;


    public InMemoryCartRepository() {
    }

    @Transactional
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


    public void update(String cartId, Cart cart) {
        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();
//        if (!listOfCarts.keySet().contains(cartId)) {
//            throw new IllegalArgumentException("takiego koszyka nie ma");
//        }
        myEntityManager.merge(cart);
        myEntityManager.getTransaction().commit();
        myEntityManager.close();
//        listOfCarts.put(cartId, cart);
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
        TypedQuery<Integer> nativeQuery = myEntityManager.createQuery("SELECT e.allCartCompe_competitionId  FROM as e", Integer.class);
        List<Integer> resultList = nativeQuery.getResultList();
        myEntityManager.getTransaction().commit();
        myEntityManager.close();

        List<Competition> competitions = new ArrayList<>();

        return competitions;

    }
}
