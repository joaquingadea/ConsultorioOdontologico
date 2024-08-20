
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.ControladoraLogica;
import logica.Usuario;


@WebServlet(name = "SVUsuarios", urlPatterns = {"/SVUsuarios"})
public class SVUsuarios extends HttpServlet {
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
        
        String usuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("usuario_contraseña");
        String contrasenia_conf = request.getParameter("usuario_contraseña-confirmacion");
        
        List<Usuario> lista_usuarios = control.traerUsuarios();
        
        /*for(Usuario usu : lista_usuarios){
            if(usu.getUsuario() == usuario){
                alert();
            }
        }*/
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
