package com.ctbe.hermela;

import com.ctbe.hermela.model.Product;
import com.ctbe.hermela.repository.ProductRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
    title = "Product Service API",
    version = "1.0.0",
    description = "RESTful Product Catalogue — Lab 2"
))
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner seedData(ProductRepository repo) {
        return args -> {
            // Your existing seed data
            repo.save(new Product("Laptop", 1200.00, 10, "Electronics"));
            repo.save(new Product("Monitor", 350.00, 5, "Electronics"));
            repo.save(new Product("Keyboard", 85.00, 20, "Electronics"));
            
            System.out.println(" Test data has been seeded into the database!");
        };
    }
}