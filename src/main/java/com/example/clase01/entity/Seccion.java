package com.example.clase01.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper=false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name="TBL_SECCIONES")
public class Seccion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SECCION")
    @SequenceGenerator(name = "SEQ_SECCION", sequenceName = "SEQ_SECCION", allocationSize = 1)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;
    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    @NotNull(message = "El estado no puede ser nulo")
    @Column(name = "ESTADO", nullable = false, length = 1)
    private Character estado= 'A';

    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @JoinColumn(name="CATEGORIA_ID", nullable = false)
    @JsonBackReference
    private Categoria categoria ;

    @OneToMany(mappedBy = "seccion")
    @JsonIgnore
    private List<Libro> libros = new ArrayList<>();
}
