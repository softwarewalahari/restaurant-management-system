package com.sriram.restaurant.service;

import java.util.List;

import com.sriram.restaurant.dto.RestaurantDTO;

public interface RestaurantService {

    RestaurantDTO addRestaurant(RestaurantDTO restaurantDTO);

    List<RestaurantDTO> getAllRestaurants();

    RestaurantDTO getRestaurantById(Long id);

    RestaurantDTO updateRestaurant(Long id, RestaurantDTO restaurantDTO);

    void deleteRestaurant(Long id);

    // Search APIs
    List<RestaurantDTO> getRestaurantsByName(String name);

    List<RestaurantDTO> getRestaurantsByAddress(String address);

    List<RestaurantDTO> getRestaurantsByOwnerName(String ownerName);
    List<RestaurantDTO> getAllRestaurants(int page, int size, String sortBy);
}