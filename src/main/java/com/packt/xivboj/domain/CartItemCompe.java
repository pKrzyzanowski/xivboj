package com.packt.xivboj.domain;

public class CartItemCompe {
    private Competition competition;


    public CartItemCompe() {
    }

    public CartItemCompe(Competition competition) {
        super();
        this.competition = competition;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}
