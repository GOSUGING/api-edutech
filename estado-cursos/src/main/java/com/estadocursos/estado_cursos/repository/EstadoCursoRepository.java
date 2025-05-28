package com.estadocursos.estado_cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

// TODO: Update the following imports to match the actual package where EstadoCurso and StatusCursoEnum are defined
// import com.curso.curso.model.EstadoCurso;
// import com.curso.curso.model.StatusCursoEnum;
import com.estadocursos.estado_cursos.model.EstadoCurso;
import com.estadocursos.estado_cursos.model.StatusCursoEnum;

public interface EstadoCursoRepository extends JpaRepository<EstadoCurso, Integer> {
    
    EstadoCurso findByStatus(StatusCursoEnum status);    

}
