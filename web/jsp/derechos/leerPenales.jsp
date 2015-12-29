<%-- 
    Document   : leerPenales
    Created on : 15/12/2015, 08:57:12 PM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="facade.Facade" scope="session"></jsp:useBean>
<%
    String comentario = request.getParameter("comentario");
    try{
        String archivo = session.getAttribute("nombreArchivo").toString();
        session.setAttribute("nombreArchivo", "");
        String mensaje  = facade.agregarArchivo(comentario,archivo,"Penales");
        if(mensaje.equals("error")){    
            String msg="<div class=\"alert alert-info\" role=\"alert\"><strong>"+"Ha ocurrido un error"+"</strong><br>Por favor intente cambiar el nombre del archivo, quiza este ya exista con ese nombre ó especifique un comentario</div>";
            session.setAttribute("mensajePenales", msg);
        }
        else{
            String msg="<div class=\"alert alert-info\" role=\"alert\"><strong>"+mensaje+"</div>";
            session.setAttribute("mensajePenales", msg);
        }
        response.sendRedirect("../cargarTabla.jsp?req=Penales-derechos/penales-penales");
    }catch(Exception e){
        String msg="<div class=\"alert alert-info\" role=\"alert\"><strong>"+"Especifique un Archivo"+"</strong></div>";
        session.setAttribute("mensajePenales", msg);
        response.sendRedirect("../cargarTabla.jsp?req=Penales-derechos/penales-penales");
    }
    
    %>