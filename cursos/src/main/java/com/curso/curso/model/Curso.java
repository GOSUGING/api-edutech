package com.curso.curso.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;



import jakarta.persistence.*;

@Entity
@Table(name = "curso")
@Data
@NoArgsConstructor
@AllArgsConstructor



public class Curso {

    @Id
    private Long id;

    @Column(nullable = false)
    private String nombreCurso;

    @Column
    private String descripcionCurso;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE) // Esto indica que solo se guarda la fecha, no la hora
    private Date duracionCurso;

    @Column(name = "estado_curso_id", nullable = false)
    private Long estadoCurso;

}