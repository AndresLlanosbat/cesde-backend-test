package com.cesde.cesde_backend_test.Controller;

import com.cesde.cesde_backend_test.Entity.Curso;
import com.cesde.cesde_backend_test.Model.ApiResponse;
import com.cesde.cesde_backend_test.Service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    private ResponseEntity<ApiResponse<Object>> obtenerTodosLosCursos(){
        try {
            List<Curso> cursos = cursoService.obtenerTodosLosCursos();
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK.value(), "Cursos obtenidos con exito", cursos));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null));
        }
    }

    @GetMapping("/filtrar/nombre")
    public ResponseEntity<ApiResponse<Object>> filtrarPorNombre(@RequestParam String nombre) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(HttpStatus.OK.value(),
                            "Cursos filtrados por nombre obtenidos con éxito",
                            cursoService.filtrarPorNombre(nombre)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null));
        }
    }

    @GetMapping("/filtrar/precio")
    public ResponseEntity<ApiResponse<Object>> filtrarPorPrecio(
            @RequestParam BigDecimal precioMin,
            @RequestParam BigDecimal precioMax) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(HttpStatus.OK.value(),
                            "Cursos filtrados por rango de precios obtenidos con éxito",
                            cursoService.filtrarPorPrecio(precioMin, precioMax)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null));
        }
    }

    @GetMapping("/filtrar/docente")
    public ResponseEntity<ApiResponse<Object>> filtrarPorDocente(@RequestParam UUID docenteId) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(HttpStatus.OK.value(),
                            "Cursos filtrados por docente obtenidos con éxito",
                            cursoService.filtrarPorDocente(docenteId)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null));
        }
    }

    @GetMapping("/buscar-curso")
    public ResponseEntity<ApiResponse<Object>> buscarCursos(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) BigDecimal precioMin,
            @RequestParam(required = false) BigDecimal precioMax,
            @RequestParam(required = false) UUID docenteId
    ) {
        try {
            List<Curso> cursos = cursoService.buscarCursos(nombre, precioMin, precioMax, docenteId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(HttpStatus.OK.value(), "Búsqueda realizada con éxito", cursos));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null));
        }
    }
}
