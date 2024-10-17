package at.technikum.springrestbackend.repository;

import at.technikum.springrestbackend.model.HouseSwap;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseSwapRepository extends ListCrudRepository<HouseSwap, Long> {

}
