package com.packt.xivboj.domain.repository.impl;

import com.packt.xivboj.domain.Cart;
import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.domain.Person;
import com.packt.xivboj.domain.repository.CartRepository;
import com.packt.xivboj.service.CartService;
import com.packt.xivboj.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class InMemoryCartRepository implements CartRepository {

    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;

    @Autowired
    CompetitionService competitionService;

    @Autowired
    CartService cartService;

    public InMemoryCartRepository() {
    }

//    @Transactional
    public Cart create(Cart cart) {

        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();


//        Cart cartFromDb = null;
//        try {
//            Query nativeQuery = myEntityManager.createNativeQuery("SELECT * FROM cart where name =" + "\"" + cart.getCartId() + "\"", Cart.class);
//            cartFromDb = (Cart) nativeQuery.getSingleResult();
//        } catch (NoResultException e) {
//            e.printStackTrace();
//        }
//        if (cartFromDb==null) {
//            myEntityManager.persist(cart);
//        }

        myEntityManager.persist(cart);
        myEntityManager.getTransaction().commit();
        myEntityManager.close();

        return cart;
    }

//    @Transactional
    public Cart read(String cartId) {

        cartId = SecurityContextHolder.getContext().getAuthentication().getName()+"sCart";

        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();

        Cart CartById = myEntityManager.find(Cart.class, cartId);


        myEntityManager.getTransaction().commit();
        myEntityManager.close();
        return CartById;
    }

    public void update(Cart cart) {
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
        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();


        myEntityManager.remove(myEntityManager.find(Cart.class, cartId));

        myEntityManager.getTransaction().commit();
        myEntityManager.close();

//        if (!listOfCarts.keySet().contains(cartId)) {
//            throw new IllegalArgumentException("nie mozna usunac takigo koszyka bo on nie istnieje");
//        }
//        listOfCarts.remove(cartId);
    }

}
