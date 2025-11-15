package com.saludo.app.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Saludo {
    @GetMapping("/api/saludo/{nombre}")
    public ResponseEntity<String> saludo(@PathVariable String nombre) {
        if (nombre.length() >= 3) {
            return ResponseEntity.ok("¡Bienvenido usuario: " + nombre + "!");
        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error: El nombre debe tener al menos 3 caracteres.");
        }
    }
}
