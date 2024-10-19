package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.dto.UserDto;
import at.technikum.springrestbackend.mapper.UserMapper;
import at.technikum.springrestbackend.model.User;
import at.technikum.springrestbackend.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    // Registrierung eines neuen Benutzers
    public UserDto registerUser(@Valid UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    // Methode zum Abrufen eines Benutzers anhand des Benutzernamens
    public User findByName(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(()
                        -> new RuntimeException("User with username " + username + " not found"));
    }

    // Abrufen eines Benutzers anhand der ID
    public UserDto getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(userMapper::toDto).orElseThrow(()
                -> new RuntimeException("User not found"));
    }

    // Überprüfen, ob eine E-Mail bereits existiert
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    // Überprüfen, ob ein Username bereits existiert
    public boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    // Methode zum Abrufen eines Benutzers anhand des Benutzernamens
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(()
                        -> new RuntimeException("User with username " + username + " not found"));
    }

    // Methode zum Abrufen eines Benutzers anhand der E-Mail-Adresse
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public UserDto updateUser(Long id, @Valid UserDto userDto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Aktualisiere die Felder des vorhandenen Benutzers mit den neuen Werten aus dem DTO
        existingUser.setSalutation(userDto.getSalutation());
        existingUser.setCountry(userDto.getCountry());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setUsername(userDto.getUsername());  // Neues Feld aktualisieren

        // Benutzer in der Datenbank speichern
        User updatedUser = userRepository.save(existingUser);

        // Aktualisierte Benutzerdaten als DTO zurückgeben
        return userMapper.toDto(updatedUser);
    }
}




/*package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.dto.UserDto;
import at.technikum.springrestbackend.mapper.UserMapper;
import at.technikum.springrestbackend.model.User;
import at.technikum.springrestbackend.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    // Registrierung eines neuen Benutzers
    public UserDto registerUser(@Valid UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    // Abrufen eines Benutzers anhand der ID
    public UserDto getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(userMapper::toDto).orElseThrow(()
                -> new RuntimeException("User not found"));
    }

    // Überprüfen, ob eine E-Mail bereits existiert
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    // Überprüfen, ob ein Username bereits existiert
    public boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    // Methode zum Abrufen eines Benutzers anhand des Benutzernamens
    public User findByName(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(()
                        -> new RuntimeException("User with username " + username + " not found"));
    }

    // Methode zum Abrufen eines Benutzers anhand der E-Mail-Adresse
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public UserDto updateUser(Long id, @Valid UserDto userDto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Aktualisiere die Felder des vorhandenen Benutzers mit den neuen Werten aus dem DTO
        existingUser.setSalutation(userDto.getSalutation());
        existingUser.setCountry(userDto.getCountry());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setUsername(userDto.getUsername());  // Neues Feld aktualisieren

        // Benutzer in der Datenbank speichern
        User updatedUser = userRepository.save(existingUser);

        // Aktualisierte Benutzerdaten als DTO zurückgeben
        return userMapper.toDto(updatedUser);
    }
}*/
