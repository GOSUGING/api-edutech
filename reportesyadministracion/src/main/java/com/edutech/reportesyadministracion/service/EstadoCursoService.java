package com.edutech.reportesyadministracion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.reportesyadministracion.model.EstadoCurso;
import com.edutech.reportesyadministracion.model.StatusCursoEnum;
import com.edutech.reportesyadministracion.repository.EstadoCursoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class EstadoCursoService {
    @Autowired  
    private EstadoCursoRepository estadoCursoRepository;
    
    public List<EstadoCurso> findAll() {
        return estadoCursoRepository.findAll();
    }

    public EstadoCurso findById(Integer id) {
        return estadoCursoRepository.findById(id).orElse(null);
    }
   
    public List<EstadoCurso> findByStatus(StatusCursoEnum status) {
        return estadoCursoRepository.findByStatus(status);
    }

    public Integer contarUsuariosPorEstadoEnCurso(Integer cursoId, StatusCursoEnum status) {
        return estadoCursoRepository.countByCursoIdAndStatus(cursoId, status);
    }
    

}