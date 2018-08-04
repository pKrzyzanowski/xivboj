package com.packt.xivboj.exception;

public class CompetitionNotFoundException extends RuntimeException {
    private String competitionId;

    public CompetitionNotFoundException(String competitionId) {
        this.competitionId = competitionId;
    }
}
