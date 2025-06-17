package com.estadocursos.estado_cursos.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estado_curso")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Entidad que representa el estado actual de un curso")
public class EstadoCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del estado del curso", example = "1")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Schema(
        description = "Estado actual del curso (ACTIVO, PENDIENTE, FINALIZADO)",
        example = "ACTIVO",
        allowableValues = {"ACTIVO", "PENDIENTE", "FINALIZADO"}
    )
    private StatusCursoEnum status;

    @Column(name = "curso_id", nullable = false)
    @Schema(description = "ID del curso asociado", example = "10")
    private Long cursoId;
}
