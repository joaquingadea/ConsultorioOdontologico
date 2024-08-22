package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Especialidad;
import logica.Turno;
import logica.Usuario;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-08-22T18:43:05")
@StaticMetamodel(Odontologo.class)
public class Odontologo_ extends Persona_ {

    public static volatile SingularAttribute<Odontologo, Usuario> usuario;
    public static volatile SingularAttribute<Odontologo, String[]> horariosAt;
    public static volatile SingularAttribute<Odontologo, Especialidad> especialidad;
    public static volatile ListAttribute<Odontologo, Turno> listaTurnos;

}