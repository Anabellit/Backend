package at.technikum.springrestbackend.security;

import at.technikum.springrestbackend.model.User;
import at.technikum.springrestbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Suche den Benutzer anhand des Benutzernamens direkt im Repository
        User user = userRepository.findByUsername(username)
                .orElseThrow(()
                        -> new UsernameNotFoundException("User with username "
                        + username + " not found"));

        // Erstelle eine Instanz von UserPrincipal mit den Benutzerinformationen
        return new UserPrincipal(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority(user.getRole()))
        );
    }
}
