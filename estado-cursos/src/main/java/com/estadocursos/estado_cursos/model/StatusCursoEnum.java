package com.estadocursos.estado_cursos.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Enum que representa el estado del curso")
public enum StatusCursoEnum {

    @Schema(description = "El curso está activo y en progreso")
    ACTIVO,

    @Schema(description = "El curso está pendiente de inicio")
    PENDIENTE,

    @Schema(description = "El curso ya ha finalizado")
    FINALIZADO
} 