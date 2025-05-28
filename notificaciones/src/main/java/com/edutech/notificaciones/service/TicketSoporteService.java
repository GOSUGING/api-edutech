package com.edutech.notificaciones.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.notificaciones.model.TicketSoporte;
import com.edutech.notificaciones.repository.TicketSoporteRepository;

@Service
public class TicketSoporteService {

    @Autowired 
    private TicketSoporteRepository repository;

    public TicketSoporte crearTicket(TicketSoporte ticket) {
        ticket.setFechaCreacion(LocalDateTime.now());
        ticket.setFechaActualizacion(LocalDateTime.now());
        ticket.setEstado("ABIERTO");
        return repository.save(ticket);
    }

    public List<TicketSoporte> obtenerPorUsuario(int usuarioId) {
        return repository.findByUsuarioUsuarioId(usuarioId);
    }



    private boolean esCambioValido(String actual, String nuevo) {
    return switch (actual) {
        case "ABIERTO" -> nuevo.equals("EN_PROGRESO");
        case "EN_PROGRESO" -> nuevo.equals("RESUELTO");
        case "RESUELTO" -> false;
        default -> false;
        };
    }


    public TicketSoporte actualizarEstado(int id, String nuevoEstado) {
        TicketSoporte ticket = repository.findById(id).orElse(null);

        if (ticket == null) {
            System.out.println("No se encontró el ticket con ID: " + id);
            return null;
        }

        String estadoActual = ticket.getEstado().toUpperCase();
        String estadoNuevo = nuevoEstado.toUpperCase();

        // Validación del flujo permitido
        if (!esCambioValido(estadoActual, estadoNuevo)) {
        throw new IllegalArgumentException("Transición de estado no permitida: " + estadoActual + " → " + estadoNuevo);
        }

        ticket.setEstado(estadoNuevo);
        ticket.setFechaActualizacion(LocalDateTime.now());
        return repository.save(ticket);
    }

    public List<TicketSoporte> listarTodos(){
        return repository.findAll();
    }
}
