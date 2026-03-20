package com.ctbe.hermela.model; 

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "products") // This creates a table named 'products' in the H2 database
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // The database will count 1, 2, 3... automatically
    private Long id;

    @NotBlank(message = "Product name must not be blank")
    @Column(nullable = false) // The database won't let you leave the name empty
    private String name;

    @Positive(message = "Price must be greater than zero")
    @Column(nullable = false)
    private double price;

    // ── Constructors ──────────────────────────────────────────
    // Spring needs this empty one to "wake up" the object
    public Product() {}

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // ── Getters and Setters ───────────────────────────────────
    // These are the "Remote Controls" to read and change the data
    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    
    public void setId(Long id) { this.id = id; }
    public void setName(String n) { this.name = n; }
    public void setPrice(double p) { this.price = p; }
}
