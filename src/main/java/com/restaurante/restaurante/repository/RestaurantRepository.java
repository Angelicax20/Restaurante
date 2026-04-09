package com.restaurante.restaurante.repository;

import com.restaurante.restaurante.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}