package com.example.clase01.controller;

import com.example.clase01.entity.Autor;
import com.example.clase01.entity.Libro;
import com.example.clase01.service.service.AutorService;
import com.example.clase01.service.service.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    private final AutorService service;
    public AutorController(AutorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Autor> getLibros() {
        return service.getAutors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> obtenerPorId(@PathVariable Long id) {
        return service.getAutor(id)
                .map(ResponseEntity::ok)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor " + id + " no existe"));
    }

    @PostMapping
    public ResponseEntity<Autor> crear(@RequestBody Autor autor) {
        return ResponseEntity.ok(service.create(autor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> actualizar(@PathVariable Long id, @RequestBody Autor autor) {
        return ResponseEntity.ok(service.update(id,autor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
