package com.tomtom.vehicle.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity(name="vehicles")
@Table
public class Vehicle {
    @Id
    @GeneratedValue
    @ApiModelProperty(notes = "Vehicle Id", name = "id", required = true, value = "1")
    private Long id;

    @Column(
            name = "name",
            nullable = false
    )
    @ApiModelProperty(notes = "Vehicle Name", name = "name", required = true, value = "golf")
    private String name;

    @Column(
            name = "brand",
            nullable = false
    )
    @ApiModelProperty(notes = "Vehicle Brand", name = "brand", required = true, value = "volkswagen")
    private String brand;

    public Vehicle() {
    }

    public Vehicle(Long id, String name, String brand) {
        this.id = id;
        this.name = name;
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
