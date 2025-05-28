package com.curso.curso.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.curso.model.Curso;

@Repository
public interface CursoRepository  extends JpaRepository<Curso, Integer>{
    

}
