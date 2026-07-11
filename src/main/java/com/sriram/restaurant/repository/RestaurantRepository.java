package com.sriram.restaurant.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sriram.restaurant.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findByName(String name);

    List<Restaurant> findByAddress(String address);

    List<Restaurant> findByOwnerName(String ownerName);

    // Pagination & Sorting
    Page<Restaurant> findAll(Pageable pageable);

}