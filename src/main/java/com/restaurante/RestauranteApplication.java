package com.restaurante;

import com.restaurante.model.Employee;
import com.restaurante.model.Restaurant;
import com.restaurante.repository.EmployeeRepository;
import com.restaurante.repository.RestaurantRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class RestauranteApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(RestauranteApplication.class, args);
        //obtener los repositorios para poder hacer operaciones de bae de datos con ellos
        RestaurantRepository restaurantRepository = context.getBean(RestaurantRepository.class);
        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);

        //restaurantRepository.
        //guardar el restaurante en base de dato usando el repositorio : save()

        Restaurant pacoBar = new Restaurant("nombre1",23.54,23); //meter objeto a base de dato
//        pacoBar.setName("Paco Bar");
//        pacoBar.setAddress("Calle 123");
//        pacoBar.setPrice(25.50);
//        pacoBar.setNumberEmployees(10);

        Restaurant bar2 = new Restaurant("nombre2", 23.54,23); //meter objeto a base de dato
        Restaurant bar3 = new Restaurant();

        restaurantRepository.save(pacoBar);//para guardar o insertar en la BD
        restaurantRepository.save(bar2);//para guardar o insertar en la BD
        restaurantRepository.save(bar3);//para guardar o insertar en la BD

// TODO es para tenerlo como un comentario recordatorio
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

        //saveall

        Restaurant r1 = new Restaurant("r1",10.0,3);
        Restaurant r2 = new Restaurant("r2",10.0,3);

        List<Restaurant> sitios = new ArrayList<>();
        sitios.add(r1);
        sitios.add(r2);

        List<String> alumnos = new ArrayList<>();
        List<Double> precios = new ArrayList<>();

        //opcion moderna para crear lista
        List<Restaurant> listaRestaurantes = List.of(r1,r2);
        restaurantRepository.saveAll(listaRestaurantes);

        //count () para contar cuantas filas hay en la tabla:
        long numeroRestaurantes = restaurantRepository.count();

        if (numeroRestaurantes > 0) {
            System.out.println("Hay " + numeroRestaurantes + " restaurantes en la base de datos.");
        } else {
            System.out.println("No hay restaurantes en la base de datos.");
        }

        //existById devuelve boolean si existe o no un restaurante con el id dado
        long id = 1;
        boolean existe = restaurantRepository.existsById(id);
        if (existe)
            System.out.println("Existe el restaurante " + existe + "  en la base de datos.");
        else
            System.out.println("No existe en la base de datos.");

        // restaurantRepository.existsById(2L); debe usarse long para que identifique el id como un numero entero largo

        boolean existeR1 = restaurantRepository.existsById(r1.getId());
        System.out.println("¿Existe el restaurante r1? " + existeR1);

        //deleteAll borrar todas las filas de la tbla
        // restaurantRepository.deleteAll();

        //deleteById borra una fila indicando su id
        restaurantRepository.deleteById(r2.getId());
        //restaurantRepository. deleteById(1L);

        //delete
        restaurantRepository.delete(r1);


        //findById

     //long resta =  restaurantRepository.findById(1);
       long idBuscado = 2L;

        Optional<Restaurant> restaurantFromDatabase = restaurantRepository.findById(idBuscado);

        if (restaurantFromDatabase.isPresent()) {
            System.out.println("Restaurante encontrado: " + restaurantFromDatabase.get());
        } else {
            System.out.println("No se encontró un restaurante con el ID: " + idBuscado);
        }

        Restaurant restaurantEncontrado = restaurantFromDatabase.get();
        System.out.println(restaurantEncontrado);

        // de consulta findAll,finddByIf,finAllon, count
        // de guardado save,saveAll
        //Para elminar deleteById,deleteAll,delete
    }

}
