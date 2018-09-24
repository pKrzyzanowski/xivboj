package com.packt.xivboj.controller;

import com.packt.xivboj.domain.Cart;
import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.exception.CompetitionNotFoundException;
import com.packt.xivboj.service.CartService;
import com.packt.xivboj.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping(value = "/rest/cart")
public class CartRestController {

    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;
    @Autowired
    private CartService cartService;
    @Autowired
    private CompetitionService competitionService;

    @Transactional
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    Cart create(@RequestBody Cart cart) {
        return cartService.create(cart);
    }

    @Transactional
    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public @ResponseBody
    Cart read(@PathVariable(value = "cartId") String cartId) {

        Cart cart = cartService.read(cartId);
        return cart;
    }

    @Transactional
    @RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value = "cartId") String cartId, @RequestBody Cart cart) {
        cartService.update(cart);
    }

    @Transactional
    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "cartId") String cartId) {
        cartService.delete(cartId);
    }

    @Transactional
    @RequestMapping(value = "/add/{competitionId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable int competitionId, HttpServletRequest request) throws IllegalAccessException {

        String currentPrincipalName = SecurityContextHolder.getContext().getAuthentication().getName();
        String userName = currentPrincipalName + "sCart";


        Cart cart = cartService.read(userName);
        if (cart == null) {
            cart = cartService.create(new Cart(userName));
        }

        Competition competition = competitionService.getCompetitionById(competitionId);
        if (competition == null) {
            throw new IllegalArgumentException(new CompetitionNotFoundException(competitionId));
        }

//        cart.addCartCompe(competition);


        String cartId = cart.getCartId();

        List<Competition> cartCompetitions = cartService.getAllCompetitionsbyCartsId(cartId);
        cartCompetitions.add(competition);
        cart.setAllCartCompe(cartCompetitions);

        EntityManager myEntityManager = entityManagerFactory.createEntityManager();
        myEntityManager.getTransaction().begin();
        myEntityManager.merge(cart);
        myEntityManager.merge(competition);
        myEntityManager.getTransaction().commit();
        myEntityManager.close();

// jest setAllCartCompet i widnieja  w niej wartosci to dlaczego nie nie mozna ich przekazac do cart.jsp?
        cartService.update(cart);
    }

    @Transactional
    @RequestMapping(value = "/remove/{competitionId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable int competitionId, HttpServletRequest request) throws IllegalAccessException {


        String currentPrincipalName = SecurityContextHolder.getContext().getAuthentication().getName();
        String userName = currentPrincipalName + "sCart";

        String sessionId = userName;
        Cart cart = cartService.read(sessionId);
        if (cart == null) {
            cart = cartService.create(new Cart(sessionId));
        }

        Competition competition = competitionService.getCompetitionById(competitionId);
        if (competition == null) {
            throw new IllegalArgumentException(new CompetitionNotFoundException(competitionId));
        }

        cart.removeCartCompe(competition);

        cartService.update(cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Niepoprawne ¿¹danie, sprawdŸ przesy³ane dane.")
    public void handleClientErrors(Exception ex) {
    }

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Wewnêtrzny b³¹d serwera")
//    public void handleServerErrors(Exception ex) {
//        System.out.println("serwer error");
//    }
}
