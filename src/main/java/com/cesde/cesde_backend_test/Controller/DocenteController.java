package com.cesde.cesde_backend_test.Controller;


import com.cesde.cesde_backend_test.Entity.Docente;
import com.cesde.cesde_backend_test.Model.ApiResponse;
import com.cesde.cesde_backend_test.Service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/docentes")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @GetMapping
    private ResponseEntity<ApiResponse<Object>> obtenerTodosLosDocentes(){
        try {
            List<Docente> docentes = docenteService.obtenerTodosLosDocentes();
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK.value(), "Docentes obtenidos con exito", docentes));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null));
        }
    }

    @GetMapping("/filtrar/nombre")
    public ResponseEntity<ApiResponse<Object>> filtrarPorNombre(@RequestParam String nombre) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(HttpStatus.OK.value(),
                            "Docentes filtrados por nombre obtenidos con éxito",
                            docenteService.filtrarPorNombre(nombre)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null));
        }
    }

    @GetMapping("/filtrar/documento")
    public ResponseEntity<ApiResponse<Object>> filtrarPorDocumento(@RequestParam Long documento) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(HttpStatus.OK.value(),
                            "Docentes filtrados por documento obtenidos con éxito",
                            docenteService.filtrarPorDocumento(documento)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null));
        }
    }

    @GetMapping("/filtrar/correo")
    public ResponseEntity<ApiResponse<Object>> filtrarPorCorreo(@RequestParam String correo) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(HttpStatus.OK.value(),
                            "Docentes filtrados por correo obtenidos con éxito",
                            docenteService.filtrarPorCorreo(correo)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null));
        }
    }


    @GetMapping("/buscar-docente")
    public List<Docente> buscarDocentes(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) Long documento,
            @RequestParam(required = false) String correo
    ) {
        return docenteService.buscarDocentes(nombre, documento, correo);
    }
}
