package com.restaurante.model;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

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

  //  private String address;

    @Column(columnDefinition = "BOOLEAN DEFAULT true") //para texto largo ,
    private  Boolean active=true;
    private  Integer numberEmployees;
    private Double price;

    //fecha de apertura, fecha de cierre.(FECHA DE INICIO)
    @CreatedDate
    @CreationTimestamp
    private LocalDate startDate = LocalDate.now(); // LocalDate.Now(); valor por la fecha actual

    // horario de apertura y cierre.
    // tipo de comida, etc


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


    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    //constructor
    public Restaurant(String name, Double price, Integer numberEmployees) {
        this.name = name;
        //this.active = active;
        this.numberEmployees = numberEmployees;
        this.price = price;
    }
//constructor vacio
    public Restaurant() {
    }
// para mostrar por consola lo que continen las listas
    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", numberEmployees=" + numberEmployees +
                ", price=" + price +
                ", startDate=" + startDate +
                '}';
    }
}
