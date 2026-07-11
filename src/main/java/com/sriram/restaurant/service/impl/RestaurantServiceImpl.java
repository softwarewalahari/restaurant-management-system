package com.sriram.restaurant.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

import com.sriram.restaurant.dto.RestaurantDTO;
import com.sriram.restaurant.entity.Restaurant;
import com.sriram.restaurant.exception.RestaurantNotFoundException;
import com.sriram.restaurant.repository.RestaurantRepository;
import com.sriram.restaurant.service.RestaurantService;
import com.sriram.restaurant.util.RestaurantMapper;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public RestaurantDTO addRestaurant(RestaurantDTO restaurantDTO) {

        Restaurant restaurant = RestaurantMapper.toEntity(restaurantDTO);

        Restaurant savedRestaurant = restaurantRepository.save(restaurant);

        return RestaurantMapper.toDTO(savedRestaurant);
    }

    @Override
    public List<RestaurantDTO> getAllRestaurants() {

        return restaurantRepository.findAll()
                .stream()
                .map(RestaurantMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RestaurantDTO getRestaurantById(Long id) {

        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found with id: " + id));

        return RestaurantMapper.toDTO(restaurant);
    }

    @Override
    public RestaurantDTO updateRestaurant(Long id, RestaurantDTO restaurantDTO) {

        Restaurant existingRestaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found with id: " + id));

        existingRestaurant.setName(restaurantDTO.getName());
        existingRestaurant.setAddress(restaurantDTO.getAddress());
        existingRestaurant.setPhone(restaurantDTO.getPhone());
        existingRestaurant.setOwnerName(restaurantDTO.getOwnerName());

        Restaurant updatedRestaurant = restaurantRepository.save(existingRestaurant);

        return RestaurantMapper.toDTO(updatedRestaurant);
    }

    @Override
    public void deleteRestaurant(Long id) {

        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found with id: " + id));

        restaurantRepository.delete(restaurant);
    }

    @Override
    public List<RestaurantDTO> getRestaurantsByName(String name) {

        return restaurantRepository.findByName(name)
                .stream()
                .map(RestaurantMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RestaurantDTO> getRestaurantsByAddress(String address) {

        return restaurantRepository.findByAddress(address)
                .stream()
                .map(RestaurantMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RestaurantDTO> getRestaurantsByOwnerName(String ownerName) {

        return restaurantRepository.findByOwnerName(ownerName)
                .stream()
                .map(RestaurantMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
public List<RestaurantDTO> getAllRestaurants(int page, int size, String sortBy) {

    Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

    Page<Restaurant> restaurantPage = restaurantRepository.findAll(pageable);

    return restaurantPage.getContent()
            .stream()
            .map(RestaurantMapper::toDTO)
            .toList();
}
}