package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.entity.UserEntity;
import at.technikum.springrestbackend.exception.EntityNotFoundException;
import at.technikum.springrestbackend.model.User;
import at.technikum.springrestbackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static final String EXISTING_EMAIL = "test@test.com";

    private static final String ANOTHER_EMAIL = "next@test.com";

    public Optional<UserEntity> findByEmail(String email) {
        // TODO: Move this to a database
        if (EXISTING_EMAIL.equalsIgnoreCase(email)) {
            var user = new UserEntity();
            user.setId(1L);
            user.setEmail(EXISTING_EMAIL);
            // PW is test
            user.setPassword("$2a$12$vucQjma1zlsU1AIcEc8Ru.NGXRbYj3/mK6ODWmfBt5sVcCvswK4xK");
            user.setRole("ROLE_ADMIN");
            return Optional.of(user);
        } else if (ANOTHER_EMAIL.equalsIgnoreCase(email)) {
            var user = new UserEntity();
            user.setId(99L);
            user.setEmail(ANOTHER_EMAIL);
            // PW is test
            user.setPassword("$2a$12$vucQjma1zlsU1AIcEc8Ru.NGXRbYj3/mK6ODWmfBt5sVcCvswK4xK");
            user.setRole("ROLE_USER");
            return Optional.of(user);
        }
        return Optional.empty();
    }

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User find(String id) {
        return userRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}

