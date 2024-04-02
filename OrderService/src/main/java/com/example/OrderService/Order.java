package com.example.OrderService;

import javax.persistence.*;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bookTitle;
    private Integer quantity;

    // Standard getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Integer getQuantity() {
        return quantity;
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

