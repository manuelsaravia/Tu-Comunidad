<%-- 
    Document   : leerConversacionUser
    Created on : 29/12/2015, 03:43:00 PM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="facade.Facade" scope="session"></jsp:useBean>
<%
    String id = session.getAttribute("idUsuario").toString();
    String mensaje = request.getParameter("mensaje");
    facade.leerConversacionUser(id, mensaje);
    String res= facade.cargarMensajesUser(id);
    session.setAttribute("conversacion", res.split(";")[0]);
    session.setAttribute("nombreUsuario", res.split(";")[1]);
    response.sendRedirect("mensajesUsuario.jsp");
    %>
