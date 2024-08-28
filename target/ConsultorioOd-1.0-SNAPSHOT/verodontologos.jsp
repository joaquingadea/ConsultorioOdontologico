
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
                                    <div class="mb-1 col-xl-4 col-sm-6 col-l-6 ">
                                        <div class="card shadow h-100 ">
                                            <div class="card-body text-center">
                                                <form class="user" action="SVElimOdontologos" method="GET" >
                                                    <div class="form-group ">
                                                        <p class="m-0 font-weight-bold text-primary">Pon el ID del odontólogo que quieres <span class="text-warning">EDITAR</span>:</p><br>
                                                        <input type="text" name="idOdEdicion" class="form-control form-control-user" placeholder="ID...">
                                                    </div>
                                                    <button type="submit" class="btn btn-primary btn-user btn-block">
                                                        Editar
                                                    </button>
                                                </form>
                                            </div> 
                                        </div>
                                    </div>
                                    <div class="mb-1 col-xl-4 col-sm-6 col-l-6">
                                        <div class="card shadow h-100 ">
                                            <div class="card-body text-center">
                                                <form class="user" action="SVElimOdontologos" method="GET" >
                                                    <div class="form-group ">
                                                        <p class="m-0 font-weight-bold text-primary">Pon el ID del odontólogo que quieres <span class="text-danger">ELIMINAR</span>:</p><br>
                                                        <input type="text" name="idOdEliminacion" class="form-control form-control-user" placeholder="ID...">
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