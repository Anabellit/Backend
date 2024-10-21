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

    private static final String API_KEY_HEADER = "x-api-key";
    private static final String API_KEY_VALUE = "L8Az2TFD4s";

    private final JwtDecoder jwtDecoder;
    private final JwtToPrincipalConverter jwtToPrincipalConverter;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        // Validate API key before JWT
        if (!isValidApiKey(request)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Invalid API Key");
            return;
        }

        // Process JWT Token if API key is valid
        extractTokenFromRequest(request)
                .map(jwtDecoder::decode)  // Decode the JWT
                .map(jwtToPrincipalConverter::convert)  // Convert JWT to UserPrincipal
                .map(userPrincipal -> new UserPrincipalAuthenticationToken(
                        userPrincipal,
                        null,  // No credentials required
                        userPrincipal.getAuthorities()))  // Add user roles
                .ifPresent(authentication -> SecurityContextHolder.getContext()
                        .setAuthentication(authentication));  // Authenticate the user

        filterChain.doFilter(request, response);
    }


    private Optional<String> extractTokenFromRequest(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
            return Optional.of(token.substring(7));  // Remove 'Bearer ' prefix
        }
        return Optional.empty();
    }

    private boolean isValidApiKey(HttpServletRequest request) {
        String apiKey = request.getHeader(API_KEY_HEADER);
        return API_KEY_VALUE.equals(apiKey);
    }
}
