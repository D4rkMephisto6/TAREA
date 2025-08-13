package com.example.clase01.service.service;

import com.example.clase01.entity.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroService {
    Libro create(Libro libro);
    Libro update(Long id, Libro libro);
    void delete(Long id);
    Optional<Libro> getLibro(Long id);
    List<Libro> getLibros();
}
