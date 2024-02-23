package at.technikum.springrestbackend.repository;

import at.technikum.springrestbackend.model.House;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends ListCrudRepository<House, String> {
}
