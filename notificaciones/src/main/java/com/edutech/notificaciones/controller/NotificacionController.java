package com.edutech.notificaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.notificaciones.model.Notificacion;
import com.edutech.notificaciones.service.NotificacionService;

@RestController
@RequestMapping("/api/notificaciones")

public class NotificacionController {

    @Autowired
    private NotificacionService service;

    @PostMapping
    public Notificacion crear(@RequestBody Notificacion notificacion){
        return service.crearNotificacion(notificacion);
    }

    @GetMapping
    public List<Notificacion> listarTodas(){
        return service.listarTodas();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Notificacion> listarporUsuario(@PathVariable int usuarioId){
        return service.obtenerPorUsuario(usuarioId);
    }
    
}
