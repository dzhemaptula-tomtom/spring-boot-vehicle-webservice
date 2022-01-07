package com.tomtom.vehicle.controller;

import com.tomtom.vehicle.model.Vehicle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Api("Vehicle rest controller")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success|OK"),
        @ApiResponse(code = 401, message = "Not Authorized!"),
        @ApiResponse(code = 403, message = "Forbidden!"),
        @ApiResponse(code = 404, message = "Not Found!")})
@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    List<Vehicle> vehicles = Arrays.asList(
            Vehicle.builder().name("Tourog").brand("Volkswagen").build(),
            Vehicle.builder().name("M3").brand("BMW").build(),
            Vehicle.builder().name("CLA 118").brand("Mercedes").build(),
            Vehicle.builder().name("Corsa").brand("Opel").build()
    );

    @ApiOperation(value = "Get Vehicles", tags = "getAllVehicles")
    @GetMapping("/")
    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }
}
