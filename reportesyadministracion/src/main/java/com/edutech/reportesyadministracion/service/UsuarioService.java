package com.edutech.reportesyadministracion.service;

import com.edutech.reportesyadministracion.dto.ReporteUsuarioDTO;
import com.edutech.reportesyadministracion.model.Usuario;
import com.edutech.reportesyadministracion.model.EstadoCurso;
//import  com.edutech.reportesyadministracion.model.StatusCursoEnum;
//import com.edutech.reportesyadministracion.model.Evaluacion;
import com.edutech.reportesyadministracion.model.NotaEvaluacion;
import com.edutech.reportesyadministracion.repository.UsuarioRepository;
import com.edutech.reportesyadministracion.repository.EstadoCursoRepository;
import com.edutech.reportesyadministracion.repository.NotaEvaluacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EstadoCursoRepository estadoCursoRepository;
    @Autowired
    private NotaEvaluacionRepository notaEvaluacionRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

public ReporteUsuarioDTO obtenerReporteCompleto(Long usuarioId) {
    Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
    if (usuario == null) return null;

    ReporteUsuarioDTO dto = new ReporteUsuarioDTO();
    dto.usuarioId = usuario.getId();
    dto.nombreUsuario = usuario.getNombre();

    // Llenar cursos y estados con for
    List<EstadoCurso> estados = estadoCursoRepository.findByUsuarioId(usuarioId);
    dto.cursos = new java.util.ArrayList<>();
    for (EstadoCurso ec : estados) {
        if (ec.getCurso() != null) {
            ReporteUsuarioDTO.CursoEstadoDTO ce = new ReporteUsuarioDTO.CursoEstadoDTO();
            ce.cursoId = ec.getCurso().getId();
            ce.nombreCurso = ec.getCurso().getNombreCurso();
            ce.estado = ec.getStatus().name();
            dto.cursos.add(ce);
        }
    }

    // Llenar evaluaciones y notas con for
    List<NotaEvaluacion> notas = notaEvaluacionRepository.findByUsuario_id(usuarioId);
    dto.evaluaciones = new java.util.ArrayList<>();
    for (NotaEvaluacion n : notas) {
        if (n.getEvaluacion() != null) {
            ReporteUsuarioDTO.EvaluacionNotaDTO en = new ReporteUsuarioDTO.EvaluacionNotaDTO();
            en.evaluacionId = n.getEvaluacion().getId();
            en.nombreEvaluacion = n.getEvaluacion().getTitulo();
            en.nota = n.getNota();
            en.puntaje = n.getPuntaje();
            en.descripcion = n.getDescripcion();
            dto.evaluaciones.add(en);
        }
    }

    return dto;
}
}