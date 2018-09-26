package com.packt.xivboj.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
public class Person implements Serializable {
    private static final long serialVersionUID = 2284040482222162898L;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Competition> competitionList;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int nameId;
    @Size(min = 1, max = 50, message = "{Person.name.validation}")
    private String name;
    private String surname;
    @Min(value = 1, message = "{Person.age.validation}")
    private int age;
    @Size(min = 1, max = 50, message = "{Person.description.validation}")
    private String description;
    private String username;
    //    @ColumnTransformer(read = "aes_encrypt(password, 'mySecretKey')", write = "aes_encrypt(?, 'mySecretKey')")
    @Size(min = 6, max = 50, message = "{Person.password.validation}")
    private String password;
    private String confirmPassword;
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
