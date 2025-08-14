package com.cesde.cesde_backend_test.Service.ServiceImpl;

import com.cesde.cesde_backend_test.Entity.Curso;
import com.cesde.cesde_backend_test.Repository.CursoRepository;
import com.cesde.cesde_backend_test.Service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> obtenerTodosLosCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public List<Curso> filtrarPorNombre(String nombre) {
        return cursoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Curso> filtrarPorPrecio(BigDecimal precioMin, BigDecimal precioMax) {
        return cursoRepository.findByPrecioBetween(precioMin, precioMax);
    }

    @Override
    public List<Curso> filtrarPorDocente(UUID docenteId) {
        return cursoRepository.findByDocente_Id(docenteId);
    }

    @Override
    public List<Curso> buscarCursos(String nombre, BigDecimal precioMin, BigDecimal precioMax, UUID docenteId) {
        return cursoRepository.buscarCursos(nombre, precioMin, precioMax, docenteId);
    }
}
