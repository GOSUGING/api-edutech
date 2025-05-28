package com.reportes.reportes.controller;

import com.reportes.reportes.dto.*;
import com.reportes.reportes.service.ReporteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reportes")
@RequiredArgsConstructor
public class ReporteController {

    private final ReporteService reporteService;

    @GetMapping("/completo")
    public ResponseEntity<ReporteDTO> obtenerReporte() {
        ReporteDTO reporte = reporteService.obtenerReporteCompleto();
        return ResponseEntity.ok(reporte);
    }

    @GetMapping("/cursos")
    public ResponseEntity<List<CursoDTO>> obtenerReporteCursos() {
        return ResponseEntity.ok(reporteService.obtenerReporteCursos());
    }

    @GetMapping("/evaluaciones")
    public ResponseEntity<List<EvaluacionDTO>> obtenerReporteEvaluaciones() {
        return ResponseEntity.ok(reporteService.obtenerReporteEvaluaciones());
    }



    @GetMapping("/notificaciones")
    public ResponseEntity<List<NotificacionDTO>> obtenerReporteNotificaciones() {
        return ResponseEntity.ok(reporteService.obtenerReporteNotificaciones());
    }

    @GetMapping("/tickets")
    public ResponseEntity<List<TicketSoporteDTO>> obtenerReporteTickets() {
        return ResponseEntity.ok(reporteService.obtenerReporteTickets());
    }

    @GetMapping("/estado-cursos")
    public ResponseEntity<List<EstadoCursoDTO>> obtenerReporteEstadoCursos() {
        return ResponseEntity.ok(reporteService.obtenerReporteEstadoCursos());
    }
}
