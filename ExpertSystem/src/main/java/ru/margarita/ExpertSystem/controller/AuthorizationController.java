package ru.margarita.ExpertSystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.margarita.ExpertSystem.DTO.AuthRequest;
import ru.margarita.ExpertSystem.DTO.AuthResponse;
import ru.margarita.ExpertSystem.DTO.RegistrationRequest;
import ru.margarita.ExpertSystem.DTO.RegistrationResponse;
import ru.margarita.ExpertSystem.security.*;
import ru.margarita.ExpertSystem.domain.Person;
import ru.margarita.ExpertSystem.mapper.PersonMapper;
import ru.margarita.ExpertSystem.service.AuthorizationService;
import ru.margarita.ExpertSystem.service.PersonService;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api")
@RestController
@AllArgsConstructor
public class AuthorizationController {

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private JWTProvider jwtProvider;

    @PostMapping("/register")
    // аннотация Valid - это от валидатора, который я в мавене не добавила
//    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
    public RegistrationResponse registerUser(@RequestBody RegistrationRequest registrationRequest) {

        return authorizationService.register(registrationRequest);

    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {

        return authorizationService.auth(request);

    }

    @GetMapping("/refresh")

    public AuthResponse refresh(@RequestHeader Map<String, String> headers, @PathVariable int id) {
        Map <String, String> tokens = new HashMap<>();
        headers.forEach((key, value) -> {
            if (key.equals("accessToken")) tokens.put(key, value);
            if (key.equals("refreshToken")) tokens.put(key,value);
        });

       return authorizationService.refresh(tokens, id);

    }
}
