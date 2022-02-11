package ru.margarita.ExpertSystem.configSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static io.jsonwebtoken.lang.Strings.hasText;

public class JWTFilter extends GenericFilterBean {

    public static final String AUTHORISATION = "Authorisation";

    @Autowired
    private JWTProvider jwtProvider;

    private CustomUserDetailsService customUserDetailsService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String token = getTokenFromRequest((HttpServletRequest) servletRequest);

    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String bearer = request.getHeader(AUTHORISATION);
        if(hasText(bearer) && bearer.startsWith("bearer ")) {
            return bearer.substring(7);
        }
        return null;
    }
}
