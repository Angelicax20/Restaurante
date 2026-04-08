package com.restaurante.restaurante;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    private  String dni;
    private  String FirstName;
    private  String LastName;

    private  Integer age;


    //TODO [Reverse Engineering] generate columns from DB
}