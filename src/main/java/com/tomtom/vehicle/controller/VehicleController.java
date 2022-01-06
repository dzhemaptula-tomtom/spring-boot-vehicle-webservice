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
            new Vehicle(1L, "Vehicle1", "Volkswagen"),
            new Vehicle(2L, "Vehicle2", "BMW"),
            new Vehicle(3L, "Vehicle3", "Mercedes"),
            new Vehicle(4L, "Vehicle4", "Opel")
    );

    @ApiOperation(value = "Get Vehicles", tags = "getAllVehicles")
    @GetMapping("/")
    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }
}
