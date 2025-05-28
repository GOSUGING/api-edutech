package com.edutech.reportesyadministracion.model;

//import com.edutech.reportesyadministracion.model.Evaluacion;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="NotaEvaluacion")

public class NotaEvaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNota;

    @Column(nullable = false)
    private float nota;

    @Column(nullable = false)
    private Integer puntaje;

    @Column(nullable = true)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "evaluacion_id",nullable = false)
    private Evaluacion evaluacion;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;




}
