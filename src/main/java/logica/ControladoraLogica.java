 package logica;

import java.util.List;
import persistencia.ControladoraPersistencia;

public class ControladoraLogica {
    ControladoraPersistencia controlP = new ControladoraPersistencia();
    
    public List<Usuario> traerUsuarios() {
      return controlP.traerUsuarios();  
    }

    public void crearUsuario(Usuario nuevoUsu) {
        controlP.crearUsuario(nuevoUsu);
    }
    
    
    public List<Odontologo> traerOdontologos(){
       return controlP.traerOdontologos(); 
    }

    public void crearOdontologo(Odontologo nuevoOd) {
        controlP.crearOdontologo(nuevoOd);
    }

    public void crearPaciente(Paciente nuevoPac) {
        controlP.crearPaciente(nuevoPac);
    }

    public List<Paciente> traerPacientes() {
        return controlP.traerPacientes();
    }

    public void eliminarOdontologo(int idOdEliminar) {
        controlP.eliminarOdontologo(idOdEliminar);
    }
}
