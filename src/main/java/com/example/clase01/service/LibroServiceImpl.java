package com.example.clase01.service;

import com.example.clase01.entity.Libro;
import com.example.clase01.repository.LibroRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService{
    private final LibroRepositorio repository;


    public LibroServiceImpl(LibroRepositorio repository) {
        this.repository = repository;
    }
    @Override
    public Libro create(Libro libro) {
        return repository.save(libro);
    }

    @Override
    public Libro update(Long id, Libro libro) {
        return repository.findById(id)
                .map(libroExistente -> {
                    libroExistente.setTitulo(libro.getTitulo());
                    libroExistente.setAutores(libro.getAutores());
                    libroExistente.setEditorial(libro.getEditorial());
                    libroExistente.setEdicion(libro.getEdicion());
                    libroExistente.setPaginas(libro.getPaginas());
                    libroExistente.setSeccion(libro.getSeccion());
                    libroExistente.setEstado(libro.getEstado());
                    return repository.save(libroExistente);
                }).orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Libro> getLibro(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Libro> getLibros() {
        return repository.findAll();
    }
}
