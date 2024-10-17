package at.technikum.springrestbackend.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtDecoder jwtDecoder;
    private final JwtToPrincipalConverter jwtToPrincipalConverter;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        extractTokenFromRequest(request)
                .map(jwtDecoder::decode)  // JWT entschlüsseln
                .map(jwtToPrincipalConverter::convert)  // JWT in UserPrincipal konvertieren
                .map(userPrincipal -> new UserPrincipalAuthenticationToken(
                        userPrincipal,
                        null,  // Keine Anmeldeinformationen erforderlich
                        userPrincipal.getAuthorities()))  // Benutzerrollen hinzufügen
                .ifPresent(authentication -> SecurityContextHolder.getContext()
                        .setAuthentication(authentication));  // Benutzer authentifizieren

        filterChain.doFilter(request, response);
    }

    private Optional<String> extractTokenFromRequest(HttpServletRequest request) {
        var token = request.getHeader("Authorization");
        if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
            return Optional.of(token.substring(7));
        }
        return Optional.empty();
    }
}
