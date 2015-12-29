<%-- 
    Document   : cargarMensajes
    Created on : 29/12/2015, 09:02:03 AM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="facade.Facade" scope="session"></jsp:useBean>
<%
    String res = facade.cargarMensajes();
    String users = res.split(";")[0];
    String mensajes = res.split(";")[1];
    
    session.setAttribute("listadoUsuarios", users);
    session.setAttribute("listadoMensajes", mensajes);
    response.sendRedirect("mensajes.jsp");
    %>
