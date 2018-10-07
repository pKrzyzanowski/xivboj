package com.packt.xivboj.domain.repository.impl;

import com.packt.xivboj.domain.Cart;
import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.domain.Person;
import com.packt.xivboj.domain.repository.CompetitionRepository;
import com.packt.xivboj.exception.CompetitionNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static com.packt.xivboj.util.PrincipalUtil.getCurrentUserCartName;


@Repository
public class InMemoryCompetitionRepository extends InMemoryBaseRepository implements CompetitionRepository {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public InMemoryCompetitionRepository() {
    }

    @Override
    public List<Competition> getAllCompetitions() {
        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();

        Query nativeQuery = myEntityManager.createNativeQuery("SELECT * FROM competition", Competition.class);
        List<Competition> resultList = nativeQuery.getResultList();

        myEntityManager.getTransaction().commit();
        myEntityManager.close();

        return resultList;
    }

    @Override
    public void addCompetition(final Competition competition) {
        packIntoEntityManagerTransaction(new BaseRepositoryTransaction() {
            @Override
            public void executeTransaction(EntityManager entityManager) {
                Competition competitionFromDb = null;
                try {
                    Query nativeQuery = entityManager.createNativeQuery("SELECT * FROM competition where name =" + "\"" + competition.getName() + "\"", Competition.class);
                    competitionFromDb = (Competition) nativeQuery.getSingleResult();
                } catch (NoResultException e) {
                    e.printStackTrace();
                }

                if (competitionFromDb == null) {
                    entityManager.persist(competition);
                }
            }
        });
    }

    @Override
    public void removeCompetition(int competitionId) {
    }

    @Override
    public Competition getCompetitionById(final int competitionId) {

        final AtomicReference<Competition> competitionById = new AtomicReference<>();

        packIntoEntityManagerTransaction(new BaseRepositoryTransaction() {
            @Override
            public void executeTransaction(EntityManager entityManager) {
                try {
                    competitionById.set(entityManager.find(Competition.class, competitionId));
                } catch (Exception e) {
                    throw new CompetitionNotFoundException(competitionId);
                }
            }
        });
        return competitionById.get();
    }

    @Override
    public List<Integer> getListOfCompetitionsIdByCartName(String cartName) {

        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();
        List<Integer> competitionIdListFromUserCart = myEntityManager.createNativeQuery("SELECT allCartCompetition_competitionId"
                + " FROM cartcompetition" + " where cart_cartId =" + "\"" + getCurrentUserCartName() + "\"").getResultList();
        myEntityManager.getTransaction().commit();
        myEntityManager.close();
        return competitionIdListFromUserCart;
    }

    @Override
    public List<Integer> getListOfCompetitionIdFromUserVotes(Integer userId) {
        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();
        List<Integer> competitionIdListFromUserVotes = myEntityManager.createNativeQuery("SELECT competitionList_competitionId"
                + " FROM person_competition where personList_nameId =" + "\"" + userId + "\"").getResultList();
        myEntityManager.getTransaction().commit();
        myEntityManager.close();
        return competitionIdListFromUserVotes;
    }


}
