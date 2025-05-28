package com.edutech.notificaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edutech.notificaciones.model.Notificacion;


public interface NotificacionRepository extends JpaRepository<Notificacion, Integer> {
    List<Notificacion> findByUsuario_UsuarioId(int usuarioId);
}
