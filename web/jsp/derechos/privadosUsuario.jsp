<%-- 
    Document   : privadosUsuario
    Created on : 27/12/2015, 01:25:26 PM
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
        <link rel="stylesheet" type="text/css" href="../../diseno/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../../diseno/css/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="../../diseno/css/style.css">
        <link rel="shortcut icon" href="../../diseno/images/favicon.png">


		
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
                            <img alt="Brand" src="../../diseno/images/favicon.png" width="70%">
                        </a>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li><a href="../cargarTabla.jsp?req=NotiImagen-principalUsuario-noticias">Inicio<span class="sr-only">(current)</span></a></li>
                            
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a><% out.println(session.getAttribute("nombre").toString()); %></a></li>
                            <li class="blue"><a href="../../iniciarsesion.jsp" class="blue">Cerrar Sesion</a></li>
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
                                        <p align="center"><% out.println(session.getAttribute("procesos").toString()); %></p>
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
                                    <h5 class="black"><div align="center">    
                                        <div class="alert alert-info"><strong>Servicios</strong></div>
                                    </div><span class="sr-only">(current)</span></h5>
                                    <ul class="nav nav-pills">
                                        <li>Derechos
                                            <ul>
                                                <li><a href="../cargarTabla.jsp?req=Constitucionales-derechos/constitucionalesUsuario-constitucionales" class="black">Constitucionales</a></li>
                                                <li><a href="../cargarTabla.jsp?req=Administrativos-derechos/administrativosUsuario-administrativos" class="black">Administrativos</a></li>
                                                <li><a href="../cargarTabla.jsp?req=Penales-derechos/penalesUsuario-penales" class="black">Penales</a></li>
                                                <li><a href="../cargarTabla.jsp?req=Procesales-derechos/procesalesUsuario-procesales" class="black">Procesales</a></li>
                                                <li><a href="../cargarTabla.jsp?req=Financieros-derechos/financierosUsuario-financieros" class="black">Financieros</a></li>
                                                <li><a href="../cargarTabla.jsp?req=Tributarios-derechos/tributariosUsuario-tributarios" class="black">Tributarios</a></li>
                                                <li><a href="../cargarTabla.jsp?req=Civiles-derechos/civilesUsuario-civiles" class="black">Civiles</a></li>
                                                <li><a href="../cargarTabla.jsp?req=Mercantiles-derechos/mercantilesUsuario-mercantiles" class="black">Mercantiles</a></li>
                                                <li><a href="../cargarTabla.jsp?req=Laborales-derechos/laboralesUsuario-laborales" class="black">Laborales</a></li>
                                                <li><a href="../cargarTabla.jsp?req=Inter_Publicos-derechos/publicosUsuario-publicos" class="black">Internacionales Publicos</a></li>
                                                <li><a href="../cargarTabla.jsp?req=Inter_Privados-derechos/privadosUsuario-privados" class="black">Internacionales Privados</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="panel panel-default paneles">
                            <h2 class="text-center">Derechos Internacionales Privados</h2>
                            <div class="panel-body">
                                <% out.println(session.getAttribute("tabla").toString());  %>
                                
                            </div>
                        </div>
                        
                    </div>
                    <div class="col-md-3">
                        <div class="panel panel-default paneles">
                            <div class="panel-body">
                                <h4>Solicitud de Servicio</h4>
                                <form action="../solicitar.jsp" method="post">
                                    <div align="center">
                                        <button class="btn btn-info" type="submit">Solicitar</button>
                                    </div>
                                </form>
                                
                            </div>
                        </div>
                        <img src="../../diseno/images/abogado.jpg" class="img-responsive" width="100%">
                        <br>
                        <img src="../../diseno/images/abogado.jpg" class="img-responsive" width="100%">
                       
                    </div>
                </div>
            </div>
             <div class="top-centro" align="center">
                            <img src="../../diseno/images/logo-compressor.png" width="100%">
                        </div>
            
            
            <script src="../../diseno/js/jquery.js"></script>
            <script src="../../diseno/js/bootstrap.min.js"></script>
           
        </body>
</html>
