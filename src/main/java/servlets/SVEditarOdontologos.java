package servlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.Odontologo;

@WebServlet(name = "SVEditarOdontologos", urlPatterns = {"/SVEditarOdontologos"})
public class SVEditarOdontologos extends HttpServlet {
    ControladoraLogica control = new ControladoraLogica();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession misession = request.getSession();
        int idEditarOd = Integer.parseInt(request.getParameter("idOdEdicion"));
        misession.setAttribute("idOdEdicion",idEditarOd);
        Odontologo odEditar = control.traerOdontologo(idEditarOd);
        misession.setAttribute("odEditar", odEditar);
        response.sendRedirect("edicionodontologo.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idEditarOd = (int) request.getSession().getAttribute("idOdEdicion");
        Odontologo odEditar = control.traerOdontologo(idEditarOd);
        
        String nombreOd_editado = request.getParameter("nombreOd");
        String apellidoOd_editado = request.getParameter("apellidoOd");
        String dniOd_editado = request.getParameter("dniOd");
        String telefonoOd_editado = request.getParameter("telefonoOd");
        String direccionOd_editado = request.getParameter("direccionOd");
        
        odEditar.setNombre(nombreOd_editado);
        odEditar.setApellido(apellidoOd_editado);
        odEditar.setDni(dniOd_editado);
        odEditar.setTelefono(telefonoOd_editado);
        odEditar.setDireccion(direccionOd_editado);
        
        control.editarOdontologo(odEditar);
        response.sendRedirect("SVOdontologosAlta");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
