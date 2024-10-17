package at.technikum.springrestbackend.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserPrincipalAuthenticationToken extends UsernamePasswordAuthenticationToken {

    // Konstruktor für den vollständigen Authentication-Token
    public UserPrincipalAuthenticationToken(Object principal, Object credentials,
                                            Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities); // Ruft den Konstruktor von UsernamePasswordAuthenticationToken auf
    }


    public UserPrincipalAuthenticationToken(Object principal) {
        super(principal, null, null);
    }
}
