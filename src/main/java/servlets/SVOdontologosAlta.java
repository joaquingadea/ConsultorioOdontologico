/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.Odontologo;


@WebServlet(name = "SVOdontologosAlta", urlPatterns = {"/SVOdontologosAlta"})
public class SVOdontologosAlta extends HttpServlet {
    
    ControladoraLogica control = new ControladoraLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Odontologo> listaOdontologos = new ArrayList<Odontologo>();
        listaOdontologos = control.traerOdontologos();
        HttpSession misession = request.getSession();
        misession.setAttribute("listaOdontologos", listaOdontologos);
        response.sendRedirect("verodontologos.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String nombreOd = request.getParameter("nombreOd");
        String apellidoOd = request.getParameter("apellidoOd");
        String dniOd = request.getParameter("dniOd");
        //Date fechaOd =  request.getParameter("fechaOd");
        String telefonoOd = request.getParameter("telefonoOd");
        String direccionOd = request.getParameter("direccionOd");
        //String especialidadOd = request.getParameter("especialidadOd");
        
        Odontologo nuevoOd = new Odontologo();
        nuevoOd.setNombre(nombreOd);
        nuevoOd.setApellido(apellidoOd);
        nuevoOd.setDni(dniOd);
        //nuevoOd.setFechaNac(fechaOd);
        nuevoOd.setDireccion(direccionOd);
        nuevoOd.setTelefono(telefonoOd);
        control.crearOdontologo(nuevoOd);
        response.sendRedirect("altaodontologo.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
