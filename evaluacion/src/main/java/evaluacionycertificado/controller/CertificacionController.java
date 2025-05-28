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

import evaluacionycertificado.model.Certificacion;
import evaluacionycertificado.model.Evaluacion;
import evaluacionycertificado.services.CertificacionServices;
import evaluacionycertificado.services.EvaluacionServices;


@RestController
@RequestMapping ("api/v1/certificado")

public class CertificacionController {
    @Autowired
    private CertificacionServices certificadoservices;

    @Autowired
    private EvaluacionServices evaluacionservices;

    @GetMapping("/listarnota")
    public ResponseEntity<List<Certificacion>> listar(){
        List<Certificacion>certificado = certificadoservices.listarCertficacion();
        if (certificado.isEmpty()) {
            return ResponseEntity.noContent().build();
            
        }
        return ResponseEntity.ok(certificado);

        
    }

    @PostMapping
    public ResponseEntity<Certificacion>guardar(@RequestBody Certificacion certificacacion){
        Certificacion certificacionNueva= certificadoservices.guardarCertificado(certificacacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(certificacionNueva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Certificacion> buscarid(@PathVariable Long id){
        try {
            Certificacion certificacion = certificadoservices.buscarCertificadoId(id);
            return ResponseEntity.ok(certificacion);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<Certificacion>actualizar(@PathVariable long id, @RequestBody Certificacion certificacion){
        try {
            Certificacion cert = certificadoservices.buscarCertificadoId(id);
            Evaluacion eva = evaluacionservices.buscarPorIdEva(certificacion.getEvaluacion().getId());
            cert.setId(id);
            cert.setNombre(certificacion.getNombre());
            cert.setEspecializacion(certificacion.getEspecializacion());
            cert.setNivel(certificacion.getNivel());
            cert.setFechaEmision(certificacion.getFechaEmision());
            cert.setFechaExpiracion(certificacion.getFechaExpiracion());
            cert.setDescripcion(certificacion.getDescripcion());
            cert.setCursoId(certificacion.getCursoId());
            cert.setUsuarioId(certificacion.getUsuarioId());
            cert.setEvaluacion(eva);

            certificadoservices.guardarCertificado(cert);

            return ResponseEntity.ok(certificacion);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Certificacion>eliminar(@PathVariable Long id,@RequestBody Certificacion certificacion){
        try {
            certificadoservices.eliminarCertificacion(id);
            return ResponseEntity.ok(certificacion);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
