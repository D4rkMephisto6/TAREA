package com.example.clase01.service.service;

import com.example.clase01.entity.Editorial;

import java.util.List;
import java.util.Optional;

public interface EditorialService {
    Editorial create(Editorial editorial);
    Editorial update(Long id, Editorial editorial);
    void delete(Long id);
    Optional<Editorial> getEditorial(Long id);
    List<Editorial> getEditorials();
}
