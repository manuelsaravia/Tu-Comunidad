<%-- 
    Document   : registrarUsuario
    Created on : 21/11/2015, 10:53:43 AM
    Author     : Manuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Tu Comunidad</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="diseno/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="diseno/css/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="diseno/css/style.css">
        <link rel="shortcut icon" href="diseno/images/favicon.png">
        
        <style type="text/css"> 
body {
background:url(diseno/images/background-compressor.jpg) no-repeat center center fixed;
-webkit-background-size: cover;
-moz-background-size: cover;
-o-background-size: cover;
background-size: cover;
}
</style> 
         
    </head>
        <body>
            <div class="row">
                <br>
                <div class="col-md-12">
                    <div class="col-lg-2 col-lg-offset-10" align="right">
                        <a href="iniciarsesion.jsp" class="btn btn-primary" type="button"><strong>Iniciar Sesión</strong></a>
                    </div>
                </div>
            </div>
            <div class="row">
                <br>
                <div class="col-md-8 col-md-offset-2">
                    <% if (session.getAttribute("mensajeRegistro") == null) {
                        session.setAttribute("mensajeRegistro", "");
                    }
                    out.print(session.getAttribute("mensajeRegistro"));
                    session.setAttribute("mensajeRegistro", "");
                    %>
                    <div class="panel panel-default" id="panel-registro">
                        <div class="panel-body">
                            <div>
                                <form action="leerRegistro.jsp" class="form-horizontal" method="post" role="form">
                                        <fieldset>
                                            <legend class="white-registro">Datos de Usuario</legend>
                                            <div class="col-md-offset-2" align="center">
                                            <div class="form-group">
                                                <label for="correo" class="col-xs-12 col-sm-6 col-md-3 control-label white-registro">Correo electrónico:</label>
                                                <div class="col-xs-12 col-sm-6 col-md-6">
                                                    <div class="input-group">
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
                                                        <input class="form-control" id="correo" name="correo" placeholder="Introduzca su correo electronico" type="email" required>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-xs-12 col-sm-6 col-md-3 control-label white-registro" for="contrasenia" >Contraseña:</label>
                                                <div class="col-xs-12 col-sm-6 col-md-6">
                                                    <div class="input-group">
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                                        <input class="form-control" id="contrasenia" name="contrasenia" placeholder= "Introduzca su contraseña" type="password" required>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-xs-12 col-sm-6 col-md-3 control-label white-registro" for="contrasenia2">Confirmar:</label>
                                                <div class="col-xs-12 col-sm-6 col-md-6">
                                                    <div class="input-group">
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                                        <input class="form-control" id="confirmarContrasenia" name="contrasenia2" placeholder= "Confirme su contraseña" type="password" required>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="nombre" class="col-xs-12 col-sm-6 col-md-3 control-label white-registro">Nombre:</label>
                                                <div class="col-xs-12 col-sm-6 col-md-6">
                                                    <div class="input-group">
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                                        <input class="form-control" id="nombre" name="nombre" placeholder="Ingrese su nombre" type="text" required>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="apellido" class="col-xs-12 col-sm-6 col-md-3 control-label white-registro">Apellido:</label>
                                                <div class="col-xs-12 col-sm-6 col-md-6">
                                                    <div class="input-group">
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                                        <input class="form-control" id="apellido" name="apellido" placeholder="Ingrese su apellido" type="text" required>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                            <div class="form-group">
                                                <label for="fechaNacimiento" class="col-xs-12 col-sm-6 col-md-3 control-label white-registro">Fecha de nacimiento:</label>
                                                <div class="col-xs-12 col-sm-6 col-md-6">
                                                    <div class="input-group">
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                                                        <input class="form-control" id="fechaNacimiento" name="fechaNacimiento" type="date" required>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="ciudad" class="col-xs-12 col-sm-6 col-md-3 control-label white-registro">Ciudad:</label>
                                                <div class="col-xs-12 col-sm-6 col-md-6">
                                                    <div class="input-group">
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-phone-alt"></span></span>
                                                        <input class="form-control" id="ciudad" name="ciudad" placeholder="Ingrese la ciudad donde vive" type="text" required>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="telefono" class="col-xs-12 col-sm-6 col-md-3 control-label white-registro">Teléfono:</label>
                                                <div class="col-xs-12 col-sm-6 col-md-6">
                                                    <div class="input-group">
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-phone-alt"></span></span>
                                                        <input class="form-control" id="telefono" name="telefono" placeholder="Digite su telefono fijo" type="number" required>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="telefonoMovil" class="col-xs-12 col-sm-6 col-md-3 control-label white-registro">Teléfono móvil:</label>
                                                <div class="col-xs-12 col-sm-6 col-md-6">
                                                    <div class="input-group">
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-phone"></span></span>
                                                        <input class="form-control" id="telefonoMovil" name="movil" placeholder="Digite su telefono movil" type="number" required>
                                                    </div>
                                                </div>
                                            </div>
                                            </div>
                                        </fieldset>
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-xs-12 text-center">
                                                <button class="btn btn-info" id="registrar" name="requerimiento" value="registrarUsuario" type="submit" >Registrar</button>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                                <form action="registrarUsuario.jsp">
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-xs-12 text-center">
                                                <button class="btn btn-danger" id="cancelar" name="requerimiento" value="cancelar" type="submit" >Cancelar</button>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            
                        </div>
                    </div>
                    <div class="superior" align="center">
                            <img src="diseno/images/logo-compressor.png" width="100%">
                        </div>
                </div>
                
            </div>
            
        
            
            
            <script src="diseno/js/jquery.js"></script>
            <script src="diseno/js/bootstrap.min.js"></script>
           
        </body>
</html>
