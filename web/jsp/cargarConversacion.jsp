<%-- 
    Document   : cargarConversacion
    Created on : 29/12/2015, 09:59:04 AM
    Author     : Manuel
--%>

<jsp:useBean id="facade" class="facade.Facade" scope="session"></jsp:useBean>
<%
    String id = request.getParameter("idUsuario");
    session.setAttribute("idUser", id);
    String res= facade.cargarConversacion(id);
    session.setAttribute("conversacion", res.split(";")[0]);
    session.setAttribute("nombreUsuario", res.split(";")[1]);
    response.sendRedirect("conversacion.jsp");
    %>
