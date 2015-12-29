<%-- 
    Document   : leerPrivados
    Created on : 15/12/2015, 09:51:39 PM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="facade.Facade" scope="session"></jsp:useBean>
<%
    String comentario = request.getParameter("comentario");
    try{
        String archivo = session.getAttribute("nombreArchivo").toString();
        session.setAttribute("nombreArchivo", "");
        String mensaje  = facade.agregarArchivo(comentario,archivo,"Inter_Privados");
        if(mensaje.equals("error")){    
            String msg="<div class=\"alert alert-info\" role=\"alert\"><strong>"+"Ha ocurrido un error"+"</strong><br>Por favor intente cambiar el nombre del archivo, quiza este ya exista con ese nombre ó especifique un comentario</div>";
            session.setAttribute("mensajePrivados", msg);
        }
        else{
            String msg="<div class=\"alert alert-info\" role=\"alert\"><strong>"+mensaje+"</div>";
            session.setAttribute("mensajePrivados", msg);
        }
        response.sendRedirect("../cargarTabla.jsp?req=Inter_Privados-derechos/privados-privados");
    }catch(Exception e){
        String msg="<div class=\"alert alert-info\" role=\"alert\"><strong>"+"Especifique un Archivo"+"</strong></div>";
        session.setAttribute("mensajePrivados", msg);
        response.sendRedirect("../cargarTabla.jsp?req=Inter_Privados-derechos/privados-privados");
    }
    
    %>
