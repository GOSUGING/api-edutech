package com.edutech.reportesyadministracion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.reportesyadministracion.model.NotaEvaluacion;
import com.edutech.reportesyadministracion.repository.NotaEvaluacionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class NotaEvaluacionService {
    @Autowired
    private NotaEvaluacionRepository notarepository;

    public List<NotaEvaluacion>listarNota(){
        return notarepository.findAll();
        
    }

    public NotaEvaluacion buscarNota(long id){
        return notarepository.findById(id).get();
    }

    public Integer contarUsuariosQueRindieronEvaluacion(Long evaluacionId) {
    return notarepository.countByEvaluacionId(evaluacionId);
}
}
