package com.estadocursos.estado_cursos;

import com.estadocursos.estado_cursos.model.EstadoCurso;
import com.estadocursos.estado_cursos.model.StatusCursoEnum;
import com.estadocursos.estado_cursos.repository.EstadoCursoRepository;
import com.estadocursos.estado_cursos.service.EstadoCursoService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EstadoCursoServiceTest {

    @Mock
    private EstadoCursoRepository estadoCursoRepository;

    @InjectMocks
    private EstadoCursoService estadoCursoService;

    private EstadoCurso estadoCurso;

    @BeforeEach
    void setUp() {
        estadoCurso = new EstadoCurso();
        estadoCurso.setId(1L);
        estadoCurso.setStatus(StatusCursoEnum.ACTIVO);
    }

    @Test
    void testFindAll() {
        List<EstadoCurso> lista = Arrays.asList(estadoCurso);
        when(estadoCursoRepository.findAll()).thenReturn(lista);

        List<EstadoCurso> resultado = estadoCursoService.findAll();

        assertEquals(1, resultado.size());
        assertEquals(StatusCursoEnum.ACTIVO, resultado.get(0).getStatus());
    }

    @Test
    void testFindByIdExiste() {
        when(estadoCursoRepository.findById(1)).thenReturn(Optional.of(estadoCurso));

        EstadoCurso resultado = estadoCursoService.findById(1);

        assertNotNull(resultado);
        assertEquals(StatusCursoEnum.ACTIVO, resultado.getStatus());
    }

    @Test
    void testFindByIdNoExiste() {
        when(estadoCursoRepository.findById(99)).thenReturn(Optional.empty());

        EstadoCurso resultado = estadoCursoService.findById(99);

        assertNull(resultado);
    }

    @Test
    void testSave() {
        when(estadoCursoRepository.save(estadoCurso)).thenReturn(estadoCurso);

        EstadoCurso resultado = estadoCursoService.save(estadoCurso);

        assertNotNull(resultado);
        assertEquals(StatusCursoEnum.ACTIVO, resultado.getStatus());
    }

    @Test
    void testDelete() {
        doNothing().when(estadoCursoRepository).deleteById(1);

        estadoCursoService.delete(1);

        verify(estadoCursoRepository, times(1)).deleteById(1);
    }

    @Test
    void testFindByStatus() {
        when(estadoCursoRepository.findByStatus(StatusCursoEnum.ACTIVO)).thenReturn(estadoCurso);

        EstadoCurso resultado = estadoCursoService.findByStatus(StatusCursoEnum.ACTIVO);

        assertNotNull(resultado);
        assertEquals(StatusCursoEnum.ACTIVO, resultado.getStatus());
    }
}
