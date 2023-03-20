package com.enigma.mountains.service.impl;

import com.enigma.mountains.dto.ERole;
import com.enigma.mountains.entity.Role;
import com.enigma.mountains.repository.RoleRepository;
import com.enigma.mountains.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;
    @Override
    public Role getOrsave(ERole role) {
        return roleRepository.findByRole(role)
                .orElseGet(() -> roleRepository.save(new Role(null, role)));
    }
}

