package com.saludo.app.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Saludo {
    @GetMapping("/api/saludo/{nombre}")
    public String saludo(@PathVariable String nombre) {
        if (nombre.length() >= 3) {
            return "¡Bienvenido usuario: " + nombre + "!";
        } else {
            throw new IllegalArgumentException("El nombre debe tener al menos 3 caracteres.");
        }
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> manejarError(IllegalArgumentException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Error: " + ex.getMessage());
    }
}
