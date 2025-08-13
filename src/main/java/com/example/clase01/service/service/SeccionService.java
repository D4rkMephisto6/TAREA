package com.example.clase01.service.service;

import com.example.clase01.entity.Seccion;

import java.util.List;
import java.util.Optional;

public interface SeccionService {
    Seccion create(Seccion seccion);
    Seccion update(Long id, Seccion seccion);
    void delete(Long id);
    Optional<Seccion> getSeccion(Long id);
    List<Seccion> getSeccions();
}
