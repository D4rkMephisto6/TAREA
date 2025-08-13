package com.example.clase01.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TBL_AUTORES")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_AUTOR")
    @SequenceGenerator(name = "SEQ_AUTOR", sequenceName = "SEQ_AUTOR", allocationSize = 1)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombres;

    @NotBlank(message = "El apellido no puede estar en blanco")
    @Column(name = "APELLIDOS", nullable = false, length = 100)
    private String apellidos;

    @NotBlank(message = "El pais no puede estar en blanco")
    @Column(name = "PAIS", nullable = false, length = 60)
    private String pais;

    @Column(name = "ESTADO", nullable = false, length = 1)
    @Builder.Default
    private Character estado = 'A';

    @ManyToMany(mappedBy = "autores")
    @JsonIgnore
    private Set<Libro> libros = new HashSet<>();

}
