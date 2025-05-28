package com.edutech.reportesyadministracion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.reportesyadministracion.model.Evaluacion;
import com.edutech.reportesyadministracion.repository.EvaluacionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EvaluacionService {
    @Autowired
    private EvaluacionRepository evaluacionrepository;

    public List<Evaluacion>listarEva(){
        return evaluacionrepository.findAll();

    }

    public Evaluacion buscarPorIdEva(long id){
        return evaluacionrepository.findById(id).get();
    }



}
