package at.technikum.springrestbackend.controller;


import at.technikum.springrestbackend.model.LoginRequest;
import at.technikum.springrestbackend.model.LoginResponse;
import at.technikum.springrestbackend.security.JwtIssuer;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
@RequiredArgsConstructor // macht automatisch den Constructor für everything final


public class AuthController {  // Name der Klasse ist jetzt korrekt "AuthController"

    private final JwtIssuer jwtIssuer;

    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody @Validated
            LoginRequest request,
            HttpServletResponse response) {
        // JWT-Token erstellen
        var token = jwtIssuer.issue(1L, request.getEmail(), List.of("User"));

        // JWT-Token im Authorization-Header setzen
        response.setHeader("Authorization", "Bearer " + token);

        // LoginResponse mit Token im Body zurückgeben
        return LoginResponse.builder()
                .accessToken(token)
                .build();
    }
}