package logica;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
@Entity
public class Administrativo extends Persona {
    @OneToOne(mappedBy = "nombre_usuario")
    private Usuario usuario_administrativo;


    public Administrativo(Usuario usuario_administrativo, int id_persona, String nombre, String apellido, Date fechaNac, String telefono, String dni, String direccion) {
        super(id_persona, nombre, apellido, fechaNac, telefono, dni, direccion);
        this.usuario_administrativo = usuario_administrativo;
    }
    

    public Usuario getUsuario_administrativo() {
        return usuario_administrativo;
    }

    public void setUsuario_administrativo(Usuario usuario_administrativo) {
        this.usuario_administrativo = usuario_administrativo;
    }

    
}
