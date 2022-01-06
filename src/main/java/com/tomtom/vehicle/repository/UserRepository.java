package com.tomtom.vehicle.repository;

import com.tomtom.vehicle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
