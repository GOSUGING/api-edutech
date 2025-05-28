package com.edutech.reportesyadministracion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.reportesyadministracion.model.*;

@Repository

public interface EstadoCursoRepository extends JpaRepository<EstadoCurso, Integer> {    
        List<EstadoCurso> findByUsuarioId(Long usuarioId);
        List<EstadoCurso> findByStatus(StatusCursoEnum status);
        Integer countByCursoIdAndStatus(Integer cursoId, StatusCursoEnum status);




}