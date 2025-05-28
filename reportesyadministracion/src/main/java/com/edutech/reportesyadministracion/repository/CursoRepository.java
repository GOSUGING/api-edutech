package com.edutech.reportesyadministracion.repository;
//import java.util.Date;
//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.reportesyadministracion.model.*;
//import com.edutech.reportesyadministracion.model.EstadoCurso;


@Repository

public interface CursoRepository extends JpaRepository<Curso, Integer> {
    Integer countByEstadoCurso(EstadoCurso estadoCurso);
}