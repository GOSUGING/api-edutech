package com.estadocursos.estado_cursos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.estadocursos.estado_cursos.model.EstadoCurso;
import com.estadocursos.estado_cursos.service.EstadoCursoService;

@RestController
@RequestMapping("/api/v1/estado-cursos")
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

    @PostMapping
    public ResponseEntity<EstadoCurso> crearEstadoCurso(@RequestBody EstadoCurso estadoCurso) {
        EstadoCurso nuevoEstado = estadoCursoService.save(estadoCurso);
        return ResponseEntity.status(201).body(nuevoEstado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoCurso> buscarEstadoCurso(@PathVariable Integer id) {
        EstadoCurso estadoCurso = estadoCursoService.findById(id);
        if (estadoCurso == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estadoCurso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoCurso> actualizarEstadoCurso(@PathVariable Integer id, @RequestBody EstadoCurso estadoCurso) {
        estadoCurso.setId(id != null ? id.longValue() : null);
        EstadoCurso actualizado = estadoCursoService.save(estadoCurso);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstadoCurso(@PathVariable Integer id) {
        estadoCursoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
