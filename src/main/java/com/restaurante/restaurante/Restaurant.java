package com.restaurante.restaurante;

import jakarta.persistence.*;
//persistence = BASE DE DATOS
import java.time.LocalDate;

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
    private  Boolean active;

    private  Integer numberEmployees;

    private Double price;


}
