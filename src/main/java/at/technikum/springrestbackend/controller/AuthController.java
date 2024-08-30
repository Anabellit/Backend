package at.technikum.springrestbackend.controller;


import at.technikum.springrestbackend.model.LoginRequest;
import at.technikum.springrestbackend.model.LoginResponse;
import at.technikum.springrestbackend.security.JwtIssuer;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor // macht automatisch den Constructor für everything final


public class AuthController {
    private final JwtIssuer jwtIssuer;
    @PostMapping("/auth/login")


    public LoginResponse login(@RequestBody @Validated LoginRequest request){
        var token = jwtIssuer.issue(1L, request.getEmail(), List.of("User"));
        return LoginResponse.builder()
                .accessToken(token)
                .build();



    }
}
