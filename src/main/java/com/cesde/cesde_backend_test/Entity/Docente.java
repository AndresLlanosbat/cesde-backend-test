package com.cesde.cesde_backend_test.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Table(name = "docentes")
@Entity
@Data
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "documento")
    private Long documento;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "correo")
    private String correo;


}
