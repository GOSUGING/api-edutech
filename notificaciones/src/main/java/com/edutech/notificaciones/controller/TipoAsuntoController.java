package com.edutech.notificaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.notificaciones.model.TipoAsunto;
import com.edutech.notificaciones.repository.TipoAsuntoRepository;

@RestController
@RequestMapping("/api/tipo-asuntos")
public class TipoAsuntoController {
    
    @Autowired
    private TipoAsuntoRepository repository;
    
    @GetMapping
    public List<TipoAsunto> listarTodos(){
        return repository.findAll();
    }
}
