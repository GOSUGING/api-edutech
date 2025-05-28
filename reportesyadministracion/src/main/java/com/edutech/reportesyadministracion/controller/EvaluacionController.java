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


import com.edutech.reportesyadministracion.model.Evaluacion;
import com.edutech.reportesyadministracion.service.EvaluacionService;

@RestController
@RequestMapping("/api/v1/reporte/evaluaciones")
public class EvaluacionController {
    @Autowired
    private EvaluacionService evaluacionservices;

    @GetMapping
    public String test() {
    return "Evaluaciones endpoint activo";
    }

    @GetMapping("/listaEvaluacion")
    public ResponseEntity<List<Evaluacion>> listar(){
        List<Evaluacion>eva = evaluacionservices.listarEva();
        if (eva.isEmpty()) {
            return ResponseEntity.notFound().build();
            
        }
        return ResponseEntity.ok(eva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evaluacion> buscarId(@PathVariable Long id){
        try {
            Evaluacion eva = evaluacionservices.buscarPorIdEva(id);
            return ResponseEntity.ok(eva);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }



}
