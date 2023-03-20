package com.enigma.mountains.service.impl;

import com.enigma.mountains.entity.User;
import com.enigma.mountains.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserDetailServiceImpl implements UserDetailsService {
   private final UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        if (!user.isPresent()){
            try {
                throw new Exception("User Not Found");
            }catch (Exception e){
                throw new RuntimeException();
            }
        }
        return new UserDetailsImpl(user.get());
    }
}
