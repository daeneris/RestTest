package ru.margarita.ExpertSystem.configSecurity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {

    private String jwtToken;
}
