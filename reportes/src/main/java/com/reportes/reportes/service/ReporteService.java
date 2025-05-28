package com.reportes.reportes.service;

import com.reportes.reportes.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReporteService {

    private final RestTemplate restTemplate;

    @Value("${servicio.cursos.url}")
    private String cursoUrl;

    @Value("${servicio.evaluaciones.url}")
    private String evaluacionUrl;

    @Value("${servicio.notificaciones.url}")
    private String notificacionesUrl;

    @Value("${servicio.tickets.url}")
    private String ticketsUrl;

    @Value("${servicio.estado.cursos.url}")
    private String estadoCursosUrl;

    public ReporteDTO obtenerReporteCompleto() {
        List<CursoDTO> cursos = consumirLista(cursoUrl, new ParameterizedTypeReference<List<CursoDTO>>() {});
        List<EvaluacionDTO> evaluaciones = consumirLista(evaluacionUrl, new ParameterizedTypeReference<List<EvaluacionDTO>>() {});
        List<NotificacionDTO> notificaciones = consumirLista(notificacionesUrl, new ParameterizedTypeReference<List<NotificacionDTO>>() {});
        List<TicketSoporteDTO> tickets = consumirLista(ticketsUrl, new ParameterizedTypeReference<List<TicketSoporteDTO>>() {});
        List<EstadoCursoDTO> estadoCursos = consumirLista(estadoCursosUrl, new ParameterizedTypeReference<List<EstadoCursoDTO>>() {});

        return new ReporteDTO(cursos, evaluaciones, notificaciones, tickets, estadoCursos);
    }

    private <T> List<T> consumirLista(String url, ParameterizedTypeReference<List<T>> typeReference) {
        ResponseEntity<List<T>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                typeReference
        );
        return response.getBody();
    }

    // Reporte solo de cursos
    public List<CursoDTO> obtenerReporteCursos() {
        return consumirLista(cursoUrl, new ParameterizedTypeReference<List<CursoDTO>>() {});
    }

    // Reporte solo de evaluaciones
    public List<EvaluacionDTO> obtenerReporteEvaluaciones() {
        return consumirLista(evaluacionUrl, new ParameterizedTypeReference<List<EvaluacionDTO>>() {});
    }

    // Reporte solo de notificaciones
    public List<NotificacionDTO> obtenerReporteNotificaciones() {
        return consumirLista(notificacionesUrl, new ParameterizedTypeReference<List<NotificacionDTO>>() {});
    }

    // Reporte solo de tickets
    public List<TicketSoporteDTO> obtenerReporteTickets() {
        return consumirLista(ticketsUrl, new ParameterizedTypeReference<List<TicketSoporteDTO>>() {});
    }

    // Reporte solo de estado de cursos
    public List<EstadoCursoDTO> obtenerReporteEstadoCursos() {
        return consumirLista(estadoCursosUrl, new ParameterizedTypeReference<List<EstadoCursoDTO>>() {});
    }

}
