package com.enigma.mountains.service;

import com.enigma.mountains.dto.AuthRegister;
import com.enigma.mountains.dto.AuthRequest;
import com.enigma.mountains.dto.LoginDTO;
import com.enigma.mountains.dto.RegisteDTO;

public interface AuthService {
    LoginDTO login(AuthRequest authRequest);
    RegisteDTO register(AuthRequest authRequestr);
}
