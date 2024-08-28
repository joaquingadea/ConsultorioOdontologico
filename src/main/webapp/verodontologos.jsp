
<%@page import="java.util.ArrayList"%>
<%@page import="logica.Odontologo"%>
<%@page import="java.util.List"%>
<%@page import="logica.ControladoraLogica"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="./componentes/head.jsp" %>
<%@include file="./componentes/bodyinicio.jsp"  %>

                        <div class="content">
                            <div class="container-fluid mb-3 ">
                                <div class="row justify-content-center">
                                    <div class="col-xl-10">
                                        <div class="card shadow h-100">
                                            <div class="card-body text-center">
                                                <form class="user m-auto" action="SVElimOdontologos" method="GET" >
                                                    <div class="form-group">
                                                        <p class="m-0 font-weight-bold text-primary">Id para la edicion de odontologos:</p><br>
                                                        <input type="text" name="nombreOd" class="form-control form-control-user" placeholder="Nombre...">
                                                    </div>
                                                    <button type="submit">
                                                        Enviar
                                                    </button>
                                                </form>
                                            </div> 
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
<div class="container-fluid">
    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary"> Odontólogos registrados en el sistema </h6>
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
                                    <%List<Odontologo> listaOd = (List) request.getSession().getAttribute("listaOdontologos");%>
                                        
                                        <tbody>
                                            <%
                                        for(Odontologo od : listaOd){%>
                                            <tr>
                                            <td><%=od.getId_persona()%></td>
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