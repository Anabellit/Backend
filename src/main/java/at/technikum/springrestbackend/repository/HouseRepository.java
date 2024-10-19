package at.technikum.springrestbackend.repository;

import at.technikum.springrestbackend.model.House;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HouseRepository extends ListCrudRepository<House, Long> {

    // Methode zum Abrufen eines Hauses basierend auf der userId (Fremdschlüssel)
    Optional<House> findByUserId(Long userId);
}
