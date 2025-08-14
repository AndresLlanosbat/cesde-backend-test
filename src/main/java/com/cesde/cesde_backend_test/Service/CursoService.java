package com.cesde.cesde_backend_test.Service;

import com.cesde.cesde_backend_test.Entity.Curso;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface CursoService {

    List<Curso> obtenerTodosLosCursos();

    List<Curso> filtrarPorNombre(String nombre);

    List<Curso> filtrarPorPrecio(BigDecimal precioMin, BigDecimal precioMax);

    List<Curso> filtrarPorDocente(UUID docenteId);

    List<Curso> buscarCursos(String nombre, BigDecimal precioMin, BigDecimal precioMax, UUID docenteId);
}
