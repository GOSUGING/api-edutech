package com.reportes.reportes.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluacionDTO {
    private Long id;
    private String titulo;
    private Date fecha;
    private String ponderacion;
    private Integer idCurso;

}
