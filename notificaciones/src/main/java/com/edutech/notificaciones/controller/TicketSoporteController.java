package com.edutech.notificaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.notificaciones.model.TicketSoporte;
import com.edutech.notificaciones.service.TicketSoporteService;

@RestController
@RequestMapping("/api/tickets")

public class TicketSoporteController {
    
    @Autowired
    private TicketSoporteService service;

    @PostMapping
    public TicketSoporte crear(@RequestBody TicketSoporte ticket){
        return service.crearTicket(ticket);
    }
    @GetMapping("/usuario/{usuarioId}")
        public List<TicketSoporte> listarPorUsuario(@PathVariable int usuarioId){
            return service.obtenerPorUsuario(usuarioId);
        }

    @PutMapping("/{id}/estado")
    public TicketSoporte actualizarEstado(@PathVariable int id, @RequestParam String estado){
        return service.actualizarEstado(id, estado);
    }

    @GetMapping
    public List <TicketSoporte> listarTodos(){
        return service.listarTodos();
    }
}

