package com.enigma.mountains.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthRegister {
    private String name;
    private String address;
    private Date birthDate;
    private String email;
}
