package com.edutech.reportesyadministracion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.reportesyadministracion.model.*;

@Repository

public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {}