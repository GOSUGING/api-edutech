package evaluacionycertificado.model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getter and setters
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Certificacion")

public class Certificacion {

    @Id // hace referencia que es unico
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    
    private Long id; 

    @Column(nullable = false)
    private String nombre; 
    @Column(nullable = false)
    private String especializacion; // quien la otorga

    @Column(nullable = false)
    private String nivel; // básico, intermedio, avanzado

    @Column(nullable = false)
    private Date fechaEmision; // cuándo se emitió

    @Column(nullable = false)
    private Date fechaExpiracion; // cuándo caduca, si aplica

       
    @Column(nullable = false)
    private String descripcion;

    @Column(name = "curso_id", nullable = false)
    private Integer cursoId;  

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @ManyToOne
    @JoinColumn(name = "evaluacion_id", referencedColumnName = "id")
    private Evaluacion evaluacion; 
}
