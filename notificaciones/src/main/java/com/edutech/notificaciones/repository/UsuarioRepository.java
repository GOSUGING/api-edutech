package com.edutech.notificaciones.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.notificaciones.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional <Usuario> findByEmail(String email);
}


