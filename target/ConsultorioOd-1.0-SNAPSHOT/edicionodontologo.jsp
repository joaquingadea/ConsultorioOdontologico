<%@page import="logica.Odontologo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="./componentes/head.jsp" %>
<%@include file="./componentes/bodyinicio.jsp"  %>
    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9 text-center">
                <h1 class="h2 text-primary mb-4">Edición de odontólogos</h1>
                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">                            
                        <!-- Nested Row within Card Body -->
                        <div class="row justify-content-center">

                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h4 class="h5 text-gray-900 mb-4">Apartado para la edición de odontólogos:</h4>
                                    </div>
                                    <% Odontologo odEditar  = (Odontologo) (request.getSession().getAttribute("odEditar")); %>
                                    <form class="user" action="SVEditarOdontologos" method="POST">
                                        <div class="form-group">
                                            <input type="text" name="nombreOd" class="form-control form-control-user"
                                                   value= <%=odEditar.getNombre()%>>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="apellidoOd" class="form-control form-control-user"
                                                 
                                                value= <%=odEditar.getApellido()%>>
                                        </div>
                                        <div class="form-group">
                                            <h5 class="h6 text-gray-900 mb-4" >Fecha de nacimiento:</h5>
                                            <input name="fechaOd" value= <%=odEditar.getFechaNac()%> type="date" class="form-control form-control-user"
                                                 
                                                >
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                name="dniOd"
                                                value= <%=odEditar.getDni()%>>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                name="telefonoOd" 
                                                value= <%=odEditar.getTelefono()%>>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                name="direccionOd"
                                                value= <%=odEditar.getDireccion()%>>
                                        </div>
                                        
                                        <button type="submit" class="btn btn-primary btn-user btn-block">
                                           Guardar cambios
                                        </button>
                                        <hr>

                                    </form>
                               
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>
<%@include file="./componentes/bodyfinal.jsp"  %>