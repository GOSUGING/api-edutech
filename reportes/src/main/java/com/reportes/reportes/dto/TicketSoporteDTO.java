package com.reportes.reportes.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketSoporteDTO {
    private int id;
    private String descripcion;
    private String estado;
    private Date fechaCreacion;
    private Date fechaActualizacion;
    private UsuarioDTO usuario;
    private TipoAsuntoDTO tipoAsunto;
}
