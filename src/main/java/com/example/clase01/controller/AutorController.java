package com.example.clase01.controller;

import com.example.clase01.entity.Libro;
import com.example.clase01.service.service.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    private final LibroService libroService;
    public AutorController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<Libro> getLibros() {
        return libroService.getLibros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerPorId(@PathVariable Long id) {
        return libroService.getLibro(id)
                .map(ResponseEntity::ok)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Libro " + id + " no existe"));
    }

    @PostMapping
    public ResponseEntity<Libro> crear(@RequestBody Libro libro) {
        return ResponseEntity.ok(libroService.create(libro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizar(@PathVariable Long id, @RequestBody Libro libro) {
        return ResponseEntity.ok(libroService.update(id,libro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        libroService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
