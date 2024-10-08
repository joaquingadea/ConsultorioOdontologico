package servlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.ControladoraLogica;

@WebServlet(name = "SVElimOdontologos", urlPatterns = {"/SVElimOdontologos"})
public class SVElimOdontologos extends HttpServlet {
    ControladoraLogica control = new ControladoraLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idOdEliminar = Integer.parseInt(request.getParameter("idOdEliminacion"));
        control.eliminarOdontologo(idOdEliminar);
        response.sendRedirect("SVOdontologosAlta");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}