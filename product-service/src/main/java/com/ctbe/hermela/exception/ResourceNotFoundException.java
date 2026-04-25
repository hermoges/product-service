package com.ctbe.hermela.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private final Long id;

    public ResourceNotFoundException(Long id) {
        super("Product " + id + " not found");
        this.id = id;
    }

    public Long getId() { return id; }
}