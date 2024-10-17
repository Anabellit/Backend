package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.dto.UserDto;
import at.technikum.springrestbackend.entity.UserEntity;
import at.technikum.springrestbackend.exception.EntityNotFoundException;
import at.technikum.springrestbackend.mapper.UserMapper;
import at.technikum.springrestbackend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    // Benutzerregistrierung
    public void registerUser(UserDto userDto) throws Exception {
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new Exception("User with this email already exists");
        }

        // Passwort verschlüsseln
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

        // Konvertierung von DTO zu Entity
        UserEntity userEntity = userMapper.toEntity(userDto);

        // Speichern des Benutzers in der Datenbank
        userRepository.save(userEntity);
    }

    // Benutzer anhand der E-Mail finden (Daten aus der Datenbank statt statische Testdaten)
    public Optional<UserDto> findByEmail(String email) {
        Optional<UserEntity> userEntity = userRepository.findByEmail(email);
        return userEntity.map(userMapper::toDto);
    }

    // Alle Benutzer abrufen
    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    // Benutzer anhand der ID finden
    public UserDto find(String id) {
        UserEntity userEntity = userRepository.findById(Long.parseLong(id))
                .orElseThrow(EntityNotFoundException::new);
        return userMapper.toDto(userEntity);
    }

    // Benutzer speichern
    public UserDto save(UserDto userDto) {
        UserEntity userEntity = userMapper.toEntity(userDto);
        UserEntity savedUser = userRepository.save(userEntity);
        return userMapper.toDto(savedUser);
    }

    // Benutzer löschen
    public void deleteUser(String id) {
        userRepository.deleteById(Long.parseLong(id));
    }
}
