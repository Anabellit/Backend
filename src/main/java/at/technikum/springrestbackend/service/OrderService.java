package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.exception.EntityNotFoundException;
import at.technikum.springrestbackend.model.Order;
import at.technikum.springrestbackend.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order find(String id) {
        return orderRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }
}
