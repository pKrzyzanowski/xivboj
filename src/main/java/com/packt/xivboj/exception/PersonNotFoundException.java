package com.packt.xivboj.exception;

public class PersonNotFoundException extends RuntimeException {
    private String personId;

    public PersonNotFoundException(String personId) {
        this.personId = personId;
    }
}
