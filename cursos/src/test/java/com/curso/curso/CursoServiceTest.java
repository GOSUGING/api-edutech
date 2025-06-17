package com.curso.curso;

import com.curso.curso.model.Curso;
import com.curso.curso.repository.CursoRepository;
import com.curso.curso.service.CursoService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CursoServiceTest {

    @Mock
    private CursoRepository cursoRepository;

    @InjectMocks
    private CursoService cursoService;

    private Curso curso;

    @BeforeEach
    void setUp() {
        curso = new Curso();
        curso.setId(1L);
        curso.setNombreCurso("Curso de Java");
        curso.setDescripcionCurso("Aprende Java desde cero");
    }

    @Test
    void testFindAll() {
        List<Curso> cursos = Arrays.asList(curso);
        when(cursoRepository.findAll()).thenReturn(cursos);

        List<Curso> resultado = cursoService.findAll();

        assertEquals(1, resultado.size());
        assertEquals("Curso de Java", resultado.get(0).getNombreCurso());
    }

    @Test
    void testFindByIdExiste() {
        when(cursoRepository.findById(1)).thenReturn(Optional.of(curso));

        Optional<Curso> resultado = cursoService.findById(1);

        assertTrue(resultado.isPresent());
        assertEquals("Curso de Java", resultado.get().getNombreCurso());
    }

    @Test
    void testFindByIdNoExiste() {
        when(cursoRepository.findById(99)).thenReturn(Optional.empty());

        Optional<Curso> resultado = cursoService.findById(99);

        assertFalse(resultado.isPresent());
    }

    @Test
    void testSave() {
        when(cursoRepository.save(curso)).thenReturn(curso);

        Curso resultado = cursoService.save(curso);

        assertNotNull(resultado);
        assertEquals("Curso de Java", resultado.getNombreCurso());
    }

    @Test
    void testDelete() {
        doNothing().when(cursoRepository).deleteById(1);

        cursoService.delete(1);

        verify(cursoRepository, times(1)).deleteById(1);
    }
}
