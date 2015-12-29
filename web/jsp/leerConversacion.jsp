<%-- 
    Document   : leerConversacion
    Created on : 29/12/2015, 12:44:49 PM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="facade.Facade" scope="session"></jsp:useBean>
<%
    String id = session.getAttribute("idUser").toString();
    String mensaje = request.getParameter("mensaje");
    facade.leerConversacion(id, mensaje);
    String res= facade.cargarConversacion(id);
    session.setAttribute("conversacion", res.split(";")[0]);
    session.setAttribute("nombreUsuario", res.split(";")[1]);
    response.sendRedirect("conversacion.jsp");
    %>
