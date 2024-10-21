package at.technikum.springrestbackend.repository;

import at.technikum.springrestbackend.model.House;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HouseRepository extends ListCrudRepository<House, Long> {

    // Custom-Methode, um ein Haus anhand der User-ID zu löschen
    void deleteByUserId(Long userId);


    // Methode zum Abrufen eines Hauses basierend auf der userId (Fremdschlüssel)
    Optional<House> findByUserId(Long userId);
}
