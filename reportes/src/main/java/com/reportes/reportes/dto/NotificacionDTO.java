package com.reportes.reportes.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class NotificacionDTO {
    private int id;
    private String tipo;
    private String titulo;
    private String mensaje;
    private Date fechaEnvio; // o LocalDateTime
    private UsuarioDTO usuario;
}
