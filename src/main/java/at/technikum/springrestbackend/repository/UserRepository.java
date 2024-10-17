package at.technikum.springrestbackend.repository;

import at.technikum.springrestbackend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // Methode, um zu prüfen, ob ein Benutzer mit dieser E-Mail existiert
    boolean existsByEmail(String email);

    // Methode, um einen Benutzer anhand der E-Mail zu finden
    Optional<UserEntity> findByEmail(String email);
}
