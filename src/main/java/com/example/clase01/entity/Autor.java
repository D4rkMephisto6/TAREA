package com.example.clase01.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper=false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="TBL_AUTORES")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;
    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombres;
    @NotBlank
    @Column(name = "APELLIDOS", nullable = false, length = 120)
    private String apellidos;

    @NotBlank
    @Column(name = "PAIS", nullable = false, length = 60)
    private String pais;

    @Column(name = "ESTADO", nullable = false, length = 1)
    @Builder.Default
    private Character estado = 'A';

    @ManyToMany(mappedBy = "autores")
    @JsonIgnore
    private Set<Libro> libros = new HashSet<>();

}
