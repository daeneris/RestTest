package ru.margarita.ExpertSystem.DTO;

import lombok.Data;

@Data
public class RegistrationResponse {

    private String accessToken;

    private String refreshToken;
}
