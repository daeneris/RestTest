package ru.margarita.ExpertSystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.margarita.ExpertSystem.DTO.*;
import ru.margarita.ExpertSystem.domain.Person;
import ru.margarita.ExpertSystem.repository.PersonRepo;
import ru.margarita.ExpertSystem.security.AuthUtil;
import ru.margarita.ExpertSystem.security.JWTProvider;
import ru.margarita.ExpertSystem.util.Roles;

import java.time.LocalDateTime;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthorizationService {

    private final JWTProvider jwtProvider;
    private final PersonRepo personRepo;
    private final PersonService personService;

    public RegistrationResponse register(RegistrationRequest registrationRequest) {
        Person person = new Person();
        person.setPassword(registrationRequest.getPassword());
        person.setPhoneNumber(registrationRequest.getLogin());
        person.setName(registrationRequest.getName());
        person.setNickName(registrationRequest.getNickName());
        person.setRole(Roles.USER);

        RegistrationResponse response = new RegistrationResponse();
        response.setAccessToken(jwtProvider.generateJWTToken(registrationRequest.getLogin()));

        person.setRefreshToken(AuthUtil.generateRefreshToken(registrationRequest.getLogin(), LocalDateTime.now().toString()));
        personRepo.save(person);

        response.setRefreshToken(person.getRefreshToken());

        return response;
    }

    public AuthResponse auth(AuthRequest request) {
        Person person = personService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        AuthResponse response = new AuthResponse();
        response.setAccessToken(jwtProvider.generateJWTToken(request.getLogin()));
        response.setRefreshToken(person.getRefreshToken());

        return response;
    }

    public AuthResponse refresh(Map<String, String> tokens, int personId) {
        // мы обсуждали, что нужно сделать метод, который достает Person по токену (в PersonRepo), тогда можно без personId
        PersonDTO personDTO = personService.getById(personId);

        return null;
    }
}
