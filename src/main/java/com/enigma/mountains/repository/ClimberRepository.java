package com.enigma.mountains.repository;

import com.enigma.mountains.entity.Climber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClimberRepository extends JpaRepository<Climber, String> {
}
