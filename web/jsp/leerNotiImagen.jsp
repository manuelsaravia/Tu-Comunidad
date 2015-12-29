<%-- 
    Document   : leerNotiImagen
    Created on : 15/12/2015, 10:15:31 PM
    Author     : Manuel
--%>
<jsp:useBean id="facade" class="facade.Facade" scope="session"></jsp:useBean>
<%
    String comentario = request.getParameter("comentario");
    try{
        String archivo = session.getAttribute("nombreArchivo").toString();
        session.setAttribute("nombreArchivo", "");
        String mensaje  = facade.agregarArchivo(comentario,archivo,"NotiImagen");
        if(mensaje.equals("error")){    
            String msg="<div class=\"alert alert-info\" role=\"alert\"><strong>"+"Ha ocurrido un error"+"</strong><br>Por favor intente cambiar el nombre del archivo, quiza este ya exista con ese nombre ó especifique un comentario</div>";
            session.setAttribute("mensajeNotiImagen", msg);
        }
        else{
            String msg="<div class=\"alert alert-info\" role=\"alert\"><strong>"+mensaje+"</div>";
            session.setAttribute("mensajeNotiImagen", msg);
        }
        response.sendRedirect("noticiaImagen.jsp");
    }catch(Exception e){
        String msg="<div class=\"alert alert-info\" role=\"alert\"><strong>"+"Especifique un Archivo"+"</strong></div>";
        session.setAttribute("mensajeNotiImagen", msg);
        response.sendRedirect("noticiaImagen.jsp");
    }
    
    %>