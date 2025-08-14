package com.cesde.cesde_backend_test.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "cursos")
@Entity
@Data
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "duracion", nullable = false)
    private Integer duracion;

    @Column(name = "precio", precision = 10, scale = 2, nullable = false)
    private BigDecimal precio;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDateTime fechaInicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "docente_id", referencedColumnName = "id", nullable = false)
    private Docente docente;
}
