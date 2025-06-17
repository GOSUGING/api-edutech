package com.curso.curso.controller;

import com.curso.curso.model.Curso;
import com.curso.curso.service.CursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cursos")
@Tag(name = "Cursos", description = "Operaciones CRUD sobre cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    // ───────────────────────────────────────────────
    @GetMapping
    @Operation(
        summary = "Listar todos los cursos",
        responses = {
            @ApiResponse(responseCode = "200",
                         description = "Lista recuperada con éxito",
                         content = @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = Curso.class))),
            @ApiResponse(responseCode = "204", description = "No existen cursos")
        }
    )
    public ResponseEntity<List<Curso>> listar() {
        List<Curso> cursos = cursoService.findAll();
        return cursos.isEmpty() ? ResponseEntity.noContent().build()
                                : ResponseEntity.ok(cursos);
    }

    // ───────────────────────────────────────────────
    @GetMapping("/{id}")
    @Operation(
        summary = "Obtener un curso por ID",
        parameters = {
            @Parameter(name = "id", description = "ID del curso", example = "1")
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "Curso encontrado",
                         content = @Content(schema = @Schema(implementation = Curso.class))),
            @ApiResponse(responseCode = "404", description = "Curso no encontrado")
        }
    )
    public ResponseEntity<Curso> obtenerPorId(@PathVariable Integer id) {
        Optional<Curso> curso = cursoService.findById(id);
        return curso.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ───────────────────────────────────────────────
    @PutMapping("/{id}")
    @Operation(
        summary = "Actualizar un curso existente",
        parameters = {
            @Parameter(name = "id", description = "ID del curso a actualizar", example = "1")
        },
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            required = true,
            description = "Datos del curso a actualizar",
            content = @Content(schema = @Schema(implementation = Curso.class))
        ),
        responses = {
            @ApiResponse(responseCode = "200", description = "Curso actualizado",
                         content = @Content(schema = @Schema(implementation = Curso.class)))
        }
    )
    public Curso actualizar(@PathVariable Integer id, @RequestBody Curso curso) {
        curso.setId(id.longValue());
        return cursoService.save(curso);
    }

    // ───────────────────────────────────────────────
    @DeleteMapping("/{id}")
    @Operation(
        summary = "Eliminar un curso",
        parameters = {
            @Parameter(name = "id", description = "ID del curso a eliminar", example = "1")
        },
        responses = {
            @ApiResponse(responseCode = "204", description = "Curso eliminado"),
            @ApiResponse(responseCode = "404", description = "Curso no encontrado")
        }
    )
    public void eliminar(@PathVariable Integer id) {
        cursoService.delete(id);
    }
    // ───────────────────────────────────────────────
    @PostMapping        
    @Operation(
        summary = "Crear un nuevo curso",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            required = true,
            description = "Datos del nuevo curso",
            content = @Content(schema = @Schema(implementation = Curso.class))
        ),
        responses = {
            @ApiResponse(responseCode = "201", description = "Curso creado exitosamente",
                         content = @Content(schema = @Schema(implementation = Curso.class)))
        }

    )

    public ResponseEntity<Curso> crear(@RequestBody Curso curso) {
        Curso nuevoCurso = cursoService.save(curso);
        return ResponseEntity.status(201).body(nuevoCurso);
    }
}