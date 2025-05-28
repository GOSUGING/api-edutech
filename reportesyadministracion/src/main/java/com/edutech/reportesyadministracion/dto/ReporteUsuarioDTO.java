package com.edutech.reportesyadministracion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class ReporteUsuarioDTO {

    public static class CursoEstadoDTO {
        public Integer cursoId;
        public String nombreCurso;
        public String estado; // Ej: "FINALIZADO", "PENDIENTE"
    }

    public static class EvaluacionNotaDTO {
        public Long evaluacionId;
        public String nombreEvaluacion;
        public Float nota; // Puede ser null si no ha rendido
        public Integer puntaje;
        public String descripcion;
    }

    public Long usuarioId;
    public String nombreUsuario;
    public List<CursoEstadoDTO> cursos;
    public List<EvaluacionNotaDTO> evaluaciones;
}