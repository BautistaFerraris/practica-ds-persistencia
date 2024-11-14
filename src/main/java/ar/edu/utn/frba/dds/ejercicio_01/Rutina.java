package ar.edu.utn.frba.dds.ejercicio_01;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "rutina")
public class Rutina {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "deportista_id")
    private Deportista deportista;

    @OneToMany
    @JoinColumn(name = "rutina_id")
    private List<DiaDeEntrenamiento> diasDeEntrenamiento;

    @OneToOne
    @JoinColumn(name = "rutina_anterior_id")
    private Rutina rutinaAnterior;

    public Rutina() {
        this.diasDeEntrenamiento = new ArrayList<>();
    }

    public void agregarDiaDeEntrenamiento(DiaDeEntrenamiento diaDeEntrenamiento) {
        this.diasDeEntrenamiento.add(diaDeEntrenamiento);
    }
}
