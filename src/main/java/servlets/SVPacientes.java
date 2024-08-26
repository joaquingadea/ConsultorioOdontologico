package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.ControladoraLogica;
import logica.Paciente;

@WebServlet(name = "SVPacientes", urlPatterns = {"/SVPacientes"})
public class SVPacientes extends HttpServlet {
    ControladoraLogica control = new ControladoraLogica();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String nombrePac = request.getParameter("nombrePac");
        String apellidoPac = request.getParameter("apellidoPac");
        String dniPac = request.getParameter("dniPac");
        String telefonoPac = request.getParameter("telefonoPac");
        String direccionPac = request.getParameter("direccionPac");
        
        Paciente nuevoPac = new Paciente();
        
        nuevoPac.setNombre(nombrePac);
        nuevoPac.setApellido(apellidoPac);
        nuevoPac.setDni(dniPac);
        nuevoPac.setTelefono(telefonoPac);
        nuevoPac.setDireccion(direccionPac);
        
        control.crearPaciente(nuevoPac);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
