package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.model.LoginResponse;
import at.technikum.springrestbackend.repository.UserRepository;
import at.technikum.springrestbackend.security.JwtIssuer;
import at.technikum.springrestbackend.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtIssuer jwtIssuer;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    public LoginResponse attemptLogin(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();

        // Umwandeln von Collection<GrantedAuthority> zu List<String>
        List<String> roles = principal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)  // Extrahiere den Namen der Authority (Rolle)
                .collect(Collectors.toList());

        // Token generieren und zurückgeben
        String token = jwtIssuer.issue(principal.getId(), principal.getUsername(), roles);

        return new LoginResponse(token);
    }
}



/*package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.model.User;
import at.technikum.springrestbackend.repository.UserRepository;
import at.technikum.springrestbackend.model.LoginRequest;
import at.technikum.springrestbackend.model.LoginResponse;
import at.technikum.springrestbackend.security.JwtIssuer;
import at.technikum.springrestbackend.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtIssuer jwtIssuer;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    public LoginResponse attemptLogin(LoginRequest loginRequest) throws AccessDeniedException {
        // Suche den Benutzer anhand des Benutzernamens (nicht mehr anhand der Email)
        Optional<User> userOptional = userRepository.findByUsername(loginRequest.getUsername());
        // Falls Benutzer nicht existiert, eine Ausnahme werfen
        if (userOptional.isEmpty()) {
            throw new AccessDeniedException("Invalid username or password.");
        }
        // Authentifizierung mit dem Benutzernamen und Passwort
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        // Speichern der Authentifizierungsdaten im SecurityContext
        SecurityContextHolder.getContext().setAuthentication(auth);
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();
        // JWT-Token ausstellen
        List<String> roles = principal.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
        String token = jwtIssuer.issue(
                principal.getId(),
                principal.getUsername(),
                roles
        );
        // Rückgabe der LoginResponse mit dem JWT-Token
        return new LoginResponse(token);
    }
}*/



/*
package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.model.User;
import at.technikum.springrestbackend.repository.UserRepository;
import at.technikum.springrestbackend.model.LoginRequest;
import at.technikum.springrestbackend.model.LoginResponse;
import at.technikum.springrestbackend.security.JwtIssuer;
import at.technikum.springrestbackend.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtIssuer jwtIssuer;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    public LoginResponse attemptLogin(LoginRequest loginRequest) throws AccessDeniedException {
        Optional<User> userOptional = userRepository.findByEmail(loginRequest.getEmail());
        // Authentifizierung mit der E-Mail und Passwort
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );
        // Speichern der Authentifizierungsdaten im SecurityContext
        SecurityContextHolder.getContext().setAuthentication(auth);
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();
        // JWT-Token ausstellen
        List<String> roles = principal.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        String token = jwtIssuer.issue(
                principal.getId(),
                principal.getUsername(),
                roles
        );
        // Rückgabe der LoginResponse mit dem JWT-Token
        return new LoginResponse(token);
    }
}



*/
/*package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.model.User;
import at.technikum.springrestbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import at.technikum.springrestbackend.model.LoginRequest;
import at.technikum.springrestbackend.model.LoginResponse;
import at.technikum.springrestbackend.security.*;
import at.technikum.springrestbackend.security.UserPrincipal;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtIssuer jwtIssuer;

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    public LoginResponse attemptLogin(LoginRequest loginRequest) throws AccessDeniedException {

        Optional<User> userOptional = userRepository.findByName(loginRequest.getUsername());


        if (userOptional.isPresent() && !userOptional.get().isActive()) {
            throw new AccessDeniedException("User is inactive.");
        }

        // pass the username and password to springs in-build security manager
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        // extract the user principle from the security context
        // the user is in the security context because the
        //information was passed to the security manager
        SecurityContextHolder.getContext().setAuthentication(auth);
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();

        // issue the jwt with the user information
        List<String> roles = principal.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        String token = jwtIssuer.issue(
                principal.getId(),
                principal.getUsername(),
                roles
        );

        return new LoginResponse(token);
    }
}*//*


*/
/*package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.model.LoginResponse;
import at.technikum.springrestbackend.security.JwtIssuer;
//import at.technikum.springrestbackend.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtIssuer jwtIssuer;

    private final AuthenticationManager authenticationManager;

    public LoginResponse attemptLogin(String email, String password) {
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        var principal = (UserPrincipal) authentication.getPrincipal();

        var roles = principal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();


        //JWT-Token erstellen
        var token = jwtIssuer.issue(JwtIssuer.Request.builder()
                .userId(principal.getUserId())
                .email(principal.getEmail())
                .roles(principal.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority).toList())
                .build());

 // JWT-Token im Authorization-Header setzen
        response.setHeader("Authorization", "Bearer " + token);*


        // LoginResponse mit Token im Body zurückgeben
        return LoginResponse.builder()
                /*.token(token)
                .build();
    }
}
*//*


*/
