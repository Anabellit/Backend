package at.technikum.springrestbackend.repository;

import at.technikum.springrestbackend.model.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends ListCrudRepository<User, Long> {

    // Methode zum Überprüfen, ob eine E-Mail existiert
    boolean existsByEmail(String email);

    // Methode zum Überprüfen, ob ein Benutzername existiert
    boolean existsByUsername(String username);

    // Methode zum Abrufen eines Benutzers anhand der E-Mail-Adresse
    Optional<User> findByEmail(String email);

    // Methode zum Abrufen eines Benutzers anhand des Benutzernamens
    Optional<User> findByUsername(String username);
}


/*
package at.technikum.springrestbackend.repository;

import at.technikum.springrestbackend.model.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends ListCrudRepository<User, Long> {

    // Methode zum Überprüfen, ob eine E-Mail existiert
    boolean existsByEmail(String email);

    // Methode zum Überprüfen, ob ein Benutzername existiert
    boolean existsByUsername(String username);  // Neue Methode für Username

    // Methode zum Abrufen eines Benutzers anhand der E-Mail-Adresse
    Optional<User> findByEmail(String email);

    // Methode zum Abrufen eines Benutzers anhand des Benutzernamens
    Optional<User> findByUsername(String username);  // Neue Methode für Username
}


*/
