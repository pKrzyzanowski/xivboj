package com.packt.xivboj.exception;

public class CompetitionNotFoundException extends RuntimeException {
    private int competitionId;

    public CompetitionNotFoundException(int competitionId) {
        this.competitionId = competitionId;
    }

}
