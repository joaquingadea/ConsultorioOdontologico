package logica;

import java.util.List;

public class Odontologo {
    private int id;
    private String nombre;
    private String apellido;
    private List<Especialidad> especialidades= null;
    private List<Turno> listaTurnos;
    private String horariosAt[];

    public Odontologo() {
    }

    public Odontologo(int id, String nombre, String apellido, List<Turno> listaTurnos, String[] horariosAt) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.listaTurnos = listaTurnos;
        this.horariosAt = horariosAt;
    }
    
    

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

    public String[] getHorariosAt() {
        return horariosAt;
    }

    public void setHorariosAt(String[] horariosAt) {
        this.horariosAt = horariosAt;
    }

    public List<Turno> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(List<Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }
    
}
