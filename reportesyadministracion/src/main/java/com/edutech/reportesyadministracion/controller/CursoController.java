package com.edutech.reportesyadministracion.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.reportesyadministracion.model.Curso;
import com.edutech.reportesyadministracion.model.EstadoCurso;
import com.edutech.reportesyadministracion.model.StatusCursoEnum;
import com.edutech.reportesyadministracion.service.CursoService;
import com.edutech.reportesyadministracion.service.EstadoCursoService;

@RestController
@RequestMapping("/api/v1/reporte/cursos")
public class CursoController {

    @Autowired
    private EstadoCursoService estadoCursoService;

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public String test() {
    return "Cursos endpoint activo";
    }

    @GetMapping("/listarCursos")
    public ResponseEntity<List<Curso>> listar() {
        List<Curso> cursos = cursoService.findAll();
        if (cursos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cursos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Curso> obtenerPorId(@PathVariable Integer id) {
        Optional<Curso> curso = cursoService.findById(id);
        if (curso.isPresent()) {
            return ResponseEntity.ok(curso.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/estado/{status}")
    public ResponseEntity<List<Curso>> buscarPorEstado(@PathVariable StatusCursoEnum status) {
        List<EstadoCurso> estadoCurso = estadoCursoService.findByStatus(status);

        if (estadoCurso == null) {
            return ResponseEntity.notFound().build();
        }

        List<Curso> cursos = new java.util.ArrayList<>();
        for (EstadoCurso ec : estadoCurso) {
            if (ec.getCursos() != null) {
                cursos.addAll(ec.getCursos());
            }
        }

        if (cursos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(cursos);
    }

   // @GetMapping("/profesor/{profesorId}/cantidad")
   // public ResponseEntity<Integer> contarCursosPorProfesor(@PathVariable Integer profesorId) {
    //    Integer cantidad = cursoService.contarCursosPorProfesor(profesorId);
    //    return ResponseEntity.ok(cantidad);
   // }

    @GetMapping("/cantidad/estado/{id}")
public ResponseEntity<Integer> contarCursosPorEstado(@PathVariable Integer id) {
    EstadoCurso estadoCurso = estadoCursoService.findById(id);
    if (estadoCurso == null) {
        return ResponseEntity.notFound().build();
    }
    Integer cantidad = cursoService.contarCursosPorEstado(null, estadoCurso.getStatus());
    if (cantidad == null) {
        return ResponseEntity.noContent().build();
    }
    // Si el estadoCurso es null, no se encontró el estado
    // Si la cantidad es null, no hay cursos con ese estado
    if (cantidad < 0) {
        return ResponseEntity.badRequest().body(0); // Retorna 0 si no hay cursos
    }
    // Si la cantidad es 0, no hay cursos con ese estado
    if (cantidad == 0) {
        return ResponseEntity.ok(0); // Retorna 0 si no hay cursos
    }
    // Si la cantidad es mayor a 0, retorna la cantidad de cursos
    return ResponseEntity.ok(cantidad);
}

}
