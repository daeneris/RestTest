package ru.margarita.ExpertSystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.margarita.ExpertSystem.configSecurity.AuthRequest;
import ru.margarita.ExpertSystem.configSecurity.AuthResponse;
import ru.margarita.ExpertSystem.configSecurity.JWTProvider;
import ru.margarita.ExpertSystem.configSecurity.RegistrationRequest;
import ru.margarita.ExpertSystem.domain.Person;
import ru.margarita.ExpertSystem.mapper.PersonMapper;
import ru.margarita.ExpertSystem.service.PersonService;

@RestController
@AllArgsConstructor
public class AuthorizationController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private JWTProvider jwtProvider;

    @PostMapping("/register")
    // аннотация Valid - это от валидатора, который я в мавене не добавила
//    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
    public String registerUser(@RequestBody RegistrationRequest registrationRequest) {
        Person person = new Person();
        person.setPassword(registrationRequest.getPassword());
        person.setPhoneNumber(registrationRequest.getLogin());
        personService.create(personMapper.toPersonDTO(person));
        return "New user must have been created";
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        Person person = personService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(person.getPhoneNumber());
        return new AuthResponse(token);
    }

}
