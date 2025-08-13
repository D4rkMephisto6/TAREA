package com.example.clase01.repository;

import com.example.clase01.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository     extends JpaRepository<Autor, Long> {}
