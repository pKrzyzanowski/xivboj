package com.packt.xivboj.domain;


import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@Entity
@XmlRootElement
public class Competition implements Serializable {
    private static final long serialVersionUID = -538766763684258062L;




    @Id
    private String competitionId;

//    @Pattern(regexp="P[1-9]+", message="{cart.cleanCart}")
    private String name;

    private String rules;



    private int preferedTime;

    //    private Person author;
    @Transient
    @JsonIgnore
    private MultipartFile competitionImage;



 


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
