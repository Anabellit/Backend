package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.model.LoginResponse;
import at.technikum.springrestbackend.security.JwtIssuer;
//import at.technikum.springrestbackend.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtIssuer jwtIssuer;

    private final AuthenticationManager authenticationManager;

    public LoginResponse attemptLogin(String email, String password) {
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        /*var principal = (UserPrincipal) authentication.getPrincipal();*/

        /*var roles = principal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();*/


        /*// JWT-Token erstellen
        var token = jwtIssuer.issue(JwtIssuer.Request.builder()
                .userId(principal.getUserId())
                .email(principal.getEmail())
                .roles(principal.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority).toList())
                .build());*/

 /*// JWT-Token im Authorization-Header setzen
        response.setHeader("Authorization", "Bearer " + token);*/


        // LoginResponse mit Token im Body zurückgeben
        return LoginResponse.builder()
                /*.token(token)*/
                .build();
    }
}

