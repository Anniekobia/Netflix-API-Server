package com.example.netflix.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @NotNull(message = "Please enter your name")
    private String name;

    @Column(name = "identification_number",unique = true)
    @NotNull(message = "Please enter a unique identification number")
    private Long identificationNumber;


    public User(String name, Long identificationNumber) {
        this.name = name;
        this.identificationNumber = identificationNumber;
    }

    private User() {
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

    public Long getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(Long identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

}