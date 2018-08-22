package com.packt.xivboj.domain;

import java.io.Serializable;

public class CartItemCompe implements Serializable{

    private static final long serialVersionUID = -538766768334258062L;

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

    @Override
    public int hashCode() {
        final int prime = 311;
        int result = 1;
        result = prime * result + ((competition == null) ? 0 : competition.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CartItemCompe other = (CartItemCompe) obj;
        if (competition == null) {
            if (other.competition != null)
                return false;
        } else if (!competition.equals(other.competition))
            return false;
        return true;
    }

}
