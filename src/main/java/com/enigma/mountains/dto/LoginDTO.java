package com.enigma.mountains.dto;

import com.enigma.mountains.service.impl.UserDetailsImpl;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {
    private String username;
    private String token;

    public LoginDTO(UserDetailsImpl username, String token) {
        this.username = username.getUsername();
        this.token = token;
    }
}
