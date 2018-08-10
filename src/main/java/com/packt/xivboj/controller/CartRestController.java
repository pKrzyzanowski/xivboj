package com.packt.xivboj.controller;

import com.packt.xivboj.domain.Cart;
import com.packt.xivboj.domain.CartItemCompe;
import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.exception.CompetitionNotFoundException;
import com.packt.xivboj.service.CartService;
import com.packt.xivboj.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "rest/cart")
public class CartRestController {


    @Autowired
    private CartService cartService;

    @Autowired
    CompetitionService competitionService;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Cart create(@RequestBody Cart cart) {
        return  cartService.create(cart);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public @ResponseBody
    Cart
    read(@PathVariable(value = "cartId") String cartId) {
        return cartService.read(cartId);
    }

    @RequestMapping(value = "/{cartId", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value = "cartId") String cartId, @RequestBody Cart cart) {
        cartService.update(cartId, cart);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "cartId") String cartId) {
        cartService.delete(cartId);
    }

    @RequestMapping(value = "/add/{competitionId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable(value = "competitionId") String competitionId, HttpServletRequest request) {
        String sessionId = request.getSession(true).getId();
        Cart cart = cartService.read(sessionId);

        if (cart == null) {
            cart = cartService.create(new Cart(sessionId));
        }

        Competition competition = competitionService.getCompetitionById(competitionId);
        if (competition == null) {
            throw new CompetitionNotFoundException(competitionId);
        }
        cart.addCartItem(new CartItemCompe(competition));
        cartService.update(sessionId, cart);
    }

    @RequestMapping(value = "/remove/{competitionId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable(value = "competitionId") String competitionId, HttpServletRequest request) {
        String sessionId = request.getSession(true).getId();
        Cart cart = cartService.read(sessionId);

        if (cart == null) {
            cart = cartService.create(new Cart(sessionId));
        }
        Competition competition = competitionService.getCompetitionById(competitionId);
        if (competition == null) {
            throw new CompetitionNotFoundException(competitionId);
        }
        cart.removeCartItem(new CartItemCompe(competition));
        cartService.update(sessionId, cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "niepoprawne rzadanie, sprawdz pzresylane dane")
    public void handleClientErrors(Exception e) {

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Wewnetrzny blad serwera")
    public void handleServerErrors(Exception e) {

    }

}
