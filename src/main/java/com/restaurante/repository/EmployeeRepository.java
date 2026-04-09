package com.restaurante.repository;


import com.restaurante.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // añadir consultas personalizadas
}
