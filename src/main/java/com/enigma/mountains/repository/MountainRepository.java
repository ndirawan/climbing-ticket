package com.enigma.mountains.repository;

import com.enigma.mountains.entity.Mountain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MountainRepository extends JpaRepository<Mountain, String> {
}
