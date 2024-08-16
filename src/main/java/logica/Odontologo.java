package logica;

import java.util.Date;
import java.util.List;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Odontologo extends Persona {
    @OneToOne(mappedBy = "nombre_usuario")
    private Usuario usuario_odontologo;
    @ManyToOne
    private Especialidad especialidad;
    @OneToMany(mappedBy = "docEncargado")
    private List<Turno> listaTurnos;
    private String horariosAt[];



    public Odontologo(Usuario usuario_odontologo, Especialidad especialidad, List<Turno> listaTurnos, String[] horariosAt, int id_persona, String nombre, String apellido, Date fechaNac, String telefono, String dni, String direccion) {
        super(id_persona, nombre, apellido, fechaNac, telefono, dni, direccion);
        this.usuario_odontologo = usuario_odontologo;
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

    public Usuario getUsuario_odontologo() {
        return usuario_odontologo;
    }

    public void setUsuario_odontologo(Usuario usuario_odontologo) {
        this.usuario_odontologo = usuario_odontologo;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
    
}
