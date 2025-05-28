package com.edutech.notificaciones.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USUARIO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Usuario {
    

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int usuarioId;

    private String nombre;

    @Column (unique= true, nullable= false)
    private String email;

    
}
