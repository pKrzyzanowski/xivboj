package com.packt.xivboj.domain;


import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

@Entity(name = "competition")
@Table(name = "competition")
@XmlRootElement
public class Competition implements Serializable, Comparable {
    private static final long serialVersionUID = -538766763684258062L;

    @ManyToMany(mappedBy = "competitionList")
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Person> personList;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int competitionId;
    //    @Pattern(regexp="P[1-9]+", message="{cart.cleanCart}")
    @Column(name = "name")
    private String name;
    @Column(name = "rules")
    private String rules;
    @Column(name = "preferedTime")
    private int preferedTime;
    private String autorsName;

    @JsonIgnore
    @Transient
    private MultipartFile competitionImage;

    public Competition() {
        super();
    }

    public Competition(String name) {
        this.name = name;
    }

    public String getAutorsName() {
        return autorsName;
    }

    public void setAutorsName(String autorsName) {
        this.autorsName = autorsName;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public int getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(int competitionId) {
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

    @XmlTransient
    public MultipartFile getCompetitionImage() {
        return competitionImage;
    }

    @XmlTransient
    public void setCompetitionImage(MultipartFile competitionImage) {
        this.competitionImage = competitionImage;
    }

    public int getPreferedTime() {
        return preferedTime;
    }

    public void setPreferedTime(int preferedTime) {
        this.preferedTime = preferedTime;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Competition other = (Competition) obj;
        if (competitionId != (other.competitionId))
            return false;
        return true;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((competitionId == 0) ? 0 : competitionId);
        return result;
    }

    @Override
    public String toString() {
        return "Konkurencja [comeptitionId=" + competitionId + ", nazwa=" + name + "]";
    }


    @Override
    public int compareTo(Object compareObj) {
        int compareQuantityOfVoices = ((Competition) compareObj).getPersonList().size();

        return compareQuantityOfVoices - this.getPersonList().size();


    }
}
