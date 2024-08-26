package persistencia;

import java.util.List;
import logica.Odontologo;
import logica.Paciente;
import logica.Usuario;

public class ControladoraPersistencia {
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    OdontologoJpaController odontologoJpa = new OdontologoJpaController();
    PacienteJpaController pacienteJpa = new PacienteJpaController();
    
    //CRUD usuario
    public List<Usuario> traerUsuarios() {
        return usuarioJpa.findUsuarioEntities();
    }

    public void crearUsuario(Usuario nuevoUsu) {
        usuarioJpa.create(nuevoUsu);
    }
    
    //CRUD odontologo
    public List<Odontologo> traerOdontologos() {
        return odontologoJpa.findOdontologoEntities();
    }

    public void crearOdontologo(Odontologo nuevoOd) {
        odontologoJpa.create(nuevoOd);
    }
    
    //CRUD paciente
    public void crearPaciente(Paciente nuevoPac) {
        pacienteJpa.create(nuevoPac);
    }
    
}
