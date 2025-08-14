package com.cesde.cesde_backend_test.Service;

import com.cesde.cesde_backend_test.Entity.Docente;

import java.util.List;

public interface DocenteService {

    List<Docente> obtenerTodosLosDocentes();

    List<Docente> filtrarPorNombre(String nombre);

    List<Docente> filtrarPorDocumento(Long documento);

    List<Docente> filtrarPorCorreo(String correo);

    List<Docente> buscarDocentes(String nombre, Long documento, String correo);
}
