package com.packt.xivboj.exception;

public class PersonNotFoundException extends RuntimeException {
    private int personId;

    public PersonNotFoundException(int personId) {
        this.personId = personId;
    }
}
