package ar.edu.utn.frba.dds.ejercicio_01;

import ar.edu.utn.frba.dds.ejercicio_01.motivaciones.BajarDePeso;
import ar.edu.utn.frba.dds.ejercicio_01.motivaciones.Mantener;
import ar.edu.utn.frba.dds.ejercicio_01.motivaciones.Motivacion;
import ar.edu.utn.frba.dds.ejercicio_01.motivaciones.Tonificar;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class MotivacionConverter implements AttributeConverter<Motivacion, String> {
  @Override
  public String convertToDatabaseColumn(Motivacion tipoMotivacion) {
    if(tipoMotivacion instanceof BajarDePeso){
      return "bajarPeso";
    }else if(tipoMotivacion instanceof Mantener) {
      return "mantener";
    }else if (tipoMotivacion instanceof Tonificar) {
      return "tonificar";
    }
    return null;
  }

  @Override
  public Motivacion convertToEntityAttribute(String tipoMotivacion) {
    if("bajarPeso".equals(tipoMotivacion))
      return new BajarDePeso();
    else if ("mantener".equals(tipoMotivacion)) {
      return new Mantener();
    }else if("tonificar".equals(tipoMotivacion))
      return new Tonificar();

    return null;
  }

}
