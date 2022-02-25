package ru.margarita.ExpertSystem.DTO;

import lombok.Data;

@Data
public class AuthRequest {
    private String login;
    private String password;
}
