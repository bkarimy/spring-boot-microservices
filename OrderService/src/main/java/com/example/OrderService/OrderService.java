package com.example.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;
    private final String BOOK_SERVICE_URL = "http://localhost:8082/api/books"; // Adjust port if necessary

    @Autowired
    public OrderService(OrderRepository orderRepository, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    public Order placeOrder(String bookTitle, int quantity) {
        // Here we would call the BookService to check if the book exists
        Boolean bookExists = checkBookAvailability(bookTitle);
        if (bookExists) {
            Order newOrder = new Order(bookTitle, quantity);
            return orderRepository.save(newOrder);
        } else {
            throw new RuntimeException("Book with title " + bookTitle + " does not exist.");
        }
    }

    private Boolean checkBookAvailability(String bookTitle) {
        // Call the BookService to verify book availability
        // The URL might need to change depending on your setup
        ResponseEntity<Boolean> response = restTemplate.getForEntity(BOOK_SERVICE_URL + "/exists/" + bookTitle, Boolean.class);
        return response.getBody();
    }
}

