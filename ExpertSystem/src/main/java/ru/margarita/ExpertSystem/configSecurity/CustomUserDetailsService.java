package ru.margarita.ExpertSystem.configSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.margarita.ExpertSystem.repository.PersonRepo;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private PersonRepo personRepo;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return CustomUserDetails.fromUserEntityToCustomUserDetails(personRepo.findByPhoneNumber(username));
    }
}
