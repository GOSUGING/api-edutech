package com.edutech.reportesyadministracion.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.edutech.reportesyadministracion.model.Evaluacion;
import com.edutech.reportesyadministracion.model.NotaEvaluacion;
//import com.edutech.reportesyadministracion.service.EvaluacionService;
import com.edutech.reportesyadministracion.service.NotaEvaluacionService;

@RestController
@RequestMapping("/api/v1/reporte/notas")
public class NotaController {
    @Autowired
    private NotaEvaluacionService notaservices;

    //@Autowired
    //private EvaluacionService evaluacionservices;

    @GetMapping("/listanota")
    public ResponseEntity<List<NotaEvaluacion>> listarnota(){
        List<NotaEvaluacion>notaevaluacion = notaservices.listarNota();
        if (notaevaluacion.isEmpty()) {
            return ResponseEntity.notFound().build();
            
        }
        return ResponseEntity.ok(notaevaluacion);
    }

    
    @GetMapping("/buscarnota/{id}")
    public ResponseEntity<NotaEvaluacion>buscarNotaId(@PathVariable Long id){
        try {
            NotaEvaluacion notaevaluacion = notaservices.buscarNota(id);
            return ResponseEntity.ok(notaevaluacion);
            
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/evaluacion/{evaluacionId}/usuarios/rindieron")
    public ResponseEntity<Integer> contarUsuariosQueRindieronEvaluacion(@PathVariable Long evaluacionId) {
        Integer cantidad = notaservices.contarUsuariosQueRindieronEvaluacion(evaluacionId);
        return ResponseEntity.ok(cantidad);
}
    

}
