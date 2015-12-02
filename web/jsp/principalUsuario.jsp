<%-- 
    Document   : principalUsuario
    Created on : 24/11/2015, 05:11:38 PM
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
                                        <p><strong>Procesos</strong></p>
                                        <p align="center">2</p>
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
                                    <h5 class="black">Servicios<span class="sr-only">(current)</span></h5>
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
                        <div class="panel panel-default paneles">
                            <div class="panel-body">
                                <div class="panel panel-info">
                                    <div class="panel-heading">
                                        <div class="panel-title">Noticia en Imagen</div>
                                    </div>
                                    <div class="panel-body">
                                        <img src="../diseno/images/noticia.jpg" class="img-responsive" alt="noticia" width="100%" align="center">
                                    </div>
                                </div>
                                <div class="panel panel-info">
                                    <div class="panel-heading">
                                        <div class="panel-title">Noticia en Texto</div>
                                    </div>
                                    <div class="panel-body text-justify">
                                        <p>El Gobierno Nacional, en cabeza del Ministerio de Salud y Protección Social, anunciará oficialmente este miércoles la liquidación de la EPS Saludcoop. (Lea también: ¿Qué deben hacer los usuarios afiliados ante liquidación de Saludcoop?)
                                                                                    <p>El Gobierno Nacional, en cabeza del Ministerio de Salud y Protección Social, anunciará oficialmente este miércoles la liquidación de la EPS Saludcoop. (Lea también: ¿Qué deben hacer los usuarios afiliados ante liquidación de Saludcoop?)

                                                                                                                                <p>El Gobierno Nacional, en cabeza del Ministerio de Salud y Protección Social, anunciará oficialmente este miércoles la liquidación de la EPS Saludcoop. (Lea también: ¿Qué deben hacer los usuarios afiliados ante liquidación de Saludcoop?)

                                                                                                                                                                            <p>El Gobierno Nacional, en cabeza del Ministerio de Salud y Protección Social, anunciará oficialmente este miércoles la liquidación de la EPS Saludcoop. (Lea también: ¿Qué deben hacer los usuarios afiliados ante liquidación de Saludcoop?)

                                                                                                                                                                                                                        <p>El Gobierno Nacional, en cabeza del Ministerio de Salud y Protección Social, anunciará oficialmente este miércoles la liquidación de la EPS Saludcoop. (Lea también: ¿Qué deben hacer los usuarios afiliados ante liquidación de Saludcoop?)

                                    </div>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                    <div class="col-md-3">
                        <div class="panel panel-default paneles">
                            <div class="panel-body">
                                <h4>Solicitud de Servicio</h4>
                                <form action="solicitar.jsp" method="post">
                                    <div align="center">
                                        <button class="btn btn-info" type="submit">Solicitar</button>
                                    </div>
                                </form>
                                
                            </div>
                        </div>
                        <img src="../diseno/images/abogado.jpg" class="img-responsive" width="100%">
                        <br>
                        <img src="../diseno/images/abogado.jpg" class="img-responsive" width="100%">
                        <div class="top-centro" align="center">
                            <img src="../diseno/images/logo-compressor.png" width="100%">
                        </div>
                    </div>
                </div>
            </div>
            
            
            
            <script src="../diseno/js/jquery.js"></script>
            <script src="../diseno/js/bootstrap.min.js"></script>
           
        </body>
</html>