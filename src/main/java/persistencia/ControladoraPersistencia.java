package persistencia;

import java.util.List;
import logica.Usuario;

public class ControladoraPersistencia {
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    public List<Usuario> traerUsuarios() {
        return usuarioJpa.findUsuarioEntities();
    }

    public void crearUsuario(Usuario nuevoUsu) {
        usuarioJpa.create(nuevoUsu);
    }
    
}
