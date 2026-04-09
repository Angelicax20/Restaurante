package com.restaurante;

import com.restaurante.model.Employee;
import com.restaurante.model.Restaurant;
import com.restaurante.repository.EmployeeRepository;
import com.restaurante.repository.RestaurantRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class RestauranteApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(RestauranteApplication.class, args);
        //obtener los repositorios para poder hacer operaciones de bae de datos con ellos
        RestaurantRepository restaurantRepository = context.getBean(RestaurantRepository.class);
        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);

        //restaurantRepository.
        //guardar el restaurante en base de dato usando el repositorio : save()

        Restaurant pacoBar = new Restaurant("nombre1","direccion",23,23.54); //meter objeto a base de dato
//        pacoBar.setName("Paco Bar");
//        pacoBar.setAddress("Calle 123");
//        pacoBar.setPrice(25.50);
//        pacoBar.setNumberEmployees(10);

        Restaurant bar2 = new Restaurant("nombre2","direccion 2", 10,22.1); //meter objeto a base de dato

        Restaurant bar3 = new Restaurant();

        restaurantRepository.save(pacoBar);//para guardar o insertar en la BD
        restaurantRepository.save(bar2);//para guardar o insertar en la BD
        restaurantRepository.save(bar3);//para guardar o insertar en la BD


        Employee empleado1 = new Employee("angelica","giraldo",26);
        employeeRepository.save(empleado1);
        System.out.println(empleado1);

        Employee empleado2 = new Employee();
        employeeRepository.save(empleado2);


        //restaurantRepository.findAll().forEach(System.out::println);
        // var restaurantes = restaurantRepository.findAll();
        //RECUPERAR DATOD DE LA BASE DE DATOS Y MOSTRARLOS POR CONSOLA
        List<Restaurant> restaurantes = restaurantRepository.findAll();
        List<Employee> empleados = employeeRepository.findAll();

        System.out.println(restaurantRepository.findAll());
        System.out.println(employeeRepository.findAll());
    }

}
