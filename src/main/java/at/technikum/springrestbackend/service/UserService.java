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

    // Methode zum Abrufen eines Benutzers anhand der E-Mail-Adresse
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);  // Nutzt die neue Methode im Repository
    }

    public UserDto updateUser(Long id, @Valid UserDto userDto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Aktualisiere die Felder des vorhandenen Benutzers mit den neuen Werten aus dem DTO
        existingUser.setSalutation(userDto.getSalutation());
        existingUser.setCountry(userDto.getCountry());
        existingUser.setEmail(userDto.getEmail());

        // Benutzer in der Datenbank speichern
        User updatedUser = userRepository.save(existingUser);

        // Aktualisierte Benutzerdaten als DTO zurückgeben
        return userMapper.toDto(updatedUser);
    }
}
