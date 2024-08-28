package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Odontologo;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-08-28T11:41:57")
@StaticMetamodel(Especialidad.class)
public class Especialidad_ { 

    public static volatile SingularAttribute<Especialidad, Integer> id_especialidad;
    public static volatile ListAttribute<Especialidad, Odontologo> doctoresEsp;
    public static volatile SingularAttribute<Especialidad, String> nombre;

}