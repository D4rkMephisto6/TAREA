package com.example.clase01.service.impl;

import com.example.clase01.entity.Autor;
import com.example.clase01.entity.Categoria;
import com.example.clase01.repository.AutorRepository;
import com.example.clase01.repository.CategoriaRepository;
import com.example.clase01.service.service.CategoriaService;

import java.util.List;
import java.util.Optional;

public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaRepository repository;

    public CategoriaServiceImpl(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Categoria create(Categoria categoria) {
        return repository.save(categoria);
    }

    @Override
    public Categoria update(Long id, Categoria categoria) {
        return repository.findById(id)
                .map(categoriaExistente -> {
                    categoriaExistente.setNombre(categoria.getNombre());
                    categoriaExistente.setEstado(categoria.getEstado());
                    return repository.save(categoriaExistente);
                }).orElseThrow(() -> new RuntimeException("Categoria no encontrado"));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Categoria> getCategoria(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Categoria> getCategorias() {
        return repository.findAll();
    }
}
