package persistencia;

import java.util.List;
import logica.Odontologo;
import logica.Usuario;

public class ControladoraPersistencia {
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    OdontologoJpaController odontologoJpa = new OdontologoJpaController();
    
    public List<Usuario> traerUsuarios() {
        return usuarioJpa.findUsuarioEntities();
    }

    public void crearUsuario(Usuario nuevoUsu) {
        usuarioJpa.create(nuevoUsu);
    }

    public List<Odontologo> traerOdontologos() {
        return odontologoJpa.findOdontologoEntities();
    }

    public void crearOdontologo(Odontologo nuevoOd) {
        odontologoJpa.create(nuevoOd);
    }
    
}
