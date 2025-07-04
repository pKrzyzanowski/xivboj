package com.packt.xivboj.controller;


import com.packt.xivboj.domain.Cart;
import com.packt.xivboj.domain.Competition;
import com.packt.xivboj.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
// dodaje to teraz jeszcze raz i powinno byc jako pierwsze
@Controller
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @RequestMapping
    public String get() {
        return "redirect:/cart/" + SecurityContextHolder.getContext().getAuthentication().getName() + "sCart";
    }
// dodaje komentarz po wielu latach na masterze 
    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public String getCart(@PathVariable(value = "cartId") String cartId, Model model) {
        model.addAttribute("cartId", cartId);
        Cart cart = cartService.read();
        model.addAttribute("cart", cart);
        return "cart";
        // ta zamiana powinna isc pierwsza po rebase
    }
}
