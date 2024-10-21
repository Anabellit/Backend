package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.dto.UserDto;
import at.technikum.springrestbackend.dto.UserProfileDto;
import at.technikum.springrestbackend.exception.UserNotFoundException;
import at.technikum.springrestbackend.mapper.UserMapper;
import at.technikum.springrestbackend.model.User;
import at.technikum.springrestbackend.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final HouseService houseService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder; // Inject the password encoder

    // Registrierung eines neuen Benutzers
    public UserDto registerUser(@Valid UserDto userDto) {
        User user = userMapper.toEntity(userDto);

        // Encode the password before saving the user
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

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

    public UserProfileDto updateUserProfile(Long id, @Valid UserProfileDto userProfileDto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));

        existingUser.setCountry(userProfileDto.getCountry());
        existingUser.setUsername(userProfileDto.getUsername());
        existingUser.setEmail(userProfileDto.getEmail());

        try {
            // Speichere die aktualisierten Benutzerdaten
            User updatedUser = userRepository.save(existingUser);
            return userMapper.toUserProfileDto(updatedUser);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Data integrity violation: "
                    + e.getMessage());
        }
    }


    // Aktualisierung der Benutzerdaten
    public UserDto updateUser(Long id, @Valid UserDto userDto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Aktualisiere die Felder des vorhandenen Benutzers mit den neuen Werten aus dem DTO
        existingUser.setSalutation(userDto.getSalutation());
        existingUser.setCountry(userDto.getCountry());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setUsername(userDto.getUsername());

        // Prüfen, ob das Passwort aktualisiert werden soll
        if (userDto.getPassword() != null && !userDto.getPassword().isEmpty()) {
            // Encode das neue Passwort
            existingUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }

        // Benutzer in der Datenbank speichern
        User updatedUser = userRepository.save(existingUser);

        // Aktualisierte Benutzerdaten als DTO zurückgeben
        return userMapper.toDto(updatedUser);
    }

    @Transactional
    public void deleteUserById(Long id) {
        try {
            // Lösche das Haus des Benutzers
            houseService.deleteHouseByUserId(id);

            // Lösche den Benutzer
            userRepository.deleteById(id);
        } catch (Exception e) {
            // Logge die genaue Fehlermeldung
            System.out.println("Fehler beim Löschen des Benutzers mit ID: " + id);
            e.printStackTrace();  // Zeige die vollständige Fehlermeldung an
            throw new RuntimeException("An error occurred while deleting the user.");
        }
    }

}



/*
package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.dto.UserDto;
import at.technikum.springrestbackend.mapper.UserMapper;
import at.technikum.springrestbackend.model.User;
import at.technikum.springrestbackend.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder; // Inject the password encoder

    // Registrierung eines neuen Benutzers
    public UserDto registerUser(@Valid UserDto userDto) {
        User user = userMapper.toEntity(userDto);

        // Encode the password before saving the user
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

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




*/
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

