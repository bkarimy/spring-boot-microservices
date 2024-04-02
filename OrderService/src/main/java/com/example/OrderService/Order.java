package com.example.OrderService;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Order {

    // Standard getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bookTitle;
    private Integer quantity;

    public void setId(Long id) {
        this.id = id;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    // Constructor, equals, hashCode and toString methods...

    public Order() {
    }

    public Order(String bookTitle, Integer quantity) {
        this.bookTitle = bookTitle;
        this.quantity = quantity;
    }

    // Override equals and hashCode methods based on the business key, if required
}

