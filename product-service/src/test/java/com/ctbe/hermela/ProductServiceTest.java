package com.ctbe.hermela;

import com.ctbe.hermela.model.Product;
import com.ctbe.hermela.repository.ProductRepository;
import com.ctbe.hermela.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository; // This is our "Fake" Filing Cabinet

    @InjectMocks
    private ProductService productService; // This is the "Manager" we are testing

    @Test
    void findById_returnsProduct_whenProductExists() {
        // 1. Arrange (The Setup)
        Product laptop = new Product("Laptop", 1200.0);
        laptop.setId(1L);
        // We tell the fake cabinet: "If someone asks for ID 1, give them this laptop"
        when(productRepository.findById(1L)).thenReturn(Optional.of(laptop));

        // 2. Act (The Action)
        Optional<Product> result = productService.findById(1L);

        // 3. Assert (The Grading)
        assertThat(result).isPresent();
        assertThat(result.get().getName()).isEqualTo("Laptop");
        assertThat(result.get().getPrice()).isEqualTo(1200.0);
    }

    @Test
    void findById_returnsEmpty_whenProductNotFound() {
        // We tell the fake cabinet: "If someone asks for ID 99, say 'Nothing here!'"
        when(productRepository.findById(99L)).thenReturn(Optional.empty());

        Optional<Product> result = productService.findById(99L);

        assertThat(result).isEmpty();
    }
}