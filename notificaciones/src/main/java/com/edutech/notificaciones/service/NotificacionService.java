package com.edutech.notificaciones.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.notificaciones.model.Notificacion;
import com.edutech.notificaciones.repository.NotificacionRepository;



@Service
public class NotificacionService {
    

    @Autowired
    private NotificacionRepository repository;

    public Notificacion crearNotificacion(Notificacion notificacion){
        notificacion.setFechaEnvio(LocalDateTime.now());
        return repository.save(notificacion);
    }
    
    public List<Notificacion> listarTodas(){
        return repository.findAll();
    }

    public List<Notificacion> obtenerPorUsuario(int usuarioId){
        return repository.findByUsuario_UsuarioId(usuarioId);
    }
}
