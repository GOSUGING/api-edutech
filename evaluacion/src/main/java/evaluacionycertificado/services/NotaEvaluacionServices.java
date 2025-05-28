package evaluacionycertificado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import evaluacionycertificado.model.NotaEvaluacion;
import evaluacionycertificado.repository.NotaEvaluacionRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional


public class NotaEvaluacionServices {
    @Autowired
    private NotaEvaluacionRepository notarepository;

    public List<NotaEvaluacion>listarNota(){
        return notarepository.findAll();
        
    }

    public NotaEvaluacion guardarNota(NotaEvaluacion nota){
        return notarepository.save(nota);

    }
    public void eliminarNota(long id){
        notarepository.deleteById(id);
    }
    public NotaEvaluacion buscarNota(long id){
        return notarepository.findById(id).get();
    }

}
