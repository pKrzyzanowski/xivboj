package com.packt.xivboj.domain;


import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class Competition implements Serializable {
    private static final long serialVersionUID = -538766763684258062L;
    private String competitionId;
    private String name;
    private String rules;
//    private Person author;
 


    public Competition() {
        super();
    }

    public Competition(String competitionId, String name) {
        this.competitionId = competitionId;
        this.name = name;
    }

    public String getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(String competitionId) {
        this.competitionId = competitionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

//    public Person getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(Person author) {
//        this.author = author;
//    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Competition other = (Competition) obj;
        if (competitionId == null) {
            if (other.competitionId != null)
                return false;
        } else if (!competitionId.equals(other.competitionId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((competitionId == null) ? 0 : competitionId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Produkt [productId=" + competitionId + ", nazwa=" + name + "]";
    }



}
