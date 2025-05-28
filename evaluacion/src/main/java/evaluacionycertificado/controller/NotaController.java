package evaluacionycertificado.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import evaluacionycertificado.model.Evaluacion;
import evaluacionycertificado.model.NotaEvaluacion;
import evaluacionycertificado.services.EvaluacionServices;
import evaluacionycertificado.services.NotaEvaluacionServices;

@RestController
@RequestMapping

public class NotaController {
    @Autowired
    private NotaEvaluacionServices notaservices;

    @Autowired
    private EvaluacionServices evaluacionservices;

    @GetMapping("/listanota")
    public ResponseEntity<List<NotaEvaluacion>> listarnota(){
        List<NotaEvaluacion>notaevaluacion = notaservices.listarNota();
        if (notaevaluacion.isEmpty()) {
            return ResponseEntity.notFound().build();
            
        }
        return ResponseEntity.ok(notaevaluacion);
    }

    
    @GetMapping("/buscarnota")
    public ResponseEntity<NotaEvaluacion>buscarNotaId(@PathVariable Long id){
        try {
            NotaEvaluacion notaevaluacion = notaservices.buscarNota(id);
            return ResponseEntity.ok(notaevaluacion);
            
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<NotaEvaluacion>actualizarNota(@PathVariable Long id, @RequestBody NotaEvaluacion notaEvaluacion){
        try {
            NotaEvaluacion nota = notaservices.buscarNota(id);
            Evaluacion evaluacion = evaluacionservices.buscarPorIdEva(notaEvaluacion.getEvaluacion().getId());
            nota.setIdNota(id);
            nota.setNota(notaEvaluacion.getNota());
            nota.setPuntaje(notaEvaluacion.getPuntaje());
            nota.setDescripcion(notaEvaluacion.getDescripcion());
            nota.setEvaluacion(evaluacion);

            notaservices.guardarNota(nota);
            return ResponseEntity.ok(notaEvaluacion);
            
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity<NotaEvaluacion>guardarNota(@RequestBody NotaEvaluacion notaevaluacion){
        NotaEvaluacion nuevaNota = notaservices.guardarNota(notaevaluacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaNota);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<NotaEvaluacion>eliminarNota(@PathVariable Long id, @RequestBody NotaEvaluacion notaEvaluacion){
        try {
            notaservices.eliminarNota(id);
            return ResponseEntity.ok(notaEvaluacion);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

}
