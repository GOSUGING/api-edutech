package com.reportes.reportes.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {
    private Integer id;
    private String nombreCurso;
    private String descripcionCurso;
    private Date duracionCurso; 
    private EstadoCursoDTO estadoCurso;
}
