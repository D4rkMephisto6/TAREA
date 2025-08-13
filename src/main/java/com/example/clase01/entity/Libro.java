package com.example.clase01.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
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
@Table(name="TBL_LIBROS")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LIBRO")
    @SequenceGenerator(name = "SEQ_LIBRO", sequenceName = "SEQ_LIBRO", allocationSize = 1)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;
    @NotBlank
    @Column(name = "TITULO", nullable = false, length = 200)
    private String titulo;

    @NotNull @Min(1)
    @Column(name = "PAGINAS", nullable = false)
    private Integer paginas;

    @NotBlank
    @Column(name = "EDICION", nullable = false, length = 50)
    private String edicion;

    @Column(name = "ESTADO", nullable = false, length = 1)
    @Builder.Default
    private Character estado = 'A';

    @ManyToOne
    @JoinColumn(name="SECCION_ID", nullable = false)
    private Seccion seccion;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "TBL_AUTORES_LIBROS",
            joinColumns = @JoinColumn(name = "LIBRO_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "AUTOR_ID", referencedColumnName = "ID")
    )
    private Set<Autor> autores= new HashSet<>();

    @ManyToOne
    @JoinColumn(name="EDITORIAL_ID", nullable = false)
    private Editorial editorial ;
}
