<%-- 
    Document   : principalAdministrador
    Created on : 3/12/2015, 06:05:35 PM
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
                            <li><a href="cargarTabla.jsp?req=NotiImagen-principalAdministrador-noticias">Inicio<span class="sr-only">(current)</span></a></li>
                            <li><a href="cargarMensajes.jsp">Mensajes</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a>Administrador<% //out.println(session.getAttribute("nombre").toString()); %></a></li>
                            <li class="blue"><a href="../cargarInicio.jsp" class="blue">Cerrar Sesion</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>
            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        <div class="panel panel-default paneles">
                            <div class="panel-body text-center">
                                <h3 class="black">Administrador <% out.println(session.getAttribute("idAdmin").toString()); %></h3>
                                
                            </div>
                        </div>
                        <div class="panel panel-default paneles">
                            <div class="panel-body">
                                
                                    <div align="center">    
                                        <div class="alert alert-danger"><strong>Administrar Servicios</strong></div>
                                    </div>
                                <p>De click en el Servicio que desea administrar</p>
                                    <p>Podrá administrar los servicios de:</p>
                                    Derechos
                                            <ul>
                                                <li><a href="cargarTabla.jsp?req=Constitucionales-derechos/constitucionales-constitucionales" class="black">Constitucionales</a></li>
                                                <li><a href="cargarTabla.jsp?req=Administrativos-derechos/administrativos-administrativos" class="black">Administrativos</a></li>
                                                <li><a href="cargarTabla.jsp?req=Penales-derechos/penales-penales" class="black">Penales</a></li>
                                                <li><a href="cargarTabla.jsp?req=Procesales-derechos/procesales-procesales" class="black">Procesales</a></li>
                                                <li><a href="cargarTabla.jsp?req=Financieros-derechos/financieros-financieros" class="black">Financieros</a></li>
                                                <li><a href="cargarTabla.jsp?req=Tributarios-derechos/tributarios-tributarios" class="black">Tributarios</a></li>
                                                <li><a href="cargarTabla.jsp?req=Civiles-derechos/civiles-civiles" class="black">Civiles</a></li>
                                                <li><a href="cargarTabla.jsp?req=Mercantiles-derechos/mercantiles-mercantiles" class="black">Mercantiles</a></li>
                                                <li><a href="cargarTabla.jsp?req=Laborales-derechos/laborales-laborales" class="black">Laborales</a></li>
                                                <li><a href="cargarTabla.jsp?req=Inter_Publicos-derechos/publicos-publicos" class="black">Internacionales Publicos</a></li>
                                                <li><a href="cargarTabla.jsp?req=Inter_Privados-derechos/privados-privados" class="black">Internacionales Privados</a></li>
                                            </ul>
                                    
                                
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
                                        <form action="noticiaImagen.jsp">
                                            <p>Podra cargar UNA noticia en formato .png o .jpg la cual aparecera en la pagina principal de todos los usuarios</p>
                                            <div align="center">
                                                <button class="btn btn-lg btn-danger" type="submit">Cargar Imagen</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                                <% out.println(session.getAttribute("tabla").toString());  %>
                            </div>
                        </div>
                        
                    </div>
                    <div class="col-md-3">
                        <div class="panel panel-default paneles">
                            <div class="panel-body text-justify">
                                <h4>Solicitudes de Servicio</h4>
                                <form action="cargarSolicitudes.jsp" method="post">
                                    <p>Permite revisar las Solitudes de servicio de todos los usuarios y dar Contestacion a cada una de ellas</p>
                                    <div align="center">
                                        <button class="btn btn-danger" type="submit">Revisar Solicitudes</button>
                                    </div>
                                </form>
                                
                            </div>
                        </div>
                        
                        
                        
                        
                    </div>
                </div>
            </div>
            
            
            <div class="top-centro" align="center">
                            <img src="../diseno/images/logo-compressor.png" width="100%">
                        </div>
            <script src="../diseno/js/jquery.js"></script>
            <script src="../diseno/js/bootstrap.min.js"></script>
           
        </body>
</html>
