package com.example.clase01.service.impl;

import com.example.clase01.entity.Autor;
import com.example.clase01.repository.AutorRepository;
import com.example.clase01.repository.LibroRepository;
import com.example.clase01.service.service.AutorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AutorServiceImpl implements AutorService {
    private final AutorRepository repository;

    public AutorServiceImpl(AutorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Autor create(Autor autor) {
        return repository.save(autor);
    }

    @Override
    public Autor update(Long id, Autor autor) {
        return repository.findById(id)
                .map(autorExistente -> {
                    autorExistente.setNombres(autor.getNombres());
                    autorExistente.setApellidos(autor.getApellidos());
                    autorExistente.setPais(autor.getPais());
                    autorExistente.setEstado(autor.getEstado());
                    return repository.save(autorExistente);
                }).orElseThrow(() -> new RuntimeException("Autor no encontrado"));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Autor> getAutor(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Autor> getAutors() {
        return repository.findAll();
    }
}
