package com.cesde.cesde_backend_test.Service.ServiceImpl;

import com.cesde.cesde_backend_test.Entity.Docente;
import com.cesde.cesde_backend_test.Repository.DocenteRepository;
import com.cesde.cesde_backend_test.Service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocenteServiceImpl implements DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    @Override
    public List<Docente> obtenerTodosLosDocentes() {
        return docenteRepository.findAll();
    }

    @Override
    public List<Docente> filtrarPorNombre(String nombre) {
        return docenteRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Docente> filtrarPorDocumento(Long documento) {
        return docenteRepository.findByDocumento(documento);
    }

    @Override
    public List<Docente> filtrarPorCorreo(String correo) {
        return docenteRepository.findByCorreoContainingIgnoreCase(correo);
    }

    @Override
    public List<Docente> buscarDocentes(String nombre, Long documento, String correo) {
        return docenteRepository.buscarDocentes(nombre, documento, correo);
    }
}
