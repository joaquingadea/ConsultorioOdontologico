package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Odontologo;
import logica.Paciente;
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;

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
    public void eliminarOdontologo(int idOdEliminar) {
        try {
            odontologoJpa.destroy(idOdEliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Odontologo traerOdontologo(int idEditarOd) {
        return odontologoJpa.findOdontologo(idEditarOd);
    }

    public void editarOdontologo(Odontologo odEditar) {
        try {
            odontologoJpa.edit(odEditar);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //CRUD paciente
    public void crearPaciente(Paciente nuevoPac) {
        pacienteJpa.create(nuevoPac);
    }

    public List<Paciente> traerPacientes() {
        return pacienteJpa.findPacienteEntities();
    }


}
