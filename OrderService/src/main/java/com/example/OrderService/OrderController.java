package com.example.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/place")
    public ResponseEntity<Order> placeOrder(@RequestParam String bookTitle, @RequestParam int quantity) {
        Order order = orderService.placeOrder(bookTitle, quantity);
        return ResponseEntity.ok(order);
    }


}

