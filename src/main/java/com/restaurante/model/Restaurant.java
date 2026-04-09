package com.restaurante.model;

import jakarta.persistence.*;
//persistence = BASE DE DATOS


@Entity
@Table(name = "restaurants") //nombre de la tabla en la base de datos
public class Restaurant {
// ingresas campos para ver en la base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//el identificador se genera solo
    private  Long id;

    @Column(unique = true) //atributo unico
    private  String name;

    private String address;

    @Column(columnDefinition = "BOOLEAN DEFAULT true") //para texto largo ,
    private  Boolean active=true;
    private  Integer numberEmployees;
    private Double price;

    //GETTERS Y SETTERS
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getNumberEmployees() {
        return numberEmployees;
    }

    public void setNumberEmployees(Integer numberEmployees) {
        this.numberEmployees = numberEmployees;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    //constructor
    public Restaurant(String name, String address, Integer numberEmployees, Double price) {
        this.name = name;
        this.address = address;
        //this.active = active;
        this.numberEmployees = numberEmployees;
        this.price = price;
    }
//constructor vacio
    public Restaurant() {
    }


}
