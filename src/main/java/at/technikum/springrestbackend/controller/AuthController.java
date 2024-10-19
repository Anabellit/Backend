package at.technikum.springrestbackend.controller;

import at.technikum.springrestbackend.model.LoginRequest;
import at.technikum.springrestbackend.model.LoginResponse;
import at.technikum.springrestbackend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Validated LoginRequest request) {
        LoginResponse response = authService.attemptLogin(request.getEmail(), request.getPassword());
        if (response != null) {
            // Rückgabe mit 200 OK
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            // Rückgabe mit 401 Unauthorized
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    // Zum Testen von Security
    @GetMapping("/public")
    public ResponseEntity<String> publicEndpoint() {
        // Rückgabe mit 200 OK
        return ResponseEntity.status(HttpStatus.OK).body("Everyone can see this");
    }
}
