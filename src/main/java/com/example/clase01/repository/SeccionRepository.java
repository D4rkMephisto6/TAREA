package com.example.clase01.repository;

import com.example.clase01.entity.Seccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeccionRepository   extends JpaRepository<Seccion, Long> {}