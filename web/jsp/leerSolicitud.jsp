<%-- 
    Document   : leerSolicitud
    Created on : 29/11/2015, 08:45:43 AM
    Author     : Manuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="facade" class="facade.Facade" scope="session"></jsp:useBean>
<jsp:useBean id="user" class="dto.Usuario" scope="session"></jsp:useBean>
<jsp:useBean id="asesoria" class="dto.Asesoria" scope="session"></jsp:useBean>
<%
    user.setCorreo(session.getAttribute("correo").toString());
    user.setContrasenia(session.getAttribute("contrasenia").toString());
    asesoria.setSolicitud(request.getParameter("titulo"));
    asesoria.setDescripcion(request.getParameter("mensaje"));
    
    String respuesta = facade.registrarAsesoria(user,asesoria);
    int ser = Integer.parseInt(session.getAttribute("procesos").toString()) + 1;
    session.setAttribute("procesos", ser);
    String msg="<div class=\"alert alert-info\" role=\"alert\"><strong>"+"Solicitud enviada exitosamente"+"</strong></div>";
            session.setAttribute("mensajeSolicitud", msg);
            response.sendRedirect("solicitar.jsp");
    %>
