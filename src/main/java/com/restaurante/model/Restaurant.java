package com.restaurante.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDate;
import java.time.LocalDateTime;

//persistence = BASE DE DATOS


@Entity
@Table(name = "restaurants") //nombre de la tabla en la base de datos
public class Restaurant {
// ingresas campos para ver en la base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//el identificador se genera solo (el id se genera)
    private  Long id;

    @Column(unique = true) //atributo unico
    private  String name;

  //  private String address;
    @Column(columnDefinition = "BOOLEAN DEFAULT true") //para texto largo ,
    private  Boolean active=true;
    private  Integer numberEmployees;
    private Double price;

    //Fecha de fundacion
    @CreationTimestamp  // esta anotacion es para que la base genere la fecha, util
    // para registrar fecha automaticamente sin preocuparse de tener que cambiarla
    private LocalDate startDateFundacion = LocalDate.now();//valor por defecto a la horal actual

    //fecha de apertura, fecha de cierre.(FECHA DE INICIO)
    @CreatedDate
    @CreationTimestamp
    private LocalDate startDate = LocalDate.now(); // LocalDate.Now(); valor por la fecha actual

    // horario de apertura y cierre.
    //private LocalDateTime ultimaReserva = LocalDateTime.now();

    // tipo de comida, etc
    @Enumerated(EnumType.STRING)
    //@Column(name = "food_type") PARA CAMBIAR EL NOMBRRE DE LA TABLA
   // private FoodType foodType = FoodType.COLOMBIAN;
    private FoodType foodType;


    //GETTERS Y SETTERS
    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
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
                ", foodType=" + foodType +
                '}';
    }
//
//    public LocalDateTime getUltimaReserva() {
//        return ultimaReserva;
//    }
//
//    public void setUltimaReserva(LocalDateTime ultimaReserva) {
//        this.ultimaReserva = ultimaReserva;
//    }

    public LocalDate getStartDateFundacion() {
        return startDateFundacion;
    }

    public void setStartDateFundacion(LocalDate startDateFundacion) {
        this.startDateFundacion = startDateFundacion;
    }
}
