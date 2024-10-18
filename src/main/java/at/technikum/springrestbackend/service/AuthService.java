package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.model.LoginResponse;
import at.technikum.springrestbackend.entity.UserEntity;
import at.technikum.springrestbackend.repository.UserRepository;
import at.technikum.springrestbackend.security.JwtIssuer;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtIssuer jwtIssuer;

    public LoginResponse attemptLogin(String email, String password) {
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (passwordEncoder.matches(password, user.getPassword())) {
            // JWT-Token erstellen
            String token = jwtIssuer.issue(JwtIssuer.Request.builder()
                    .userId(user.getId())  // ID ist jetzt vom Typ String
                    .email(user.getEmail())
                    .roles(List.of(user.getRole())) // Rolle wird als Liste hinzugefügt
                    .build());

            return new LoginResponse(token, user.getEmail(), user.getRole());
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
