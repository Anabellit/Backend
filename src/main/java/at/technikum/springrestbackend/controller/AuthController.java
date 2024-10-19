package at.technikum.springrestbackend.controller;

import at.technikum.springrestbackend.model.LoginRequest;
import at.technikum.springrestbackend.model.LoginResponse;
import at.technikum.springrestbackend.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:63343")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) {

        try {
            // Login basierend auf username und password
            LoginResponse loginResponse = authService.attemptLogin(loginRequest);
            return ResponseEntity.ok(loginResponse);
        } catch (AccessDeniedException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

    }
}


/*
package at.technikum.springrestbackend.controller;

import at.technikum.springrestbackend.model.LoginRequest;
import at.technikum.springrestbackend.model.LoginResponse;
import at.technikum.springrestbackend.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:63343")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody
                                                   @Valid LoginRequest loginRequest) {

        try {
            LoginResponse loginResponse = authService.attemptLogin(loginRequest);
            return ResponseEntity.ok(loginResponse);
        } catch (AccessDeniedException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

    }
}*/
