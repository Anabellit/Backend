package at.technikum.springrestbackend.repository;

import at.technikum.springrestbackend.model.HouseSwap;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseSwapRepository extends CrudRepository<HouseSwap, String> {
}
