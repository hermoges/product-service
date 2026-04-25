package com.ctbe.hermela;

import com.ctbe.hermela.dto.ProductResponse;
import com.ctbe.hermela.exception.ResourceNotFoundException;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
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
        Product laptop = new Product("Laptop", 1200.0, 10, "Electronics");
        laptop.setId(1L);
        when(productRepository.findById(1L)).thenReturn(Optional.of(laptop));

        // 2. Act (The Action)
        // I changed the name to 'result' so it matches the lines below!
        ProductResponse result = productService.findById(1L);

        // 3. Assert (The Grading)
        assertThat(result).isNotNull(); 
        assertThat(result.getName()).isEqualTo("Laptop");
        assertThat(result.getPrice()).isEqualTo(1200.0);
    }

    @Test
    void findById_throwsException_whenProductNotFound() {
        // 1. Arrange
        when(productRepository.findById(99L)).thenReturn(Optional.empty());

        // 2. Act & Assert
        // We just check that it throws the exception. 
        // We delete the line 'assertThat(result).isEmpty();' because there is no result to check!
        assertThrows(ResourceNotFoundException.class, () -> {
            productService.findById(99L);
        });
    }}