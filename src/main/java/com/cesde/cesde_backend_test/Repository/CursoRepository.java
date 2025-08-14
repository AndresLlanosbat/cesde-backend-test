package com.cesde.cesde_backend_test.Repository;

import com.cesde.cesde_backend_test.Entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface CursoRepository extends JpaRepository<Curso, UUID> {

    List<Curso> findByNombreContainingIgnoreCase(String nombre);

    List<Curso> findByPrecioBetween(BigDecimal precioMin, BigDecimal precioMax);

    List<Curso> findByDocente_Id(UUID docenteId);

    @Query("SELECT c FROM Curso c " +
            "WHERE (:nombre IS NULL OR LOWER(c.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) " +
            "AND (:precioMin IS NULL OR c.precio >= :precioMin) " +
            "AND (:precioMax IS NULL OR c.precio <= :precioMax) " +
            "AND (:docenteId IS NULL OR c.docente.id = :docenteId)")
    List<Curso> buscarCursos(String nombre, BigDecimal precioMin, BigDecimal precioMax, UUID docenteId);
}
