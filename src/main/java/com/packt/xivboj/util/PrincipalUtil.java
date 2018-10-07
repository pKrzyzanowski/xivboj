package com.packt.xivboj.util;

import org.springframework.security.core.context.SecurityContextHolder;

public class PrincipalUtil  {
    private PrincipalUtil() {}

    private static final String CART_SUFFIX = "sCart";

    public static String getCurrentUserCartName() {
        return SecurityContextHolder.getContext().getAuthentication().getName() + PrincipalUtil.CART_SUFFIX;
    }
}
