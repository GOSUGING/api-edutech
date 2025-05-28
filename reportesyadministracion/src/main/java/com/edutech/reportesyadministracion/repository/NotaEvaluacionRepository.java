package com.edutech.reportesyadministracion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.reportesyadministracion.model.*;

@Repository

public interface NotaEvaluacionRepository extends JpaRepository<NotaEvaluacion, Long> {
// Usuarios que han realizado la evaluación
Integer countByEvaluacionId(Long evaluacionId);
List<NotaEvaluacion> findByUsuario_id(Long usuario_id);



}