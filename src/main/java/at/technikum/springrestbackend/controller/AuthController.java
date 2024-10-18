package at.technikum.springrestbackend.controller;

import at.technikum.springrestbackend.model.LoginRequest;
import at.technikum.springrestbackend.model.LoginResponse;
//import at.technikum.springrestbackend.security.UserPrincipal;
import at.technikum.springrestbackend.service.AuthService;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor // macht automatisch den Constructor für everything final

public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Validated
            LoginRequest request) {
        return authService.attemptLogin(request.getEmail(), request.getPassword());
    }

    // Zum Testen von Security
    @GetMapping("/public")
    public String publicEndpoint() {
        return "Everyone can see this";
    }

}
