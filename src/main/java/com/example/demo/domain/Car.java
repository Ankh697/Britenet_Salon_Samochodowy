package com.example.demo.domain;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
public class Car {
    @Id
    @GeneratedValue
    private Long id;
    private String model;
    @OneToMany(mappedBy = "car", cascade = CascadeType.PERSIST)
    private Set<CarRent> carRents = new LinkedHashSet<>();

    public Car(){}

    public Car(String model) {
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    /*public Set<CarRent> getCarRents() {
        return carRents;
    }*/
    public Set<CarRent> selectAllCarRents() {
        return carRents;
    }

    public void setCarRents(Set<CarRent> carRents) {
        this.carRents = carRents;
    }

}
