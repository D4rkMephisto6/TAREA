package com.example.clase01.service.impl;

import com.example.clase01.entity.Editorial;
import com.example.clase01.repository.CategoriaRepository;
import com.example.clase01.repository.EditorialRepository;
import com.example.clase01.service.service.EditorialService;

import java.util.List;
import java.util.Optional;

public class EditorialServiceImpl implements EditorialService {

    private final EditorialRepository repository;

    public EditorialServiceImpl(EditorialRepository repository) {
        this.repository = repository;
    }

    @Override
    public Editorial create(Editorial editorial) {
        return repository.save(editorial);
    }

    @Override
    public Editorial update(Long id, Editorial editorial) {
        return repository.save(editorial);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Editorial> getEditorial(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Editorial> getEditorials() {
        return repository.findAll();
    }
}
