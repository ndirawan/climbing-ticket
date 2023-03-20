package com.enigma.mountains.dto;

import com.enigma.mountains.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisteDTO {
    private String username;

    public RegisteDTO(User user) {
        this.username = user.getUsername();
    }
}
