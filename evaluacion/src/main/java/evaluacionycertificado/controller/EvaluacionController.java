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
import evaluacionycertificado.service.EvaluacionService;

@RestController
@RequestMapping("api/v1/evaluacion")

public class EvaluacionController {
    @Autowired
    private EvaluacionService evaluacionservices;

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
    @PostMapping
    public ResponseEntity<Evaluacion>guardar(@RequestBody Evaluacion eva){
        Evaluacion evaluacionNueva = evaluacionservices.guardarEvaluacion(eva);
        return ResponseEntity.status(HttpStatus.CREATED).body(evaluacionNueva);
        

    }
    @PutMapping("/{id}")
    public ResponseEntity<Evaluacion>actualizarEvaluacion(@PathVariable Long id,@RequestBody Evaluacion evaluacion){
        try {
            Evaluacion eva = evaluacionservices.buscarPorIdEva(id);
            eva.setTitulo(evaluacion.getTitulo());
            eva.setFecha(evaluacion.getFecha());
            eva.setPonderacion(evaluacion.getPonderacion());
            eva.setCursoId(evaluacion.getCursoId());

            evaluacionservices.guardarEvaluacion(eva);
            return ResponseEntity.ok(evaluacion);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Evaluacion>eliminarEvaluacion(@PathVariable Long id, @RequestBody Evaluacion evaluacion){
        try {
            evaluacionservices.eliminarEva(id);
            return ResponseEntity.ok(evaluacion);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    

}
