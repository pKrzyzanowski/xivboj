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

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
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

    @Transactional
    public Cart read(String cartId) {

         cartId = SecurityContextHolder.getContext().getAuthentication().getName()+"sCart";

        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();

        Cart CartById = myEntityManager.find(Cart.class, cartId);

        if (CartById == null) {

            String currentPrincipalName = SecurityContextHolder.getContext().getAuthentication().getName();

            Query nativeQuery = myEntityManager.createNativeQuery("SELECT * FROM person where username =" + "\"" + currentPrincipalName + "\"", Person.class);
            Person person = (Person) nativeQuery.getSingleResult();

            CartById = new Cart();
            CartById.setCartId(person.getName() + "sCart");
            //pobrac osobe na ktorej koncie jestsmy i stowrzyc nowa karte oraz nadac tej karcie osobe
            CartById.setPerson(person);
            person.setCart(CartById);
            myEntityManager.persist(CartById);
            myEntityManager.merge(person);

        }
        myEntityManager.getTransaction().commit();
        myEntityManager.close();


        myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();
        //        // tutaj ustawic karcie konkurencje
        List<Competition> cartCompetitions = cartService.getAllCompetitionsbyCartsId(cartId);
        CartById.setAllCartCompe(cartCompetitions);


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

    @Transactional
    public List<Competition> getAllCompetitionsbyCartsId(String cartId) {
        List<Competition> competitions = new ArrayList<>();
        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();

        String query = "SELECT allCartCompe_competitionId FROM cartcompetition WHERE Cart_cartId = " + "\"" + cartId + "\"";
        Query nativeQuery = myEntityManager.createNativeQuery(query);
        List<Integer> resultList = nativeQuery.getResultList();


        for (Integer competitionId : resultList) {
            competitions.add(competitionService.getCompetitionById(competitionId));
        }
        myEntityManager.getTransaction().commit();
        myEntityManager.close();


        return competitions;

    }
}
