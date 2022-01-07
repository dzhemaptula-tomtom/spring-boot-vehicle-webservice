package com.tomtom.vehicle;

import com.tomtom.vehicle.model.User;
import com.tomtom.vehicle.model.Vehicle;
import com.tomtom.vehicle.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class VehicleApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehicleApplication.class, args);
    }

    // Run code after startup
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            var vehicles = List.of(
                    Vehicle.builder()
                            .name("418")
                            .brand("BMW")
                            .build(),
                    Vehicle.builder()
                            .name("420")
                            .brand("BMW")
                            .build(),
                    Vehicle.builder()
                            .name("430")
                            .brand("BMW")
                            .build(),
                    Vehicle.builder()
                            .name("440")
                            .brand("BMW")
                            .build()
            );

            var user = User.builder()
                    .firstName("Dzhem")
                    .lastName("Aptula")
                    .email("dzhem.aptula@tomtom.com")
                    .birthDate(LocalDate.now())
                    .ownedVehicles(vehicles)
                    .build();

            userRepository.save(user);
        };
    }
}
