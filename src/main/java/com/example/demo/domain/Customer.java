package com.example.demo.domain;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;



//http://www.codejava.net/frameworks/hibernate/hibernate-many-to-many-association-with-extra-columns-in-join-table-example
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    private Set<CarRent> carRents = new LinkedHashSet<>();

    public Customer(){}
    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    /*public Set<CarRent> getCarRents() {
        return carRents;
    }*/

    public void setCarRents(Set<CarRent> carRents) {
        this.carRents = carRents;
    }

    public Set<CarRent> selectAllCustomerRents() {
        return carRents;
    }
}
