package logica;

import java.util.List;

public class Especialidad {
    private int id;
    private String nombre;
    private List<Odontologo> doctoresEsp;

    public Especialidad() {
    }

    public Especialidad(int id, String nombre, List<Odontologo> doctoresEsp) {
        this.id = id;
        this.nombre = nombre;
        this.doctoresEsp = doctoresEsp;
    }

    public List<Odontologo> getDoctoresEsp() {
        return doctoresEsp;
    }

    public void setDoctoresEsp(List<Odontologo> doctoresEsp) {
        this.doctoresEsp = doctoresEsp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
