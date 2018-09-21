package com.packt.xivboj.controller;

import javax.servlet.http.HttpServletRequest;

import com.packt.xivboj.domain.Cart;
import com.packt.xivboj.domain.CartItemCompe;
import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.exception.CompetitionNotFoundException;
import com.packt.xivboj.service.CartService;
import com.packt.xivboj.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/rest/cart")
public class CartRestController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CompetitionService competitionService;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Cart create(@RequestBody Cart cart) {
        return  cartService.create(cart);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public @ResponseBody Cart read(@PathVariable(value = "cartId") String cartId) {
        return cartService.read(cartId);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value = "cartId") String cartId,	@RequestBody Cart cart) {
        cartService.update(cartId, cart);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "cartId") String cartId) {
        cartService.delete(cartId);
    }

    @RequestMapping(value = "/add/{competitionId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable int competitionId, HttpServletRequest request) throws IllegalAccessException {


        String currentPrincipalName = SecurityContextHolder.getContext().getAuthentication().getName();
        String userName = currentPrincipalName+"sCart";


        Cart cart = cartService.read(userName);
        if(cart== null) {
            cart = cartService.create(new Cart(userName));
        }

        Competition competition = competitionService.getCompetitionById(competitionId);
        if(competition == null) {
            throw new IllegalArgumentException(new CompetitionNotFoundException(competitionId));
        }

        cart.addCartCompe(competition);

        cartService.update(userName, cart);
    }

    @RequestMapping(value = "/remove/{competitionId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable int competitionId, HttpServletRequest request) throws IllegalAccessException {


        String currentPrincipalName = SecurityContextHolder.getContext().getAuthentication().getName();
        String userName = currentPrincipalName+"sCart";

        String sessionId = userName;
        Cart cart = cartService.read(sessionId);
        if(cart== null) {
            cart = cartService.create(new Cart(sessionId));
        }

        Competition competition = competitionService.getCompetitionById(competitionId);
        if(competition == null) {
            throw new IllegalArgumentException(new CompetitionNotFoundException(competitionId));
        }

        cart.removeCartCompe(competition);

        cartService.update(sessionId, cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST,  reason="Niepoprawne ¿¹danie, sprawdŸ przesy³ane dane.")
    public void handleClientErrors(Exception ex) { }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason="Wewnêtrzny b³¹d serwera")
    public void handleServerErrors(Exception ex) {
        System.out.println("okukubanbo");
    }
}
