package com.ctbe.hermela;

import com.ctbe.hermela.model.Product;
import com.ctbe.hermela.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner seedData(ProductRepository repo) {
        return args -> {
            // This runs as soon as the app starts!
            repo.save(new Product("Laptop", 1200.00));
            repo.save(new Product("Monitor", 350.00));
            repo.save(new Product("Keyboard", 85.00));
            System.out.println("✅ Test data has been seeded into the database!");
        };
    }
}