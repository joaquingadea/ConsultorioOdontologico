package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Turno;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-08-28T11:41:57")
@StaticMetamodel(Paciente.class)
public class Paciente_ extends Persona_ {

    public static volatile SingularAttribute<Paciente, Boolean> tiene_responsable;
    public static volatile ListAttribute<Paciente, Turno> lista_turnos;
    public static volatile SingularAttribute<Paciente, String> nombre_responsable;

}