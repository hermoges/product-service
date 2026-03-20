package com.ctbe.hermela.repository;

import com.ctbe.hermela.model.Product; // Telling the librarian to handle your Product noun
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // This is a "Derived Query." 
    // Spring reads this name and writes: "SELECT * FROM products WHERE name LIKE %keyword% IGNORE CASE"
    List<Product> findByNameContainingIgnoreCase(String keyword);
}