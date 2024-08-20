package logica;

import java.util.List;
import persistencia.ControladoraPersistencia;

public class ControladoraLogica {
    ControladoraPersistencia controlP = new ControladoraPersistencia();
    public List<Usuario> traerUsuarios() {
      return controlP.traerUsuarios();  
    }
    
}
