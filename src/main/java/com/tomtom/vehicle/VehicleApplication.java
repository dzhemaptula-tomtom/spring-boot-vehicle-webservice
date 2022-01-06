package com.tomtom.vehicle;

import com.tomtom.vehicle.model.User;
import com.tomtom.vehicle.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class VehicleApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehicleApplication.class, args);
    }

    // Run code after startup
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            var student = new User(
                    "Dzhem",
                    "Aptula",
                    "dzhem.aptula@tomtom.com",
                    LocalDate.now()
            );

            userRepository.save(student);
        };
    }
}
