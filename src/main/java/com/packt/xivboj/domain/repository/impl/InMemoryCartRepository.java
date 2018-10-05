package com.packt.xivboj.domain.repository.impl;

import com.packt.xivboj.domain.Cart;
import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.domain.Person;
import com.packt.xivboj.domain.repository.CartRepository;
import com.packt.xivboj.service.CartService;
import com.packt.xivboj.service.CompetitionService;
import com.packt.xivboj.util.PrincipalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


@Repository
public class InMemoryCartRepository extends InMemoryBaseRepository implements CartRepository {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    CompetitionService competitionService;

    @Autowired
    CartService cartService;

    @Autowired
    public InMemoryCartRepository() {
    }

    public Cart create(final Cart cart) {
        packIntoEntityManagerTransaction(new BaseRepositoryTransaction() {
            @Override
            public void executeTransaction(EntityManager entityManager) {
                entityManager.persist(cart);
            }
        });
        return cart;
    }

    //skoro i tak cartId jest przypisywane potem to nie musimy podawac tego w argumencie metody
    //cartIdArg do usuniecia na moje
    public Cart read(String cartIdArg) {
        final String cartId = PrincipalUtil.getCurrentUserCartName();

        final AtomicReference<Cart> cartById = new AtomicReference<>();
        packIntoEntityManagerTransaction(new BaseRepositoryTransaction() {
            @Override
            public void executeTransaction(EntityManager entityManager) {
                cartById.set(entityManager.find(Cart.class, cartId));
            }
        });

        return cartById.get();
    }

    public void update(final Cart cart) {
        packIntoEntityManagerTransaction(new BaseRepositoryTransaction() {
            @Override
            public void executeTransaction(EntityManager entityManager) {
                entityManager.merge(cart);
            }
        });
    }

    public void delete(final String cartId) {
        packIntoEntityManagerTransaction(new BaseRepositoryTransaction() {
            @Override
            public void executeTransaction(EntityManager entityManager) {
                entityManager.remove(entityManager.find(Cart.class, cartId));
            }
        });
    }
}
