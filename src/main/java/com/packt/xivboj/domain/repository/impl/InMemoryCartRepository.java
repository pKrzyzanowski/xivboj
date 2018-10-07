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
import java.util.concurrent.atomic.AtomicReference;

import static com.packt.xivboj.util.PrincipalUtil.getCurrentUserCartName;


@Repository
public class InMemoryCartRepository extends InMemoryBaseRepository implements CartRepository {

    @Autowired
    CompetitionService competitionService;

    @Autowired
    CartService cartService;

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

    public Cart read() {
        final String cartId = getCurrentUserCartName();
        final AtomicReference<Cart> CartById = new AtomicReference<>();

        packIntoEntityManagerTransaction(new BaseRepositoryTransaction() {
            @Override
            public void executeTransaction(EntityManager entityManager) {
                CartById.set(entityManager.find(Cart.class, cartId));
            }
        });
        return CartById.get();
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
