
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        /*HttpSession misession = request.getSession();
        String usuario = request.getParameter("usuario_inicio");
        String contrasenia = request.getParameter("contrasenia_inicio");
        List<Usuario>listaUsuarios = control.traerUsuarios();
        for(Usuario usu:listaUsuarios){
            if(usuario == usu.getUsuario() && contrasenia == usu.getContrasenia_usuario()){
                response.sendRedirect("index.jsp");
                break;
            }
            else{
                System.out.println("El usuario o contraseña son incorrectos");
            }
        }*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        String usuario = request.getParameter("usuario_registro");
        String contrasenia = request.getParameter("contrasenia_registro");
        String contrasenia_conf = request.getParameter("contrasenia-confirmacion");
        String rol = request.getParameter("rol_registro");
        //List<Usuario> lista_usuarios = control.traerUsuarios();
        
        /*
            ERRORES POSIBLES
            boolean ok = true;
        for(Usuario usu : lista_usuarios){
            if(ok == true){
            if(usu.getUsuario() == usuario){
                alert("usuario ya utilizado, porfavor utilice otro usuario sin registrar");
                break;
            }
            if(contrasenia != contrasenia_conf){
                alert("Error al confirmar la contraseña");
                break;
            }
            if(rol != "Odontologo" || rol != "Administrativo"){
                alert("el rol no existe")
                break;
            }
            }
        }
        */
        Usuario nuevoUsu = new Usuario();
        nuevoUsu.setUsuario(usuario);
        nuevoUsu.setContrasenia_usuario(contrasenia);
        nuevoUsu.setRol(rol);
        control.crearUsuario(nuevoUsu);
        response.sendRedirect("login.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
