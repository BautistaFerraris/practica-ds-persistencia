package ar.edu.utn.frba.dds.ejercicio_01;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "diaDeEntrenamiento")
public class DiaDeEntrenamiento {
  @Id
  @GeneratedValue
  private Long id;

  @ManyToMany
  @JoinTable(name = "diaEntrenamiento_ejercicio",joinColumns = @JoinColumn(name = "diaDeEntrenamiento_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ejercicio_id", referencedColumnName = "id"))
  private List<Ejercicio> ejercicios;

  @Column(name = "numero")
  private Integer numero; // representa el orden en la duracion de la rutina.

  @OneToOne
  @JoinColumn(name = "siguienteDia_id")
  private DiaDeEntrenamiento siguienteDia;

  public DiaDeEntrenamiento() {
    this.ejercicios = new ArrayList<>();
  }
  public void agregarEjercicio(Ejercicio ejercicio) {
    this.ejercicios.add(ejercicio);
  }
}
