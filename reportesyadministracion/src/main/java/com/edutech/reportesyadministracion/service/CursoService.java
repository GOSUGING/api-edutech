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
    // Puedes agregar más servicios según sea necesario


    // Buscar todos los cursos
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }


    // Buscar curso por ID
    public Optional<Curso> findById(Integer id) {
        return cursoRepository.findById(id);
    }

    //Cursos activos
   // public List<Curso> buscarCursosActivosHoy() {
    //    Date hoy = new Date();
    //    return cursoRepository.findByFechaInicioBeforeAndFechaFinAfter(hoy, hoy);
    //}
    //Contar cursos por profesor
    //public Integer contarCursosPorProfesor(Integer profesorId) {
    //    return cursoRepository.countByProfesorId(profesorId);
    //}
    
    //Contar cursos por estado
    public int contarCursosPorEstado(StatusCursoEnum status) {
        return cursoRepository.countByEstadoCursoStatus(status);
    }
}
