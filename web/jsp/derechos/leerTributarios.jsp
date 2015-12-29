<%-- 
    Document   : leerTributarios
    Created on : 15/12/2015, 09:16:13 PM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="facade.Facade" scope="session"></jsp:useBean>
<%
    String comentario = request.getParameter("comentario");
    try{
        String archivo = session.getAttribute("nombreArchivo").toString();
        session.setAttribute("nombreArchivo", "");
        String mensaje  = facade.agregarArchivo(comentario,archivo,"Tributarios");
        if(mensaje.equals("error")){    
            String msg="<div class=\"alert alert-info\" role=\"alert\"><strong>"+"Ha ocurrido un error"+"</strong><br>Por favor intente cambiar el nombre del archivo, quiza este ya exista con ese nombre � especifique un comentario</div>";
            session.setAttribute("mensajeTributarios", msg);
        }
        else{
            String msg="<div class=\"alert alert-info\" role=\"alert\"><strong>"+mensaje+"</div>";
            session.setAttribute("mensajeTributarios", msg);
        }
        response.sendRedirect("../cargarTabla.jsp?req=Tributarios-derechos/tributarios-tributarios");
    }catch(Exception e){
        String msg="<div class=\"alert alert-info\" role=\"alert\"><strong>"+"Especifique un Archivo"+"</strong></div>";
        session.setAttribute("mensajeTributarios", msg);
        response.sendRedirect("../cargarTabla.jsp?req=Tributarios-derechos/tributarios-tributarios");
    }
    
    %>
