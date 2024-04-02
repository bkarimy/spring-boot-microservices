package com.example.OrderService;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // This can be left empty if we only need CRUD operations provided by JpaRepository.
    // Add any custom methods if needed.
}

