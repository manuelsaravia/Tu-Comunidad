<%-- 
    Document   : iniciarsesion
    Created on : 20/11/2015, 10:38:34 PM
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
                    <div class="col-lg-3" align="left">
                        <div class="alert alert-info">
                            <h5>Contamos con <strong><%out.println(session.getAttribute("usuarios").toString()); %> </strong>Usuarios Registrados</h5>
                        </div>
                    </div>
                    <div class="col-lg-1 col-lg-offset-8" align="right">
                        <a href="registrarUsuario.jsp" class="btn btn-info" type="button"><strong>Registrate</strong></a>
                    </div>
                </div>
            </div>
            <div class="row">
                <br><br><br>
                <div class="col-md-4 col-md-offset-4">
                    <% if (session.getAttribute("mensajeInicio") == null) {
                        session.setAttribute("mensajeInicio", "");
                    }
                    out.print(session.getAttribute("mensajeInicio"));
                    session.setAttribute("mensajeInicio", "");
                    %>
                    <div class="panel panel-default" id="inicio">
                        <div class="panel-body">
                            <div align="center">
                                <!--<h1 class="white"><strong>Tu Comunidad</strong></h1>-->
                                <div align="center">
                                    <img src="diseno/images/logo-compressor.png" width="100%">
                                </div>
                            </div>
                            <br>
                            <form action="validarSesion.jsp" method="post">
                                <div align="center">
                                    <input class="input-lg form-control inputcolor" name="correo" placeholder="Ingrese su Correo" type="email" required/>
                                    <input class="input-lg form-control inputcolor" name="contrasenia" placeholder="Ingrese su Contraseña" type="password" required/>
                                </div>
                                <div align="center">
                                    <br>
                                    <button name="iniciar" type="submit" class="btn btn-primary btn-lg">Iniciar Sesion</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                
            </div>
            
        
            
            
            <script src="diseno/js/jquery.js"></script>
            <script src="diseno/js/bootstrap.min.js"></script>
           
        </body>
</html>
