package at.technikum.springrestbackend.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@Component
public class JwtIssuer {

    private final JwtProperties properties;

    @Data
    @Builder
    public static class Request {
        private String userId; // Changed to String for UUID
        private String email;
        private List<String> roles;
    }

    // Method to generate a token
    public String issue(Request request) {
        var now = Instant.now();

        var rolesWithPrefix = request.getRoles().stream()
                .map(role -> role.startsWith("ROLE_") ? role : "ROLE_" + role)
                .toList();

        return JWT.create()
                .withSubject(request.getUserId())  // Use UUID as a string
                .withIssuedAt(now)
                .withExpiresAt(now.plus(properties.getTokenDuration()))  // Add token expiration
                .withClaim("e", request.getEmail())  // Add email as a claim
                .withClaim("au", rolesWithPrefix)  // Add roles with "ROLE_" prefix
                .sign(Algorithm.HMAC256(properties.getSecretKey()));  // Sign with secret key
    }
}
