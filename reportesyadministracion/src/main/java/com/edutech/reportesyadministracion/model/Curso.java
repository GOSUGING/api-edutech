package com.edutech.reportesyadministracion.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "curso")
@Data
@NoArgsConstructor
@AllArgsConstructor



public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombreCurso;

    @Column
    private String descripcionCurso;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE) // Esto indica que solo se guarda la fecha, no la hora
    private Date duracionCurso;

    @ManyToOne
    @JoinColumn(name = "estado_curso_id", nullable = false)
    private EstadoCurso estadoCurso;

}