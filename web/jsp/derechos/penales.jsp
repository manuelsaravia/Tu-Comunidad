<%-- 
    Document   : penales
    Created on : 15/12/2015, 08:50:27 PM
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
                            <li><a href="../cargarTabla.jsp?req=NotiImagen-principalAdministrador-noticias">Inicio<span class="sr-only">(current)</span></a></li>
                            
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a>Administrador<% //out.println(session.getAttribute("nombre").toString()); %></a></li>
                            <li class="blue"><a href="../../cargarInicio.jsp" class="blue">Cerrar Sesion</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>
            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        <div class="panel panel-default paneles">
                            <div class="panel-body text-center">
                                <h3 class="black">Administrador<% //out.println(session.getAttribute("nombre").toString()); %></h3>
                                
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
                                                <li><a href="../cargarTabla.jsp?req=Constitucionales-derechos/constitucionales-constitucionales" class="black">Constitucionales</a></li>
                                                <li><a href="../cargarTabla.jsp?req=Administrativos-derechos/administrativos-administrativos" class="black">Administrativos</a></li>
                                                <li><a href="../cargarTabla.jsp?req=Penales-derechos/penales-penales" class="black">Penales</a></li>
                                                <li><a href="../cargarTabla.jsp?req=Procesales-derechos/procesales-procesales" class="black">Procesales</a></li>
                                                <li><a href="../cargarTabla.jsp?req=Financieros-derechos/financieros-financieros" class="black">Financieros</a></li>
                                                <li><a href="../cargarTabla.jsp?req=Tributarios-derechos/tributarios-tributarios" class="black">Tributarios</a></li>
                                                <li><a href="../cargarTabla.jsp?req=Civiles-derechos/civiles-civiles" class="black">Civiles</a></li>
                                                <li><a href="../cargarTabla.jsp?req=Mercantiles-derechos/mercantiles-mercantiles" class="black">Mercantiles</a></li>
                                                <li><a href="../cargarTabla.jsp?req=Laborales-derechos/laborales-laborales" class="black">Laborales</a></li>
                                                <li><a href="../cargarTabla.jsp?req=Inter_Publicos-derechos/publicos-publicos" class="black">Internacionales Publicos</a></li>
                                                <li><a href="../cargarTabla.jsp?req=Inter_Privados-derechos/privados-privados" class="black">Internacionales Privados</a></li>
                                            </ul>
                                    
                            </div>
                        </div>
                    </div>
                    <div class="col-md-9">
                        <div class="panel panel-default paneles">
                            <h2 class="text-center">Derechos Penales</h2>
                            <div class="panel-body">
                                
                                <div class="panel panel-info">
                                    
                                    <div class="panel-heading">
                                        <div class="panel-title">Carga de Archivos</div>
                                    </div>
                                    <div class="panel-body">
                                        <%
                                            if(session.getAttribute("mensajePenales") == null){
                                                session.setAttribute("mensajePenales", "");
                                            }
                                            out.println(session.getAttribute("mensajePenales"));
                                            session.setAttribute("mensajePenales","");
                                            %>
                                            
                                        <p>Antes de darle click en <strong>"Guardar"</strong> debe seleccionar un archivo y dale click en <strong>"Cargar"</strong>. 
                                        Posteriormente incluya un comentario.</p>
                                        <% 
                                                    if (session.getAttribute("mensajeImagen") == null) {
                                                        session.setAttribute("mensajeImagen", "");
                                                    } 
                                                
                                                    out.println(session.getAttribute("mensajeImagen"));
                    
                                                    session.setAttribute("mensajeImagen", " ");
                                                %>
                                        <form class="form-horizontal text-left" enctype="multipart/form-data" action="cargarImagenPenales.jsp" method="post" role="form">
                                            <div class="form-group">
                                                
                                                <label for="archivo" class="col-md-2 control-label text-left">Archivo:</label>
                                                <div class="col-md-8">
                                                    <input type="file" name="archivo" class="form-control" id="evidencia" placeholder="Elija un archivo">
                                                     
                                                </div>
                                                <button class="btn btn-danger btn-sm" name="requerimiento" type="submit">Cargar</button>
                                            
                                            </div>
                                        </form>
                                                <form action="leerPenales.jsp" method="post">
                                                    <label for="comentario" class="col-md-2 control-label text-left">Comentario:</label>
                                                    <div class="col-md-8">
                                                        <input type="text" name="comentario" class="form-control" id="comentario" placeholder="Introduzca un comentario">
                                                     
                                                    </div>
                                                    <br><br><br>
                                                     <div align="center">
                                                        <button class="btn btn-danger" name="requerimiento" type="submit">Guardar Cambios</button>
                                                    </div>
                                                </form>
                                    </div>
                                </div>
                                <div class="panel panel-info">
                                    
                                    <div class="panel-heading">
                                        <div class="panel-title">Historial de Archivos Cargados</div>
                                    </div>
                                    <div class="panel-body">
                                        <% out.println(session.getAttribute("tabla").toString());  %>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
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
