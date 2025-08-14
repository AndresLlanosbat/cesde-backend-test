package com.cesde.cesde_backend_test.Repository;

import com.cesde.cesde_backend_test.Entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, UUID> {

    List<Docente> findByNombreContainingIgnoreCase(String nombre);

    List<Docente> findByDocumento(Long documento);

    List<Docente> findByCorreoContainingIgnoreCase(String correo);

    @Query("SELECT d FROM Docente d " +
            "WHERE (:nombre IS NULL OR LOWER(d.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) " +
            "AND (:documento IS NULL OR d.documento = :documento) " +
            "AND (:correo IS NULL OR LOWER(d.correo) LIKE LOWER(CONCAT('%', :correo, '%')))")
    List<Docente> buscarDocentes(String nombre, Long documento, String correo);
}
