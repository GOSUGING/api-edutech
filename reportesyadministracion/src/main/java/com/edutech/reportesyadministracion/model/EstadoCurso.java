package com.edutech.reportesyadministracion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "estado_curso")
@Data
@NoArgsConstructor  

@AllArgsConstructor

public class EstadoCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private StatusCursoEnum status;

    @OneToMany(mappedBy = "estadoCurso", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Curso> cursos;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    @JsonIgnore
    private Curso curso;

}