package com.example.clase01.service.service;

import com.example.clase01.entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    Categoria create(Categoria categoria);
    Categoria update(Long id, Categoria categoria);
    void delete(Long id);
    Optional<Categoria> getCategoria(Long id);
    List<Categoria> getCategorias();
}
