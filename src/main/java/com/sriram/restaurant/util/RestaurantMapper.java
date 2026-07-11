package com.sriram.restaurant.util;

import com.sriram.restaurant.dto.RestaurantDTO;
import com.sriram.restaurant.entity.Restaurant;

public class RestaurantMapper {

    // Entity -> DTO
    public static RestaurantDTO toDTO(Restaurant restaurant) {

        if (restaurant == null) {
            return null;
        }

        return new RestaurantDTO(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getAddress(),
                restaurant.getPhone(),
                restaurant.getOwnerName()
        );
    }

    // DTO -> Entity
    public static Restaurant toEntity(RestaurantDTO dto) {

        if (dto == null) {
            return null;
        }

        Restaurant restaurant = new Restaurant();

        restaurant.setId(dto.getId());
        restaurant.setName(dto.getName());
        restaurant.setAddress(dto.getAddress());
        restaurant.setPhone(dto.getPhone());
        restaurant.setOwnerName(dto.getOwnerName());

        return restaurant;
    }
}