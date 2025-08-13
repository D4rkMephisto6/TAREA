package com.example.clase01.service.impl;

import com.example.clase01.entity.Seccion;
import com.example.clase01.repository.EditorialRepository;
import com.example.clase01.repository.SeccionRepository;
import com.example.clase01.service.service.SeccionService;

import java.util.List;
import java.util.Optional;

public class SeccionServiceImpl implements SeccionService {

    private final SeccionRepository repository;

    public SeccionServiceImpl(SeccionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Seccion create(Seccion seccion) {
        return repository.save(seccion);
    }

    @Override
    public Seccion update(Long id, Seccion seccion) {
        return repository.save(seccion);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Seccion> getSeccion(Long id) {
        return repository.findById(id) ;
    }

    @Override
    public List<Seccion> getSeccions() {
        return repository.findAll();
    }
}
