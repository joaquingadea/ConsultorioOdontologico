
<%@page import="logica.Paciente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logica.Odontologo"%>
<%@page import="java.util.List"%>
<%@page import="logica.ControladoraLogica"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="./componentes/head.jsp" %>
<%@include file="./componentes/bodyinicio.jsp"  %>
<div class="container-fluid">
    <div class="card shadow mb-4">
                        
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary"> Pacientes registrados en el sistema </h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Nombre</th>
                                            <th>Apellido</th>
                                            <th>DNI</th>
                                            <th>Fecha nacimiento</th>
                                            <th>Direccion</th>
                                            <th>Telefono</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                       <tr>
                                            <th>Id</th>
                                            <th>Nombre</th>
                                            <th>Apellido</th>
                                            <th>DNI</th>
                                            <th>Fecha nacimiento</th>
                                            <th>Direccion</th>
                                            <th>Telefono</th>
                                        </tr>
                                    </tfoot>
                                    <%List<Odontologo> listaPacientes = (List) request.getSession().getAttribute("listaPacientes");%>
                                        
                                        <tbody>
                                            <%
                                        for(Paciente paciente : listaPacientes){%>
                                            <tr>
                                            <td><%=paciente.getId_persona()%></td>
                                            <td><%=paciente.getNombre()%></td>
                                            <td><%=paciente.getApellido()%></td>
                                            <td><%=paciente.getDni()%></td>
                                            <td><%=paciente.getFechaNac()%></td>
                                            <td><%=paciente.getDireccion()%></td>
                                            <td><%=paciente.getTelefono()%></td>
                                            </tr> <%};%>
                                        </tbody>
                                        
                                    </table>
                                
                            </div>
                        </div>
                    </div>
</div>
<%@include file="./componentes/bodyfinal.jsp"  %>