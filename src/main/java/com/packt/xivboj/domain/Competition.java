package com.packt.xivboj.domain;

public class Competition {

    private String competitionId;
    private String name;
    private String rules;
//    private Person author;
 


    public Competition() {

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





}
