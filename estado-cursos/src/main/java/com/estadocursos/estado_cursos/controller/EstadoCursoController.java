package com.estadocursos.estado_cursos.controller;

import com.estadocursos.estado_cursos.model.EstadoCurso;
import com.estadocursos.estado_cursos.service.EstadoCursoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/estado-cursos")
@Tag(name = "Estados de Curso", description = "Operaciones CRUD para gestionar los estados de los cursos")
public class EstadoCursoController {

    @Autowired
    private EstadoCursoService estadoCursoService;

    @GetMapping
    @Operation(
        summary = "Listar todos los estados de curso",
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista de estados obtenida",
                         content = @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = EstadoCurso.class))),
            @ApiResponse(responseCode = "204", description = "No hay estados disponibles")
        }
    )
    public ResponseEntity<List<EstadoCurso>> listarEstados() {
        List<EstadoCurso> estados = estadoCursoService.findAll();
        return estados.isEmpty() ? ResponseEntity.noContent().build()
                                 : ResponseEntity.ok(estados);
    }

    @PostMapping
    @Operation(
        summary = "Crear un nuevo estado de curso",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Estado de curso a crear",
            required = true,
            content = @Content(schema = @Schema(implementation = EstadoCurso.class))
        ),
        responses = {
            @ApiResponse(responseCode = "201", description = "Estado creado exitosamente",
                         content = @Content(schema = @Schema(implementation = EstadoCurso.class)))
        }
    )
    public ResponseEntity<EstadoCurso> crearEstadoCurso(@RequestBody EstadoCurso estadoCurso) {
        EstadoCurso nuevoEstado = estadoCursoService.save(estadoCurso);
        return ResponseEntity.status(201).body(nuevoEstado);
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Buscar estado de curso por ID",
        parameters = {
            @Parameter(name = "id", description = "ID del estado de curso", example = "1")
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "Estado encontrado",
                         content = @Content(schema = @Schema(implementation = EstadoCurso.class))),
            @ApiResponse(responseCode = "404", description = "Estado no encontrado")
        }
    )
    public ResponseEntity<EstadoCurso> buscarEstadoCurso(@PathVariable Integer id) {
        EstadoCurso estadoCurso = estadoCursoService.findById(id);
        return estadoCurso == null ? ResponseEntity.notFound().build()
                                   : ResponseEntity.ok(estadoCurso);
    }

    @PutMapping("/{id}")
    @Operation(
        summary = "Actualizar un estado de curso existente",
        parameters = {
            @Parameter(name = "id", description = "ID del estado de curso", example = "1")
        },
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Nuevo contenido del estado de curso",
            required = true,
            content = @Content(schema = @Schema(implementation = EstadoCurso.class))
        ),
        responses = {
            @ApiResponse(responseCode = "200", description = "Estado actualizado correctamente")
        }
    )
    public ResponseEntity<EstadoCurso> actualizarEstadoCurso(@PathVariable Integer id, @RequestBody EstadoCurso estadoCurso) {
        estadoCurso.setId(id != null ? id.longValue() : null);
        EstadoCurso actualizado = estadoCursoService.save(estadoCurso);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Eliminar un estado de curso",
        parameters = {
            @Parameter(name = "id", description = "ID del estado a eliminar", example = "1")
        },
        responses = {
            @ApiResponse(responseCode = "204", description = "Estado eliminado exitosamente")
        }
    )
    public ResponseEntity<Void> eliminarEstadoCurso(@PathVariable Integer id) {
        estadoCursoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
