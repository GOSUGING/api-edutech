package com.curso.curso.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "curso")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Entidad que representa un curso disponible en el sistema")
public class Curso {

    @Id
    @Schema(description = "Identificador único del curso", example = "1")
    private Long id;

    @Column(nullable = false)
    @Schema(description = "Nombre del curso", example = "Programación en Java")
    private String nombreCurso;

    @Column
    @Schema(description = "Descripción general del curso", example = "Curso introductorio a Java con ejercicios prácticos.")
    private String descripcionCurso;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @Schema(description = "Duración del curso expresada como una fecha de finalización", example = "2025-08-01", type = "string", format = "date")
    private Date duracionCurso;

    @Column(name = "estado_curso_id", nullable = false)
    @Schema(description = "ID del estado del curso relacionado", example = "2")
    private Long estadoCurso;

}
