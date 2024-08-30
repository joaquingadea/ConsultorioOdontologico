
<%@page import="logica.Paciente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logica.Odontologo"%>
<%@page import="java.util.List"%>
<%@page import="logica.ControladoraLogica"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="./componentes/head.jsp" %>
<%@include file="./componentes/bodyinicio.jsp"  %>


<div class="content">
                            <div class="container-fluid mb-4 ">
                                <div class="row justify-content-center ">
                                    <div class="mb-1 mt-1 col-xl-4 col-sm-6 col-l-6 ">
                                        <div class="card shadow h-100 ">
                                            <div class="card-body text-center">
                                                <form class="user" action="SVEditarPacientes" method="GET" >
                                                    <div class="form-group ">
                                                        <p class="m-0 font-weight-bold text-primary">Pon el ID del paciente que quieres <span class="text-warning">EDITAR</span>:</p><br>
                                                        <input type="text" name="idPacEdicion" class="form-control form-control-user" placeholder="ID...">
                                                    </div>
                                                    <button type="submit" class="btn btn-primary btn-user btn-block">
                                                        Editar
                                                    </button>
                                                </form>
                                            </div> 
                                        </div>
                                    </div>
                                    <div class="mb-1 mt-1 col-xl-4 col-sm-6 col-l-6">
                                        <div class="card shadow h-100 ">
                                            <div class="card-body text-center">
                                                <form class="user" action="SVElimPacientes" method="POST" >
                                                    <div class="form-group ">
                                                        <p class="m-0 font-weight-bold text-primary">Pon el ID del paciente que quieres <span class="text-danger">ELIMINAR</span>:</p><br>
                                                        <input type="text" name="idPacEliminacion" class="form-control form-control-user" placeholder="ID...">
                                                    </div>
                                                    <button type="submit" class="btn btn-primary btn-user btn-block">
                                                        Eliminar
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
                                    <%List<Paciente> listaPacientes = (List) request.getSession().getAttribute("listaPacientes");%>
                                        
                                        <tbody>
                                            <%
                                        for(Paciente paciente : listaPacientes){ %>
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