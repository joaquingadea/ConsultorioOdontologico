package logica;

import java.util.Date;
import java.util.List;

public class Odontologo extends Persona {
    private int id_odontologo;
    private Usuario usuario_odontologo;
    private List<Especialidad> especialidades= null;
    private List<Turno> listaTurnos;
    private String horariosAt[];

    public Odontologo(int id_odontologo, Usuario usuario_odontologo, List<Turno> listaTurnos, String[] horariosAt, int id, String nombre, String apellido, Date fechaNac, String telefono, String dni, String direccion) {
        super(id, nombre, apellido, fechaNac, telefono, dni, direccion);
        this.id_odontologo = id_odontologo;
        this.usuario_odontologo = usuario_odontologo;
        this.listaTurnos = listaTurnos;
        this.horariosAt = horariosAt;
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

    public Usuario getUsuario_odontologo() {
        return usuario_odontologo;
    }

    public void setUsuario_odontologo(Usuario usuario_odontologo) {
        this.usuario_odontologo = usuario_odontologo;
    }

    public int getId_odontologo() {
        return id_odontologo;
    }

    public void setId_odontologo(int id_odontologo) {
        this.id_odontologo = id_odontologo;
    }
    
}
