package ru.margarita.ExpertSystem.configSecurity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.margarita.ExpertSystem.domain.Person;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {
    private Integer login;//login = phoneNumber
    private String password;
    private Collection<? extends GrantedAuthority> grantedAuthorities;

    public static CustomUserDetails fromUserEntityToCustomUserDetails(Person person) {
        CustomUserDetails userDetails = new CustomUserDetails();
        userDetails.login = person.getPhoneNumber();
        userDetails.password = person.getPassword();
        userDetails.grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(person.getRole().getName()));
        return userDetails;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
