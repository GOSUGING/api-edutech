package evaluacionycertificado.model;

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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="NotaEvaluacion")

public class NotaEvaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNota;

    @Column(nullable = false)
    private float nota;

    @Column(nullable = false)
    private Integer puntaje;

    @Column(nullable = true)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_evaluacion",nullable = false)
    private Evaluacion evaluacion;

    @Column(name= "id_estudiante",nullable = false)
    private Long id_estudiante;


}
