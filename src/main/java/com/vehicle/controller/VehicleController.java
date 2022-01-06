package com.vehicle.controller;

import com.vehicle.model.Vehicle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    List<Vehicle> vehicles = new ArrayList<>();
    {
        vehicles.add(new Vehicle(1,"Vehicle1", "Volkswagen"));
        vehicles.add(new Vehicle(2,"Vehicle2", "BMW"));
        vehicles.add(new Vehicle(3,"Vehicle3", "Mercedes"));
        vehicles.add(new Vehicle(4,"Vehicle4", "Opel"));
    }

    @ApiOperation(value = "Get Vehicles", response = Iterable.class, tags = "getAllVehicles")
    @GetMapping("/")
    public String getAllVehicles() {
        return "Hello vehicle";
    }
}
