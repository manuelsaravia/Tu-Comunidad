<%-- 
    Document   : cargarInicio
    Created on : 14/12/2015, 03:38:00 PM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="facade.Facade" scope="session"></jsp:useBean>
<%
    String usuarios = facade.contarUsuarios();
    session.setAttribute("usuarios", usuarios);
    response.sendRedirect("iniciarsesion.jsp");
    %>
