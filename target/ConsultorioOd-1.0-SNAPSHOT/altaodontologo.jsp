<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="./componentes/head.jsp" %>
<%@include file="./componentes/bodyinicio.jsp"  %>

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9 text-center">
                <h1 class="h2 text-gray-900 mb-4">Alta odontólogos</h1>
                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">                            
                        <!-- Nested Row within Card Body -->
                        <div class="row justify-content-center">

                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h4 class="h5 text-gray-900 mb-4">Escribe los datos del nuevo odontólogo:</h4>
                                    </div>
                                    <form class="user" action="SVOdontologosAlta" method="POST">
                                        <div class="form-group">
                                            <input type="text" name="nombreOd" class="form-control form-control-user"
                                                 
                                                placeholder="Nombre...">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="apellidoOd" class="form-control form-control-user"
                                                 
                                                placeholder="Apellido...">
                                        </div>
                                        <div class="form-group">
                                            <h5 class="h6 text-gray-900 mb-4" >Fecha de nacimiento:</h5>
                                            <input name="fechaOd" placeholder="Fecha de nacimiento..."type="date" class="form-control form-control-user"
                                                 
                                                >
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                name="dniOd"
                                                placeholder="Dni...">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                name="telefonoOd" 
                                                placeholder="Telefono...">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                name="direccionOd"
                                                placeholder="Dirección...">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                name="especialidadOd"
                                                placeholder="Especialidad...">
                                        </div>
                                        
                                        <button type="submit" class="btn btn-primary btn-user btn-block">
                                            Guardar odontólogo
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