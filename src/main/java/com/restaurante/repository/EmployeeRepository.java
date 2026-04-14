package com.restaurante.repository;


import com.restaurante.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    void findByDni(String dni);

    List<Employee> findByLastName(String lastName);

//METODOS DE CONSULTAS DERIVADAS - QUERY DERIVADOS

    List<Employee> findByAge(Integer age);

    List<Employee> findByRestaurantName(String restaurantName);

    List<Employee> findByFirstName(String firstName);


    // añadir consultas personalizadas
}
