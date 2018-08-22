package com.packt.xivboj.domain;

import java.io.Serializable;

public class Person implements Serializable{
    private static final long serialVersionUID = 2284040482222162898L;
    private String nameId;
    private String name;
    private String surname;
    private int age;
    private String description;

    public Person(String nameId, String name, String surname) {
        this.nameId = nameId;
        this.name = name;
        this.surname = surname;
    }

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
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
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (this == null){return false;}
        if (getClass() != o.getClass()) {
            return false;
        }
        Person other = (Person) o;
        if (nameId == null) {
            if (o != null) {
                return false;
            }
        } else if (!nameId.equals(other.nameId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Osoba [personId=" + nameId + ", nazwa=" + name + "]";
    }

}
