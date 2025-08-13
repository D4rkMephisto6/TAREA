package com.example.clase01.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name="TBL_CATEGORIAS")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CATEGORIA")
    @SequenceGenerator(name="SEQ_CATEGORIA", sequenceName="SEQ_CATEGORIA", allocationSize=1)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;
    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    @NotNull(message = "El estado no puede ser nulo")
    @Column(name = "ESTADO", nullable = false, length = 1)
    private Character estado= 'A';

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "categoria")
    @JsonManagedReference
    private Set<Seccion> secciones = new HashSet<>();
}
