package com.tomtom.vehicle.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_email_unique", columnNames = "email")
        }
)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Getter
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @Column(name = "user_id", nullable = false, updatable = false)
    @ApiModelProperty(notes = "User Id", name = "userId", required = true, value = "1")
    private Long userId;

    @Getter
    @Setter
    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @ApiModelProperty(notes = "User first name", name = "firstName", required = true, value = "John")
    private String firstName;

    @Getter
    @Setter
    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @ApiModelProperty(notes = "User last name", name = "lastName", required = true, value = "Doe")
    private String lastName;

    @Getter
    @Setter
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @ApiModelProperty(notes = "User email address", name = "email", required = true, value = "john.doe@tomtom.com")
    private String email;

    @Getter
    @Setter
    @Column(
            name = "birth_date"
    )
    @ApiModelProperty(notes = "User birth date", name = "birthDate", required = true)
    private LocalDate birthDate;

    @Getter
    @Setter
    @ToString.Exclude
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "owner_user_id",
            referencedColumnName = "user_id"
    )
    private List<Vehicle> ownedVehicles = new ArrayList<>();
}
