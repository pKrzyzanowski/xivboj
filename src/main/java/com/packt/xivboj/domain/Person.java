package com.packt.xivboj.domain;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@Entity
public class Person implements Serializable{
    private static final long serialVersionUID = 2284040482222162898L;

    @Id
    @GeneratedValue
    private int nameId;
    private String name;
    private String surname;
    private int age;
    private String description;





    public Person( String name, String surname) {

        this.name = name;
        this.surname = surname;
    }

    public Person() {
    }

    public int getNameId() {
        return nameId;
    }

    public void setNameId(int nameId) {
        this.nameId = nameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (nameId != (other.nameId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Osoba [personId=" + nameId + ", nazwa=" + name + "]";
    }

}
