package com.ctbe.hermela.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.Instant;
import java.util.Map;

@RestController
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        // Map.of creates a small "dictionary" of information
        return ResponseEntity.ok(Map.of(
            "service", "product-service",
            "version", "1.0.0",
            "status", "UP", // "UP" means the heart is beating!
            "timestamp", Instant.now().toString()
        ));
    }
}