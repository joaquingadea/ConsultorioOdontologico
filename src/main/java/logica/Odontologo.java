package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Odontologo extends Persona implements Serializable {
    @OneToOne
    private Usuario usuario;
    @ManyToOne
    private Especialidad especialidad;
    @OneToMany(mappedBy = "docEncargado")
    private List<Turno> listaTurnos;
    private String horariosAt[];

    public Odontologo() {
    }
    
    public Odontologo(Usuario usuario, Especialidad especialidad, List<Turno> listaTurnos, String[] horariosAt, int id_persona, String nombre, String apellido, Date fechaNac, String telefono, String dni, String direccion) {
        super(id_persona, nombre, apellido, fechaNac, telefono, dni, direccion);
        this.usuario = usuario;
        this.especialidad = especialidad;
        this.listaTurnos = listaTurnos;
        this.horariosAt = horariosAt;
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

    

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
