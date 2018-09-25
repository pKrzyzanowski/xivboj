package com.packt.xivboj.domain;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Person implements Serializable {
    private static final long serialVersionUID = 2284040482222162898L;

    @ManyToMany
    List<Competition> competitionList;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int nameId;
    private String name;
    private String surname;
    private int age;
    private String description;
    private String username;
    private String password;
    private int enabled = 1;
    private String role = "ROLE_USER";
    @OneToOne(mappedBy = "person")
    private Cart cart;
    @Transient
    private MultipartFile PersonImage;

    public Person(String name, String surname) {

        this.name = name;
        this.surname = surname;
    }

    public Person() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public MultipartFile getPersonImage() {
        return PersonImage;
    }

    public void setPersonImage(MultipartFile personImage) {
        PersonImage = personImage;
    }

    public List<Competition> getCompetitionList() {
        return competitionList;
    }

    public void setCompetitionList(List<Competition> competitionList) {
        this.competitionList = competitionList;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String login) {
        this.username = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
