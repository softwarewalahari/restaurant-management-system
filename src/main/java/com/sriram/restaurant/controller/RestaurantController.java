package com.sriram.restaurant.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.sriram.restaurant.dto.RestaurantDTO;
import com.sriram.restaurant.service.RestaurantService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/restaurants")
@CrossOrigin(origins = "*")
@Tag(
    name = "Restaurant Management API",
    description = "CRUD Operations for Restaurant Management System"
)
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Operation(summary = "Add a new restaurant")
    @PostMapping
    public RestaurantDTO addRestaurant(@Valid @RequestBody RestaurantDTO restaurantDTO) {
        return restaurantService.addRestaurant(restaurantDTO);
    }

    @Operation(summary = "Get all restaurants")
    @GetMapping
    public List<RestaurantDTO> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @Operation(summary = "Get restaurant by ID")
    @GetMapping("/{id}")
    public RestaurantDTO getRestaurantById(@PathVariable Long id) {
        return restaurantService.getRestaurantById(id);
    }

    @Operation(summary = "Update restaurant")
    @PutMapping("/{id}")
    public RestaurantDTO updateRestaurant(
            @PathVariable Long id,
            @Valid @RequestBody RestaurantDTO restaurantDTO) {

        return restaurantService.updateRestaurant(id, restaurantDTO);
    }

    @Operation(summary = "Delete restaurant")
    @DeleteMapping("/{id}")
    public String deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return "Restaurant deleted successfully";
    }

    @Operation(summary = "Search restaurants by name")
    @GetMapping("/search")
    public List<RestaurantDTO> searchByName(@RequestParam String name) {
        return restaurantService.getRestaurantsByName(name);
    }

    @Operation(summary = "Search restaurants by address")
    @GetMapping("/search/address")
    public List<RestaurantDTO> searchByAddress(@RequestParam String address) {
        return restaurantService.getRestaurantsByAddress(address);
    }

    @Operation(summary = "Search restaurants by owner")
    @GetMapping("/search/owner")
    public List<RestaurantDTO> searchByOwner(@RequestParam String ownerName) {
        return restaurantService.getRestaurantsByOwnerName(ownerName);
    }

    @Operation(summary = "Get restaurants with pagination and sorting")
    @GetMapping("/page")
    public List<RestaurantDTO> getRestaurantsWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        return restaurantService.getAllRestaurants(page, size, sortBy);
    }
}