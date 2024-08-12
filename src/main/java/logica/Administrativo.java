package logica;

import java.util.Date;

public class Administrativo extends Persona {
    private int id_administrativo;
    private Usuario usuario_administrativo;

    public Administrativo(int id_administrativo, Usuario usuario_administrativo, int id, String nombre, String apellido, Date fechaNac, String telefono, String dni, String direccion) {
        super(nombre, apellido, fechaNac, telefono, dni, direccion);
        this.id_administrativo = id_administrativo;
        this.usuario_administrativo = usuario_administrativo;
    }

    public int getId_administrativo() {
        return id_administrativo;
    }

    public void setId_administrativo(int id_administrativo) {
        this.id_administrativo = id_administrativo;
    }

    public Usuario getUsuario_administrativo() {
        return usuario_administrativo;
    }

    public void setUsuario_administrativo(Usuario usuario_administrativo) {
        this.usuario_administrativo = usuario_administrativo;
    }

    
}
