package com.curso.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.curso.model.Curso;

import com.curso.curso.repository.CursoRepository;



import jakarta.transaction.Transactional;

@Service
@Transactional
public class CursoService {
    
    
    @Autowired
    private CursoRepository cursoRepository;

    
    
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> findById(Integer id) {
        return cursoRepository.findById(id);
    }

     public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    public void delete(Integer id) {
        cursoRepository.deleteById(id);
    }



    
}
