<%-- 
    Document   : solicitar
    Created on : 27/11/2015, 10:18:08 AM
    Author     : Manuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Tu Comunidad</title>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../diseno/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../diseno/css/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="../diseno/css/style.css">
        <link rel="shortcut icon" href="../diseno/images/favicon.png">


		
	</head>
        <body class="principales">
            <nav class="navbar navbar-default">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand">
                            <img alt="Brand" src="../diseno/images/favicon.png" width="70%">
                        </a>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li><a href="principalUsuario.jsp">Inicio<span class="sr-only">(current)</span></a></li>
                            <li><a href="#">Mensajes</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a><% out.println(session.getAttribute("nombre").toString()); %></a></li>
                            <li class="blue"><a href="../iniciarsesion.jsp" class="blue">Cerrar Sesion</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>
            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        <div class="panel panel-default paneles">
                            <div class="panel-body">
                                <h3 class="black"><% out.println(session.getAttribute("nombre").toString()); %></h3>
                                <div class="row">
                                    <div class="col-md-4 hidden-xs">
                                        <p><strong>Visitas</strong></p>
                                        <p align="center"><% out.println(session.getAttribute("visitas").toString()); %></p>
                                    </div>
                                    <div class="col-md-4 hidden-xs">
                                        <p><strong>Servicios</strong></p>
                                        <p align="center">-</p>
                                    </div>
                                    <div class="col-md-4 hidden-xs">
                                        <p><strong>Cliente</strong></p>
                                        <p align="center"><% out.println(session.getAttribute("tipo").toString()); %></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default paneles">
                            <div class="panel-body">
                                <button type="button" class="navbar-toggle collapsed navbar-default" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2" aria-expanded="false">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <strong>Menú</strong></button>
                                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">   
                                    <h5 class="black">Noticias Juridicas<span class="sr-only">(current)</span></h5>
                                    <ul class="nav nav-pills">
                                        <li>Derechos
                                            <ul>
                                                <li>Constitucionales</li>
                                                <li>Administrativos</li>
                                                <li>Penales</li>
                                                <li>Procesales</li>
                                                <li>Financieros</li>
                                                <li>Tributarios</li>
                                                <li>Civiles</li>
                                                <li>Mercantiles</li>
                                                <li>Laborales</li>
                                                <li>Internacionales Publicos</li>
                                                <li>Internacionales Privados</li>
                                            </ul>
                                        </li>
                                    </ul>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <% if (session.getAttribute("mensajeSolicitud") == null) {
                        session.setAttribute("mensajeSolicitud", "");
                    }
                    out.print(session.getAttribute("mensajeSolicitud"));
                    session.setAttribute("mensajeSolicitud", "");
                    %>
                        <div class="panel panel-default paneles">
                            <div class="panel-body">
                                
                                <div class="panel panel-info">
                                    <div class="panel-heading">
                                        <h3 class="panel-title">Solicitud de Servicio</h3>
                                    </div>
                                    <div class="panel-body text-justify">
                                        <p>Para el campo de mensaje se tiene un maximo de <a class="black">200</a> caracteres.</p>
                                        <br>
                                        <!--<form class="form-horizontal text-left" enctype="multipart/form-data" action="cargarImagen.jsp" method="post" role="form">
                                             <div class="form-group">
                                                <% if (session.getAttribute("mensajeImagen") == null) {
                                                        session.setAttribute("mensajeImagen", "");
                                                    }
                                                    out.print(session.getAttribute("mensajeImagen"));
                                                    session.setAttribute("mensajeImagen", "");
                                                %>
                                                <label for="evidencia" class="col-md-2 col-md-offset-1 control-label text-left">Evidencia<a class="red"> *</a> :</label>
                                                <div class="col-md-7">
                                                    <input type="file" name="evidencia" class="form-control" id="evidencia" placeholder="Elija una imagen con el error encontrado">
                                                     
                                                </div>
                                            
                                            <div class="col-md-2 col-md-offset-0">
                                               <button class="btn btn-primary btn-sm" name="requerimiento" type="submit">Cargar</button>
                                            </div>
                                            </div>
                                        </form>-->
                                        <form class="form-horizontal text-left" action="leerSolicitud.jsp" method="post" role="form">
                                            <div class="form-group">
                                                <label for="titulo" class="col-md-3 control-label text-left">Solicitud<a class="red"> *</a> :</label>
                                                <div class="col-md-8 col-md-offset-1">
                                                    <input type="text" name="titulo" class="form-control" id="mensaje" placeholder="Generalice su necesidad">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="mensaje" class="col-md-3 control-label text-left">Mensaje<a class="red"> *</a> :</label>
                                                <div class="col-md-8 col-md-offset-1">
                                                    <textarea type="text" name="mensaje" class="form-control" id="mensaje" rows="3" placeholder="Describa la necesidad o asistencia requerida"></textarea>
                                                </div>
                                            </div>
                                            <div align="center">
                                                <button class="btn btn-primary" name="requerimiento" type="submit">Reportar</button>
                                            </div>
                                        </form>
                                        
                                        <br>
                                        <form action="solicitar.jsp">
                                            <div align="center">
                                                <button class="btn btn-danger" name="requerimiento" type="submit">Cancelar</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="top-centro" align="center">
                            <img src="../diseno/images/logo-compressor.png" width="100%">
                        </div>
                    </div>
                    <div class="col-md-3">
                        <img src="../diseno/images/abogado.jpg" class="img-responsive" width="100%">
                        <br>
                        <img src="../diseno/images/abogado.jpg" class="img-responsive" width="100%">
                        <br>
                        <img src="../diseno/images/abogado.jpg" class="img-responsive" width="100%">
                    </div>
                </div>
            </div>
            
            
            
            <script src="../diseno/js/jquery.js"></script>
            <script src="../diseno/js/bootstrap.min.js"></script>
           
        </body>
</html>
