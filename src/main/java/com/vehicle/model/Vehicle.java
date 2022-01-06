package com.vehicle.model;

import io.swagger.annotations.ApiModelProperty;

public class Vehicle {
    @ApiModelProperty(notes = "Vehicle Id", name = "id", required = true, value = "1")
    private int id;

    @ApiModelProperty(notes = "Vehicle Name", name = "name", required = true, value = "golf")
    private String name;

    @ApiModelProperty(notes = "Vehicle Brand", name = "brand", required = true, value = "volkswagen")
    private String brand;

    public Vehicle(int id, String name, String brand) {
        this.id = id;
        this.name = name;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
