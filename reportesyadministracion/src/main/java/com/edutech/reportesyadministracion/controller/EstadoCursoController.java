package com.edutech.reportesyadministracion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.edutech.reportesyadministracion.model.EstadoCurso;
import com.edutech.reportesyadministracion.model.StatusCursoEnum;
import com.edutech.reportesyadministracion.service.EstadoCursoService;

@RestController
@RequestMapping("/api/v1/reporte/estado-cursos")
public class EstadoCursoController {

    @Autowired
    private EstadoCursoService estadoCursoService;

    @GetMapping
    public ResponseEntity<List<EstadoCurso>> listarEstados() {
        List<EstadoCurso> estados = estadoCursoService.findAll();
        if (estados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estados);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EstadoCurso> buscarEstadoCurso(@PathVariable Integer id) {
        EstadoCurso estadoCurso = estadoCursoService.findById(id);
        if (estadoCurso == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estadoCurso);
    }

    @GetMapping("/{cursoId}/usuarios/finalizados")
    public ResponseEntity<Integer> contarUsuariosFinalizados(@PathVariable Integer cursoId) {
        Integer cantidad = estadoCursoService.contarUsuariosPorEstadoEnCurso(cursoId, StatusCursoEnum.FINALIZADO);
        return ResponseEntity.ok(cantidad);
}

    @GetMapping("/{cursoId}/usuarios/pendientes")
    public ResponseEntity<Integer> contarUsuariosPendientes(@PathVariable Integer cursoId) {
        Integer cantidad = estadoCursoService.contarUsuariosPorEstadoEnCurso(cursoId, StatusCursoEnum.PENDIENTE);
        return ResponseEntity.ok(cantidad);
    }

   
}
