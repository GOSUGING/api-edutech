package com.edutech.reportesyadministracion.service;

//import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.reportesyadministracion.model.Curso;
import com.edutech.reportesyadministracion.model.EstadoCurso;
import com.edutech.reportesyadministracion.model.StatusCursoEnum;
//import com.edutech.reportesyadministracion.model.EstadoCurso;
import com.edutech.reportesyadministracion.repository.CursoRepository;

import jakarta.transaction.Transactional;



@Service
@Transactional
public class CursoService {

        
    
    @Autowired
    private CursoRepository cursoRepository;

   // @Autowired
    //private EstadoCursoService estadoCursoService; // Inyectar el servicio de EstadoCurso si es necesario


    // Buscar todos los cursos
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }


    // Buscar curso por ID
    public Optional<Curso> findById(Integer id) {
        return cursoRepository.findById(id);
    }


    //Contar cursos por estado
    public Integer contarCursosPorEstado(StatusCursoEnum status, StatusCursoEnum statusCursoEnum) {
        EstadoCurso estadoCurso = new EstadoCurso();
        estadoCurso.setStatus(status);
        return cursoRepository.countByEstadoCurso(estadoCurso);
    }
}
