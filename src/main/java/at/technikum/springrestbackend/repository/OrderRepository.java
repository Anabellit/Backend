package at.technikum.springrestbackend.repository;

import at.technikum.springrestbackend.model.Order;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends ListCrudRepository<Order, String> {
}
