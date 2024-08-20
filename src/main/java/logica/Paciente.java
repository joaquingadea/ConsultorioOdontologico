package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
@Entity
public class Paciente extends Persona implements Serializable{
    private boolean tiene_responsable;
    private String nombre_responsable;
    @OneToMany(mappedBy = "paciente")
    private List<Turno> lista_turnos;

    public Paciente() {
    }
    
    public Paciente(boolean tiene_responsable, String nombre_responsable, List<Turno> lista_turnos, int id_persona, String nombre, String apellido, Date fechaNac, String telefono, String dni, String direccion) {
        super(id_persona, nombre, apellido, fechaNac, telefono, dni, direccion);
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
    