package com.packt.xivboj.controller;

import com.packt.xivboj.domain.Cart;
import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.domain.Person;
import com.packt.xivboj.domain.repository.impl.InMemoryBaseRepository;
import com.packt.xivboj.exception.CompetitionNotFoundException;
import com.packt.xivboj.service.CartService;
import com.packt.xivboj.service.CompetitionService;
import com.packt.xivboj.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.packt.xivboj.util.PrincipalUtil.getCurrentUserCartName;


@RestController
@RequestMapping(value = "/rest/cart")
public class CartRestController extends InMemoryBaseRepository {

    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;

    @Autowired
    private CartService cartService;

    @Autowired
    private CompetitionService competitionService;

    @Autowired
    private PersonService personService;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    Cart create(@RequestBody Cart cart) {
        return cartService.create(cart);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public @ResponseBody
    Cart read(@PathVariable(value = "cartId") String cartId) {
        return cartService.read();
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value = "cartId") String cartId, @RequestBody Cart cart) {
        cartService.update(cart);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "cartId") String cartId) {
        cartService.delete(cartId);
    }

    @RequestMapping(value = "/add/{competitionId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable int competitionId) {
        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();

        String currentPrincipalName = SecurityContextHolder.getContext().getAuthentication().getName();
        Cart cart = cartService.read();
        if (cart == null) {
            Query nativeQuery = myEntityManager.createNativeQuery("SELECT * FROM person where username =" + "\"" + currentPrincipalName + "\"", Person.class);
            Person person = (Person) nativeQuery.getSingleResult();
            cart = new Cart();
            cart.setCartId(getCurrentUserCartName());
            cart.setPerson(person);
            person.setCart(cart);
            myEntityManager.persist(cart);
            myEntityManager.merge(person);
        }
        Competition competition = competitionService.getCompetitionById(competitionId);

        if (!competitionService.getListOfCompetitionsIdByCartName(getCurrentUserCartName())
                .contains(competition.getCompetitionId())
                && !competitionService.getListOfCompetitionIdFromUserVotes(personService.getCurrentPersonId())
                .contains(competition.getCompetitionId())) {
            List<Competition> cartCompetitions = cart.getAllCartCompetition();
            cartCompetitions.add(competition);
            cart.setAllCartCompetition(cartCompetitions);

            myEntityManager.merge(cart);
            myEntityManager.merge(competition);
        }
        myEntityManager.getTransaction().commit();
        myEntityManager.close();
    }

    @RequestMapping(value = "/remove/{competitionId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable int competitionId, HttpServletRequest request) throws IllegalAccessException {

        String currentPrincipalName = SecurityContextHolder.getContext().getAuthentication().getName();
        String userName = currentPrincipalName + "sCart";

        Cart cart = cartService.read();
        Competition competition = competitionService.getCompetitionById(competitionId);
        if (competition == null) {
            throw new IllegalArgumentException(new CompetitionNotFoundException(competitionId));
        }

        List<Competition> cartCompetitions = cart.getAllCartCompetition();
        cartCompetitions.remove(competition);
        cart.setAllCartCompetition(cartCompetitions);

        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();
        myEntityManager.merge(cart);
        myEntityManager.merge(competition);

        myEntityManager.getTransaction().commit();
        myEntityManager.close();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Niepoprawne ¿¹danie, sprawdŸ przesy³ane dane.")
    public void handleClientErrors(Exception ex) {
        System.out.println("Client error." + ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Wewnêtrzny b³¹d serwera")
    public void handleServerErrors(Exception ex) {
        System.out.println("server error." + ex.getMessage());
    }
}
