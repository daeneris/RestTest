package ru.margarita.ExpertSystem.configSecurity;

import lombok.Data;

@Data
public class AuthRequest {
    private String login;
    private String password;
}
