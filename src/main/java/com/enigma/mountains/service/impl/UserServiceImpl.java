package com.enigma.mountains.service.impl;

import com.enigma.mountains.entity.User;
import com.enigma.mountains.repository.UserRepository;
import com.enigma.mountains.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
