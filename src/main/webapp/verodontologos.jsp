
<%@page import="logica.Odontologo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="logica.ControladoraLogica"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="./componentes/head.jsp" %>
<%@include file="./componentes/bodyinicio.jsp"  %>
<div class="container-fluid">
    <div class="card shadow mb-4">
                        
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
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
                                            <th>Nombre</th>
                                            <th>Apellido</th>
                                            <th>DNI</th>
                                            <th>Fecha nacimiento</th>
                                            <th>Direccion</th>
                                            <th>Telefono</th>
                                        </tr>
                                    </tfoot>
                                    
                                        
                                        <tbody>
                                            <%
                                        ControladoraLogica control = new ControladoraLogica();
                                        List<Odontologo> listaOd = control.traerOdontologos();
                                        for(Odontologo od : listaOd){%>
                                            <tr>
                                            <td><%=od.getNombre()%></td>
                                            <td><%=od.getApellido()%></td>
                                            <td><%=od.getDni()%></td>
                                            <td><%=od.getFechaNac()%></td>
                                            <td><%=od.getDireccion()%></td>
                                            <td><%=od.getTelefono()%></td>
                                            </tr> <%};%>
                                        </tbody>
                                        
                                    </table>
                                
                            </div>
                        </div>
                    </div>
</div>
<%@include file="./componentes/bodyfinal.jsp"  %>