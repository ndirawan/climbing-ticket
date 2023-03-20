package com.enigma.mountains.service.impl;

import com.enigma.mountains.dto.*;
import com.enigma.mountains.entity.Climber;
import com.enigma.mountains.entity.Role;
import com.enigma.mountains.entity.User;
import com.enigma.mountains.repository.ClimberRepository;
import com.enigma.mountains.repository.UserRepository;
import com.enigma.mountains.security.JwtUtils;
import com.enigma.mountains.service.AuthService;
import com.enigma.mountains.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private UserRepository userRepository;
    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;
    private JwtUtils jwtUtils;
    private RoleService roleService;

    @Override
    public RegisteDTO register(AuthRequest authRequest) {
        Role role = roleService.getOrsave(ERole.ROLE_USER);
        authRequest.setPassword(passwordEncoder.encode(authRequest.getPassword()));
        Climber climber = authRequest.getClimber();
        User user = userRepository.save(new User(null, authRequest.getUsername(), authRequest.getPassword(),
                new ArrayList<>(Collections.singleton(role)), climber));
        return new RegisteDTO(user);
    }

    @Override
    public LoginDTO login(AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String token = jwtUtils.generateToken(userDetails.getUsername());
        return new LoginDTO(userDetails, token);
    }
}
