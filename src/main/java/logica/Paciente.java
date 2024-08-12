package logica;

import java.util.Date;
import java.util.List;

public class Paciente extends Persona{
    
    private int id_paciente;
    private boolean tiene_responsable;
    private String nombre_responsable;
    private List<Turno> lista_turnos;

    public Paciente(int id_paciente, boolean tiene_responsable, String nombre_responsable, List<Turno> lista_turnos, String nombre, String apellido, Date fechaNac, String telefono, String dni, String direccion) {
        super(nombre, apellido, fechaNac, telefono, dni, direccion);
        this.id_paciente = id_paciente;
        this.tiene_responsable = tiene_responsable;
        this.nombre_responsable = nombre_responsable;
        this.lista_turnos = lista_turnos;
    }
    
    public String getNombre_responsable() {
        return nombre_responsable;
    }

    public void setNombre_responsable(String nombre_responsable) {
        this.nombre_responsable = nombre_responsable;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public boolean isTiene_responsable() {
        return tiene_responsable;
    }

    public void setTiene_responsable(boolean tiene_responsable) {
        this.tiene_responsable = tiene_responsable;
    }

    public List<Turno> getLista_turnos() {
        return lista_turnos;
    }

    public void setLista_turnos(List<Turno> lista_turnos) {
        this.lista_turnos = lista_turnos;
    }

    

}
    