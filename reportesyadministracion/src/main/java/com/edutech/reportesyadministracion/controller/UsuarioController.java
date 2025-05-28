package com.edutech.reportesyadministracion.controller;

import com.edutech.reportesyadministracion.model.Usuario;
import com.edutech.reportesyadministracion.service.UsuarioService;
import com.edutech.reportesyadministracion.dto.ReporteUsuarioDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reporte/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.findAll();
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

     @GetMapping("/{usuarioId}/reporte-completo")
    public ResponseEntity<ReporteUsuarioDTO> obtenerReporteCompleto(@PathVariable Long usuarioId) {
        ReporteUsuarioDTO dto = usuarioService.obtenerReporteCompleto(usuarioId);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(dto);
    }
}