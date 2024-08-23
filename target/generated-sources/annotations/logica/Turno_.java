package logica;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Odontologo;
import logica.Paciente;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-08-22T19:39:12")
@StaticMetamodel(Turno.class)
public class Turno_ { 

    public static volatile SingularAttribute<Turno, Date> fecha;
    public static volatile SingularAttribute<Turno, Odontologo> docEncargado;
    public static volatile SingularAttribute<Turno, Integer> hora;
    public static volatile SingularAttribute<Turno, Paciente> paciente;
    public static volatile SingularAttribute<Turno, Integer> id_turno;

}