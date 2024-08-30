package at.technikum.springrestbackend.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Component
public class JwtIssuer {

    private static final String SECRET_KEY = "your-secret-key"; // Replace with a strong key

    public String issue(long id, String email, List<String> roles) {
        Date expirationDate = Date.from(Instant.now().plus(1, ChronoUnit.DAYS));

        return JWT.create()
                .withSubject(String.valueOf(id))
                .withExpiresAt(expirationDate)
                .withClaim("email", email)
                .withClaim("roles", roles)
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }
}
