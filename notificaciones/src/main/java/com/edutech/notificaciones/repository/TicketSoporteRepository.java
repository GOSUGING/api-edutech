package com.edutech.notificaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.notificaciones.model.TicketSoporte;

public interface TicketSoporteRepository extends JpaRepository<TicketSoporte, Integer>{
    List<TicketSoporte> findByUsuarioUsuarioId(int usuarioId);
}
