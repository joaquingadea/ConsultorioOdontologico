package logica;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity 
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_especialidad;
    private String nombre;
    private List<Odontologo> doctoresEsp;

    public Especialidad() {
    }

    public Especialidad(int id_especialidad, String nombre, List<Odontologo> doctoresEsp) {
        this.id_especialidad = id_especialidad;
        this.nombre = nombre;
        this.doctoresEsp = doctoresEsp;
    }

    public List<Odontologo> getDoctoresEsp() {
        return doctoresEsp;
    }

    public void setDoctoresEsp(List<Odontologo> doctoresEsp) {
        this.doctoresEsp = doctoresEsp;
    }

    public int getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
}
