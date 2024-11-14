package ar.edu.utn.frba.dds.ejercicio_01;

import ar.edu.utn.frba.dds.ejercicio_01.motivaciones.Motivacion;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "deportista")
public class Deportista {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nombre", columnDefinition = "VARCHAR(50)")
    private String nombre;

    @Column(name = "apellido", columnDefinition = "VARCHAR(50)")
    private String apellido;

    @EllementCollection     //me falta la dependencia de maven
    @CollectionTable(name = "medios_de_contacto", joinColumns = @JoinColumn(name = "deportista_id"))
    @Column(name = "contacto")
    private List<String> contactos;

    @Convert(converter = MotivacionConverter.class)
    @Column(name = "tipo_motivacion")
    private Motivacion motivacionPrincipal;

    @Column(name = "peso_inicial", columnDefinition = "DECIMAL")
    private Double pesoInicialEnKilos;

    public void agregarContacto(String contacto) {
        contactos.add(contacto);
    }

    public Deportista(){
        this.contactos = new ArrayList<>();
    }

}
