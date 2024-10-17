package at.technikum.springrestbackend.controller;

import at.technikum.springrestbackend.model.LoginRequest;
import at.technikum.springrestbackend.model.LoginResponse;
import at.technikum.springrestbackend.security.JwtIssuer;
import at.technikum.springrestbackend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final JwtIssuer jwtIssuer;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request) {
        // Authentifizierung durchführen und LoginResponse zurückgeben
        return authService.attemptLogin(request.getEmail(), request.getPassword());
    }

    // Zum Testen der öffentlichen Route
    @GetMapping("/public")
    public String publicEndpoint() {
        return "Everyone can see this";
    }

    // Zum Testen der geschützten Route
    @GetMapping("/secured")
    public String secured() {
        return "This can only be seen by a logged-in user.";
    }

    // Zum Testen der Admin-Route
    @GetMapping("/admin")
    public String admin() {
        return "If you see this, then you're an admin.";
    }
}
