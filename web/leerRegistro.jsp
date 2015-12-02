<%-- 
    Document   : leerRegistro
    Created on : 28/11/2015, 03:48:46 PM
    Author     : Manuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="facade" class="facade.Facade" scope="session"></jsp:useBean>
<jsp:useBean id="user" class="dto.Usuario" scope="session"></jsp:useBean>
<%
    String correo = request.getParameter("correo");
    String contrasenia = request.getParameter("contrasenia");
    String contrasenia2 = request.getParameter("contrasenia2");
    String nombre = request.getParameter("nombre");
    String apellido = request.getParameter("apellido");
    String fechaNacimiento = request.getParameter("fechaNacimiento");
    String ciudad = request.getParameter("ciudad");
    int telefono = Integer.parseInt(request.getParameter("telefono"));
    String movil = request.getParameter("movil");
    
    if(contrasenia.equals(contrasenia2)){
        user.setApellido(apellido);
        user.setCiudad(ciudad);
        user.setContrasenia(contrasenia);
        user.setCorreo(correo);
        user.setFechaNacimiento(fechaNacimiento);
        user.setMovil(movil);
        user.setNombre(nombre);
        user.setTelefono(telefono);
        
        String respuesta = facade.registrarUsuario(user);
        String msg="<div class=\"alert alert-info\" role=\"alert\"><strong>"+respuesta+"</strong></div>";
            session.setAttribute("mensajeRegistro", msg);
            response.sendRedirect("registrarUsuario.jsp");
    }
    
    %>
