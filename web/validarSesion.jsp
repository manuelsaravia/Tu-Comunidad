<%-- 
    Document   : validarSesion
    Created on : 28/11/2015, 07:55:40 PM
    Author     : Manuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="facade" class="facade.Facade" scope="session"></jsp:useBean>
<jsp:useBean id="user" class="dto.Usuario" scope="session"></jsp:useBean>
<%
    String correo = request.getParameter("correo");
    String contrasenia = request.getParameter("contrasenia");
    System.err.println(correo);
    System.err.println(contrasenia);
    user.setCorreo(correo);
    user.setContrasenia(contrasenia);
    System.err.println(user.getCorreo());
    System.err.println(user.getContrasenia());
    String respuesta = facade.validarSesion(user);
    System.err.println(respuesta);
    if(!respuesta.equals("error")){
        String datos[] = respuesta.split(";");
        session.setAttribute("idUsuario",datos[0]);
        session.setAttribute("nombre",datos[1]);
        session.setAttribute("correo",user.getCorreo());
        session.setAttribute("contrasenia",user.getContrasenia());
        session.setAttribute("visitas",datos[3]);
        session.setAttribute("tipo",datos[4]);
        
        response.sendRedirect("jsp/principalUsuario.jsp");
    }
    else{
        String msg="<div class=\"alert alert-info\" role=\"alert\"><strong>"+"Ha ocurrido un error a la hora de iniciar sesion, Verifique los datos registrados"+"</strong></div>";
        session.setAttribute("mensajeInicio", msg);
        response.sendRedirect("iniciarsesion.jsp");
    }
    %>
