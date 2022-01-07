package com.tomtom.vehicle.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "vehicles")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Vehicle {
    @Getter
    @Id
    @SequenceGenerator(
            name = "vehicle_sequence",
            sequenceName = "vehicle_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_sequence")
    @Column(name = "vehicle_id", nullable = false, updatable = false)
    @ApiModelProperty(notes = "Vehicle Id", name = "vehicleId", required = true, value = "1")
    private Long vehicleId;

    @Getter
    @Setter
    @Column(
            name = "name",
            nullable = false
    )
    @ApiModelProperty(notes = "Vehicle Name", name = "name", required = true, value = "golf")
    private String name;

    @Getter
    @Setter
    @Column(
            name = "brand",
            nullable = false
    )
    @ApiModelProperty(notes = "Vehicle Brand", name = "brand", required = true, value = "volkswagen")
    private String brand;

    @Getter
    @Setter
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "owner_user_id",
            referencedColumnName = "user_id"
    )
    private User owner;

}
