package com.reportes.reportes.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor 
public class ReporteDTO {
    private List<CursoDTO> cursos;
    private List<EvaluacionDTO> evaluaciones;
    private List<NotificacionDTO> notificaciones;
    private List<TicketSoporteDTO> ticketsSoporte;
    private List<EstadoCursoDTO> estadoCursos;
}
