package com.example.clase01.service.service;

import com.example.clase01.entity.Autor;

import java.util.List;
import java.util.Optional;

public interface AutorService {
    Autor create(Autor autor);
    Autor update(Long id, Autor autor);
    void delete(Long id);
    Optional<Autor> getAutor(Long id);
    List<Autor> getAutors();
}

