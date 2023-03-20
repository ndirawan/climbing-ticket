package com.enigma.mountains.repository;

import com.enigma.mountains.dto.ERole;
import com.enigma.mountains.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByRole(ERole role);
}
