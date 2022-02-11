package ru.margarita.ExpertSystem.configSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.margarita.ExpertSystem.DTO.PersonDTO;
import ru.margarita.ExpertSystem.domain.Person;
import ru.margarita.ExpertSystem.mapper.PersonMapper;
import ru.margarita.ExpertSystem.service.PersonService;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonService personService;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PersonDTO personDTO = personService.getByLogin(username);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(personMapper.toPerson(personDTO));
    }
}
