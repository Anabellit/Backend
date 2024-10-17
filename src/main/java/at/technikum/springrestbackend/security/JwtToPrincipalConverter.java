package at.technikum.springrestbackend.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtToPrincipalConverter {

    public UserDetails convert(DecodedJWT jwt) {
        // Extrahiere die Rollen (Authorities) aus dem JWT-Claim "au"
        List<String> roles = jwt.getClaim("au").asList(String.class);

        // Wandle die Rollen in GrantedAuthority-Objekte um
        var authorities = roles.stream()
                .map(SimpleGrantedAuthority::new)  // Umwandeln in SimpleGrantedAuthority
                .collect(Collectors.toList());

        return UserPrincipal.builder()
                .userId(Long.parseLong(jwt.getSubject()))
                .email(jwt.getClaim("e").asString())
                .authorities(authorities)  // Setze die Authorities (Rollen)
                .build();
    }
}
